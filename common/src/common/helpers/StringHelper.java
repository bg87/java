package common.helpers;

public class StringHelper {

    // Checks whether a string is null or empty
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    // Return longer string
    public static String longerString(String one, String two) {
        if(one.length() > two.length()) {
            return one;
        } else {
            return two;
        }
    }

    // Count chars in string ignoring whitespaces
    public static int charsInString(String string) {
        String newStr = string.replace(" ", "");
        return newStr.length();
    }

    // Reverse a string
    public static StringBuilder reverse(String string) {
        StringBuilder newStr = new StringBuilder();
        newStr.append(string);
        return newStr.reverse();

    }
}
