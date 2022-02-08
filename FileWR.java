
package com;

import java.io.FileWriter;
import java.io.IOException;
 

public class FileWR
{
	static FileWriter writer;
	public FileWR(String fileName)
        {
		try
                {
			writer = new FileWriter(fileName+".csv");
		}
                catch (IOException e)
                {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
 
	public static void writeFile(String text) throws IOException
        {
		writer.write(text);
	}
 
	public static void close()
        {
		try
                {
			writer.close();
		} catch (IOException e)
                {
			e.printStackTrace();
		}
	}
}