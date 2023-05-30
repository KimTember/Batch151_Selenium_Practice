public class Runner {


    public static void main(String[] args) {


        //Database e bağlan
        JDBCUtils.connectToDataBase();

        //Statement oluştur

        JDBCUtils.createStatement();

        //Query çalıştır.
        String sql="CREATE TABLE workers(worker_id varchar(20), worker_name varchar(20), worker_salary int);";
        JDBCUtils.execute(sql);









    }
}
