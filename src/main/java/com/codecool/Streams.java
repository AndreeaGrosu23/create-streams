package com.codecool;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Streams {
    public static void main(String[] args) {

        /*
         * Create a stream out of the following array.
         */

        String[] a1 = {"one", "two", "three"};
//        Stream<String> s1 = Arrays.stream(a1);
        Stream<String> s1 = Arrays.asList(a1).stream();
        s1.forEach(n -> System.out.println(n));

        /*
         * Create a stream containing the Strings "one" , "two" and "three"
         * without using an array
         */

        Stream<String> s2 = Stream.of("one", "two", "three");
        s2.forEach(n -> System.out.println(n));

        /*
         * Create a stream using a stream builder.
         */

        Stream.Builder<String> b1 =Stream.builder();
        /* ??? */
        Stream<String> s3 = b1.add(a1[0])
                                .add(a1[1])
                                .add(a1[2])
                                .build();
        s3.forEach(n -> System.out.println(n));

        /*
         * Collect one of the above defined streams into a list.
         *
         * HINT: the keyword here is "collect"
         */

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(a1);
        List<String> l1 = streamSupplier.get().collect(Collectors.toList());

       /*!!!!!Exception in thread "main" java.lang.IllegalStateException:
        *stream has already been operated upon or closed
        *For whatever reason, you really want to reuse a Stream,
        * try the following Supplier solution
        */

        System.out.println(l1);

        /*
         * Streams can be infinite.  We obviously cannot create such a
         * stream by supplying all the elements ourselves.
         *
         * HINT: When looking for methods to create such streams
         * realize that:
         * - These methods cannot belong to an instance
         * - They are returning streams
         */

        /*
         * Create a stream of the powers of two.
         */

        Integer twoToTheZeroth = 1;
        UnaryOperator<Integer> doubler = (Integer x) -> 2 * x;
        Stream<Integer> s4 = Stream.iterate(twoToTheZeroth, doubler);
//        s4.limit(10).forEach(n -> System.out.println(n));
        /*
         * Create a stream containing the first ten elements of s4.
         */

        Stream<Integer> s5 = s4.limit(10);
        s5.forEach(n -> System.out.println(n));
        /*
         * Create a stream containing the elements of the Fibonacci
         * sequence.
         *
         * HINT: You will need to create a new class for this.
         */

//        Supplier<Integer> fibSupp = new Fibonacci();
//        Stream<Integer> s6 = Stream.generate(fibSupp).limit(10).collect(Collectors.toList());
//        s6.forEach(System.out::println);

        Fibonacci fibonacci = new Fibonacci();
        List<Integer> listFibo = fibonacci.generate(10);
        System.out.println(listFibo);

        Stream<List<Integer>> s6 = Arrays.asList(listFibo).stream();
        s6.forEach(System.out::println);


    }
}
