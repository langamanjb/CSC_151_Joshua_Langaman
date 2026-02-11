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

        
    
}
