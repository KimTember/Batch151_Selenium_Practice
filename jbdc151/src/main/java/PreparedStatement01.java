import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Selim0504");

        Statement statement = connection.createStatement();


        //Ornek1): Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin

        //prepared statement oluşturmak için :
        //1. Adım:Prepared statement querysini oluştur.
        String sql1="UPDATE companies SET number_of_employees = ? WHERE company =?";//>parametrelendirme
        //2. adım: Prepared Statement objesi oluştur

        PreparedStatement preparedStatement=connection.prepareStatement(sql1);

        //3. Adım: preparedStatement objesi ile setInt gibi methodlarla soru işaretleri yerlerine koymak istediği değerleri yerleştiriyoru

        preparedStatement.setInt(1,9999);
        preparedStatement.setString(2,"IBM");


        //4. Adım: Query yi çalıştır

        int guncellenenSatirSayisi=preparedStatement.executeUpdate();
        System.out.println("guncellenenSatirSayisi = " + guncellenenSatirSayisi);

        //güncelleme sonrası datayı okumak için yeni table ı okuyalım

        String sql2="SELECT * FROM companies";
        ResultSet resultSet=statement.executeQuery(sql2);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1)+"--"+resultSet.getObject(2)+"--"+resultSet.getObject(3));
        }



        //2. Örnek Prepared Statement kullanarak company  adı CASPER olan number_of_employees değerini 5000 olarak güncelleyin


        preparedStatement.setInt(1,5000);
        preparedStatement.setString(2,"CASPER");

        int guncellenenSayi=preparedStatement.executeUpdate();
        System.out.println("guncellenenSayi = " + guncellenenSayi);


        String sql3="SELECT * FROM companies";
        ResultSet resultset3=statement.executeQuery(sql3);
        while (resultset3.next()){
            System.out.println(resultset3.getObject(1)+"--"+resultset3.getObject(2)+"--"+resultset3.getObject(3));


        }



        connection.close();
        statement.close();


    }
}

