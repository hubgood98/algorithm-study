package org.study;

import java.util.Arrays;

public class Stream {
    public static void main(String[] args) {

        String[] names = {"Alice","Bob","Charlie","David","Eve"};

        java.util.stream.Stream<String> nameStream = Arrays.stream(names);

        nameStream.map(String::toUpperCase)
                        .forEach(System.out::println);
        System.out.println("Hello world!");
    }
}