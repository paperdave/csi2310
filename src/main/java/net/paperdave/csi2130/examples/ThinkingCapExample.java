package net.paperdave.csi2130.thinkingcap;

import edu.colorado.simulations.ThinkingCap;
import net.paperdave.csi2130.runner.Lab;

import java.time.LocalDate;

public class ThinkingCapExample1 extends Lab {
    @Override
    public String getName() {
        return "Thinking Cap - Example 1";
    }

    @Override
    public String getDescription() {
        return "This lab demonstrates the use of the Thinking Cap system.";
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
