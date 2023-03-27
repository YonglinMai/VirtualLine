import java.util.NoSuchElementException;
/**
 * Name: Yonglin Mai
 * Stony ID: 113299531
 * Homework 4
 * Recitation: 01
 */

/**
 * a fully-documented HoldingQueue class which models a Queue, and extends VirtualLine.
 */
public class HoldingQueue extends VirtualLine{

    private int maxSize;

    /**
     * This is a getter class that gets the max size of the HoldingQueue.
     * @return          :
     *                  The maxSize of the holding Queue
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * This is a setter class that sets the max size of the HoldingQueue.
     * @param maxSize           :
     *                          The max size of the HoldingQueue.
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * A method that adds the specified Person to the rear of the HoldingQueue.
     * @param p         :
     */
    public void enqueue(Person p){
            super.enqueue(p);

    }


    /**
     * A method that removes the Person at the front of the HoldingQueue.
     * @return          :
     *                  The person that is being removed.
     */
    /*
    public Person dequeue() throws NoSuchElementException {
        return super.dequeue();
    }


     */
    /**
     * Returns the student at the front of the HoldingQueue without removing them from the Queue.
     * @return          :
     *                  The person at the front of the line.
     */
    /*
    public Person peek(){
        return super.peek();
    }


     */
    /**
     * Returns true if the HoldingQueue contains no people, returns false otherwise.
     * @return          :
     *                  True if virtual line is empty.
     *                  False if virtual line is not empty.
     */
    /*
    public boolean isEmpty(){
        return super.isEmpty();
    }

     */

}
