package absensisekolah.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DbUtility {

    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost:3306/";
    private String dbUsrnm = "root";
    private String dbPasswd = "";
    Connection connection;

    public Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName(dbDriver);
                connection = DriverManager.getConnection(dbUrl + "AbsensiSekolah", dbUsrnm, dbPasswd);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error when try connect to mysql server, "
                        + "check your configuration");
            }
        }
        return connection;

    }

}
