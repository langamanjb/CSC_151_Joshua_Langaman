/* 
@author: Joshua Langaman
@date: 3/18/25
@description:
1. Design and write a Java program that uses two integer arrays named: firstArray and secondArray.
Your program should accomplish two things: a.) are the arrays the same length 
b.) are the arrays equal(e.g. do they contain the same values). You must determine these without using any of 
the built-in Java methods that do this for you. Once your program determines the result, you should print the following 
messages: "Yes/No these arrays do/do not contain the same values" and "Yes/No these arrays are/are not the same length"

2. Design and write a Java program that uses three arrays named: arr1, arr2 and arr3 that contain at least 25 integer 
values each. Your program should sum each array respectively(Note: do not use the built-in Java functions), print the sum of 
each to the console and determine which of the three arrays has the highest value and print the array and its value to the 
console. 

3. Design and write a Java program that uses one array named myArray that contains at least 50 integer values. 
Your program should determine the highest value in the array and print the following message to the console: "The highest 
value in the myArray object is: xxxxx"

4. Using what you have learned with mathematical operators and during the lecture on the Mod-10 Check, you should design and 
write a program that implements a Mod-10(Credit Card Check) and determine if a given credit card is valid. You should use 
chatGPT to generate known-good test credit cards to test your program logic. After your program tests the validity of the 
credit card, you should print to the console the following message: "Credit Card xxxxxxxxxxxxxxxx is/is not valid."

*/

package labs.example.array;

public class Week10Main 
{
    public static void main(String[] args) 
    {
        // #1
        Week10ArrayChecker checker = new Week10ArrayChecker();

        //Change the values in these arrays to test
        int[] firstArray = {1, 2, 3, 4, 3};
        int[] secondArray = {1, 2, 3, 4, 5};

        // Check length
        boolean sameLength = checker.sameLength(firstArray, secondArray);

        // Check values
        boolean sameValues = checker.sameValues(firstArray, secondArray);

        // Print results
        if (sameValues) 
        {
            System.out.println("Yes these arrays do contain the same values");
        }
        else 
        {
            System.out.println("No these arrays do not contain the same values");
        }

        if (sameLength) 
        {
            System.out.println("Yes these arrays are the same length");
        } 
        else 
        {
            System.out.println("No these arrays are not the same length");
        }

        // #2
        Week10ArraySum arraySum = new Week10ArraySum();

        int[] arr1 = 
        {
            12, 7, 45, 23, 9,
            31, 18, 50, 4, 27,
            36, 15, 29, 41, 6,
            22, 39, 11, 48, 3,
            25, 14, 33, 8, 19
        };

        int[] arr2 = 
        {
            5, 28, 13, 44, 2,
            37, 16, 9, 30, 21,
            40, 7, 24, 35, 11,
            18, 46, 3, 27, 14,
            32, 20, 6, 41, 10
        };

        int[] arr3 = 
        {
          9, 9, 9, 9, 9,
          9, 9, 9, 9, 9,
          9, 9, 9, 9, 9,
          9, 9, 9, 9, 9,
          9, 9, 9, 9, 9 
        };

        int sum1 = arraySum.getArraySum(arr1);
        int sum2 = arraySum.getArraySum(arr2);
        int sum3 = arraySum.getArraySum(arr3);

        System.out.println("The sum of arr1 is: " + sum1);
        System.out.println("The sum of arr2 is: " + sum2);
        System.out.println("The sum of arr3 is: " + sum3);

        arraySum.printHighestArray(sum1, sum2, sum3);

        // #3

        Week10ArrayMax arrayMax = new Week10ArrayMax();

        int[] myArray = 
        {
            12, 45, 7, 89, 23, 56, 91, 34, 67, 18,
            72, 5, 99, 41, 60, 3, 88, 27, 54, 76,
            11, 39, 82, 6, 95, 21, 48, 70, 14, 63,
            36, 9, 84, 2, 58, 97, 25, 43, 68, 16,
            79, 31, 53, 10, 92, 4, 66, 28, 75, 19
        };

        int maxValue = arrayMax.findMax(myArray);
    
        System.out.println("The highest value in the myArray object is: " + maxValue);
    

        // #4

        Week10CCValidChecker ccChecker = new Week10CCValidChecker();

        // Known valid test number
        String cardNumber = "4532015112830326";

        boolean isValid = ccChecker.isValid(cardNumber);

        if (isValid) 
        {
            System.out.println("Credit Card " + cardNumber + " is valid.");
        } 
        else 
        {
            System.out.println("Credit Card " + cardNumber + " is not valid.");
        }
        
    
    }
}

