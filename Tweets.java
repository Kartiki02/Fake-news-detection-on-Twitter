package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class Tweets
{

    ConfigurationBuilder cb = new ConfigurationBuilder();
    Twitter twitter;
    ArrayList<Status> tweets;

    Tweets()
    {
        cb.setDebugEnabled(true).setOAuthConsumerKey("6ECBhguW5yvexhr8YGqWtnWVX")
                .setOAuthConsumerSecret("vEe6Cf77n0ZyEMd25uy2EX5TfVKLo5omVFgqDxrCciWOsYl7SE")
                .setOAuthAccessToken("2374984802-kjKt3HzMVO7RzmDOfnXVSD3Qj3G47VAUQOQkabg")
                .setOAuthAccessTokenSecret("wIAk3MGqQyHpjar1li3o4KoiJ9fCKEA7XnVChWNP9O64F");
        twitter = new TwitterFactory(cb.build()).getInstance();
        tweets = new ArrayList<Status>();
    }

    public void getTweets(String tag, int numberOfTweets, int queryCount)
    {
        Query query = new Query(tag);
        long lastID = Long.MAX_VALUE;

        while (tweets.size() < numberOfTweets)
        {
            if (numberOfTweets - tweets.size() > 100)
            {
                query.setCount(queryCount);
            }
            else
            {
                query.setCount(numberOfTweets - tweets.size());
            }
            try
            {
                QueryResult result = twitter.search(query);
                tweets.addAll(result.getTweets());
                System.out.println("Gathered " + tweets.size() + " tweets" + "\n");
                for (Status t : tweets)
                {
                    if (t.getId() < lastID)
                    {
                        lastID = t.getId();
                    }
                }
            } catch (TwitterException te)
            {
                System.out.println("Couldn't connect: " + te);
            }
            ;
            query.setMaxId(lastID - 1);
        }
    }

    public void writeTweets()
    {
        FileWR writer = new FileWR("Tweets");

        try
        {
            writer.writeFile("S#,Location,Date, User, Message \n");
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }

        for (int i = 0; i < tweets.size(); i++)
        {
            Status t = (Status) tweets.get(i);

            String user = t.getUser().getScreenName();
            String msg = t.getText();

            Date d = t.getCreatedAt();
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            try
            {

                writer.writeFile(i + "," + t.getUser().getLocation() + "," + month + " - " + day + " - " + year
                        + ", USER: " + user + " , wrote: " + msg + "\n");
                System.out.println("month:: " + month);
                System.out.println("day:: " + day);
                System.out.println("year:: " + year);
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        Tweets t = new Tweets();
        t.getTweets("#Cancer", 50, 50);
        t.writeTweets();
    }
}
