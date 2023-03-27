
/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 4
 * Recitation: 01
 */

/**
 * A fully documented class that randomly selects a ride.
 */
public class RandomGenerator {
    /**
     * This selects an element of the array passed in with equal probability for each one.
     * @param rides         :
     *                      The list of Ride.
     * @return              :
     *                      The chosen Ride.
     */
    public static Ride selectRide(Ride[] rides){
        int max = rides.length - 1;
        int p = (int) Math.round(Math.random() * max);
        return rides[p];
    }
}
