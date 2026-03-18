package edu.eci.dosw.DOSW_Library.Core.Util;

import java.util.UUID;

public class IdGeneratorUtil {
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
