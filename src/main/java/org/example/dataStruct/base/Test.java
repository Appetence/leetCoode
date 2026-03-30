package org.example.dataStruct.base;

public class Test {

    public static void main(String[] args) {
        int a = 1;
        int b = 11;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);

        System.out.println(b);

    }
}
