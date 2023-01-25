package net.paperdave.csi2130.examples;

import edu.colorado.simulations.ThinkingCap;
import net.paperdave.csi2130.runner.Example;

import java.time.LocalDate;

public class ThinkingCapExample extends Example {
    @Override
    public String getName() {
        return "Thinking Cap Example";
    }

    @Override
    public String getDescription() {
        return "This lab demonstrates the use of the Thinking Cap class, as shown in the lecture.";
    }

    @Override
    public LocalDate getCreatedDate() {
        return LocalDate.of(2023, 1, 18);
    }

    @Override
    public void run() {
        ThinkingCap student = new ThinkingCap();
        ThinkingCap fan = new ThinkingCap();
        student.slots("Hello", "Bye");
        fan.slots("Go Cougars!", "Boo!");
        student.pushGreen();
        fan.pushGreen();
        student.pushRed();
    }
}
