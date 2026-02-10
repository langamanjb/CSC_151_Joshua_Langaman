package src.labs.example.Mammal;

public class Dog extends Mammal
{
    public Dog(String name)
    {
        this.name = name;
    }
    
    public void bark()
    {
        System.out.println(name + " says: Bark! Bark!");
    }

}
