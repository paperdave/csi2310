package net.paperdave.csi2130.runner;

import java.time.LocalDate;

public abstract class Example implements Runnable {
    private String name;
    private String description;
    private LocalDate createdDate;
    private Input[] inputs;

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Example() {}
}
