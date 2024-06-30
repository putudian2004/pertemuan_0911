package pertemuan09;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author DIANSARIANI 2201010254
 * TGL : 2024-06-21
 */
public class koneksi {
    public static Connection buatkoneks(){
        Connection cnn = null;
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/temanbaik","root","");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Koneksi ke DBMS MySQL gagal");
        }
        return cnn;
    }

}