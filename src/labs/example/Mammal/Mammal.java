package src.labs.example.Mammal;

public class Mammal 
{
    String hairColor;
    String eyeColor;
    double bodyTemp;
    int age;
    double weight;
    boolean isAwake;
    boolean isSitting;
    String name;

    public Mammal(String hairColor, String eyeColor, double bodyTemp, int age, double weight, boolean isAwake, boolean isSitting) 
    {
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.bodyTemp = bodyTemp;
        this.age = age;
        this.weight = weight;
        this.isAwake = isAwake;
        this.isSitting = isSitting;
    }


    public void run() 
    {
        System.out.println("The mammal is running.");
    }

    public void eat() 
    {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() 
    {
        isAwake = false;
        System.out.println(name + " is sleeping.");
    }

    public void scratch() 
    {
        System.out.println(name + " is scratching itself.");
    }

    public void wakeUp() 
    {
        isAwake = true;
        System.out.println(name + " is awake.");
    }

    public void makingNoise()
    {
        System.out.println(name + " makes a noise.");
    }

    public void breath() 
    {
        System.out.println(name + " is breathing.");
    }

    public void drinkingWater() 
    {
        System.out.println(name + " is drinking water.");
    }

    public void isMoving()
    {
        System.out.println(name + " is moving.");
    }

    public void getMammalDetails()
    {
        System.out.println(this.hairColor);
        System.out.println(this.eyeColor);
    }

    public void sit() throws Exception
    {
        isSitting = true;
        System.out.println(name + " is sitting.");
        Thread.sleep(15000);



    }

    public void setName(String name)
    {
        this.name = name;
        return;
    }

    public String getName()
    {
       return this.name;
    }
    public Mammal()
    {
        
    }
}
    
