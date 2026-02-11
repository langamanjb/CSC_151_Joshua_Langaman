package src.labs.example.Mammal;

public class Main 
{
    public static void main (String[] args) throws Exception 
    {
        Mammal mammal = new Mammal();

    //     mammal.setName("Cat");
    //     String mammalName = mammal.getName();
    //     System.out.println("Mammal Name: " + mammalName);

    //    mammal.sit();
    //    System.out.println(mammalName + " is no longer sitting.");

    //     mammal.isMoving();
    //     mammal.makingNoise();

        mammal.walk();
        mammal.calculateAngle();

        // Create an instance of the Dog class, which is a subclass of Mammal, and demonstrate its functionality.

        Dog dog = new Dog("Feast"); // My actual dogs name. 
        System.out.println("Dog Name: " + dog.getName());
        dog.bark(); // This will call the bark method of the Dog class, which will print a message to the console that includes the dog's name.
       

    }
}
