
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class TruncTable {
    
    public static void deltable()
    {
        try{
         Class.forName("com.mysql.jdbc.Driver");
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");
            PreparedStatement ps = cn1.prepareStatement("truncate negative");
            ps.execute();
            PreparedStatement ps1 = cn1.prepareStatement("truncate positive");
            ps1.execute();
            PreparedStatement ps2 = cn1.prepareStatement("truncate rumour");
            ps2.execute();

        }
        catch(Exception e)
        {
            System.out.println("Exception while truncating"+e);
        }
    }
    
}
