package connectMariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.jasper.tagplugins.jstl.core.Catch;

public class connectDB {
	private static String url ="jdbc:mariadb://localhost:3306/db_perfume?useUnicode=true&characterEncoding=utf8mb4";
	private static String user ="root";
	private static String password ="root";
	
	static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	


}
