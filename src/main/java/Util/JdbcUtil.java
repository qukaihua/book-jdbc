package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 96283 on 2018/11/7.
 */
public class JdbcUtil {

    public static Connection getConn(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.237.140:3506/book?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;

    }
}
