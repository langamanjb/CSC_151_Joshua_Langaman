/*
@Author: Joshua Langaman
@Date: 2/11/26
@Description: This class contains methods to calculate various physical quantities such as distance, velocity, momentum, force, work, kinetic energy, and potential energy.
*/
package src.labs.example.physics;

import java.lang.Math; // Importing this allows you to use certain math functions, such as Math.pow() for calculating powers.

public class physics
{
    final static double GRAVITY = 9.81; // Gravity is a constant

    public double getDistance(double v, double t) // v = velocity, t = time
    {
        return v * t;
    }

    public double getVelocity(double x, double t) // x = distance, t = time
    {
        return x / t;
    }
    
    public double getMomentum(double m, double v) // m = mass, v = velocity
    {
        return m * v;
    }

    public double getForce(double m, double a) // m = mass, a = acceleration
    {
        return m * a;
    }

    public double getWork(double f, double d) // f = force, d = distance
    {
        return f * d;
    }

    public double getKineticEnergy(double m, double v) // m = mass, v = velocity
    {
        return 0.5 * m * Math.pow(v, 2);
    }

    public double getPotentialEnergy(double m, double h) // m = mass, h = height
    {
        return m * GRAVITY * h;
    }


/*
@Author: Joshua Langaman
@Date: 2/22/26
@Description: Week 6 Lab: This section of the code shows how to caluculate the angle opposite side a (3) in a right
triangle with sides 3 and 4 using the getAngle method from the physics class. It then checks if the calculated
angle is approximately 36.87 degrees, which is the angle in a 3-4-5 triangle, and logs information about 
whether the angle is valid or invalid.
*/

    public double getAngle(double a, double b) // a and b are the lengths of the two shorter sides of a right triangle. This method calculates the angle opposite side a using the inverse tangent function.
    {
        return Math.toDegrees(Math.atan(a / b)); // Convert the angle from radians to degrees before returning it.
    }

    public void logInvalidAngleInfo(double angle) // This method is used to log information about invalid angles.
    {
        System.out.println("Logging the angle " + angle + " degrees. This is not a right angle.");
    }

    public void logValidAngleInfo(double angle) // This method is used to log information about valid angles.
    {
        System.out.println("Logging the angle " + angle + " degrees. This is a valid 3-4-5 triangle angle");
    }
    
//@Description: Week 6 Lab: This section of the code calculates the speed of light in miles per hour, the time it takes for light to travel 
// from the Sun to Earth in hours, and the distance from the Sun to Earth in miles. It then checks if the calculated distance 
// is approximately equal to the known distance from the Sun to Earth and logs information about whether the calculated 
// distance is valid or invalid.
    public double getLightSppedInMPH()
    {
        double milesPerSecond = 186282; // Speed of light in miles per second
        return milesPerSecond * 3600; // Convert to miles per hour

    }
    public double getTimeFromSunToEarthInHours()
    {
        double seconds = 499; // Time it takes for light to travel from the Sun to Earth in seconds
        return seconds / 3600; // Convert to hours
    }
    public double getKnownDistanceToEarth()
    {
        return 92947266.72; // Known distance from the Sun to Earth in miles
    }
    public void logEarthToSunInvalidDistance(double distance)// This method is used to log information about the calculated distance from the Sun to Earth if it is not approximately equal to the known distance.
    {
        System.out.println("The calculated distance " + distance + " miles is invalid.");
    }

}

