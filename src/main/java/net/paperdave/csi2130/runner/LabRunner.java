package net.paperdave.csi2130.runner;

import org.reflections.Reflections;

import javax.swing.*;
import java.util.Set;

public class LabRunner {
    public static Lab[] scanForLabs() {
        Reflections r = new Reflections("net");
        Set<Class<? extends Lab>> classes = r.getSubTypesOf(Lab.class);
        Lab[] labs = new Lab[classes.size()];
        int i = 0;
        for (Class<? extends Lab> o : classes) {
            try {
                labs[i] = o.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        return labs;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch(Exception ignored){}

        new LabRunnerFrame(scanForLabs());
    }
}
