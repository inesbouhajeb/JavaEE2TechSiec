import java.util.Scanner;

public class LibraryDelete {

    public static void run(BookDao dao) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj id ksiazki:");
        int id=Integer.valueOf(scanner.nextLine());
        dao.delete(id);
        System.out.println("Usunieto poprawnie");
    }
}
