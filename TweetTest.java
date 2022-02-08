

package com;

import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.Query;
import twitter4j.QueryResult;


public class TweetTest {

    public static void main(String args[]) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("MpFkaTo09lcaViPXhhVSerB9J")
                .setOAuthConsumerSecret("4rYYSSLeqXTbxOW4iu4IJNRJ7VlmTvFGvze2w5yT5LDGEBFm9q")
                .setOAuthAccessToken("1064413053612187654-I15f71ops5sWd48WbBblKrm7VnmhPS")
                .setOAuthAccessTokenSecret("eaD6DdwZcT6rbVZvgmDCDqZEMiovOdjNE7c3aK7LDJ7KW");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        List<Status> statuses;
        try {
//            statuses = twitter.getHomeTimeline();
//        
//      System.out.println("Showing home timeline.");
//      for (Status status : statuses) {
//    System.out.println("@:"+status.getUser().getName() + ":tweet:::" + status.getText());
//         
            

            Query query = new Query("PMO India");
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
               
                System.out.println("************************************************************************************************************");
            
            }

        } catch (Exception ex) {
            //Logger.getLogger(Rutuja.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

}
