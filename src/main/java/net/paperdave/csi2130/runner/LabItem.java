package net.paperdave.csi2130.runner;

import java.time.format.DateTimeFormatter;

public record LabItem(Lab lab) {
    @Override
    public String toString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd - ").format(lab.getCreatedDate()) + lab.getName();
    }
}
