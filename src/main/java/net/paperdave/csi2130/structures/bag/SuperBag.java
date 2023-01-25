// Created Date: 2023-01-18
package net.paperdave.csi2130.structures.bag;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * the super bag has an infinite amount of space. extremely horrible cpu and memory performance
 */
public class SuperBag implements IBag {
    private LinkedList<Bag> bags;
    public SuperBag() {
        bags = new LinkedList<>();
    }

    /** Adds a new item to the bag.
     *  @param item  The item to be added to the bag.
     */
    public void add(int item) {
        for (Bag bag : bags) {
            try {
                bag.add(item);
                return;
            } catch (BagFullException e) {
                // do nothing
            }
        }    
        Bag newBag = new Bag(Integer.MAX_VALUE - 10);
        newBag.add(item);
    }

    public boolean remove(int item) {
        for (Bag bag : bags) {
            if (bag.remove(item)) {
                return true;
            }
        }
        return false;
    }

    public int countOccurrences(int item) {
        int count = 0;
        for (Bag bag : bags) {
            count += bag.countOccurrences(item);
            if (count < 0 || count == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return count;
    }

    public BigInteger countOccurrencesExact(int item) {
        BigInteger count = BigInteger.ZERO;
        for (Bag bag : bags) {
            count = count.add(BigInteger.valueOf(bag.countOccurrences(item)));
            if (count.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                return BigInteger.valueOf(Integer.MAX_VALUE);
            }
        }
        return count;
    }

    public int size() {
        int size = 0;
        for (Bag bag : bags) {
            size += bag.size();
            if (size < 0 || size == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return size;
    }

    public BigInteger sizeExact() {
        BigInteger size = BigInteger.ZERO;
        for (Bag bag : bags) {
            size = size.add(BigInteger.valueOf(bag.size()));
            if (size.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                return BigInteger.valueOf(Integer.MAX_VALUE);
            }
        }
        return size;
    }

    public float capacity() {
        return Float.POSITIVE_INFINITY;
    }
}
