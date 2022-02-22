package com.study.lambda;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

// 提供名稱串流
public class NamesSupplier implements Supplier<Stream<String>> {
    private List<String> strings = Arrays.asList("Londo", "Vir", "G'Kar", "Na'Toth",
                                                 "Delenn", "Lennier", "Kosh");

    private Gson gson;

    public List<String> getStrings() {
        return strings;
    }

    @Override
    public Stream<String> get() {
        return strings.stream();
    }
}