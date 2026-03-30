/*
@author: Joshua Langaman
@date: 3/25/26
Description: This program demonstrates how to read a CSV file in Java. It reads the contents of a CSV file, splits each line into fields, and prints them to the console.
*/

package labs.example.fileOperations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReadingCSVFile
{
    private static final String CSV_FILE_PATH = "/Users/joshualangaman/CSC_151_Joshua_Langaman/src/labs/example/fileOperations//";// Update this path to your CSV file
    private static final String CSV_FILE_NAME = CSV_FILE_PATH + "/users.csv"; // Update this to your CSV file name

    public static void main(String args[])
    {
        //call the open() file method
        openCSVFile();
    }
    //private method to work on 
    private static void openCSVFile()
    {
        //create a handle to a new File object
        File csv_file = new File(CSV_FILE_NAME);

        try
        {
            BufferedWriter csv_file_writer = new BufferedWriter(new FileWriter(CSV_FILE_NAME,true));

            //if the file and directories exist, then start processing
            if(csv_file.exists())
            {
                BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_NAME));
                String line;
                int count = 0;
                int grade = 0;
                int avg = 0;

                //loop over each line in the file
                while ((line = br.readLine()) != null)
                {
                    if(count > 0) //do not print the first line in the CSV
                    {
                        String[] value = line.split(",");
                        int totalNumOfGrades = value.length - 1;
                        grade = Integer.parseInt(value[1]) + Integer.parseInt(value[2]) + Integer.parseInt(value[3]);
                        avg = grade / totalNumOfGrades;
                        System.out.println(value[0] + " average is: " + avg);
                    }
                    grade = 0;
                    avg = 0;
                    count++;
                }
            }
            else
            {
                System.out.println("CSV file does not exist. Please check the file path and name.");
            }
            csv_file_writer.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.out.println("Please check the file path and name, and ensure the file is accessible.");
        }
    }
    
       






    


}