
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


public class PatternMatch
{

    String rumour = "no";
 
    public String pattern(String tweet)
    {
        try
        {
            int prob = 0;
            int h1 = 0;
            int a1 = 0;
            int q1 = 0;
            int d1 = 0;
            int u1 = 0;
            int rt = 0;

            String pre = "";

            String t = tweet;
            if (t.contains("http"))
            {
                u1++; 
                if (u1 > 1)
                {
                    prob++; 
                }
            }
            if (t.contains("RT"))       //Retweet
            {
                rt++;
                if (rt > 1)
                {
                    prob++; 
                }
            }

            for (char c : t.toCharArray())
            {
                if (c == '$')
                {
                    d1++;
                    if (d1 > 1)
                    {
                        prob++;
                      
                    }
                }
                if (c == '#')
                {
                    h1++;
                    if (h1 > 1)
                    {
                        prob++;
                    }
                }
                if (c == '?')
                {
                    q1++;
                    if (q1 > 1)
                    {
                        prob++;
                    }
                }
                if (c == '@')
                {
                    a1++;
                    if (a1 > 1)
                    {
                        prob++;    
                    }
                }
            }
            
            if (prob >= 2)
            {
                rumour = "yes";
            }
            
            System.out.println("$:: " + d1);
            System.out.println("#:: " + h1);
            System.out.println("?:: " + q1);
            System.out.println("@:: " + a1);
            System.out.println("URL:: " + u1);
            System.out.println("RT:: " + rt);
                    
            System.out.println("***********************************************************************************************************************************");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
           
        return rumour;
    }

}
