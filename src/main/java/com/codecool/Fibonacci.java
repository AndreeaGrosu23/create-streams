package com.codecool;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci implements Supplier<Integer> {

    int a=1, b=0, c=1;

    public Integer get() {

        a=b;
        b=c;
        c=a+b;

        return a;
    }


//        return Stream.iterate(new int[]{0,1}, i -> new int[]{i[1], i[0] + i[1]})
//                    .limit(series)
//                    .map(i->i[0])
//                    .collect(Collectors.toList());


}