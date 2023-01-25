package net.paperdave.csi2130.runner;

import java.time.format.DateTimeFormatter;

public record LabItem(Example example) {
    @Override
    public String toString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd - ").format(example.getCreatedDate()) + example.getName();
    }
}
