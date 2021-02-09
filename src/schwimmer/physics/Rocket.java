package schwimmer.physics;

/**
 * Class to manage the location of a Rocket after it's been fired. 
 */
public class Rocket {

    private final double velocity;
    private final double angle;

    public Rocket(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = Math.toRadians(angle);
    }

    /**
     *
     * @param time in seconds
     * @return the X location of the Rocket at the specified time.
     */
    public double getX(double time) {
        double xVelocity = Math.cos(angle) * velocity;
        return xVelocity * time;
    }

    /**
     *
     * @param time in seconds
     * @return the Y location of the Rocket at the specified time.
     */
    public double getY(double time) {
        final double GRAVITY = 9.8;
        double yVelocity = Math.sin(angle) * velocity;
        double y = yVelocity * time - 0.5 * GRAVITY * time * time;
        return y;
    }

    /**
     *
     * @return the time in seconds that the rocket lands.
     */
    public double getFlightTime() {
        final double GRAVITY = 9.8;
        double yVelocity = Math.sin(angle) * velocity;
        return yVelocity / (0.5 * GRAVITY);
    }

    public double getHighestY() {
        final double GRAVITY = 9.8;
        double yVelocity = Math.sin(angle) * velocity;
        return (yVelocity * yVelocity) / (GRAVITY * 2);
    }

}
