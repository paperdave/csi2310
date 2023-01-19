// Created Date: 2023-01-18
package net.paperdave.csi2130.structures.bag;

import net.paperdave.csi2130.runner.Lab;

import java.time.LocalDate;

public class BagLab extends Lab {

    @Override
    public String getName() {
        return "Bag Lab";
    }

    @Override
    public String getDescription() {
        return "This lab demonstrates the use of the Bag class.";
    }

    @Override
    public LocalDate getCreatedDate() {
        return LocalDate.of(2023, 1, 18);
    }

    @Override
    public void run() {
        Bag bagA = new Bag();
        Bag bagB = new Bag();
        bagA.add(1);
        bagA.add(4);
        bagA.add(2);
        bagA.add(4);
        System.out.println("Bag A size is " + bagA.size());
        System.out.println("Bag A count of 1: " + bagA.countOccurrences(1));
        System.out.println("Bag A count of 2: " + bagA.countOccurrences(2));
        System.out.println("Bag A count of 3: " + bagA.countOccurrences(3));
        System.out.println("Bag A count of 4: " + bagA.countOccurrences(4));

        bagB.add(1);
        bagB.add(2);
        bagB.add(3);
        bagB.add(4);
        bagB.add(6);

        System.out.println("Bag B size is " + bagB.size());
        System.out.println("Bag B count of 1: " + bagB.countOccurrences(1));
        System.out.println("Bag B count of 2: " + bagB.countOccurrences(2));
        System.out.println("Bag B count of 3: " + bagB.countOccurrences(3));
        System.out.println("Bag B count of 4: " + bagB.countOccurrences(4));
        System.out.println("Bag B count of 5: " + bagB.countOccurrences(5));
        System.out.println("Bag B count of 6: " + bagB.countOccurrences(6));

        bagA.remove(4);
        bagA.remove(4);
        bagA.remove(4);
        bagA.remove(4);
        bagA.remove(4);

        System.out.println("Bag A size is " + bagA.size());
    }
}