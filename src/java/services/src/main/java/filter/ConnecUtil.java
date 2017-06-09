package filter;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnecUtil {
	public static Connection getMyConnection() throws SQLException,
    ClassNotFoundException {
		return SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
	}

}
