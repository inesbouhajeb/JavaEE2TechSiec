import java.util.Scanner;

public class RunnerClass {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while(true) {
            System.out.println("Wybierz opcje:\n 1- Dodaj nowy rekord\n 2- Wyswietl ksiazke\n 3- Usun ksiazke\n 4- Zaktualizuj ksiazke\n 5- Wczytaj wszsytkie ksiazki ");
            String readed=scanner.next();
            scanner.nextLine();
                switch (readed) {
                    case "1":
                        LibrarySave.run();
                        break;
                    case "2":
                        LibraryRead.run();
                        break;
                    case "3":
                        LibraryDelete.run();
                        break;
                    case "4":
                        LibraryUpdate.run();
                        break;
                    case "5":
                        LibraryReadAll.run();
                        break;
                    default:
                        break;
                }
            }
    }
}
