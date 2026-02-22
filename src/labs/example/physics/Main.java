/*
@Author: Joshua Langaman
@Date: 2/11/26
@Description: This program demonstrates the use of a physics class to calculate various physical quantities.
*/
package src.labs.example.physics;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        physics physics = new physics(); // Create an instance of the physics class to access its methods.

        // All of the following lines call different methods from the physics class to calculate and print various physical quantities.
        // See physics.java for the implementation of these methods and the formulas they use.

        // double distance = physics.getDistance(10, 5);
        // System.out.println("Distance: " + distance + " miles");

        // double velocity = physics.getVelocity(50, 5);
        // System.out.println("Velocity: " + velocity + " miles per hour");

        // double momentum = physics.getMomentum(2, 10);
        // System.out.println("Momentum: " + momentum + " kg*m/s");

        // double force = physics.getForce(2, 9.81);
        // System.out.println("Force: " + force + " kg*m/s^2");

        // double work = physics.getWork(20, 5);
        // System.out.println("Work: " + work + " joules");

        // double kineticEnergy = physics.getKineticEnergy(2, 10);
        // System.out.println("Kinetic Energy: " + kineticEnergy + " joules");

        // double potentialEnergy = physics.getPotentialEnergy(2, 5);
        // System.out.println("Potential Energy: " + potentialEnergy + " joules");


/*
@Author: Joshua Langaman
@Date: 2/22/26
@Description: Week 6 Lab: This section of the code shows how to caluculate the angle opposite side a (3) in a right 
triangle with sides 3 and 4 using the getAngle method from the physics class. It then checks if the calculated
angle is approximately 36.87 degrees, which is the angle in a 3-4-5 triangle, and logs information about 
whether the angle is valid or invalid.
*/

        double angle = physics.getAngle(3, 4); // Calculate the angle opposite side a (3) in a right triangle with sides 3 and 4.

        if (angle > 37 || angle < 36.87) // Check if the calculated angle is not approximately 36.87 degrees, which is the angle in a 3-4-5 triangle.
        {
            physics.logInvalidAngleInfo(angle); // Log information about the invalid angle if it is not approximately 36.87 degrees.
        }
        else
        {
            physics.logValidAngleInfo(angle); // Log information about the valid angle if it is approximately 36.87 degrees.
        }

//@Description: Week 6 Lab: This section of the code calculates the distance from the Sun to Earth using the speed of light and the 
// time it takes for light to travel from the Sun to Earth. It then compares the calculated distance to the known distance 
// from the Sun to Earth and logs information about whether the calculated distance is valid or invalid.

        double velocity = physics.getLightSppedInMPH(); // Calculate the speed of light in miles per hour using the getLightSppedInMPH method from the physics class.
        double time = physics.getTimeFromSunToEarthInHours(); // Calculate the time it takes for light to travel from the Sun to Earth in hours using the getTimeFromSunToEarthInHours method from the physics class.
        double distance = physics.getDistance(velocity, time);
        double knownDistance = physics.getKnownDistanceToEarth(); // Get the known distance from the Sun to Earth in miles using the getDistanceFromSunToEarthInMiles method from the physics class.   

        if (distance != knownDistance) // Check if the calculated distance from the Sun to Earth is not approximately equal to the known distance from the Sun to Earth.
        {
            physics.logEarthToSunInvalidDistance(distance); // Log information about the calculated distance if it is approximately equal to the known distance from the Sun to Earth.;
        }
        else
        {
            System.out.println("The calculated distance is valid: " + distance + " miles.");
        }

    }



}
