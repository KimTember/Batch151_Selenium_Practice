import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws SQLException {


        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Selim0504");

        Statement statement =connection.createStatement();

        //1. örnek: region id si 1 olan "country name" değerlerini çağırın
        String sql1="Select country_name from countries where region_id=1";
        boolean r1= statement.execute(sql1);
        System.out.println("r1 = " + r1);

        // Satırları görmek için executeQuery methodunu kullanmalıyız. execute() methodu sadece true veya false döner

        ResultSet resultSet=statement.executeQuery(sql1);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

        System.out.println("\n======================2.Örnek=======================\n");

        //2. Örnek: "region_id"nin 2 den büyük olduğu "country_id" ve "country_name" değerlerini çağırın
        String sql2= "SELECT country_id, country_name FROM countries WHERE region_id>2";
        ResultSet resultset2=statement.executeQuery(sql2);

        while (resultset2.next()){//Resultset son satıra gelip false verdikten sonra kapanır. Kapalı Resultset üzerinde işlem yapılırsa exception atar.

            System.out.println(resultset2.getString(1)+"--"+resultset2.getString(2));
        }


        //3. Örnek "number_of_employees"değeri en düşük olan satırın tüm değerlerini çağırın


        String sql3="SELECT * FROM companies WHERE number_of_employees=(SELECT MIN(number_of_employees)FROM companies)";
        ResultSet resultSet3=statement.executeQuery(sql3);
        while (resultSet3.next()) {
            System.out.println(resultSet3.getInt(1)+"--"+resultSet3.getString(2)+"--"+ resultSet3.getInt(3));
        }


        connection.close();
        statement.close();



    }
}
