/*
@author: Joshua Langaman
@date: 2/23/26
@description: Week 6 Lab: This section of the code defines a class called WhileLoop. 

1. In your WhileLoop.java Class, you should create a private method named executeWhileLoop() that does not take 
any arguments and implements a While loop to iterate until the loop executes 10 times. You should call the
executeWhileLoop() method from the main() method in your Class. You should use what you learned with incrementing/decrementing 
counters to execute the While loop. After the loop is complete, you should print a message to the console that prints the number 
of iterations and a message that the loop is now complete. Hint: use concatenation when printing the message.
*/

package labs.example.loops;

public class WhileLoop 
{
    public static void main(String[] args) // The main method is the entry point of the program. It is where the execution starts.
    {
        executeWhileLoop(); // Call the executeWhileLoop method to run the while loop and print the results.
    }
    public static void executeWhileLoop()
    {
        int counter = 0; // Initialize a counter variable to keep track of the number of iterations.
        while (counter < 10) // The loop will continue to execute as long as the counter is less than 10.
        {
            System.out.println("The loop is executing. Current iteration: " + (counter + 1)); // Print the current iteration number to the console.
            counter++; // Increment the counter by 1 in each iteration.

        }
        System.out.println("The loop executed " + counter + " times. The loop is now complete."); // Print the number of iterations and a completion message.
        
    }
}
