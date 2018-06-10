
/*
Klasa pośrednicząca pomiędzy bazą danych a aplikacją.
 */

import java.sql.*;

public class BookDao {

    private static final String URL="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=Library";
    private static final String USERNAME="sa";
    private static final String PASS="Student140";
    private Connection connection;

    public BookDao() {
        try {
            connection=DriverManager.getConnection(URL,USERNAME,PASS);
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Could not close connection");
            e.printStackTrace();
        }
    }

    public void save(Book book){
        final String sql="insert into books(title,author,year,isbn) values(?,?,?,?)";

        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getYear());
            ps.setString(4,book.getIsbn());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public Book read(int id){
        final String sql="select * from books where id=?";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()) {
                Book book = new Book();
                book.setAuthor(rs.getString("author"));
                book.setId(Integer.valueOf(rs.getString("id")));
                book.setIsbn(rs.getString("isbn"));
                book.setYear(rs.getInt("year"));
                book.setTitle(rs.getString("title"));
                return book;
            }
        } catch (SQLException e) {
            System.out.println("Could not get book");
            e.printStackTrace();
        }
        return null; //lub ElementNotFoundException
    }

    public void update(Book book){
        try {
            final String sql="update books set title=?,author=?,year=?,isbn=? where id=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getYear());
            ps.setString(4,book.getIsbn());
            ps.setInt(5,book.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Could not update record");
            e.printStackTrace();
        }

    }

    public void delete(int id){
        final String sql="delete from books where id=?";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
            e.printStackTrace();
        }
    }

    public void readAll(){
        final String sql="select * from books";
        try {
            Statement statement=connection.createStatement();
            statement.executeQuery(sql);
            ResultSet rs=statement.getResultSet();

            while (rs.next()){
                System.out.println("Book{title='" + rs.getString("title") + '\'' +
                        ", author='" + rs.getString("author") + '\'' +
                        ", year=" + rs.getInt("year") +
                        ", isbn='" + rs.getString("isbn") + '\'' +
                        ",id="+ rs.getInt("id")+ '\''+
                        '}');
            }
        } catch (SQLException e) {
            System.out.println("Could not read all books");
            e.printStackTrace();
        }
    }
}
