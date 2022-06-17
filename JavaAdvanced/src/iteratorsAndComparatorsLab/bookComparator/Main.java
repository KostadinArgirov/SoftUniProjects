package iteratorsAndComparatorsLab.bookComparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new BookComparator());

        Set<Book> setOfBooks = new TreeSet<>(new BookComparatorByYear());

        books.stream()
                .sorted(Comparator.comparingInt(Book::getYear))
                .forEach(System.out::println);

        for (Book b : setOfBooks) {
            System.out.println(b);
        }
    }
}