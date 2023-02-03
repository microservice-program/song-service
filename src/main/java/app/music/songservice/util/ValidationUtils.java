package app.music.songservice.util;

import app.music.songservice.exceptions.exception.CommonException;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static void checkCondition(boolean condition, CommonException exception) {
        if (!condition) throw exception;
    }
}
