import rs.itbootcamp.dao.*;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;
import rs.itbootcamp.model.UserModel;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodDao fd = new FoodDaoSQL();
        MealDao md = new MealDaoSQL();
        UserDao ud = new UserDaoSQL();

//        fd.update(new FoodModel(10, "Grasak", 340, 15, 15, 18));
//        FoodModel food = new FoodModel(2,"Mleko", 58.2, 23.5, 14.5,2.8);
//        //fd.add(food);
//        System.out.println(fd.getFood(1));
//        MealModel meal = new MealModel(2,"Jelo2", "Drugo jelo", "8");
//        //md.add(meal);
//        System.out.println(md.getMeal(1));
//        System.out.println(md.getAllMeal());
//        //fd.addToMeal(1,1,600);
//        System.out.println(md.getFoodMealNames(1));
//        System.out.println(md.getFoodMeal(1));
//
////        ud.add(new UserModel(5,"NameUser4", "nestoDrugo4@nesto.com", "12345678", false));
////        ud.delete(1);
//        ud.update(new UserModel(1,"Name", "nestoNovo@nesto.com", "12345678", true));
//        System.out.println(ud.getUser(1));


//        for (int i = 10; i < 15; i++) {
//            fd.add(new FoodModel(i, "Name"+i, 200+i*13.7,0.5*i*2,1,2));
//        }

//        System.out.println("Unesite email ili username: ");
//        String entry = sc.next();
//        System.out.println("Unesite password: ");
//        String pw = sc.next();
//
//        if (ud.login(entry,pw)){
//            System.out.println("USPESNO");
//        }else {
//            System.out.println("NEUSPESNO");
//        }



    }
}
