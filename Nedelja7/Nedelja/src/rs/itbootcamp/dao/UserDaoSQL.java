package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.UserModel;

import java.sql.*;

public class UserDaoSQL implements UserDao{
    private static final Connection conn = DatabaseConnection.getConnection();
    @Override
    public void add(UserModel user) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");
            st.setInt(1,user.getUserId());
            st.setString(2,user.getUserName());
            st.setString(3,user.getEmail());
            st.setString(4,user.getPassword());
            st.setBoolean(5,user.isAdmin());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE user_id = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserModel user) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users " +
                    "SET username = ?, " +
                    "email = ?, " +
                    "user_password = ?, " +
                    "user_admin = ? " +
                    "WHERE user_id = ?");
            st.setString(1, user.getUserName());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.isAdmin());
            st.setInt(5, user.getUserId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel getUser(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE user_id = " + id);
            if (rs.next()){
                return new UserModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5)
                );
            } else {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMealGrade(int user_id, int meal_id, int grade) {
        // TODO
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO usermeal VALUES(?,?,?)");
            st.setInt(1,user_id);
            st.setInt(2,meal_id);
            st.setInt(3,grade);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String entry, String password) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT user_password FROM users WHERE username = '" + entry + "' OR email = '" + entry + "'");
            return  rs.next() && rs.getString(1).equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
