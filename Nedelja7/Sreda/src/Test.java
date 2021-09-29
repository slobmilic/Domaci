import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.dao.MealDaoSQL;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

public class Test {
    public static void main(String[] args) {
        FoodDaoSQL fd = new FoodDaoSQL();
        FoodModel food = new FoodModel(2,"Mleko", 58.2, 23.5, 14.5,2.8);
        //fd.insert(food);
        System.out.println(fd.getFood(1));
        MealDaoSQL md = new MealDaoSQL();
        MealModel meal = new MealModel(2,"Jelo2", "Drugo jelo", "8");
        //md.insert(meal);
        System.out.println(md.getMeal(1));
        System.out.println(md.getAllMeal());
        //fd.addToMeal(1,1,600);
        System.out.println(md.getFoodMealNames(1));
        System.out.println(md.getFoodMeal(1));


    }
}
