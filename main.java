import java.sql.*;

class hospital{
    public static void main(String[] args) {
        String url="postgres://deep:wgXBHnl1CkbwAwpzQ9Av9COAVbQqcf9l@dpg-codljj8l5elc73fqb91g-a.singapore-postgres.render.com/hospital_management_system_4htd";
        String username="deep";
        String password="wgXBHnl1CkbwAwpzQ9Av9COAVbQqcf9l";
        try{
        Connection db=DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
            System.out.println("Error Occured "+e);
        }
    }
}