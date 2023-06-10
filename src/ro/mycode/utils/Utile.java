package ro.mycode.utils;

import ro.mycode.controllers.ControlUser;
import ro.mycode.models.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Utile {

    public static <T> void load(String path, String type, ArrayList<T> elements) {

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            elements.clear();
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();

                switch (type) {
                    case "order":
                        Orders orders = new Orders(text);
                        elements.add((T) orders);
                        break;
                    case "order details":
                        OrderDetails orderDetails = new OrderDetails(text);
                        elements.add((T) orderDetails);
                        break;
                    case "products":
                        Products products = new Products(text);
                        elements.add((T) products);
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> void read(ArrayList<T> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }

    public static int findByEmailPassword(String email, String password) {
        Admin admin1 = new Admin();
        Customer customer1 = new Customer();
        for (int i = 0; i < 1000; i++) {
            if (admin1.getEmail().equals(email) && admin1.getPassword().equals(password)) {
                return 1;
            }
            if (customer1.getEmail().equals(email) && customer1.getPassword().equals(password)) {
                return -1;
            }
        }
        return 0;
    }


    public static void menuAdmin() {
        Admin admin1 = new Admin();
        System.out.println("Bine ai venit " + admin1.getFullName() + " !");
        System.out.println();
        System.out.println("Apasati tasta 1 pentru a vedeat toti clientii");
    }

    public static void menuCustomer() {
        Customer customer1 = new Customer();
        System.out.println("Bine ai venit " + customer1.getFullName() + " !");
        System.out.println();
        System.out.println("Apasati tasta 1 pentru a vedea toate produsele");
    }

    public static <T> void play() {
        ControlUser controlUser = new ControlUser();
        Admin admin1 = new Admin();
        Customer customer1 = new Customer();
        System.out.println("Introduceti adresa de mail si parola");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String password = scanner.nextLine();

        if (findByEmailPassword(email, password) == 1) {
            menuAdmin();
        }
        if (findByEmailPassword(email, password) == -1) {
            menuCustomer();
        }
        if (email.equals(admin1.getEmail()) && password.equals(admin1.getPassword())) {
            boolean running = true;
            while (running) {
                int alegere = Integer.parseInt(scanner.nextLine());
                switch (alegere) {
                    case 1:
                        controlUser.read();
                }
            }
        }
        if (email.equals(customer1.getEmail()) && password.equals(customer1.getPassword())) {
            boolean running = true;
            while (running) {
                int alegere = Integer.parseInt(scanner.nextLine());
                switch (alegere) {
                    case 1:
                        controlUser.read();
                }
            }
        }
    }
}
