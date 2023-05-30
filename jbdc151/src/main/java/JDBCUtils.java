import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {


    //Bu Classta tekrarlı kullanılacak methodlar oluşturacağız

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    //Database e bağlanma methodu --> Connection return yapar

    public static Connection connectToDataBase() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Selim0504");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    //Statement oluşturma methodu-->Statement return yapar

    public static Statement createStatement(){

        try {
           statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;

    }
    //execute() methodu ile Query çalıştıran method

    public static boolean execute(String sql){
        try {
            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//execute query ve executeUpdate methodları ödev
        public static ResultSet executeQuery(String sql){

                resultSet = statement.executeQuery(sql);



            return resultSet;

        }

    }






}
