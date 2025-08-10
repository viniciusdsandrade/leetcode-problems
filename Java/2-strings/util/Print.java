package util;

import static java.lang.System.*;

public class Print {
    public static void printf(String format, Object... args) {
        out.printf(format, args);
        out.flush();
    }
}
