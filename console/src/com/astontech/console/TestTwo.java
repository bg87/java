package com.astontech.console;

public class TestTwo implements ITest {

    @Override
    public void methodOne(int one) {
        System.out.println(one);
    }

    @Override
    public void methodTwo(String two) {
        System.out.println(two);
    }
}
