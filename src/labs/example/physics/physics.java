package src.labs.example.physics;

import java.lang.Math;

public class physics
{
    final static double GRAVITY = 9.81;

    public double getDistance(double v, double t)
    {
        return v * t;
    }

    public double getVelocity(double x, double t)
    {
        return x / t;
    }
    
    public double getMomentum(double m, double v)
    {
        return m * v;
    }

    public double getForce(double m, double a)
    {
        return m * a;
    }

    public double getWork(double f, double d)
    {
        return f * d;
    }

    public double getKineticEnergy(double m, double v)
    {
        return 0.5 * m * Math.pow(v, 2);
    }

    public double getPotentialEnergy(double m, double h)
    {
        return m * GRAVITY * h;
    }

        
    
}
