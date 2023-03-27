
import java.util.*;
/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 4
 * Recitation: 01
 */

/**
 * fully-documented driver class called SevenFlags which runs the simulation.
 */
public class SevenFlags {

    private static Ride BSOD = new Ride();
    private static  Ride ToT = new Ride();
    private static Ride GF = new Ride();
    private static Ride KK = new Ride();

    private static Ride[] rides = new Ride[]{BSOD, ToT, GF, KK};

    private static ArrayList<Person> regular = new ArrayList<>();
    private static ArrayList<Person> silver = new ArrayList<>();
    private static ArrayList<Person> gold = new ArrayList<>();

    public static Scanner input = new Scanner(System.in);

    /**
     * This method randomly generates rides for a person.
     * @param p         :
     *                  The target person.
     */
    public static void determineRides(Person p){
        for (int i = p.getLines().size(); i < p.getMaxLines(); i++){
            // Randomly generate a ride for the peron
            Ride newRide = RandomGenerator.selectRide(rides);

            //enqueue the people into the virtual line of the ride.
            newRide.enqueue(p);
            // Add the Ride to the list of rides.
            //rideList.add(newRide);
            p.getLines().add(newRide);
        }
        //set the person's ride list to the newly created ride list.
        //p.setLines(rideList);
    }

    /**
     * This method creates a line of people of a specific membership.
     * @param memberShip        :
     *                          the membership line.
     * @param numCustomer       :
     *                          The number of people with the membership.
     * @param maxLine           :
     *                          The max line that each person can be on.
     * @param member            :
     *                          The string format of the membership.
     */
    public static void createLine(ArrayList<Person> memberShip, int numCustomer, int maxLine, String member){
        for (int i = 1; i <= numCustomer; i++){
           Person person = new Person(i);
           person.setMaxLines(maxLine);
           person.setMembership(member);
           determineRides(person);
           memberShip.add(person);
           //System.out.println(memberShip.get(i-1).getMembership());
        }
    }

    /**
     * This method sets up the Ride object for each ride.
     * @param ride          :
     *                      The ride object.
     * @param name          :
     *                      The name of the Ride object.
     */
    public static void setRides (Ride ride, String name){
        ride.setName(name);

        System.out.println("Please enter the duration of " + ride.getName() + " (minutes): ");
        int duration = input.nextInt();
        ride.setDuration(duration);

        System.out.println("Please enter the capacity of " + ride.getName() + ": ");
        ride.setCapacity(input.nextInt());

        System.out.println("Please enter the holding queue size for " + ride.getName() + ": ");
        int holdingQueue = input.nextInt();
        ride.getHoldingQueue().setMaxSize(holdingQueue);

        ride.setTimeLeft(duration);
    }




    /**
     * This method generates a string format of the people waiting in line.
     * @param line          :
     *                      The linked list of people on the line.
     * @return              :
     *                      The line in string format.
     */
    public static String printLoop(LinkedList<Person> line){
        String printLine = "";
        for (Person item: line){
           String itemString = "[" + item.getMembership() + " " + item.getNumber() + "]" + "   ";
           printLine += itemString;
        }
        return printLine;
    }

    /**
     * This method generates a string format of the people on the ride.
     * @param line          :
     *                      The list of people on the ride.
     * @return              :
     *                      The list in string format.
     */
    public static String printList(List<Person> line){
        String printLine = "";
        for (Person item: line){
            String itemString = "[" + item.getMembership() + " " + item.getNumber() + "]" + "   ";
            printLine += itemString;
        }
        return printLine;
    }

    /**
     * This method puts the printLoop and the printList method together and prints all the information for each ride.
     * @param ride          :
     *                      The Ride object that is to be printed.
     */
    public static void printRide(Ride ride){
        System.out.println(ride.getName() + " - Time remaining: " + ride.getTimeLeft() + " min");
        System.out.println("On Ride: " + printList(ride.getPeopleOnRide()));
        System.out.println("Holding Queue: " + printLoop(ride.getHoldingQueue()));
        System.out.println("Virtual Queue: " + printLoop(ride.getVirtualLine()));
    }

    /**
     * This method generates a string format of all person objects in an arrayList.
     * @param membershipLine            :
     *                                  The arrayList of person objects.
     * @return                          :
     *                                  A string of all person objects.
     */
    public static String printMemberLine(ArrayList<Person> membershipLine){
        String personString = "";
        for(Person p: membershipLine){
            personString += p.toString();
        }
        return personString;
    }

    /**
     * This method puts the printRide method and printString method together and print all the information of the
     * stimulation.
     */
    public static void printAll(){
            System.out.println();
            printRide(BSOD);
            System.out.println();
            printRide(ToT);
            System.out.println();
            printRide(KK);
            System.out.println();
            printRide(GF);
            System.out.println();

            System.out.println("Regular Customers:");
            System.out.println("Num         Line        Status");
            System.out.println("------------------------------");
            System.out.println(printMemberLine(regular));

            System.out.println("Silver Customers:");
            System.out.println("Num         Line 1       Line 2       Status");
            System.out.println("--------------------------------------------");
            System.out.println(printMemberLine(silver));

            System.out.println("Gold Customers:");
            System.out.println("Num         Line 1        Line 2      Line 3       Status");
            System.out.println("---------------------------------------------------------");
            System.out.println(printMemberLine(gold));
    }

