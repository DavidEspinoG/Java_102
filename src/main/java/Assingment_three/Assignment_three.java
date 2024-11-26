package Assingment_three;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assignment_three {
    public static void main(String[] args) {
        fourteenB();
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

    public static void six() {
        List<Book> books = List.of(
                new Book("Thinking in Java", 30),
                new Book("Java in 24 hrs", 20),
                new Book("Java Recipes", 10)
        );
        double result = books.stream()
                .mapToDouble(Book::getPrice)
                .filter(number -> number > 90)
                .average()
                .orElse(0.0);
        System.out.println(result);
    }

    public static void seven() {
        List<Book> books = List.of(
            new Book("Atlas Shrugged", 10.0),
            new Book("Freedom at Midnight", 5.0),
            new Book("Gone with the wind", 5.0)
        );

        Map<String, Double> booksMap = books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice));
        booksMap.forEach((title, price) -> {
            if(title.startsWith("A")) {
                System.out.println(price);
            }
        });
        System.out.println(booksMap);
    }

    public static void eight() {
        List<Book> books = List.of(
                new Book("Gone with the wind", 5.0),
                new Book("Gone with the wind", 10.0),
                new Book("Atlas shrugged", 15.0)
        );
        books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice, (a, b) -> a + b))
                .forEach((title, price) -> System.out.println("Price: " + price + " Title: " + title));

    }

    public static void nine() {
        List<Person> people = List.of(
                new Person("Bob", "Sanchez", 31 ),
                new Person("Paul", "Jimenez", 32),
                new Person("John", "Marquez", 33)
        );
        double result = people.stream()
                .filter(person -> person.getAge() > 30)
                .mapToInt(person -> person.getAge())
                .average().orElse(0.0);
    }

    public static void tenA() {
        Optional<Double> price = Optional.ofNullable(20.0);
        if(price.isPresent()) System.out.println(price.get());
        System.out.println(price.orElse(0.0));
        System.out.println(price.orElseGet(() -> 0.0));
    }
    public static void tenB() {
        Optional<Double> priceTwo = Optional.ofNullable(null);
        System.out.println(priceTwo);
        if(priceTwo.isEmpty()) {
            System.out.println("Is empty");
        };
        priceTwo.ifPresent(System.out::println);
        System.out.println(priceTwo.orElse(40.0));
    }

    public static void tenC() {
        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(() -> new RuntimeException("Bad code"));
        System.out.println(z);
    }

    public static void eleven() {
        List<AnotherBook> books = List.of(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        );
        List<String> genresList = new ArrayList<>();
        books.stream()
                .forEach(book -> genresList.add(book.getGenre()));
        genresList.stream()
                .forEach(System.out::println);
    }

    public static void twelveA() {
        DoubleStream doubleStream = DoubleStream.of(0, 2, 4);
        Double result = doubleStream
                .filter(n -> n % 2 != 0 )
                .sum();
        System.out.println(result);

    }

    public static void twelveB() {
        OptionalDouble result = Stream.of(1.0, 3.0)
                .mapToDouble(n -> n)
                .filter(n -> n % 2 == 0)
                .average();
        result.ifPresent(System.out::println);
        System.out.println(result.orElse(0));
    }

    public static void thirteenA() {
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        boolean result = ls.stream()
                .distinct()
                .anyMatch(n -> n == 11);
        System.out.println(result);
        boolean resultTwo = ls.stream()
                .noneMatch(n -> n % 11 > 0);
        System.out.println(resultTwo);
    }

    public static void fourteenA() {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger);
        Stream.of(11, 11, 22, 33)
                .parallel()
                .filter(n -> {
                    atomicInteger.incrementAndGet();
                    return n % 2 == 0;
                });
        System.out.println(atomicInteger);
    }

    public static void fourteenB() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
        stream.filter(e -> {
            atomicInteger.incrementAndGet();
            return e % 2 == 0;
        }).forEach(System.out::println);
        System.out.println(atomicInteger);

    }

}
