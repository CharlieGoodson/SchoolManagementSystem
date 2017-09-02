package loginapp;

import dbutil.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    private Connection connection;

    public LoginModel() {
        try {
            connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(connection == null) {
            System.exit(1);
        }
    }

    public boolean isDatabaseConnected() {
        return connection != null;
    }

    public boolean isLogin(String user, String pass, String opt) throws Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM login where username = ? and password = ? and division = ?";

        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, opt);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
        finally {
            rs.close();
            ps.close();
        }
    }
}
