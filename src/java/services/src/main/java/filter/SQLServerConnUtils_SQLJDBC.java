package filter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SQLServerConnUtils_SQLJDBC {
	public static Connection getSQLServerConnection()
	         throws SQLException, ClassNotFoundException {
	     String hostName = "localhost";
	     String database = "card_processing";
	     String userName = "sa";
	     String password = "123456";
	 
	     return getSQLServerConnection(hostName, 
	             database, userName, password);
	 }
	 
	 // Trường hợp sử dụng SQLServer.
	 // Và thư viện SQLJDBC.
	 public static  Connection getSQLServerConnection(String hostName,
	       String database, String userName,
	         String password) throws ClassNotFoundException, SQLException {
	     Class.forName("net.sourceforge.jtds.jdbc.Driver");
	 
	     // Cấu trúc URL Connection dành cho SQLServer
	     // Ví dụ:
	     // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
	     String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433"
	             +  ";databaseName=" + database;
	 
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
}
