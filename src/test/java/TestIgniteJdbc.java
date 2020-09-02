/*
import org.apache.catalina.AccessLog;

import java.sql.*;

public class TestIgniteJdbc {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Register JDBC driver.
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

            con = DriverManager.getConnection("jdbc:ignite:thin://localhost");
            System.out.println("con: " + con);

            // Query people with specific age using prepared statement.
            stmt = con.prepareStatement("select username, password from user");
            System.out.println("stmt: " + stmt);

            rs = stmt.executeQuery();
            System.out.println("rs: " + rs);

            while (rs.next()) {
                System.out.println("gogo");
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("username: " + username);
                System.out.println("password: " + password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException throwables) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException throwables) {}
            }
            if (con != null) {
                try { con.close(); } catch (SQLException throwables) {}
            }
        }
    }
}
*/
