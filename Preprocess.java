
package com;


public class Preprocess
{
    String clean_tweet=null;
    public String process(String tweet)
        
    {
         clean_tweet=tweet.replaceAll("[^A-Z a-z]","");
         clean_tweet=clean_tweet.replaceAll("http","");
         clean_tweet=clean_tweet.replaceAll("https","");
         clean_tweet=clean_tweet.replaceAll("www","");
         System.out.println("preprocessed tweet:"+clean_tweet); 
        return clean_tweet;
    }
    
}
