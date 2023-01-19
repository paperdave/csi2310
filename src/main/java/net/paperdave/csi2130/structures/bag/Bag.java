// Created Date: 2023-01-18
package net.paperdave.csi2130.structures.bag;

/**
 * it's a bag of numbers
 */
public class Bag implements IBag {
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
        if (size == BAG_SIZE) {
            throw new BagFullException();
        }
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
