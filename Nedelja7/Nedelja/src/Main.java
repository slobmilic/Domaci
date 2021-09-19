import rs.itbootcamp.dao.FoodDao;
import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.dao.FridgeDao;
import rs.itbootcamp.dao.FridgeDaoSQL;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static FoodDao fd = new FoodDaoSQL();
    static FridgeDao ff = new FridgeDaoSQL();
    static int fridge_id = 1;
    private static void welcomeMessage(){
        System.out.println("Welcome to kitchen!!!");
        System.out.println("------------------------");
    }

    private static void addFoodToFridge(Scanner sc){
        List<FoodModel> foodList = fd.getAllFood();
        int choice = -1;

        while(choice != 0){
            for(int i = 0; i < foodList.size(); i++){
                System.out.println((i+1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if(choice > 0 && choice <= foodList.size()){
                System.out.println("How much: (in grams)");
                double mass = sc.nextDouble();
                fd.addToFridge(fridge_id,foodList.get(choice - 1).getFood_id(),mass);
                System.out.println("++");
            }
        }
    }

    private static void searchFood(Scanner sc){
        System.out.println("Enter search phase:");
        String s = sc.next();
        List<FoodModel> fl = fd.searchForFood(s);
        System.out.println("Enter number of results per page:");
        int perPage = sc.nextInt();
        int page = 1;
        int x = -1;

        while(x != 0){
            if (fl.size() < perPage * page) {
                for (int i = perPage * (page - 1); i < fl.size(); i++) {
                    System.out.println(fl.get(i));
                }
                x = 0;
                continue;
            }
            for (int i = perPage * (page - 1); i < perPage * page; i++) {
                System.out.println(fl.get(i));
            }
            System.out.println("--------------------------------");
            System.out.println("n OR b");
            String cho = sc.next();
            if (cho.equals("n")){
                page++;
                continue;
            }
            if (cho.equals("b")) {
                page--;
                continue;
            }else {
                System.out.println("Invalid command");
            }
        }
        System.out.println("---------------------------------");
    }

    private static void removeFoodFromFridge(Scanner sc){

        int choice = -1;

        while (choice != 0){
            List<FoodModel> foodList = ff.getAllFood(fridge_id);
            for (int i = 0; i < foodList.size(); i++) {
                System.out.println((i+1) + "." + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if (choice > 0 && choice <= foodList.size()){
                int id = sc.nextInt();
                fd.removeFromFridge(id);
                System.out.println("--");
            }
        }
    }

    private static void fridgeMenu(Scanner sc){
        int choice;
        do{
            System.out.println("My Fridge:");
            System.out.println("--------");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Look in");
            System.out.println("4. Create meal");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch(choice){
                case 1 -> addFoodToFridge(sc);
                case 2 -> removeFoodFromFridge(sc);
                case 3 -> System.out.println("Write all food from fridge");
                case 4 -> System.out.println("Create meal");
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    private static void mainMenu(Scanner sc){
        int choice;
        do{
            System.out.println("Main menu:");
            System.out.println("-----------");
            System.out.println("1. My Fridge");
            System.out.println("2. Meals");
            System.out.println("3. All food");
            System.out.println("4. Search food");
            System.out.println("5. Add new food");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice){
                case 1 -> fridgeMenu(sc);
                case 2 -> System.out.println("Meals");
                case 3 -> System.out.println("All food");
                case 4 -> searchFood(sc);
                case 5 -> System.out.println("Add new food");
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeMessage();

        mainMenu(sc);
    }
}