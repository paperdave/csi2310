// Created Date: 2023-01-18
package net.paperdave.csi2130.structures.bag;

/**
 * it's a bag of numbers
 */
public class Bag implements IBag {
    private static final int DEFAULT_BAG_SIZE = 100;
    private int[] bag;
    private int pointer;

    /**
     * Post-condition: The Bag has been initialized and it is now empty.
     */
    public Bag(int size) {
        bag = new int[size];
        pointer = 0;
    }

    /**
     * Post-condition: The Bag has been initialized and it is now empty.
     */
    public Bag() {
        this(DEFAULT_BAG_SIZE);
    }

    /** Adds a new item to the bag.
     *  @param item  The item to be added to the bag.
     */
    public void add(int item) {
        if (pointer == DEFAULT_BAG_SIZE) {
            throw new BagFullException();
        }
        
        bag[pointer] = item;
        pointer++;
    }

    /** Adds a new item to the bag.
     *  @param item  The item to be added to the bag.
     */
    public boolean tryAdd(int item) {
        if (pointer == DEFAULT_BAG_SIZE) {
            return false;
        }
        
        bag[pointer] = item;
        pointer++;

        return true;
    }

    /** The return value is the number of integers in the Bag. */
    public int size() {
        return pointer;
    }

    public int capacity() {
        return bag.length;
    }

    /** Counts up the number of occurrences of target in the Bag.
     *  @param target  The integer to be counted.
     *  @return  The number of times that target occurs in the Bag.
     */
    public int countOccurrences(int target) {
        int count = 0;
        for (int i = 0; i < pointer; i++) {
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
        while ((index < pointer) && (bag[index] != target)) {
            index++;
        }
        if (index == pointer) {
            return false;
        } else {
            bag[index] = bag[pointer - 1];
            pointer--;
            return true;
        }
    }
}
