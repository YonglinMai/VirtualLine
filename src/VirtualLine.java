import java.util.LinkedList;
/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 4
 * Recitation: 01
 */

/**
 * A fully-documented VirtualLine class which models a Queue.
 */
public class VirtualLine extends LinkedList<Person> {

    /**
     * A method that adds the specified Person to the rear of the VirtualLine.
     * @param p         :
     *                  The person that is to be added to the rear of the line.
     */
    public void enqueue(Person p){
        super.add(p);
    }

    /**
     * A method that removes the Person at the front of the VirtualLine.
     * @return          :
     *                  The person that is being removed.
     */
    public Person dequeue() {
        return super.remove();
    }

    /**
     * Returns the student at the front of the VirtualLine without removing them from the Queue.
     * @return          :
     *                  The person at the front of the line.
     */
    public Person peek(){
        return super.peek();
    }

    /**
     * Returns true if the VirtualLine contains no people, returns false otherwise.
     * @return          :
     *                  True if virtual line is empty.
     *                  False if virtual line is not empty.
     */
    public boolean isEmpty(){
        return super.isEmpty();
    }
}
