/* 
@author: Joshua Langaman
@date: 3/18/25
@description:1. Design and write a Java program that uses two integer arrays named: firstArray and secondArray.
Your program should accomplish two things: a.) are the arrays the same length 
b.) are the arrays equal(e.g. do they contain the same values). You must determine these without using any of 
the built-in Java methods that do this for you. Once your program determines the result, you should print the following 
messages: "Yes/No these arrays do/do not contain the same values" and "Yes/No these arrays are/are not the same length"

*/
package labs.example.array;

public class Week10ArrayChecker 
{
    // Method to check if two arrays are the same length
    public boolean sameLength(int[] firstArray, int[] secondArray) 
    {
        return firstArray.length == secondArray.length;
    }

    public boolean sameValues(int[] firstArray, int[] secondArray) 
    {
        // First check if the arrays are the same length becausue if theyre not the same length, they cannot have the same values
        if (firstArray.length != secondArray.length) 
        {
            return false; 
        }

        // Check if all values are the same
        for (int i = 0; i < firstArray.length; i++) 
        {
            if (firstArray[i] != secondArray[i]) 
            {
                return false; // If any value is different, return false
            }
        }
        return true; // If all values are the same, return true
    }
}
