package net.paperdave.csi2130.structures.bag;

public interface IBag {
    void add(int item);
    boolean remove(int item);
    int countOccurrences(int item);
    int size();
}
