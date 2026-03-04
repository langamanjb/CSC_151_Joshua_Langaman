/*
@Author: Joshua Langaman
@Date: 3/2/26
@Description: 1. Create a public method in your ArrayOperations Class named createNewArray() that accepts one integer argument 
and returns void. Your method should define a new integer array with the default value of elements in the array set to the 
parameter that is passed in. You should loop over the newly created array and for each array index/position, you should add 
the value of the current loop count to the value of the array. After the loop is complete, you should then call a private 
method named displayArray() that returns void and takes your previously created array as an argument. You should print out 
to the console the following: "I created a new array and it now has " + YOUR_ARRAY_LENGTH_HERE + " items in it.". Then print 
the following on another line:  "The array items and their values are listed below: " and print the values of the array that 
you passed in to the method.

2. You should create a new public method named sortArray() in your ArrayOperations Class that takes an unsorted integer 
array of 50 distinct integer values as the only argument. You should call the method from the Main Class and pass the unsorted 
integer array into the sortArray() method from the Main Class. Your sortArray() method must build the logic to sort the 
array(e.g. you cannot use built-in Java sorting methods to do this). When your method is done sorting the array, you should 
print the sorted array to the console.  This type of sorting is known as a bubble-sort and is one of the most inefficient ways 
to sort data; however, it is incredibly helpful in building your logic skills.

3. Implement a new public method in your ArrayOperations Class named getDaysAndMonths() that does NOT take any arguments and returns void. Your new method should create an integer array for the days in each month and a second String array to hold the names of each month in the year. You should decide how to present the following information to the console based on the information provided:

There are 31 days in January
There are 28 days in February
There are 31 days in March
...etc.

*/

package labs.example.array;

public class Main 
{
    public static void main(String[] args) 
    {
        // Create an instance of the ArrayOperations class
        ArrayOperations arrayOperations = new ArrayOperations();

        // Step 1.
        // Call the method and pass an integer
        arrayOperations.createNewArray(5);

        // Step 2.
        // Creating an unsorted array of 50 distinct integer values
        int unsortedArray[] = 
        { 64, 34, 25, 12,
        22, 11, 90, 45, 78, 56,
        23, 67, 89, 34, 12, 9,
        1, 5, 3, 8, 15, 29,
        40, 50, 60, 70, 80,
        10, 20, 30, 4, 6,
        7, 13, 17, 19, 21,
        27, 33, 37, 41, 43,
        47, 53, 59, 61, 73 };
        
        arrayOperations.sortArray(unsortedArray);

        // Step 3. Show the days in each month 
        arrayOperations.getDaysAndMonths();
    }
}
