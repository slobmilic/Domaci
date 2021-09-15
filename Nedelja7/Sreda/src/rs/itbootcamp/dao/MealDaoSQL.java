package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealDaoSQL implements MealDao{
    private static final Connection conn = DatabaseConnection.getConnection();

    @Override
    public void insert(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO meal VALUES(?,?,?,?)");
            st.setInt(1,mm.getMealId());
            st.setString(2,mm.getMealName());
            st.setString(3,mm.getMealDesc());
            st.setString(4,mm.getMealDifficulty());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM meal WHERE meal_id = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE meal " +
                    "SET meal_name = ?, " +
                    "meal_desc = ?, " +
                    "meal_difficulty = ?, " +
                    "WHERE food_id = ?");
            st.setString(1,mm.getMealName());
            st.setString(2,mm.getMealDesc());
            st.setString(3,mm.getMealDifficulty());
            st.setInt(6,mm.getMealId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MealModel getMeal(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal WHERE meal_id = " + id);
            while(rs.next()){
                MealModel newMeal = new MealModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                return newMeal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MealModel> getAllMeal() {
        List<MealModel> allMeal = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal");
            while(rs.next()){
                MealModel newMeal = new MealModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                allMeal.add(newMeal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMeal;
    }

    @Override
    public List<String> getFoodMealNames(int meal_id) {
        List<String> fn = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT food_name FROM food " +
                                               "WHERE food_id IN " +
                                               "(SELECT food_id FROM mealfood WHERE meal_id = " + meal_id + ")");
            while(rs.next()){
            fn.add(rs.getString(1));
            }
            return fn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodModel> getFoodMeal(int meal_id) {
        List<FoodModel> fm = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food " +
                                               "WHERE food_id IN " +
                                               "(SELECT food_id FROM mealfood WHERE meal_id = " + meal_id + ")");
            while(rs.next()){
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );
                fm.add(newFood);
            }
            return fm;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
