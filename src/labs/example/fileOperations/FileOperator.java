package labs.example.fileOperations;

//import necessary java packages
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


//define the FileOperator Class
public class FileOperator {

    //define the static variable to hold the path to the file name
    private static final String FILE_PATH = "T:\\CSC_151\\src\\labs\\example\\fileOperations\\";
    private static final String FILE_NAME = FILE_PATH + "files\\users.csv";
    private static final String ERROR_LOGGER_FILE = FILE_PATH + "logs\\csv_error.log";

    //set up the Main() method, so that we can implement this Class
    public static void main(String args[]){
        //call the open() file method
        openCSVFile();
    }

    //private method to work on 
    private static void openCSVFile(){
        //create a handle to a new File object
        File csv_file = new File(FILE_NAME);
        File log_file = new File(ERROR_LOGGER_FILE);

        //try to execute the block of code below
        try{
          //create a BufferedWriter object and get handle to the FileWriter, so that we can write data to a file
          //put the file_writer in APPEND mode using the boolean flag set to true
          BufferedWriter csv_file_writer = new BufferedWriter(new FileWriter(ERROR_LOGGER_FILE,true));

          //if both files and directories exist, then start processing
          if(csv_file.exists() && log_file.exists()){
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            int count = 0;
            int grade = 0;
            int avg = 0;
            //loop over each line in the file
            while ((line = br.readLine()) != null) {
                if(count > 0){//do not print the first line in the CSV
                    String[] value = line.split(",");
                    int totalNumOfGrades = value.length - 1;
                    grade = Integer.parseInt(value[1]) + Integer.parseInt(value[2]) + Integer.parseInt(value[3]); //+ Integer.parseInt(value[2] + Integer.parseInt(value[3]));
                    avg = grade/totalNumOfGrades ;
                    System.out.println(value[0] + " average is: " + avg);
                }//end if
                grade = 0;
                avg = 0;
                count++;
            }//end while loop
          }//end if
          else{//else, one or more of the required files does not exist, so create them
            String message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
           
            if(!log_file.exists() || !csv_file.exists()){
                //create a 
                log_file.createNewFile();
                message = message + "MISSING LOG FILE! The " + ERROR_LOGGER_FILE + " was missing, so we created it for you.";
                csv_file_writer.write(message);
                csv_file_writer.newLine();
                //csv_file_writer.close();
            }//end if
            //if the CSV file does NOT exist, then throw write an error to the log file
            if(!csv_file.exists()){
                //csv_file.createNewFile();
                message = message + "MISSING CSV FILE! The " + FILE_NAME + " was missing, so it was created.";
                csv_file_writer.write(message);
                csv_file_writer.newLine();
                //csv_file_writer.close();
            }//end if
            //if the log file does not exist, then write a message to the l
            csv_file_writer.close();
          }//end if 

         

        }//end try block
        catch(IOException e){//catch any IOException errors that occur
            System.out.println(e);
            System.out.println("Error getting Buffered Writer Object! Cannot proceed!");
        }//end catch block
        





    }
}
