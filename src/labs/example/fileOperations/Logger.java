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

#Date: 4/19/2026
#Week 14 Description: 
Continuing from last week and using ArrayLists along with file operations, you have more lofty goals to accomplish this week. 
See below for details:
1. Using the api_error.log file(attached to this lab), you should modify your Logger.java Class to open the file and find all 
references to disk space errors. You should create a new private method named getDiskSpaceErrorsWithIPAddress(file) that passes 
in the file handle(e.g. same as the lab from last week). Next, your program should determine which line each error occurs on and
 capture the IP address for each error. For each disk space error and associated IP address, you should print the result to the 
 console in the following format: Disk space error on line xxx for IP Address: xxx.xx.xxx.xxxx. 

2. Next, you should write an overloaded method named  openErrorLog("http_access_log") that passes in the argument listed
above(e.g. http_access_log). Note, you already have a method named openErrorLog() from last week. However, in Java you can 
have the same method name many times with different arguments. This is known as overloading and works because the method
signatures are different; therefore, making it a completely different method. Your new overloaded method should conditionally 
check the argument passed in to ensure that it is correct and return the BufferedReader handle. Hint: You will call this 
overloaded method for the remainder of this lab to open and operate on files.

3. When using linux operating systems, they use Apache web servers, which create log files known as http-access files.
These contain all HTTP requests made for a given web server. The file has a specific pattern such that +0000 and +0500 are 
the GMT offset for the timezone. GMT stands Greenwich Meridian Time and this is how we apply day-lights-savings time(a.k.a DST).
Hint: use the http_access.log file for this.
Your goal is to use the overloaded openErrorLog() method. You should create a new private method  named getGMTOffset(file) that 
takes a single argument to process the http_access.log file. The method should determine how many distinct GMT offsets exist in
the file. For example, count how many times +0000 occurs and print it to the console. You should do this for each distinct 
offset. Hint: You have a new file to read. Think about how we did this in the previous labs.

4. You should create a new method named getHTTPCodes() that takes the BufferedReader handle as an argument. The method's goal 
is to determine how may 2xx, 3xx,4xx and 5xx HTTP status codes occur in the file. For example, when a web server such as 
Apache processes a successful HTTP request, the response code is a 200 ok. However, if there is an internal server error 
the code could be in the 500 range(e.g. 504). You should determine how many of each error code occurs and print the result 
to the console in the following format:

5xx Errors: 124
2xx Errors: 677
3xx Errors: 990