    /**
     * This is a method that generates a new round of ride, once a ride ends.
     * @param ride          :
     *                      The ride object that is starting a new round.
     */
    public static void newRound(Ride ride){
        ArrayList<Person> newRound = new ArrayList<>();

        for (Person p: ride.getPeopleOnRide()){
            // Change the status of the people.
            p.setStatus(Status.Available);
            // Remove the ride from their Ride list.
            p.getLines().remove(0);
            // Generate a new ride for the person.
            //p.getLines().add(newRide(p));
            determineRides(p);

        }
        // push people from the HoldingQueue to the onRide list
        int i = newRound.size();
        while(i < ride.getCapacity() && !ride.getHoldingQueue().isEmpty()){
            ride.setTotalPeople(ride.getTotalPeople() + 1);
            Person p = ride.getHoldingQueue().dequeue();
            newRound.add(p);
            p.setStatus(Status.OnRide);
            p.setTotalRide(p.getTotalRide() + 1);
            i++;
        }
        ride.setPeopleOnRide(newRound);

        // push another set of Person to the HoldingQueue.
        int count = ride.getHoldingQueue().size();
        VirtualLine temp = new VirtualLine();
        while (count < ride.getHoldingQueue().getMaxSize() && !ride.getVirtualLine().isEmpty()){
            Person p = ride.dequeue();
            if (p.getStatus().equals(Status.Available)){
                ride.getHoldingQueue().enqueue(p);
                p.setStatus(Status.Holding);
                count++;
            }
            else{
                temp.enqueue(p);
            }
        }
        ride.setVirtualLine(temp);
    }

    /**
     * This is a method that counts down the time left for each ride.
     * @param ride          :
     *                      The ride object for the count down.
     */
    public static void countDown(Ride ride){
        if (ride.getTimeLeft() - 1 == 0){
            ride.setTimeLeft(ride.getDuration());
            newRound(ride);
        }
        else{
            ride.setTimeLeft(ride.getTimeLeft() - 1);
        }
    }

    /**
     * This methode set up the lines immediately after the user enters the needed inputs
     * @param ride          :
     *                      The Target ride class for the setup.
     */
    public static void initialSetup(Ride ride){
        int i = 0;
        int j = 0;

        while (i < ride.getCapacity() && !ride.getVirtualLine().isEmpty()){
            Person next = ride.getVirtualLine().dequeue();
            next.setTotalRide(next.getTotalRide() + 1);
            ride.getPeopleOnRide().add(next);
            next.setStatus(Status.OnRide);
            i++;
        }
        while (j < ride.getHoldingQueue().getMaxSize() && !ride.getVirtualLine().isEmpty()){
            Person next = ride.dequeue();
            ride.getHoldingQueue().enqueue(next);
            next.setStatus(Status.Holding);
            j++;
        }
    }

    /**
     * This method calculates the average rides each membership can get.
     * @param memberList        :
     *                          The membership list.
     * @return                  :
     *                          The average rides of each membership.
     */
    public static double averageRide(ArrayList<Person> memberList){
        int sum = 0;
        for(Person p: memberList){
            sum += p.getTotalRide();
        }
        return sum /(double) memberList.size();
    }

    /**
     * This method prints out the overall statistics of the stimulation.
     */
    public static void printStatistics(){
        System.out.println("On average, Gold customers have taken " + averageRide(gold) + " rides");
        System.out.println("On average, Silver customers have taken " + averageRide(silver) + " rides");
        System.out.println("On average, Regular customers have taken " + averageRide(regular) + " rides");
        System.out.println();
        System.out.println("BSOD has completed rides for " + BSOD.getTotalPeople());
        System.out.println("ToT has completed rides for " + ToT.getTotalPeople());
        System.out.println("KK has completed rides for " + GF.getTotalPeople());
        System.out.println("GF has completed rides for " + KK.getTotalPeople());
    }

    /**
     * Main method that runs the entire stimulation.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Seven Flags!");

        System.out.println("Please enter the number of regular customers: ");
        int regularPpl = input.nextInt();
        System.out.println("Please enter the number of silver customers: ");
        int silverPpl = input.nextInt();
        System.out.println("Please enter the number of gold customers: ");
        int goldPpl = input.nextInt();
        System.out.println("Please enter simulation length: ");
        int counter = input.nextInt();
        //System.out.println(time);

        try{
            createLine(gold, goldPpl, 3, "Gold");
            createLine(silver, silverPpl, 2, "Silver");
            createLine(regular, regularPpl, 1, "Regular");
        }catch (IllegalArgumentException e){
            System.out.println("Illegal Argument");
        }


        // Set up each ride.
        setRides(BSOD, "BSOD");
        setRides(KK, "KK");
        setRides(ToT, "ToT");
        setRides(GF, "GF");

        // Initial setup of the stimulation
        initialSetup(BSOD);
        initialSetup(ToT);
        initialSetup(KK);
        initialSetup(GF);

        for (int count = 0; count <= counter; count++){
            System.out.println("At time " + count + ":");
            printAll();
            countDown(BSOD);
            countDown(ToT);
            countDown(KK);
            countDown(GF);
        }

        System.out.println("----------------------------------");
        printStatistics();

    }
}
