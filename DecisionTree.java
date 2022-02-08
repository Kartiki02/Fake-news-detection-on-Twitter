package Cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import util.DbUtil;

public class DecisionTree
{

    public static float arr[] = new float[15];

    public static void main(String arg[]) {
        DecisionTree re = new DecisionTree();

    }

    public void test(String hb, String tm) {
        final Classifier<String, String> bayes = new BayesClassifier<String, String>();

        try
        {

            BayesClassifier b1 = new BayesClassifier();

            final String[] positiveText = "1 2  ".split("\\s");
            bayes.learn("Low", Arrays.asList(positiveText));

            final String[] positiveText1 = "3 ".split("\\s");
            bayes.learn("Normal", Arrays.asList(positiveText1));

            final String[] positiveText2 = "4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20".split("\\s");
            bayes.learn("High", Arrays.asList(positiveText2));

            String word1 = hb;  //rumor

            String value3 = word1;
            word1 = word1.replaceAll("[^a-zA-Z0-9 -]", "");
            final String[] unknownText1 = word1.split("\\s");
          
            String[] s1 = unknownText1;
            System.out.println("features" + bayes.classify(Arrays.asList(unknownText1)).getFeatureset() + " " + "Category" + "  " + bayes.classify(Arrays.asList(unknownText1)).getCategory() + "    "
                    + " ");
            Connection cn = DbUtil.getConnection();

            Statement stmt = null;
            PreparedStatement ps = null;
            stmt = cn.createStatement();

            stmt.execute("INSERT INTO severity(cat) VALUES ('"
                       + bayes.classify(Arrays.asList(unknownText1)).getCategory() + 
                     "')");

            ((BayesClassifier<String, String>) bayes).classifyDetailed(Arrays.asList(unknownText1));

     
            Set<String> str = bayes.getCategories();
            System.out.println("s" + str);

            bayes.setMemoryCapacity(500);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
