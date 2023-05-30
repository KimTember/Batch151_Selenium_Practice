import java.sql.*;

public class CallableStatement01 {

    public static void main(String[] args) throws SQLException {


        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Selim0504");
        Statement statement =connection.createStatement();

        //SELAMLAMA yapan bir function oluşturup çalıştırınız,
        //callable statment adımları
        //1. adım Function kodunu yazınız

        String sql= "CREATE OR REPLACE FUNCTION selamlama(x TEXT)RETURNS TEXT AS $$ BEGIN RETURN 'Merhaba ' || x || ', nasılsın?';END;$$ LANGUAGE plpgsql;";

        //2.adım Function kodunu çalıştırınız
      //  statement.execute(sql);
      //  String sql2="SELECT selamlama('Ahmet')";//==>Burası callable Statement kullanmadan function çağırma işlemi
        // ResultSet resultset=statement.executeQuery(sql2);//Function ı parametre ile çağırdık. bize bir table döndü
      //  resultset.next();
      //  System.out.println(resultset.getObject(1));
        //1.ÖRNEK: selamlama yapan bir function ı Callable Statement ile çağırınız.
        //3. adım Function ı çağır

        CallableStatement callableStatement=connection.prepareCall("{?=call selamlama(?)}");//-->parametrelendirme

        //4. Adım Return için registerOutParameter() methodunu, paramatreler için setInt(), setString()... metjhodlarını kullanınız
        callableStatement.registerOutParameter(1,Types.VARCHAR);
        callableStatement.setString(2,"Ali");

        //5. adım:execute() methodu ile callableStatement'ı çalıştır

        callableStatement.execute();

        //6. Adım: Sonucu görmek için callableStatement dan data türünü çağır
        //callablestatement da data resultset içine alınmaz. direkt callableStatementdan alınır

        System.out.println(callableStatement.getString(1));



        //2. Örnek : İki sayıyı toplayan bir function yazınız ve callable statement ile çağırınız.

        //1.Adım : Function kodunu yazınız
        String sql2= "CREATE OR REPLACE FUNCTION toplama(x NUMERIC, y NUMERIC) RETURNS NUMERIC AS $$ BEGIN RETURN x+y; END;\n" +
                "$$ LANGUAGE plpgsql;";
        //2.Adım: Function kodunu çalıştırınız.
        statement.execute(sql2);

        ////3. Adım: Function ı çağır
        CallableStatement callableStatement2=connection.prepareCall("{?= call toplama (?,?)}");


        //4.Adım: Return için registerOutParameter () methodunu, parametreler için setInt(), setString().... methodlarını kullanınız

        callableStatement2.registerOutParameter(1,Types.NUMERIC);
        callableStatement2.setInt(2,6);
        callableStatement2.setInt(3,4);

        //5.Adım: execute() methodu ile callableStatement r-tan data türünü çağır
        callableStatement2.execute();

        //6.Adım: Sonucu görmek için callableStatement tan data türünü çağır
        System.out.println(callableStatement2.getObject(1));












        connection.close();
        statement.close();


    }
}
