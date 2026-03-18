/* 
@author: Joshua Langaman
@date: 3/18/25
@description:
2. Design and write a Java program that uses three arrays named: arr1, arr2 and arr3 that contain at least 25 integer 
values each. Your program should sum each array respectively(Note: do not use the built-in Java functions), print the sum of 
each to the console and determine which of the three arrays has the highest value and print the array and its value to the 
console. 
*/

package labs.example.array;

public class Week10ArraySum 
{
    public int getArraySum(int[] arr) 
    {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) 
        {
            sum += arr[i];
        }

        return sum;
    }

    public void printHighestArray(int sum1, int sum2, int sum3) 
    {
        if (sum1 > sum2 && sum1 > sum3) 
        {
            System.out.println("arr1 has the highest value: " + sum1);
        } 
        else if (sum2 > sum1 && sum2 > sum3) 
        {
            System.out.println("arr2 has the highest value: " + sum2);
        } 
        else if (sum3 > sum1 && sum3 > sum2) 
        {
            System.out.println("arr3 has the highest value: " + sum3);
        } 
        else 
        {
            System.out.println("There is a tie for the highest value.");
        }
    }
}
