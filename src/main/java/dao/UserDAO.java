package dao;

import java.sql.*;
import model.*;
import util.DBContext;

/**
 *
 * @author huytr
 */
public class UserDAO extends DBContext {

    public User login(String username, String password) {
        String sql = "SELECT user_id,\n"
                + "username,\n"
                + "full_name,\n"
                + "phone,\n"
                + "role_id\n"
                + "FROM Users\n"
                + "WHERE username = ?\n"
                + "AND password_hash = ?\n"
                + "AND is_active = 1";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setFullName(rs.getString("full_name"));
                u.setPhone(rs.getString("phone"));
                u.setRoleId(rs.getInt("role_id"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        User u = ud.login("reception01", "123");
        System.out.println(u.toString());

    }
}
