import java.util.ArrayList;
import java.util.List;

/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 4
 * Recitation: 01
 */

/**
 * fully-documented Ride object which will contain the duration of the ride in minutes,
 * an instance of the VirtualLine Object, an instance of the HoldingQueue Object,
 * a list or an array of all the people on the ride
 */
public class Ride {

    private int duration;

    private int timeLeft;

    private int capacity;

    private String Name;

    private VirtualLine virtualLine;

    private HoldingQueue holdingQueue;

    private List<Person> peopleOnRide;

    private int totalPeople = 0;

    /**
     * The default constructor of the Ride class.
     */
    public Ride(){
        virtualLine = new VirtualLine();
        holdingQueue = new HoldingQueue();
        peopleOnRide = new ArrayList<>();

    }

    /**
     * This is a getter method that gets the total number of people that went on the ride.
     * @return          :
     *                  The total number of people that went on the ride.
     */
    public int getTotalPeople() {
        return totalPeople;
    }

    /**
     * This is a setter method that sets the total number of people that went on the ride.
     * @param totalPeople           :
     *                              The total number of people that went on the ride.
     */
    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }

    /**
     * This is a getter method that gets the duration of the Ride.
     * @return          :
     *                  The duration of the Ride.
     */
    public int getDuration() {
        return duration;
    }
    /**
     * This is a getter method that gets the capacity of the Ride.
     * @return          :
     *                  The capacity of the Ride.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This is a getter method that gets the duration of the Ride.
     * @return          :
     *                  The time left for the ride.
     */
    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * This is a getter method that gets the Name of the Ride.
     * @return          :
     *                  The name of the Ride.
     */
    public String getName() {
        return Name;
    }

    /**
     * This is a getter method that gets the HoldingQueue of the Ride.
     * @return          :
     *                  The HoldingQueue of the Ride.
     */
    public HoldingQueue getHoldingQueue() {
        return holdingQueue;
    }

    /**
     * This is a getter method that gets the VirtualLine of the Ride.
     * @return          :
     *                  The VirtualLine of the ride.
     */
    public VirtualLine getVirtualLine() {
        return virtualLine;
    }

    /**
     * This is a getter method that gets the People on the Ride.
     * @return          :
     *                  A list of people on the Ride.
     */
    public List<Person> getPeopleOnRide() {
        return peopleOnRide;
    }

    /**
     * This is a setter method that sets the duration of the Ride.
     * @param duration      :
     *                      The duration of the Ride.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * This is a setter method that sets the capacity of the Ride.
     * @param capacity      :
     *                      The capacity of the ride.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * This is a setter method that sets the Name of the Ride.
     * @param name          :
     *                      The name of the Ride.
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * This is a setter method that sets the HoldingQueue of the Ride.
     * @param holdingQueue      :
     *                          The HoldingQueue of the Ride.
     */
    public void setHoldingQueue(HoldingQueue holdingQueue) {
        this.holdingQueue = holdingQueue;
    }

    /**
     * This is a setter method that sets the list of people that is on the Ride.
     * @param peopleOnRide      :
     *                          The list of people on the ride.
     */
    public void setPeopleOnRide(List<Person> peopleOnRide) {
        this.peopleOnRide = peopleOnRide;
        //System.out.println(this.peopleOnRide);
        /*
        for (int i = 0; i < getTotalPeople(); i++){
            this.peopleOnRide.set(i, peopleOnRide.get(i));
        }

         */

    }

    /**
     * This is a setter method that sets the time left for the ride.
     * @param timeLeft          :
     *                          The amount of time that is left for the Ride.
     */
    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    /**
     * This is a setter method that sets the VirtualLine of the Ride.
     * @param virtualLine
     */
    public void setVirtualLine(VirtualLine virtualLine) {
        this.virtualLine = virtualLine;
    }


    /**
     * A method that adds the specified Person to the rear of the VirtualLine.
     * @param p         :
     *                  The person that is to be added to the rear of the line.
     */

    public void enqueue(Person p){
        virtualLine.enqueue(p);
    }

    /**
     * A method that removes the Person at the front of the VirtualLine.
     * @return          :
     *                  The person that is being removed.
     */
    public Person dequeue() {
       return virtualLine.dequeue();
    }
}
