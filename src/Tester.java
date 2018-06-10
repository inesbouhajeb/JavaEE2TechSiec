

import java.sql.*;
import java.util.Scanner;
/*
Klasa pośrednicząca pomiędzy bazą danych a aplikacją.
 */

public class Tester {

    public static void main(String[] args) throws SQLException {

        String url="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Library";
        String username="sa";
        String password="Student140";
        Connection connection=DriverManager.getConnection(url,username,password);

//        Statement statementUpdate=connection.createStatement();
        //String insert="insert into books (id,title) values(2, 'Pies ktory jezdzil koleja')";
        // int inserted=statementUpdate.executeUpdate(insert);//1 lub 0- zwraca ilosc zaktualizowanych rekotrdow
//        statementUpdate.close();

        String queryInjectionPrepared="insert into books(title) values(?)";
        PreparedStatement preparedStatement=connection.prepareStatement(queryInjectionPrepared);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj tytul ksiazki:");
        String bookTitle=scanner.nextLine();
        preparedStatement.setString(1,bookTitle);
        preparedStatement.executeUpdate();
        preparedStatement.close();

//        Statement statementDelete=connection.createStatement();
//        String delete="delete from books where id=0 and isbn='null' ";
//        int deleted=statementDelete.executeUpdate(delete);//1 lub 0- zwraca ilosc zaktualizowanych rekotrdow
//        statementDelete.close();

        Statement statement=connection.createStatement();
        String query="select * from books";
        ResultSet resultSet=statement.executeQuery(query);

        while (resultSet.next()){
            int id=Integer.valueOf(resultSet.getString("id")); //id
            String title=resultSet.getString("title");
            String author=resultSet.getString("author");
            int year= resultSet.getInt("year");
            String isbn=resultSet.getString("isbn");
            System.out.println("ID:"+id+", "+"title: "+title+", "+"author: "+author+", "
                    +"year: "+year+", "+"ISBN: "+isbn);
        }
        statement.close();
        connection.close();
    }
}
