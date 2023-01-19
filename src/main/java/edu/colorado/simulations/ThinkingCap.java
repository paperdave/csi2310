package net.paperdave.csi2130.thinkingcap;

public class ThinkingCap {
    private String red;
    private String green;

    public ThinkingCap() {}

    public void slots(String newGreen, String newRed) {
        this.green = newGreen;
        this.red = newRed;
    }

    public void pushRed() {
        System.out.println(red);
    }

    public void pushGreen() {
        System.out.println(green);
    }
}
