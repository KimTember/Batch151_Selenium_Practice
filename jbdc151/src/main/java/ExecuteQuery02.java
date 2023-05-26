import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute02 {
    public static void main(String[] args) throws SQLException {


        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Selim0504");
        Statement statement =connection.createStatement();
        
    }
}
