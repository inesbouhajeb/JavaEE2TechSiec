import java.util.Scanner;

public class RunnerClass {

    private static BookDao bookDao;

    public static void main(String[] args) {
        bookDao=new BookDao();
        Scanner scanner=new Scanner(System.in);

        while(true) {
            System.out.println("Wybierz opcje:\n 1- Dodaj nowy rekord\n 2- Wyswietl ksiazke\n 3- Usun ksiazke\n 4- Zaktualizuj ksiazke\n 5- Wczytaj wszsytkie ksiazki ");
            String readed=scanner.next();
            scanner.nextLine();
                switch (readed) {
                    case "1":
                        LibrarySave.run(bookDao);
                        break;
                    case "2":
                        LibraryRead.run(bookDao);
                        break;
                    case "3":
                        LibraryDelete.run(bookDao);
                        break;
                    case "4":
                        LibraryUpdate.run(bookDao);
                        break;
                    case "5":
                        LibraryReadAll.run(bookDao);
                        break;
                    default:
                        break;
                }
            }
    }
}
