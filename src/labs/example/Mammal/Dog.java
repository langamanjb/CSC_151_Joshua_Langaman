/*
@author: Joshua Langaman
@date: 2/11/26
@description: This class defines a Dog, which is a type of Mammal. It includes a constructor to set the dog's name and a method to simulate the dog barking.
*/

package src.labs.example.Mammal;

public class Dog extends Mammal 
{
    public Dog(String name) // Constructor for the Dog class, which takes a name as a parameter and assigns it to the instance variable 'name' inherited from the Mammal class.
    {
        this.name = name;
    }
    
    public void bark() // This method simulates the dog barking by printing a message to the console that includes the dog's name.
    {
        System.out.println(name + " says: Bark! Bark!");
    }

}
