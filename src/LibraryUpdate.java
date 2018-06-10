import java.util.Scanner;

public class LibraryUpdate {

    public static void run() {
        Scanner scanner=new Scanner(System.in);
        BookDao dao=new BookDao();

        System.out.println("Podaj id ksiazki ktora chcesz zaktualizowac:");
        int id=Integer.valueOf(scanner.next());
        Book book=dao.read(id);
        int koniec=0;

        while (true){
            System.out.println("Co chesz zaktualizowac? Wpisz odpowiedni numer:\n 1-tytul,\n 2-autora,\n 3-rok,\n 4-isbn,\n 5-koniec");
            String choice = scanner.next();
            String readedLine="";
            switch (choice) {
                case "1":
                    System.out.println("Podaj nowy tytul ksiazki:");
                    while (readedLine.equals(""))
                    {readedLine = scanner.nextLine();}
                    book.setTitle(readedLine);
                    break;
                case "2":
                    System.out.println("Podaj nowego autora ksiazki:");
                    while (readedLine.equals(""))
                    {readedLine = scanner.nextLine();}
                    book.setAuthor(readedLine);
                    break;
                case "3":
                    System.out.println("Podaj nowy rok wydania ksiazki:");
                    while (readedLine.equals(""))
                    {readedLine = scanner.nextLine();}
                    book.setYear(Integer.valueOf(readedLine));
                    break;
                case "4":
                    System.out.println("Podaj nowy numer ISBN ksiazki:");
                    while (readedLine.equals(""))
                    {readedLine = scanner.nextLine();}
                    book.setIsbn(readedLine);
                    break;
                case "5":
                    koniec=1;
                    break;

                    default:
                        break;
            }

            if (koniec==1){
                break;
            }
            else {
                dao.update(book);
                System.out.println("Zaktualizowano poprawnie");
            }
        }
        dao.close();
    }
}
