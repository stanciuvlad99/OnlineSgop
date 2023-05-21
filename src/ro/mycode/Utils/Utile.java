package ro.mycode.Utils;

import ro.mycode.models.OrderDetails;
import ro.mycode.models.Orders;
import ro.mycode.models.Products;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Utile{



    public static<T> void load(String path, String type,ArrayList<T> elements){

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            elements.clear();
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();

                switch (type){
                    case "order":
                        Orders orders = new Orders(text);
                        elements.add((T)orders);
                    break;
                    case "order details":
                        OrderDetails orderDetails = new OrderDetails(text);
                        elements.add((T)orderDetails);
                        break;
                    case "products":
                        Products products = new Products(text);
                        elements.add((T)products);
                        break;

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void read(ArrayList arrayList){
        for (int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i).toString());
        }
    }




}
