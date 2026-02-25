/*
@author: Joshua Langaman
@date: 2/25/26
@description: Week 6 Lab: This section of the code defines a class called ForLoop.

2. You should create a new Java Class named ForLoop.java in your labs.example.loops package.
From the main() method in the Class, you should call a new private method named executeForLoop() that does not take any 
arguments. Using what you learned in the lecture, you should have your for-loop iterate 20 times starting from 0 and 
print the value of the loop counter for each loop iteration within the method itself. 
Finally, you should call the executeForLoop() method from your main method.

3. In your ForLoop.java Class, you should implement a new private method named sumTwoNumbers(), which should take two integer
arguments, return an integer value and be called from the main() method. When the sumTwoNumbers() method is 
called, you should sum the two numbers and return the sum to the main() method. After the value is returned to the 
main() method, you should use what you learned on incrementing and decrementing counters to decrement the value by 1 
using the prefix approach and print the newly decremented value to the console from the main() method.
*/

package labs.example.loops;

public class ForLoop 
{
    public static void main(String[] args) // The main method is the entry point of the program. It is where the execution starts.
    {
        executeForLoop(); // Call the executeForLoop method to run the for loop and print the results.
    }

    private static void executeForLoop()
    {
        for (int i = 0; i < 20; i++) // The loop will execute 20 times, starting from 0 and incrementing by 1 in each iteration.
        {
            System.out.println("The loop counter is: " + i); // Print the current value of the loop counter to the console.
        }
    }
}
