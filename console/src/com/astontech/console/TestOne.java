package com.astontech.console;

public class TestOne implements ITest {

    @Override
    public void methodOne(int one) {
        System.out.println(one);
    }

    @Override
    public void methodTwo(String two) {
        System.out.println(two);
    }
}
