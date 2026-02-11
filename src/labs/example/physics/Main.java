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

        double distance = physics.getDistance(10, 5);
        System.out.println("Distance: " + distance + " miles");

        double velocity = physics.getVelocity(50, 5);
        System.out.println("Velocity: " + velocity + " miles per hour");

        double momentum = physics.getMomentum(2, 10);
        System.out.println("Momentum: " + momentum + " kg*m/s");

        double force = physics.getForce(2, 9.81);
        System.out.println("Force: " + force + " kg*m/s^2");

        double work = physics.getWork(20, 5);
        System.out.println("Work: " + work + " joules");

        double kineticEnergy = physics.getKineticEnergy(2, 10);
        System.out.println("Kinetic Energy: " + kineticEnergy + " joules");

        double potentialEnergy = physics.getPotentialEnergy(2, 5);
        System.out.println("Potential Energy: " + potentialEnergy + " joules");
    }
}
