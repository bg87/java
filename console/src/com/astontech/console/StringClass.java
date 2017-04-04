package com.astontech.console;

public class StringClass implements CharSequence {

    public char charAt(int index) {
        return 'a';
    }

    public int length() {
        return 1;
    }

    public String subSequence(int i, int x) {
        return "string";
    }

    public String toString(char ch) {
        return "string";
    }

}
