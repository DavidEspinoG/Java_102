package Assingment_one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Function;

interface Printable<T> {
    void print(T t);
}

interface Retrievable<T> {
    T retrieve();
}

interface Evaluate<T> {
    boolean isNegative(T t);
}

interface Functionable<T, R> {
    R applyThis(T t);
}
class Person {
    private String name;
    private Integer age;
    private double height;

    public Person(String name, Integer age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public Integer getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }
    public String toString() {
        return this.name + " " + this.age + " height: " + this.height;
    }
    public double getHeight() {
        return this.height;
    }


}


public class BasicLambdas {
    public static void main(String[] args) {
        BasicLambdas basicLambdas = new BasicLambdas();
        basicLambdas.consumer();
        basicLambdas.supplier();
        basicLambdas.predicate();
        basicLambdas.function();
        List<Person> people = getPeople();
        sortHeight(people);

    }
    public  void consumer () {
        Printable<String> printable = s -> System.out.println(s);
        printable.print("Assingment_one.Printable Lambda");
        Consumer<String> myConsumer = s -> System.out.println(s);
        myConsumer.accept("Printing using a consumer");
        Consumer<String> myConsumer2 = System.out::println;
        myConsumer2.accept("Printing using method reference");
    }

    public void supplier() {
        Retrievable<Integer> implementation = () -> 77;
        Integer result = implementation.retrieve();
        System.out.println(result);
        Supplier<Integer> supplier = () -> 77;
        Integer result2 = supplier.get();
        System.out.println(result2);
    }

    public void predicate() {
        Evaluate<Integer> evaluator = number -> number > 0;
        System.out.println(evaluator.isNegative(-1));
        System.out.println(evaluator.isNegative(1));
        Predicate<Integer> evaluatorWithPredicate = number -> number > 0;
        System.out.println(evaluatorWithPredicate.test(1));
        System.out.println(check(4, n -> n % 2 == 0));
        System.out.println(check(7, n -> n % 2 == 0));
        System.out.println(check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));
        System.out.println(check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));
        System.out.println("Is Mike an adult? " + check(33, n -> n >= 18));
        System.out.println("Is Ann an adult? " + check(13, n -> n >= 18));
    }

    public void function() {
        Functionable<Integer, String> functionable = n -> "The number is: " + n;
        System.out.println(functionable.applyThis(25));
        Function<Integer, String> function = n -> "The number is: " + n;
        System.out.println(function.apply(88));
    }

    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static void sortAge(List<Person> people) {
        people
                .sort(Comparator.comparing(Person::getAge));
        people.forEach(System.out::println);
    }

    private static void sortName(List<Person> people ) {
        people.sort(Comparator.comparing(Person::getName));
        people.forEach(System.out::println);
    }

    private static void sortHeight(List<Person> people) {
        people.sort(Comparator.comparing(Person::getHeight));
        people.forEach(System.out::println);
    }


}
