package net.paperdave.csi2130.structures;

/**
 * A Collection class is a data type that is capable of holding a group of items.
 * In Java, Collection classes can be implemented as a class, along with methods to add, remove, and examine items.
 *
 * This bag is a very basic example of a collection. Inside the bag are some numbers.
 * When you first begin to use a bag, the bag will be empty.
 * We count on this to be the initial state of any bag that we use.
 * Numbers may be added into a bag.
 * The bag can hold many numbers.
 * We can even place the same number more than once.
 * We may remove a number from a bag, But we remove only one number at a time.
 * Another operation is to determine how many numbers are in a bag.
 */
public class Bag {
    private static final int BAG_SIZE = 100;
    private int[] bag;
    private int size;

    //  Post-condition:  The Bag has been initialized and it is now empty.
    public Bag() {
        bag = new int[BAG_SIZE];
        size = 0;
    }

    /** Adds a new item to the bag.
     *  @param item  The item to be added to the bag.
     */
    public void add(int item) {
        bag[size] = item;
        size++;
    }

    /** The return value is the number of integers in the Bag. */
    public int size() {
        return size;
    }

    public int countOccurrences(int target) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (bag[i] == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * If target was in the Bag, then one copy of target has been removed from the Bag, and the return value is true;
     * otherwise the Bag is unchanged and the return value is false.
     */
    public boolean remove(int target) {
        int index = 0;
        while ((index < size) && (bag[index] != target)) {
            index++;
        }
        if (index == size) {
            return false;
        } else {
            bag[index] = bag[size - 1];
            size--;
            return true;
        }
    }

    
}
