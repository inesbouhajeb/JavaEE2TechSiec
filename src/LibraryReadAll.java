import java.util.Scanner;

public class LibraryReadAll {

    public static void run() {

        BookDao dao=new BookDao();
        dao.readAll();
        dao.close();
    }
}
