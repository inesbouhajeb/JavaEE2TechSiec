/*
Class designed to read book id from user and then show all information about this book in console.
 */

import java.util.Scanner;

public class LibraryRead {

    private static int id;

    public static void run(BookDao bookDao) {
        Book book;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj id ksiazki:");
        try{
            id=Integer.valueOf(scanner.nextLine());
            book=bookDao.read(id);
            if(book==null){
                System.out.println("Brak książki o podanym id.");
            }
            else {
                System.out.println(book+"id="+id);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Zły format id! Podaj wartość numeryczną całkowitą!");
        }
    }
}