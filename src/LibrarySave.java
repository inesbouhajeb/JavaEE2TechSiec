import java.util.Scanner;

public class LibrarySave {

    private static int year;
    private static boolean check;

    public static void run(BookDao bookDao) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj tytul ksiazki:");
        String title=scanner.nextLine();
        System.out.println("Podaj autora ksiazki:");
        String author=scanner.nextLine();
        System.out.println("Podaj numer ISBN ksiazki:");
        String isbn=scanner.nextLine();
        check=false;
        do {
            try {
                System.out.println("Podaj rok wydania ksiazki:");
                year = Integer.valueOf(scanner.nextLine());
                Book book = new Book(title, author, year, isbn);
                System.out.println(book.toString());
                bookDao.save(book);
                System.out.println("Zapisano poprawnie");
                check=true;
            } catch (NumberFormatException e) {
                System.out.println("Zły format daty! Podaj wartość numeryczną całkowitą!");
            }

        }
        while (check=true);
    }
}