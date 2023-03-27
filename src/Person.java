import java.util.ArrayList;
import java.util.List;

/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 4
 * Recitation: 01
 */

/**
 * fully-documented class named Person which contains an integer id, the max amount of lines they can be on,
 * array or a list of the current lines that they are on and the current status of the person (an enum).
 */

public class Person {

    private int number;
    private int maxLines;
    private List<Ride> lines;
    private Status status;

    private String membership;

    private int totalRide = 0;

    /**
     * This is a getter method gets the total ride of a person.
     * @return          :
     *                  The total ride of a person.
     */
    public int getTotalRide() {
        return totalRide;
    }

    /**
     *  This method is a setter method that sets the total ride of a person.
     * @param totalRide     :
     *                      The total ride of a person.
     */
    public void setTotalRide(int totalRide) {
        this.totalRide = totalRide;
    }

    /**
     * This is a getter method that gets the membership of the person.
     * @return          :
     *                  the membership of the person.
     */
    public String getMembership() {
        return membership;
    }
    /**
     * This is a setter method that sets the membership of a person.
     * @param membership    :
     *                  The membership of the person.
     */
    public void setMembership(String membership) {
        this.membership = membership;
    }

    /**
     * This is a getter method that gets the number of the person.
     * @return          :
     *                  the number of the person.
     */
    public int getNumber() {
        return number;
    }

    /**
     * This is a getter method that gets the max number of lines the person can be on.
     * @return          :
     *                  the max number of lines the person can be on.
     */
    public int getMaxLines() {
        return maxLines;
    }

    /**
     * This is a getter method that gets lines that the person is on.
     * @return          :
     *                  The lines that the person is in.
     */
    public List<Ride> getLines() {
        return lines;
    }

    /**
     * This is a getter method that gets the status of the person.
     * @return          :
     *                  Returns the status of the person.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * This is a setter method that sets the number of a person.
     * @param number    :
     *                  The number of the person.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * This is a setter method that sets the max number of lines for a person.
     * @param maxLines      :
     *                      The max number of lines for a person.
     */
    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
    }

    /**
     * This is a setter method that sets the lines of a person
     * @param lines         :
     *                      The lines that the person is currently on.
     */
    public void setLines(List<Ride> lines) {
        this.lines = lines;
    }

    /**
     * This is a setter method that sets the status of a person
     * @param status        :
     *                      The status of a person
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * This is a default Person constructor that initializes the person number.
     * @param number        :
     *                      The number of a person.
     * Preconditions        :
     *                      The number must be positive.
     * Throws               :
     *                      IllegalArgumentException if the number is not positive
     */
    public Person(int number) throws IllegalArgumentException{
        if (number < 0){
            throw new IllegalArgumentException();
        }
        lines = new ArrayList<>();
        this.number = number;
        setStatus(Status.Available);
    }

    public String toString(){
        String rides = "";
        for (Ride line : lines) {
            rides = rides  + "      " + line.getName() + "      ";
        }
        return (number + rides + status + "\n");
    }
}
