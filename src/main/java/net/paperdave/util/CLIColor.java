package net.paperdave.util;

public class CLIColor {
    public static final String ESC = "\u001b[";

    public static final String RESET = ESC + "0m";
    public static final String BOLD = ESC + "1m";
    public static final String UNDERLINE = ESC + "4m";
    public static final String BLINK = ESC + "5m";
    public static final String REVERSE = ESC + "7m";
    public static final String HIDDEN = ESC + "8m";

    public static final String BLACK = ESC + "30m";
    public static final String RED = ESC + "31m";
    public static final String GREEN = ESC + "32m";
    public static final String YELLOW = ESC + "33m";
    public static final String BLUE = ESC + "34m";
    public static final String MAGENTA = ESC + "35m";
    public static final String CYAN = ESC + "36m";
    public static final String WHITE = ESC + "37m";

    public static String apply(String str, String... styles) {
        String style = String.join("", styles);
        return style + str.replace(RESET, style) + RESET;
    }
}