5. You should create a new method named getResponseSizes() that takes the BufferedReader handle as an argument.
In the http_access.log file, there is a response size beside the http response code. For example the value directly to the 
right of a 200 response code in the file, may have a number such as 5199, which represent the size of the response from the web 
server in bytes. Your goal is to determine how many log lines(.e.g total count) have a response size > 3900 and print the 
result to the console.
6. Finally, you should write a private method named groupHTTPMethodsAndEndPoints() that takes the BufferedReader handle as 
the only argument. You should read the file and determine all of the the HTTP verbs(e.g. POST,PUT,DELETE,PATCH,GET,OPTIONS) 
that are listed in the file. However, you should only print each of them one time on the console no matter how many times they 
appear in the file and you cannot hard-code the specific verbs(e.g. you cannot conditionally check for POST,PUT,DELETE etc.). 
This means you must be able to determine all verbs without knowing their specific values. Hint: Use ArrayLists to help you 
track them
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
    private static final String HTTP_ACCESS_LOG = LOG_FILE_PATH + "http_access.log";


    public static void main(String args[])
    {
        //create BufferedReader handles
        BufferedReader file = null; 
        BufferedReader file2 = null;
        BufferedReader file3 = null;
        BufferedReader file4 = null;
        BufferedReader file5 = null;

        try
        {
            //open the api_error.log file and find disk space errors with IP addresses
            file = openErrorLog();
            getDiskSpaceErrorsWithIPAddress(file);
            file.close();

            //open the http_access.log file using the overloaded method and get GMT offsets
            file2 = openErrorLog("http_access_log");
            getGMTOffset(file2);
            file2.close();

            //open the http_access.log file again and count HTTP code groups
            file3 = openErrorLog("http_access_log");
            getHTTPCodes(file3);
            file3.close();

            //open the http_access.log file again and count response sizes > 3900
            file4 = openErrorLog("http_access_log");
            getResponseSizes(file4);
            file4.close();

            //open the http_access.log file again and group HTTP methods and endpoints
            file5 = openErrorLog("http_access_log");
            groupHTTPMethodsAndEndPoints(file5);
            file5.close();
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

    //Overloaded method to open the http_access.log file
    public static BufferedReader openErrorLog(String file_name) throws IOException
    {
        //Conditionally check that the argument is correct
        if(file_name.equals("http_access_log"))
        {
            File http_file = new File(HTTP_ACCESS_LOG);

            if(http_file.exists())
            {
                BufferedReader br = new BufferedReader(new FileReader(HTTP_ACCESS_LOG));
                return br;
            }
            else
            {
                System.out.println("HTTP access log file does not exist. Please check the file path and name.");
                return null;
            }
        }
        else
        {
            System.out.println("Incorrect argument passed into overloaded openErrorLog() method.");
            return null;
        }
    }
    //Method to find all disk space errors and print the line number and IP address
    private static void getDiskSpaceErrorsWithIPAddress(BufferedReader file) throws IOException
    {
        String line;
        int lineNumber = 0;

        //loop over each line in the file
        while((line = file.readLine()) != null)
        {
            lineNumber++;

            if(line.contains("Disk space"))
            {
                String[] parts = line.split(" ");
                String ipAddress = parts[3];

                System.out.println("Disk space error on line " + lineNumber + " for IP Address: " + ipAddress);
            }
        }
    }
    //method to determine how many distinct GMT offsets exist in the file
    private static void getGMTOffset(BufferedReader file) throws IOException
    {
        String line;

        ArrayList<String> offsets = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>();

        //loop over each line in the file
        while((line = file.readLine()) != null)
        {
            String[] parts = line.split(" ");

            for(int i = 0; i < parts.length; i++)
            {
                if(parts[i].startsWith("+") || parts[i].startsWith("-"))
                {
                    String offset = parts[i];

                    int index = offsets.indexOf(offset);

                    if(index != -1)
                    {
                        counts.set(index, counts.get(index) + 1);
                    }
                    else
                        {
                            offsets.add(offset);
                            counts.add(1);
                        }
    
                        break;
                    }
                }
            }
    
            System.out.println("GMT Offset Counts:");
    
            for(int i = 0; i < offsets.size(); i++)
            {
                System.out.println(offsets.get(i) + ": " + counts.get(i));
            }
        }
        //method to count 2xx, 3xx, 4xx, and 5xx HTTP status codes
    private static void getHTTPCodes(BufferedReader file) throws IOException
    {
        String line;
        int count2xx = 0;
        int count3xx = 0;
        int count4xx = 0;
        int count5xx = 0;

        //loop over each line in the file
        while((line = file.readLine()) != null)
        {
            String[] parts = line.split(" ");

            for(int i = 0; i < parts.length; i++)
            {
                if(parts[i].length() == 3)
                {
                    char firstChar = parts[i].charAt(0);

                    if(Character.isDigit(firstChar))
                    {
                        int statusCode = Integer.parseInt(parts[i]);

                        if(statusCode >= 200 && statusCode < 300)
                        {
                            count2xx++;
                        }
                        else if(statusCode >= 300 && statusCode < 400)
                        {
                            count3xx++;
                        }
                        else if(statusCode >= 400 && statusCode < 500)
                        {
                            count4xx++;
                        }
                        else if(statusCode >= 500 && statusCode < 600)
                        {
                            count5xx++;
                        }
                    }
                }
            }
        }
        System.out.println("5xx Errors: " + count5xx);
        System.out.println("2xx Errors: " + count2xx);
        System.out.println("3xx Errors: " + count3xx);
        System.out.println("4xx Errors: " + count4xx);
    }
    //method to count how many response sizes are greater than 3900
    private static void getResponseSizes(BufferedReader file) throws IOException
    {
        String line;
        int responseSizeCount = 0;

        //loop over each line in the file
        while((line = file.readLine()) != null)
        {
            String[] parts = line.split(" ");
            for(int i = 0; i < parts.length - 1; i++)
                {
                    if(parts[i].length() == 3)
                    {
                        char firstChar = parts[i].charAt(0);
    
                        if(Character.isDigit(firstChar))
                        {
                            int statusCode = Integer.parseInt(parts[i]);
    
                            if(statusCode >= 100 && statusCode <= 599)
                            {
                                if(parts[i + 1].matches("\\d+"))
                                {
                                    int responseSize = Integer.parseInt(parts[i + 1]);
    
                                    if(responseSize > 3900)
                                    {
                                        responseSizeCount++;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
    
            System.out.println("Total number of log lines with response size > 3900: " + responseSizeCount);
        }
        //method to print unique HTTP methods and endpoints
    private static void groupHTTPMethodsAndEndPoints(BufferedReader file) throws IOException
    {
        String line;

        ArrayList<String> methods = new ArrayList<String>();
        ArrayList<String> endpoints = new ArrayList<String>();

        //loop over each line in the file
        while((line = file.readLine()) != null)
        {
            int firstQuote = line.indexOf("\"");
            int secondQuote = line.indexOf("\"", firstQuote + 1);

            if(firstQuote != -1 && secondQuote != -1)
            {
                String requestPart = line.substring(firstQuote + 1, secondQuote);
                String[] requestValues = requestPart.split(" ");

                if(requestValues.length >= 2)
                {
                    String method = requestValues[0];
                    String endpoint = requestValues[1];

                    if(!methods.contains(method))
                    {
                        methods.add(method);
                    }
                    if(!endpoints.contains(endpoint))
                        {
                            endpoints.add(endpoint);
                        }
                    }
                }
            }
    
            System.out.println("Unique HTTP Methods:");
            for(int i = 0; i < methods.size(); i++)
            {
                System.out.println(methods.get(i));
            }
    
            System.out.println("Unique Endpoints:");
            for(int i = 0; i < endpoints.size(); i++)
            {
                System.out.println(endpoints.get(i));
            }
        }
    

    //Method to count the different error types in the log file
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
    

