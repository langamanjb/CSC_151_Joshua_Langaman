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

3. Implement a new public method in your ArrayOperations Class named getDaysAndMonths() that does NOT take any arguments and 
returns void. Your new method should create an integer array for the days in each month and a second String array to hold 
the names of each month in the year. You should decide how to present the following information to the console based on the 
information provided:

There are 31 days in January
There are 28 days in February
There are 31 days in March
...etc. 
*/

package labs.example.array;

public class ArrayOperations 
{
   // Step 1. 
   // Public method that creates a new array
   public void createNewArray(int value) 
   {
        // Create a new array 
        int numbers[] = new int[5];

        // Fill the array
        for (int i = 0; i < numbers.length; i++) 
        {
            numbers[i] = value + i;
        }

        // Call the private method to display the array
        displayArray(numbers);
  
    }

    // Private method to display the array
    private void displayArray(int[] array) 
    {

        System.out.println("I created a new array and it now has " + array.length + " items in it.");
        System.out.println("The array items and their values are listed below:");

        for (int i = 0; i < array.length; i++) 
        {
            System.out.println("Index " + i + " : " + array[i]);
        }
    }


    // Step 2.
    //Creating a public method to sort an array using bubble sort algorithm
    public void sortArray(int[] unsortedArray) 
    {
        int n = unsortedArray.length;

        // Bubble sort code
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (unsortedArray[j] > unsortedArray[j + 1]) 
                {
                    //Swap unsortedArray[j] and unsortedArray[j + 1]
                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j + 1];
                    unsortedArray[j + 1] = temp;
                }
            }
        }

        // Print the sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) 
        {
            System.out.print(unsortedArray[i] + " ");
        }
        
        // Print a new line after printing the sorted array
        System.out.println(); 
    
    }
    //Step 3.
    //Creating a public method to display the number of days in each month
    public void getDaysAndMonths()
    {
        int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String monthNames[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int i = 0; i < monthNames.length; i++) 
        {
            System.out.println("There are " + daysInMonth[i] + " days in " + monthNames[i]);
        }
        
    }




}
