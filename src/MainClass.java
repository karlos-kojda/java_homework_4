import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) {

        // 1. Using Java Stream API find out sum of all numbers between 1 and 10000
        // that are dividable by both 3 and 5 but not dividable by 7
        System.out.print("Sum of all numbers between 1 and 10000\n1. Number has to be dividable by 3 and 5\n2. Number can't be dividable by 7\nSum: ");
        System.out.println(Stream.iterate(1, A -> A + 1).limit(10000)
                .filter(A -> A % 3 == 0 && A % 5 == 0 && A % 7 != 0)
                .collect(Collectors.summingInt(A -> A)));


        // 2. Using Java Stream API print first 100 even numbers that are not dividable by 8
        System.out.println("---------------------------------\nFirst 100 even numbers\nNone of the numbers ca't be dividable by 8\nNumbers:");
        Stream.iterate(1, A -> A + 1)
                .filter(A -> A % 2 == 0 && A % 8 != 0)
                .limit(100)
                .forEach(A -> System.out.println(A));


        // 3.1 Using Java Stream API print names (in alphabetic order) of all books that have price smaller than 100.
        System.out.println("\nExercise 3.1");
        List<Book> bookList = Stream.of(new Book("Lord of the rings", 150),
                new Book("Harry Potter", 125),
                new Book("Witcher", 200),
                new Book("Avengers", 95),
                new Book("Animal planet", 90),
                new Book("Dog is my friend", 80),
                new Book("Book with no end", 55),
                new Book("Dog", 50))
                .filter(A -> A.getPrice() < 100)
                .sorted((A, B) -> A.getName().
                        compareTo(B.getName()))
                .collect(Collectors.toList());
        bookList.forEach(A -> System.out.println(A.getName()));

        // 3.2 Using Java stream API find out how many books have name shorter than 5 characters
        System.out.println("\nExercise 3.2");
        System.out.println(Stream.of(new Book("Lord of the rings", 150),
                        new Book("Harry Potter", 125),
                        new Book("Witcher", 200),
                        new Book("Avengers", 95),
                        new Book("Animal planet", 90),
                        new Book("Dog is my friend", 80),
                        new Book("Book", 55),
                        new Book("Dog", 50))
                .filter(A -> A.getName().length() < 5)
                .count());

        // 3.3 Using Java stream API find out what is the average price of the book in the list
        System.out.println("\nExercise 3.3");
        System.out.println(Stream.of(new Book("Lord of the rings", 150),
                        new Book("Harry Potter", 125),
                        new Book("Witcher", 200),
                        new Book("Avengers", 95),
                        new Book("Animal planet", 90),
                        new Book("Dog is my friend", 80),
                        new Book("Book with no end", 55),
                        new Book("Dog", 50))
                .mapToInt(A -> A.getPrice())
                .average().getAsDouble());

        // 3.4 Using Java stream API find out if all books in list are cheaper than 500
        System.out.println("\nExercise 3.4");
        System.out.println(Stream.of(new Book("Lord of the rings", 150),
                new Book("Harry Potter", 125),
                new Book("Witcher", 200),
                new Book("Avengers", 95),
                new Book("Animal planet", 90),
                new Book("Dog is my friend", 80),
                new Book("Book with no end", 55),
                new Book("Dog", 50))
                .allMatch(A -> A.getPrice() < 500));
    }
}
