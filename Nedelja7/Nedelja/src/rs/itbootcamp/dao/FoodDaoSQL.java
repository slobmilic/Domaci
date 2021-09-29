package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoSQL implements FoodDao{
    private static final Connection conn = DatabaseConnection.getConnection();

    @Override
    public void add(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO food VALUES(?,?,?,?,?,?)");
            st.setInt(1,fm.getFood_id());
            st.setString(2,fm.getFood_name());
            st.setDouble(3,fm.getFood_kcal());
            st.setDouble(4,fm.getFood_proteins());
            st.setDouble(5,fm.getFood_carbohydrates());
            st.setDouble(6,fm.getFood_fat());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addToMeal(int meal_id, int food_id, double mass) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO mealfood VALUES(?,?,?)");
            st.setInt(1,meal_id);
            st.setInt(2,food_id);
            st.setDouble(3,mass);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToFridge(int fridge_id, int food_id, double mass) {
        // TODO
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO fridgefood VALUES(?,?,?)");
            st.setInt(1,fridge_id);
            st.setInt(2,food_id);
            st.setDouble(3,mass);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFromFridge(int id){
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM fridgefood WHERE food_id = ?");
            st.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FoodModel> searchForFood (String s){
        List<FoodModel> fl = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food WHERE LOWER (food_name) LIKE LOWER ('%" + s + "%')");
            while(rs.next()){
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );
                fl.add(newFood);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return fl;
    }

    public void updateFridge(int fridge_id, int food_id, double mass){
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE fridgefood " +
                                                             "SET mass = ? " +
                                                             "WHERE fridge_id = ? AND food_id = ?");
            st.setDouble(1, mass);
            st.setInt(2, fridge_id);
            st.setInt(3, food_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM food WHERE food_id = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE food " +
                                                             "SET food_name = ?, " +
                                                                 "food_kcal = ?, " +
                                                                 "food_proteins = ?, " +
                                                                 "food_carbs = ?, " +
                                                                 "food_fat = ? " +
                                                             "WHERE food_id = ?");
            st.setString(1,fm.getFood_name());
            st.setDouble(2,fm.getFood_kcal());
            st.setDouble(3,fm.getFood_proteins());
            st.setDouble(4,fm.getFood_carbohydrates());
            st.setDouble(5,fm.getFood_fat());
            st.setInt(6,fm.getFood_id());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public FoodModel getFood(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food WHERE food_id = " + id);
            if (rs.next()){
                return new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodModel> getAllFood() {
        List<FoodModel> allFood = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food");
            while(rs.next()){
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                        );
                allFood.add(newFood);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allFood;
    }

}
