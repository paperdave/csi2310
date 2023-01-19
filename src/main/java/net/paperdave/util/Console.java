package net.paperdave.util;

public class Console {
    public static void log(Object ...message) {
        for (Object o : message) {
            if (o instanceof String) {
                System.out.print(o);
            } else {
                System.out.print(Util.inspect(o));
            }
        }
        System.out.println();
    }
}
