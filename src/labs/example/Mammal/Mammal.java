package src.labs.example.Mammal;

public class Mammal 
{
    String hairColor;
    String eyeColor;
    double bodyTemp;
    int age;
    double weight;
    boolean isAwake;

    public Mammal(String hairColor, String eyeColor, double bodyTemp, int age, double weight, boolean isAwake) 
    {
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.bodyTemp = bodyTemp;
        this.age = age;
        this.weight = weight;
        this.isAwake = isAwake;
    }

    public void run() 
    {
        System.out.println("The mammal is running.");
    }

    public void eat() 
    {
        System.out.println("The mammal is eating.");
    }
    
    public void sleep() 
    {
        isAwake = false;
        System.out.println("The mammal is sleeping.");
    }

    public void scratch() 
    {
        System.out.println("The mammal is scratching itself.");
    }

    public void wakeUp() 
    {
        isAwake = true;
        System.out.println("The mammal is awake.");
    }

    public void makingNoise()
    {
        System.out.println("The mammal makes a noise.");
    }

    public void breath() 
    {
        System.out.println("The mammal is breathing.");
    }

    public void drinkingWater() 
    {
        System.out.println("The mammal is drinking water.");
    }

    public void isMoving()
    {
        System.out.println("The mammal is moving.");
    }
}
