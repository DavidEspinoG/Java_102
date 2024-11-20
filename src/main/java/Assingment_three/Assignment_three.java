package Assingment_three;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assignment_three {
    public static void main(String[] args) {

        fiveA();
    }

    public static void one() {
        OptionalDouble average = IntStream.range(0, 5).average();
        if(average.isPresent()) {
            System.out.println(average.getAsDouble());
        }
    }

    public static void two() {
        List<Item> items = List.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"));
        items.stream()
                .map(Item::getName)
                .sorted()
                .forEach(System.out::print);
    }

    public static void three() {
        Stream<List<String>> lists = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        lists.filter(list -> list.contains("c"))
                .flatMap((list) -> list.stream())
                .forEach(System.out::println);
    }

    public static void fourA() {
        List<Integer> integers = List.of(1,2,3);
        Integer sum = integers.stream()
                .mapToInt(integer -> integer )
                .sum();
        System.out.println(sum);

        OptionalInt max = integers.stream()
                .mapToInt(integer -> integer)
                .max();
        System.out.println(max.orElseThrow());

    }

    public static void fourB() {
        List<Person> people = List.of(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29)
        );
        Optional<Person> oldest = people.stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println(oldest.get());
    }

    public static void fourC() {
        List<Integer> integers = List.of(10, 47, 33, 23);
        Optional<Integer> result = integers.stream()
                .reduce(Integer::max);
        result.ifPresent(System.out::println);

        Integer resultB = integers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println(resultB);

    }

    public static Optional<String> getGrade(int marks) {
        Optional<String> grade = Optional.empty();
        if(marks > 50) {
            grade = Optional.of("Pass");
        } else {
            grade = Optional.of("Fail");
        }
        return grade;
    }

    public static void fiveA() {
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);

        System.out.println(grade1.orElse("Unknown"));

        if(grade2.isPresent()) {
            grade2.ifPresent(System.out::println);
        }
    }
}
