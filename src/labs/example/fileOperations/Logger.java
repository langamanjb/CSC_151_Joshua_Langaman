/*
#Author: Joshua langaman 
#Date: 4/8/2026
#Description: 1. Use the knowledge you gained from previous labs and read the api_error.log file and print it to the console. 
Next, create a new Java Class in your src/labs/example/fileOperations package named Logger.java that has a main() method.

2. From your main() method, and call a new method named,  openErrorLog() that does NOT take any arguments and opens your file. 
After the file is opened within the openErrorLog() method, you should then return the file handle as a  
BufferedFileReader object to your main() method. 

3. Next, in your main() method, immediately after the newly returned BufferedFileReader Object handle,  call a new method 
named getCountOfErrorTypes() that passes the BufferedReader Object handle into the method. Hint: getCountOfErrorTypes(file), 
where file is the BufferedReader Object handle.

4. In your getCountOfErrorTypes() method, you should begin reading the file line-by-line and count the number of times you 
find [ERROR], [WARN],[INFO] and [DEBUG]. You should print the total count of each these to the console. When this is done, 
make sure you close the file from your main() method.

5. Modify your main() method and open the file again using the BufferedReader Object handle you already have created. 
Hint: you are re-opening the file after it has been closed. Next, create a new private method named getMemoryLimitExceededCount()
that returns void and passes the BufferedReader Object handle as an argument(e.g. getMemoryLimitExceededCount(file2)).
Your method should count the number of times the memory limit is exceeded and the respective Endpoint it occurs on. 
When done, print the count and Endpoint to the console. Hint: Use ArrayLists and make sure you close your file.

*/

package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Logger
{
    private static final String LOG_FILE_PATH = "/Users/joshualangaman/CSC_151_Joshua_Langaman/src/labs/example/fileOperations/";
    private static final String LOG_FILE_NAME = LOG_FILE_PATH + "api_error.log";

    public static void main(String args[])
    {
        //create BufferedReader handles
        BufferedReader file = null;
        BufferedReader file2 = null;

        try
        {
            //call the open file method
            file = openErrorLog();

            String line;

            //loop over each line in the file and print it
            while((line = file.readLine()) != null)
            {
                System.out.println(line);
            }

            //close the file after printing
            file.close();

            //open the file again and count the log types
            file = openErrorLog();
            getCountOfErrorTypes(file);
            file.close();

            //open the file again and count memory limit exceeded by endpoint
            file2 = openErrorLog();
            getMemoryLimitExceededCount(file2);
            file2.close();
        }
        //catch any IO exceptions that may occur during file operations
        catch(IOException e)
        {
            System.out.println(e);
            System.out.println("Please check the file path and name, and ensure the file is accessible.");
        }
    }

    //method to open the log file and return the BufferedReader object
    public static BufferedReader openErrorLog() throws IOException
    {
        //create a handle to a new File object
        File log_file = new File(LOG_FILE_NAME);

        //if the file exists, return the BufferedReader object
        if(log_file.exists())
        {
            BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_NAME));
            return br;
        }
        else
        {
            System.out.println("Log file does not exist. Please check the file path and name.");
            return null;
        }
    }

    //method to count the different error types in the log file
    public static void getCountOfErrorTypes(BufferedReader file) throws IOException
    {
        String line;
        int errorCount = 0;
        int warnCount = 0;
        int infoCount = 0;
        int debugCount = 0;

        //loop over each line in the file
        while((line = file.readLine()) != null)
        {
            if(line.contains("[ERROR]"))
            {
                errorCount++;
            }
            if(line.contains("[WARN]"))
            {
                warnCount++;
            }
            if(line.contains("[INFO]"))
            {
                infoCount++;
            }
            if(line.contains("[DEBUG]"))
            {
                debugCount++;
            }
        }

        System.out.println("The total number of [ERROR] logs is: " + errorCount);
        System.out.println("The total number of [WARN] logs is: " + warnCount);
        System.out.println("The total number of [INFO] logs is: " + infoCount);
        System.out.println("The total number of [DEBUG] logs is: " + debugCount);
    }

    //private method to count memory limit exceeded and the endpoint where it occurs
    private static void getMemoryLimitExceededCount(BufferedReader file) throws IOException
    {
        String line;

        ArrayList<String> endpoints = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>();

        //loop over each line in the file
        while((line = file.readLine()) != null)
        {
            if(line.contains("Memory limit exceeded"))
            {
                String[] parts = line.split("Endpoint: ");
                String endpoint = parts[1];

                int index = endpoints.indexOf(endpoint);

                if(index != -1)
                {
                    counts.set(index, counts.get(index) + 1);
                }
                else
                {
                    endpoints.add(endpoint);
                    counts.add(1);
                }
            }
        }

        System.out.println("Memory limit exceeded count by endpoint:");

        for(int i = 0; i < endpoints.size(); i++)
        {
            System.out.println(endpoints.get(i) + " : " + counts.get(i));
        }
    }
}