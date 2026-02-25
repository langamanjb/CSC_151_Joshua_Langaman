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

4. In your ForLoop.java Class, you should implement a new private method named sumLoopCounter() that takes an integer 
argument and returns an integer value. You should use a for-loop to loop until the integer argument value is 
reached(e.g. if you pass in 10 for the integer value, you should loop 10 times). 
Each iteration through the loop, you should add the loop counter value to a new variable named sum and continue to 
sum the values until the for-loop is done. You should call this new method from the main() method and print the following 
message with the returned value-> The sum of the loop counter is:"xx". 

5. In your ForLoop.java Class, you should implement a new private method named printMultiplicationTable() that takes 
an integer value and returns void. Your method's goal is to generate the multiplication table for any integer value 
passed in and should print the multiplication table for every value between 0 and 12. You should 
call the printMultiplicationTable() method from the main() method in your class.
*/

package labs.example.loops;

public class ForLoop 
{
    public static void main(String[] args) // The main method is the entry point of the program. It is where the execution starts.
    {
        executeForLoop(); // Call the executeForLoop method to run the for loop and print the results.

        int sum = sumTwoNumbers(10, 20); // Call the sumTwoNumbers method with two integers.
        --sum; // Decrement the returned sum by 1 using the prefix approach.
        System.out.println("The decremented sum is: " + sum); // Print the decremented value to the console.

        int loopSum = sumLoopCounter(10); // Call the sumLoopCounter method with an integer argument.
        System.out.println("The sum of the loop counter is: " + loopSum); // Print the returned value from the sumLoopCounter method to the console with a message.

        printMultiplicationTable(2); // Call the printMultiplicationTable method with an integer argument to generate and print the multiplication table for that number.

    }
    //2.
    private static void executeForLoop()
    {
        for (int i = 0; i < 20; i++) // The loop will execute 20 times, starting from 0 and incrementing by 1 in each iteration.
        {
            System.out.println("The loop counter is: " + i); // Print the current value of the loop counter to the console.
        }
    }
    //3.
    private static int sumTwoNumbers(int num1, int num2) // This method takes two integer arguments and returns their sum.
    {
        return num1 + num2; // Return the sum of the two numbers.
    }
    //4. 
    private static int sumLoopCounter(int limit) // This method takes an integer argument and returns the sum of the loop counter values up to that limit.
    {
        int sum = 0; // Initialize a variable to hold the sum of the loop counter values.
        for (int i = 0; i < limit; i++) // Loop until the integer argument value is reached.
        {
            sum += i; // Add the current loop counter value to the sum variable.
        }
        return sum; // Return the final sum after the loop is done.
    }
    //5.
    private static void printMultiplicationTable(int number) // This method takes an integer argument and prints the multiplication table for that number.
        {
            System.out.println("Multiplication Table for " + number + ":"); // Print a header for the multiplication table.
            for (int i = 0; i <= 12; i++) // Loop from 0 to 12 to generate the multiplication table.
            {
                System.out.println(number + " x " + i + " = " + (number * i)); // Print the current multiplication result to the console.
            }
        }
}
