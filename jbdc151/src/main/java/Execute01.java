import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//1.adım : driver a kaydol ==> JDBC 4 sonrası gerek yoktur

        Class.forName("org.postgresql.Driver");

      //  2. adım: Database e bağlan

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Selim0504");

        //3. adım : Statement oluştur.

        Statement statement =connection.createStatement();
        //4. adım: Query çalıştır

        /*
        eğer execute methodu DDL(create, drop, alter table) ile kullanılırsa her zamna false döner
        eğer execute methodu DQL(select) ile kullanılırsa data dönerse 'true' data dönmezse false döner
         */

        //execute() methodu parametre olarak girilen String SQL komutunu baplı olduğu database uzerinde uygular


                //1. örnek:worker adında bir table oluşturunuz
        boolean sql1=statement.execute("CREATE TABLE workers(worker_id varchar(20), worker_name varchar(20), worker_salary int);");
        System.out.println("sql1 = " + sql1);

        //2. örnek: workers tableına bir adres sutunu ekleyiniz
        boolean sql2=statement.execute("alter table workers add workers_address VARCHAR(100);");
        System.out.println("sql2 = " + sql2);
        //3. örnek: worker table ini siliniz,
        String sqlQuery ="Drop Table workers";
        boolean sql3=statement.execute(sqlQuery);
        System.out.println("sql3 = " + sql3);


        //5. adım Bağlantıyı kapat

        connection.close();
        statement.close();



    }}
