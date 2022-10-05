package br.ufc.qxd.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String jdbcDriver = "org.postgresql.Driver";
    private static String hostName = "localhost";
    private static String userName = "postgres";
    private static String password = "root";
    private static String dataBaseName = "universidade";
    private static String dataBasePrefix = "jdbc:postgresql://";
    private static String dabaBasePort = "5432";
    private static String url = dataBasePrefix + hostName + ":" + dabaBasePort + "/" + dataBaseName;

    public static Connection getConnection() {
        try {
            Class.forName(jdbcDriver);
            return DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
