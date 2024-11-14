package Assignment_two;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {
        //staticMR();
        //boundMR();
        //unboundMR();
        constructorMR();
    }

    public static void staticMR() {
        List<Integer> integers = Arrays.asList(1, 2, 7, 4, 5);
        Consumer<List<Integer>> sorter = list -> Collections.sort(list);
        //System.out.println(integers);
        //sorter.accept(integers);
        //System.out.println(integers);

        integers = Arrays.asList(1, 2, 7, 4, 5);
        Consumer<List<Integer>> sorterMR = Collections::sort;
        System.out.println(integers);
        sorterMR.accept(integers);
        System.out.println(integers);
    }

    public static void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> beginsWith = (prefix) -> name.startsWith(prefix);
        System.out.println(beginsWith.test("Mr"));
        System.out.println(beginsWith.test("Ms"));


        Predicate<String> beginsWithMR = name::startsWith;
        System.out.println(beginsWithMR.test("Mr"));
        System.out.println(beginsWithMR.test("Ms"));
    }

    public static void unboundMR() {
        Predicate<String> isEmpty = string -> string.isEmpty();
        //System.out.println(isEmpty.test(""));
        //System.out.println(isEmpty.test("Hello"));

        Predicate<String> isEmptyMR = String::isEmpty;
        System.out.println(isEmptyMR.test(""));
        System.out.println(isEmptyMR.test("Hello"));

        BiPredicate<String, String> startsWith = (string, prefix) -> string.startsWith(prefix);
        System.out.println(startsWith.test("Mr. David", "Ms"));

        BiPredicate<String, String> startsWithMR = String::startsWith;
        System.out.println(startsWith.test("Mr. David", "Ms"));

    }

    public static void constructorMR() {
        Supplier<List<String>> supplier = () -> new ArrayList<String>();
        List<String> list = supplier.get();
        list.add("Lambda");
        list.forEach(System.out::println);

        Supplier<List<String>> supplierMR = ArrayList::new;
        list = supplierMR.get();
        list.add("Method reference");
        list.forEach(System.out::println);

        Function<Integer, List<String>> supplierFunc = (integer) -> new ArrayList(integer);
        list = supplierFunc.apply(10);
        list.add("Function");
        list.forEach(System.out::println);

        Function<Integer, List<String>> supplierFuncMR = ArrayList::new;
        list = supplierFuncMR.apply(10);
        list.add("Function MR");
        list.forEach(System.out::println);
    }
}
