
package com;

import com.Preprocess;
import com.SentimentProcessor;
import Cluster.DecisionTree;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Predict extends HttpServlet
{

   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = "";
        int happy = 0;
        int anger = 0;
        int neutral = 0;
        int disgust = 0;
        int hate = 0;
        int sadness = 0;
        int surprise = 0;
        int tcount = 0;
            
        
        String search_q = "";
        try
        {
            TruncTable tt=new TruncTable();
            tt.deltable();
            HttpSession session = request.getSession();
            search_q = session.getAttribute("search_query").toString();
            System.out.println("Query in predict is : " + search_q);
           // search_q = search_q.replaceAll(" ", "%20");
            int neg = 0, pos = 0, pt = 0, nt = 0, score = 0, x = 0, rmrcnt = 0, f = 0;
            
            String pred = null;

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");

            String tweet, clean_tweet, tkn;

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
         //   cb.setDebugEnabled(true)
                                                .setOAuthConsumerKey("MpFkaTo09lcaViPXhhVSerB9J")
                                                .setOAuthConsumerSecret("4rYYSSLeqXTbxOW4iu4IJNRJ7VlmTvFGvze2w5yT5LDGEBFm9q")
                                                .setOAuthAccessToken("1064413053612187654-I15f71ops5sWd48WbBblKrm7VnmhPS")
                                                .setOAuthAccessTokenSecret("eaD6DdwZcT6rbVZvgmDCDqZEMiovOdjNE7c3aK7LDJ7KW");
            
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            List<Status> statuses = twitter.getHomeTimeline();
            Query query1 = new Query(search_q);
            QueryResult result = twitter.search(query1);
            
             int tp=0, tn=0, fp=0,fn=0;
             float acc=0, prec=0,rec=0;
        
            for (Status status : result.getTweets())
            {
                x++;
                tcount++;
                tweet = status.getText();
                name = status.getUser().getName();
                Date posted_at=status.getCreatedAt();
                PatternMatch pm = new PatternMatch();
                String rumour = pm.pattern(tweet);
                System.out.println("rumor:: " + rumour);
                if (rumour == "yes") 
                {
                    rmrcnt++;
                    PreparedStatement ps23 = cn1.prepareStatement("insert into rumour(tweet,user,tdate) values(?,?,?)");
                    ps23.setString(1,tweet);
                    ps23.setString(2,name);
                    ps23.setString(3, posted_at.toString());
                    ps23.execute();
                }

                Preprocess pro = new Preprocess();
                clean_tweet = pro.process(tweet);
                System.out.println("Preprocessed tweet: " + clean_tweet);

                SentimentProcessor sp = new SentimentProcessor();

                int sentiscore = sp.sentimentScore(clean_tweet);
                System.out.println("Sentiscore is :" + sentiscore);

                if (sentiscore == 1)
                {
                    score++;
                    tp++;
                }
                
                else
                {
                    score--;
                    tn++;
                }

                String[] token = clean_tweet.split(" ");
                int p = 0;
                int n = 0;
                int y = 0;

                for (int i = 0; i < token.length; i++)
                {
                    y++;
                    // System.out.println(token[i].toString().trim());
                    tkn = token[i].toString().trim();
                    PreparedStatement ps1 = cn1.prepareStatement("select * from negativedataset where negative=?");
                    ps1.setString(1, tkn);
                    ResultSet rs = ps1.executeQuery();
                    
                    while (rs.next())
                    {
                        neg++;
                        n++;
                        tn++;
                    }
                    
                    PreparedStatement ps2 = cn1.prepareStatement("select * from positivedataset where positive=?");
                    ps2.setString(1, tkn);
                    ResultSet rs1 = ps2.executeQuery();
                    
                    while (rs1.next())
                    {
                        pos++;
                        p++;
                        tp++;
                    }
                    
                    PreparedStatement ps3 = cn1.prepareStatement("select * from classpre where tweetcat=? and classname='happy'");
                    ps3.setString(1, tkn);
                    ResultSet rs3 = ps3.executeQuery();
                    
                    while (rs3.next())
                    {
                        happy++;
                    }
                    
                    PreparedStatement ps4 = cn1.prepareStatement("select * from classpre where tweetcat=? and classname='anger'");
                    ps4.setString(1, tkn);
                    ResultSet rs4 = ps4.executeQuery();
                    
                    while (rs4.next())
                    {
                        anger++;
                    }
                    
                    PreparedStatement ps5 = cn1.prepareStatement("select * from classpre where tweetcat=? and classname='neutral'");
                    ps5.setString(1, tkn);
                    ResultSet rs5 = ps5.executeQuery();
                    
                    while (rs5.next())
                    {
                        neutral++;
                    }
                    
                    PreparedStatement ps6 = cn1.prepareStatement("select * from classpre where tweetcat=? and classname='disgust'");
                    ps6.setString(1, tkn);
                    ResultSet rs6 = ps6.executeQuery();
                    
                    while (rs6.next())
                    {
                        disgust++;
                    }
                    
                    PreparedStatement ps7 = cn1.prepareStatement("select * from classpre where tweetcat=? and classname='hate'");
                    ps7.setString(1, tkn);
                    ResultSet rs7 = ps7.executeQuery();
                    
                    while (rs7.next())
                    {
                        hate++;
                    }
                    
                    PreparedStatement ps8 = cn1.prepareStatement("select * from classpre where tweetcat=? and classname='sadness'");
                    ps8.setString(1, tkn);
                    ResultSet rs8 = ps8.executeQuery();
                    
                    while (rs8.next())
                    {
                        sadness++;
                    }
                    
                    PreparedStatement ps9 = cn1.prepareStatement("select * from classpre where tweetcat=? and classname='surprise'");
                    ps9.setString(1, tkn);
                    ResultSet rs9 = ps9.executeQuery();
                    
                    while (rs9.next())
                    {
                        surprise++;
                    }
                }
                
                float p1 = (float) p / y;
                float n1 = (float) n / y;
                
                System.out.println("Positive polarity of tweet : " + p1);
                System.out.println("Negative polarity of tweet : " + n1);

                if (p1 > n1 && sentiscore == 1)
                {
                    pt++;
                    fp++;
                    PreparedStatement ps21 = cn1.prepareStatement("insert into positive(tweet,user,tdate) values(?,?,?)");
                    ps21.setString(1,tweet);
                    ps21.setString(2,name);
                    ps21.setString(3, posted_at.toString());
                    ps21.execute();

                }
                
                else
                {
                    nt++;
                    fn++;
                    PreparedStatement ps22 = cn1.prepareStatement("insert into negative(tweet,user,tdate) values(?,?,?)");
                    ps22.setString(1,tweet);
                    ps22.setString(2,name);
                    ps22.setString(3, posted_at.toString());
                    ps22.execute();
                }

            }
            
            System.out.println("Total Tweets:: " + tcount);
            session.setAttribute("totalp", pos);
            session.setAttribute("totaln", neg);
            session.setAttribute("pt", pt);
            session.setAttribute("nt", nt);
            
            System.out.println("*************************************************************");
            
            System.out.println("Happy:: " + happy);
            System.out.println("Anger:: " + anger);
            System.out.println("Neutral:: " + neutral);
            System.out.println("Disgust:: " + disgust);
            System.out.println("Hate:: " + hate);
            System.out.println("Sadness:: " + sadness);
            System.out.println("Surprise:: " + surprise);
            
            session.setAttribute("happy", happy);
            session.setAttribute("anger", anger);
            session.setAttribute("neutral", neutral);
            session.setAttribute("disgust", disgust);
            session.setAttribute("hate", hate);
            session.setAttribute("sadness", sadness);
            session.setAttribute("surprise", surprise);
            
            PreparedStatement ps10 = cn1.prepareStatement("insert into classcount(happy, anger, neutral, disgust, hate, sadness, surprise, name) values(?,?,?,?,?,?,?,?)");
            
            ps10.setInt(1, happy);
            ps10.setInt(2, anger);
            ps10.setInt(3, neutral);
            ps10.setInt(4, disgust);
            ps10.setInt(5, hate);
            ps10.setInt(6, sadness);
            ps10.setInt(7, surprise);
            ps10.setString(8, search_q);
            ps10.execute();
            
            System.out.println("*************************************************************");
            System.out.println("Query in predict is " + search_q);
            System.out.println("Total negative Tweets = " + nt);
            System.out.println("Total positive Tweets = " + pt);
            System.out.println("Total rumour count = " + rmrcnt);
            
            System.out.println("Tp = " + tp+" Tn = "+tn+" Fp = "+fp+" Fn = "+fn);
            
            acc=((float)tp+tn)/(tp+fp+tn+fn)*100;
            prec=tp/((float)tp+fp)*100;
            rec=tp/((float)tp+fn)*100;
            
            System.out.println("Accuracy = " + acc*100);
            System.out.println("Precision = "+prec*100);
            System.out.println("Recall = "+rec*100);
            
            DecisionTree dt = new DecisionTree();
            dt.test("" + rmrcnt, "" + tcount);
            
            System.out.println("total sentiment score=" + (score - nt));
            
            float negpercentage = ((float) nt / x) * 100;
            float pospercentage = ((float) pt / x) * 100;
            
            System.out.println("negper=" + negpercentage );
            System.out.println("posper=" + pospercentage);
            
            session.setAttribute("negper", negpercentage);
            session.setAttribute("posper", pospercentage);
            session.setAttribute("nt", nt);
            session.setAttribute("pt", pt);
            session.setAttribute("tt", tcount);
            session.setAttribute("rt", rmrcnt);
            session.setAttribute("acc", acc);
            session.setAttribute("prec", prec);
            session.setAttribute("rec", rec);

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");
            PreparedStatement ps = cn.prepareStatement("insert into viewanalysis(name, positive, negative, rumor) values(?,?,?,?)");

            ps.setString(1, search_q);
            ps.setInt(2, pt);
            ps.setInt(3, nt);
            ps.setInt(4, rmrcnt);
            ps.execute();
            RequestDispatcher rd = request.getRequestDispatcher("ViewBehaviour.jsp");
            rd.include(request, response);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
