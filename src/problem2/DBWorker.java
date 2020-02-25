package problem2;

import java.sql.*;

public class DBWorker {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "z123456789Zazat";
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void  showNewsText(int id) {
        String SQL = "select news_name, contant from news where id = " + id;
        try (
                Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL))
        {
            System.out.println("news  ||            contant");
            while (rs.next())
            {
                System.out.println(rs.getString(1) + " || " + rs.getString(2));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addNews(String name, String contant) {
        String SQL = "insert into news(news_name, contant, date_of_publication) values (?,?,current_timestamp);";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, contant);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteNews(int id) {
        String SQL = "delete from news where id = ?;";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeNews(String name, String contant, int id) {
        String SQL = "update news set news_name = ?, contant = ? where id = ?;";
        try (Connection conn = connect();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, contant);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
