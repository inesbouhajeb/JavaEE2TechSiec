import java.util.Scanner;

/*
Wczytuje dane o dowolnej książce od użytkownika i zapisuje w bazie danych.
 */
public class LibrarySave {
    public static void run() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj tytul ksiazki:");
        String title=scanner.nextLine();
        System.out.println("Podaj autora ksiazki:");
        String author=scanner.nextLine();
        System.out.println("Podaj rok wydania ksiazki:");
        int year=Integer.valueOf(scanner.nextLine());
        System.out.println("Podaj numer ISBN ksiazki:");
        String isbn=scanner.nextLine();

        Book book=new Book(title,author,year,isbn);
        System.out.println(book.toString());
        BookDao bookDao=new BookDao();
        bookDao.save(book);
        System.out.println("Zapisano poprawnie");
        bookDao.close();
    }
}
