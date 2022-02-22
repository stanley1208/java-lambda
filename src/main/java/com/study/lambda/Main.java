package com.study.lambda;

import com.study.lambda.NamesSupplier;

import java.util.stream.Stream;
import java.util.logging.*;

// 印出名稱
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        NamesSupplier supplier = new NamesSupplier();

        try (Stream<String> lines = supplier.get()) {
            lines.forEach(line -> logger.info(String.format("Hello, %s!%n", line)));
        }
        try (Stream<String> lines = supplier.get()) {
            lines.forEach(line -> System.out.printf("What up, %s?%n", line));
        }
    }
}