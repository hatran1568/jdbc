package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDAO {
    protected static Connection connection;

    public static Connection getConnection(){
        try {
            if (connection == null) {
                String user = "root";

                String pass = "123456";
                String url = "jdbc:mysql://localhost:3306/springcrud?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
            }

        } catch (Exception ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;

    }

    public BaseDAO() {
        connection = getConnection();
    }
}
