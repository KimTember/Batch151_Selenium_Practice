import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {


        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Selim0504");
        Statement statement =connection.createStatement();

        //Ornek1: Companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın

        //1. Yol: OFFSETve LIMIT kullanarak,

        String sql1= "SELECT company, number_of_employees FROM companies ORDER BY number_of_employees DESC OFFSET 1 LIMIT 1";
        ResultSet resultset=statement.executeQuery(sql1);
        resultset.next();
        System.out.println(resultset.getObject(1)+"--"+resultset.getObject(2));

        //2. Yol: Subquery kullanarak

        String sql2="SELECT company, number_of_employees FROM companies WHERE number_of_employees=" +
                " (SELECT MAX(number_of_employees) FROM companies WHERE number_of_employees <(SELECT MAX (number_of_employees) FROM companies))";
        ResultSet resultSet2=statement.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getObject(1)+"--"+resultSet2.getObject(2));
        }
        connection.close();
        statement.close();


    }
}
