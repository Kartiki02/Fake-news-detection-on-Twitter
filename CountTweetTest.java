package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import util.DbUtil;


public class CountTweetTest
{
  public static void main(String args[])
  {
        Connection cn = DbUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //String status="";
        String uname = "";
        String tweets = "";

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("MpFkaTo09lcaViPXhhVSerB9J")
                .setOAuthConsumerSecret("4rYYSSLeqXTbxOW4iu4IJNRJ7VlmTvFGvze2w5yT5LDGEBFm9q")
                .setOAuthAccessToken("1064413053612187654-I15f71ops5sWd48WbBblKrm7VnmhPS")
                .setOAuthAccessTokenSecret("eaD6DdwZcT6rbVZvgmDCDqZEMiovOdjNE7c3aK7LDJ7KW");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        List<Status> statuses;
        try
        {
            ps = cn.prepareCall("truncate tweet.usertweets;");
            ps.execute();
            Query query = new Query("PMO India");
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                int h1 = 0;
                int a1 = 0;
                int q1 = 0;
                int d1 = 0;
                int u1 = 0;
                int rt = 0;
                String pre = "";
                String fakeTweet = "";
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                String t = status.getText();
                if (t.contains("http"))
                {
                    u1++;
                    if (u1 > 3)
                    {
                            fakeTweet = "Fake Tweet's";
                    }
                }
                if (t.contains("RT"))
                {
                    rt++;
                    if (rt > 3)
                    {
                            fakeTweet = "Fake Tweet's";
                    }
                }

                for (char c : t.toCharArray())
                {
                    if (c == '$')
                    {
                        d1++;
                        if (d1 > 3)
                        {
                            fakeTweet = "Fake Tweet's";
                        }
                    }
                    if (c == '#')
                    {
                        h1++;
                        if (h1 > 3)
                        {
                            fakeTweet = "Fake Tweet's";
                        }
                    }
                    if (c == '?')
                    {
                        q1++;
                        if (q1 > 3)
                        {
                            fakeTweet = "Fake Tweet's";
                        }
                    }
                    if (c == '@')
                    {
                        a1++;
                        if (a1 > 3)
                        {
                            fakeTweet = "Fake Tweet's";
                        }
                    }

                }
                System.out.println("$:: " + d1);
                System.out.println("#:: " + h1);
                System.out.println("?:: " + q1);
                System.out.println("@:: " + a1);
                System.out.println("URL:: " + u1);
                System.out.println("RT:: " + rt);
                System.out.println("fakeTweet:: " + fakeTweet);
                ps = cn.prepareCall("insert into usertweets values(0,?,?,?,?,?,?,?,?)");
                ps.setString(1, status.getUser().getScreenName());
                ps.setString(2, status.getText());
                ps.setInt(3, h1);
                ps.setInt(4, q1);
                ps.setInt(5, a1);
                ps.setInt(6, u1);
                ps.setInt(7, rt);
                ps.setString(8, fakeTweet);
                ps.execute();
                System.out.println("***********************************************************************************************************************************");
            }

//                ps = cn.prepareCall("insert into usertweets values(0,?,?)");
//                ps.setString(1, status.getUser().getScreenName());
//                ps.setString(2, status.getText());
//                ps.execute();
//                System.out.println("***********************************************************************************************************************************");
//
//            }
//
//        } catch (Exception ex) {
//            //Logger.getLogger(Rutuja.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//
//        try {
//            ps = cn.prepareStatement("select * from usertweets");
//            ResultSet rs1 = ps.executeQuery();
//            while (rs1.next()) {
//                uname = rs1.getString("username");
//                tweets = rs1.getString("tweets");
//                for (char c : tweets.toCharArray()) {
//                    if (c == '$') {
//                        d1++;
//                    }
//                    if (c == '#') {
//                        h1++;
//                    }
//                    if (c == '?') {
//                        q1++;
//                    }
//                    if (c == '@') {
//                        a1++;
//                    }
//                }
//            }
//            System.out.println("$:: " + d1);
//            System.out.println("#:: " + h1);
//            System.out.println("?:: " + q1);
//            System.out.println("@:: " + a1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
