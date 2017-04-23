package HomeWork.OnlineStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Тарас on 05.04.2017.
 */
public class Store {
    static ArrayList<Product> goods = new ArrayList<Product>();
    static String[] productName = {"Дрель", "Штопор", "Кресло", "Кружка", "Молоток", "Часы", "Плед", "Стул", "Лампа", "Ваза"};
    static int[] productPrice = {45, 5, 50, 10, 15, 40, 20, 25, 35, 30};
    static int[] productAmount = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    static int cash = new Random().nextInt(201);
    static ArrayList<Product> cart = new ArrayList<Product>();
    static ArrayList<Integer> cartAmount = new ArrayList();
    static int sum = 0;

    public static void Shop()throws IOException{

        for (int i = 0; i < 10; i++)
            goods.add(new Product(i+1, productName[i], productPrice[i]));

        System.out.println("Добро пожаловать! Вас счёт: " + cash + "$");
        System.out.println("\nАссортимент магазина \"Домовой\":");

        for (int i = 0; i < 10; i++)
            System.out.println("id " + goods.get(i).id + " - " + goods.get(i).name + ", " + goods.get(i).price + "$" + " - " + productAmount[i] + " штук");

        System.out.println("\nВведите через пробел id и колличество выбранных товаров, каждый с новой строки.");

        Selection();

        while(cash < sum){
            System.out.println("\nУ Вас недостаточно денег. Выберите товары заново.");
            cart.clear();
            sum = 0;
            Selection();
        }
        System.out.println("Ok");


    }

    public static void Selection()throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = reader.readLine();
            if(!s.isEmpty()){
                String[] ss = s.split(" ");
                cart.add(goods.get(Integer.parseInt(ss[0]) - 1));
                cartAmount.add(Integer.parseInt(ss[1]));
            }
            else break;
        }

        System.out.println("Вы выбрали:\n");

        for (int i = 0; i < cart.size(); i++) {
            sum += cart.get(i).price * cartAmount.get(i);
            System.out.println(cart.get(i).name + ", " + cart.get(i).price + "$" + " - " + cartAmount.get(i) + " штук.");
        }

        System.out.println("На общую сумму " + sum + "$.");
    }
}
