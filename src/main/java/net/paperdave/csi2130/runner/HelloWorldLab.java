package net.paperdave.csi2130.runner;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class HelloWorldLab extends Lab {
    @Override
    public String getName() {
        return "Hello World Lab";
    }

    @Override
    public String getDescription() {
        return "This lab prints \"Hello World\" to the console. It is a simple lab to demonstrate the LabRunner system.";
    }

    @Override
    public LocalDate getCreatedDate() {
        return LocalDate.of(2023, 1, 18);
    }

    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
