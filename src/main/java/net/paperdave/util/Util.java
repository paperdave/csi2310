package net.paperdave.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Util {
    public static final int MAX_WIDTH = 80;
    public static final int MAX_DEPTH = 5;

    // mimic node.js' util.inspect, which formats any value or object
    public static String inspect(Object value, int depth) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return CLIColor.apply("\"" + value.toString().replaceAll("\"", CLIColor.apply("\\\\\"", CLIColor.CYAN)).replaceAll("\t", CLIColor.apply("\\\\t", CLIColor.CYAN)).replaceAll("\r", CLIColor.apply("\\\\r", CLIColor.CYAN)).replaceAll("\n", CLIColor.apply("\\\\n", CLIColor.CYAN)) + "\"", CLIColor.GREEN);
        }
        if (value instanceof Boolean || value instanceof Number) {
            return CLIColor.apply(value.toString(), CLIColor.YELLOW);
        }
        // if array
        if (value.getClass().isArray()) {
            String componentName = value.getClass().getComponentType().getSimpleName();
            String[] values = new String[Array.getLength(value)];
            for (int i = 0; i < values.length; i++) {
                values[i] = inspect(Array.get(value, i))
                        .replaceFirst("^" + Pattern.quote(CLIColor.apply(componentName, CLIColor.CYAN)) + "\\s*", "")
                        .replaceFirst("^" + Pattern.quote(CLIColor.BLUE + value.getClass().getComponentType().getName()) + "\\s*", CLIColor.BLUE);
            }
            String prefix = CLIColor.apply(componentName, CLIColor.CYAN) + CLIColor.apply("[" + values.length + "]", CLIColor.MAGENTA);
            String joined = prefix + " { " + String.join(", ", values) + " }";
            if (joined.length() < MAX_WIDTH) {
                return joined;
            }
            for (int i = 0; i < values.length; i++) {
                values[i] = "  " + values[i].replaceAll("\\n", "\n  ");
            }
            return prefix + " {\n" + String.join(",\n", values) + "\n}";
        }
        if (value instanceof List<?>) {
            Class<?> cls = value.getClass();
            while (cls.getSimpleName().equals("")) {
                cls = cls.getSuperclass();
            }
            String listName = cls.getSimpleName();
            String[] values = new String[((List<?>) value).size()];
            String contentClass = getCommonSuperclass((List<Object>) value);
            boolean isAllSameClass = contentClass != null;
            for (int i = 0; i < values.length; i++) {
                if (contentClass != null) {
                    if (!contentClass.equals(((List<?>) value).get(i).getClass().getSimpleName())) {
                        isAllSameClass = false;
                    }
                }
            }
            for (int i = 0; i < values.length; i++) {
                values[i] = inspect(((List<?>) value).get(i))
                        .replaceFirst("^" + Pattern.quote(CLIColor.BLUE + ((List<?>) value).get(i).getClass().getName()) + "\\s*", CLIColor.BLUE);
                if (isAllSameClass) {
                    values[i] = values[i].replaceFirst("^" + Pattern.quote(CLIColor.apply(contentClass, CLIColor.CYAN)) + "\\s*", "");
                }
            }
            String prefix = CLIColor.apply(listName, CLIColor.CYAN) + (contentClass!=null?CLIColor.apply("<" + contentClass + ">", CLIColor.MAGENTA):"");
            String joined = prefix + " { " + String.join(", ", values) + " }";
            if (joined.length() < MAX_WIDTH) {
                return joined;
            }
            for (int i = 0; i < values.length; i++) {
                values[i] = "  " + values[i].replaceAll("\\n", "\n  ");
            }
            return prefix + " {\n" + String.join(",\n", values) + "\n}";
        }
        // if it has a toString that isn't the default
        try {
            if (!value.getClass().getMethod("toString").getDeclaringClass().equals(Object.class)) {
                try {
                    return CLIColor.apply(value.getClass().getSimpleName(), CLIColor.CYAN) + " " + CLIColor.apply(value.toString(), CLIColor.BLUE).replaceFirst("^" + Pattern.quote(CLIColor.BLUE + value.getClass().getName()) + "\\s*", CLIColor.BLUE);
                } catch (Exception e) {
                    return CLIColor.apply(value.getClass().getSimpleName(), CLIColor.CYAN) + " " + CLIColor.apply("Error in toString()", CLIColor.RED);
                }
            }
        } catch (NoSuchMethodException e) {}

        // print out all public fields
        ArrayList<String> fields = new ArrayList<>();
        for (Field field : value.getClass().getFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                try {
                    fields.add(field.getName() + ": " + inspect(field.get(value), depth + 1));
                }
                catch (IllegalAccessException e) {}
                catch (Exception e) {
                    fields.add(field.getName() + ": " + CLIColor.apply("Error in toString(): " + e, CLIColor.RED));
                }
            }
        }
        Class<?> cls = value.getClass();
        while (cls.getSimpleName().equals("")) {
            cls = cls.getSuperclass();
        }
        String prefix = CLIColor.apply(cls.getSimpleName(), CLIColor.CYAN);
        if (fields.size() == 0) {
            return prefix + " {}";
        }
        if (fields.size() <= 3) {
            String joined = prefix + " { " + String.join(", ", fields) + " }";
            if (joined.length() < MAX_WIDTH) {
                return joined;
            }
        }
        for (int i = 0; i < fields.size(); i++) {
            fields.set(i, "  " + fields.get(i).replaceAll("\\n", "\n  "));
        }
        return prefix + " {\n" + String.join(",\n", fields) + "\n}";
    }

    private static String getCommonSuperclass(List<Object> objects) {
        if (objects.size() == 0) {
            return null;
        }
        Class<?> commonSuperclass = objects.get(0).getClass();
        for (Object object : objects) {
            if (object == null) continue;

            Class<?> objectClass = object.getClass();
            while (!commonSuperclass.isAssignableFrom(objectClass)) {
                commonSuperclass = commonSuperclass.getSuperclass();
            }

            if (commonSuperclass == Object.class) {
                return null;
            }
        }
        return commonSuperclass.getSimpleName();
    }

    public static String inspect(Object value) {
        return inspect(value, MAX_DEPTH);
    }
}