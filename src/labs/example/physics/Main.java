package src.labs.example.physics;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        physics physics = new physics();

        double distance = physics.getDistance(10, 5);
        System.out.println("Distance: " + distance);

        double velocity = physics.getVelocity(50, 5);
        System.out.println("Velocity: " + velocity);

        double momentum = physics.getMomentum(2, 10);
        System.out.println("Momentum: " + momentum);

        double force = physics.getForce(2, 9.81);
        System.out.println("Force: " + force);

        double work = physics.getWork(20, 5);
        System.out.println("Work: " + work);

        double kineticEnergy = physics.getKineticEnergy(2, 10);
        System.out.println("Kinetic Energy: " + kineticEnergy);

        double potentialEnergy = physics.getPotentialEnergy(2, 5);
        System.out.println("Potential Energy: " + potentialEnergy);
    }
}
