/* 
@author: Joshua Langaman
@date: 3/18/25
@description:
3. Design and write a Java program that uses one array named myArray that contains at least 50 integer values. 
Your program should determine the highest value in the array and print the following message to the console: "The highest 
value in the myArray object is: xxxxx"
*/

package labs.example.array;

public class Week10ArrayMax 
{
    
    public int findMax(int[] arr) 
    {
        // Assume first element is the max to compare with
        int max = arr[0];

       // The loop starts from 1 because we already considered the first element as max
        for (int i = 1; i < arr.length; i++) 
            {

            if (arr[i] > max) 
            {
                max = arr[i];
            }
        }
        return max;
    }
}
