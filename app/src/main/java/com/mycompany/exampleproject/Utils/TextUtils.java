package com.mycompany.exampleproject.Utils;

import java.util.regex.Pattern;

public class TextUtils {
    public static boolean isEmail(String text) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches();
    }

    public static boolean isCpf(String text) {
        return ValidateCPF.isCPF(text);
    }

    public static boolean containsSpecialCharacter(String text) {
        return Pattern.matches("[!@#$%&*()_+=|<>?{}\\[\\]~-]", text);
    }

    public static boolean containsCapitalLetter(String text) {
        return Pattern.matches("[A-Z]+", text);
    }

    public static boolean containsAlphaNumeric(String text) {
        return Pattern.matches("[0-9]+", text);
    }
}
