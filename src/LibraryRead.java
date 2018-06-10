/*
Wczytujje od użytkownika numer isbn ksiazki i wczytuje na tej podstawie ksiazke z bazy danych oraz wyswietla o niej informacje w konsoli.
 */

import java.util.Scanner;

public class LibraryRead {

    public static void run() {
        Book book;
        BookDao dao=new BookDao();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj id ksiazki:");
        int id=Integer.valueOf(scanner.nextLine());

        book=dao.read(id);
        System.out.println(book);
        dao.close();
    }
}