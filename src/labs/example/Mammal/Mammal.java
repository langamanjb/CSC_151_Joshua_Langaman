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
    String species;  

    public Mammal(String hairColor, String eyeColor, double bodyTemp, int age, double weight, boolean isAwake, boolean isSitting, String name, String species) 
    {
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.bodyTemp = bodyTemp;
        this.age = age;
        this.weight = weight;
        this.isAwake = isAwake;
        this.isSitting = isSitting;
        this.species = "";
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
        //Thread.sleep(15000);
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
    public void species(String speciesName) 
    {
        System.out.println("Species: " + speciesName);
        return;
    }
    
    public int walk()
    {
        int walkSouth = 3;
        int walkEast = 4;

        double distance = Math.sqrt(Math.pow(walkSouth, 2) + Math.pow(walkEast, 2));

        System.out.println(name + " walked 3 miles south and 4 miles east. Straight line distance from starting point: " + distance + " miles.");
        return (int) distance;
    }
    public double calculateAngle()
    {
        double walkSouth = 3;
        double walkEast = 4;

        double angleInDegrees = Math.toDegrees(Math.atan2(walkSouth, walkEast));

        System.out.printf("%s Angle from South to East: %.2f degrees %n", name, angleInDegrees);
        return angleInDegrees;
    }
    public void barking()
    {
        System.out.println("Woof Woof!");
    }
}
    
