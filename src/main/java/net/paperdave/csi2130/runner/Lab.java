package net.paperdave.csi2130.runner;

import java.time.LocalDate;

public abstract class Lab implements Runnable {
    public abstract String getName();
    public abstract String getDescription();
    public abstract LocalDate getCreatedDate();

    public Lab() {
        super();
    }
}
