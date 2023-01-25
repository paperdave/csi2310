// Created Date: 2023-01-18
package net.paperdave.csi2130.structures.bag;

import net.paperdave.csi2130.runner.Example;

import java.time.LocalDate;

public class SuperBagExample extends Example {
    @Override
    public String getName() {
        return "Super Bag Example";
    }
    @Override
    public String getDescription() {
        return "This lab demonstrates the use of the SuperBag class. It requires a lot of CPU time and ram.";
    }
    @Override
    public LocalDate getCreatedDate() {
        return LocalDate.of(2023, 1, 25);
    }
    @Override
    public void run() {
        SuperBag bag = new SuperBag();

        System.out.println("The bag's capacity() is " + bag.capacity());
        System.out.println("The bag's size() is " + bag.size());
        System.out.println("We will now add 1 trillion random items.");

        for (long i = 0; i < 1_000_000L; i++) {
            bag.add((int) Math.floor(Math.random() * 100.0));
            System.err.println("@ " + i);
        }

        System.out.println("The bag's size() is now " + bag.size());
        System.out.println("Size has a cap on it so we need sizeExact(): " + bag.sizeExact());
        System.out.println("The bag's has this many fives: " + bag.countOccurrencesExact(5));

    }
}
