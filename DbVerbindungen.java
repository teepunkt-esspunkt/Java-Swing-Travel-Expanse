package reisekosten;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbVerbindungen {
	// Treiber für den Verbindungsaufbau mit der Datenbank
	private String treiber = "com.mysql.cj.jdbc.Driver";

	// Datenbank Verbindungsdaten
	    private String url = "url";
        private String user = "user";
        private String password = "password";
	// Variable zur Verbindung mit der Datenbank
	private Connection conn;
	public DbVerbindungen () {
		conn = null;
	}
	// Datenbank Verbindung starten
	public void dbVerbindungStarten() {
		try {
			if(conn == null || conn.isClosed()) {
			Class.forName(treiber);
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
// Datenbank Verbindung trennen
	public void dbVerbindungTrennen() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
// Datenbank Verbindung neustarten
	public void dbVerbindungNeustarten() {
		dbVerbindungTrennen();
		dbVerbindungStarten();

	}
// get connection
	public Connection getConn() {
		return conn;
	}

}
