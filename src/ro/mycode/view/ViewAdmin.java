package ro.mycode.view;

import ro.mycode.controllers.ControlOrderDetails;
import ro.mycode.controllers.ControlOrders;
import ro.mycode.controllers.ControlProducts;
import ro.mycode.controllers.ControlUser;
import ro.mycode.models.Admin;
import ro.mycode.models.Products;
import ro.mycode.models.User;
import ro.mycode.utils.Utile;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAdmin {
    private ArrayList<Admin> admins;
    private Admin admin;
    private ControlUser controlUser;
    private ControlProducts controlProducts;
    private ControlOrders controlOrders;
    private ControlOrderDetails controlOrderDetails;

    public ViewAdmin() {
        this.admin = new Admin("admin,1,ionutmarian@email.com,dummypass,Ionut Marian,0721234567,1,communication/problem-solving,bugs solving");
        this.controlUser = new ControlUser();
        this.controlProducts = new ControlProducts();
        this.controlOrders = new ControlOrders();
        this.controlOrderDetails = new ControlOrderDetails();
        this.admins = new ArrayList<>();
        play();
    }

    public void menu() {
        System.out.println("Apasati tasta 1 pentru a vedea customerii sau adminii");
        System.out.println("Apasati tsata 2 pentru a vedea toate produsele");
        System.out.println("Apasati tsata 3 pentru a dauga produse");
    }

    public void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:read();
                    break;
                case 2:readProducts();
                    break;
                case 3:adaugareProduse();
                break;
                default:
                    break;
            }
        }
    }

    public void read() {
        System.out.println("Introduceti 'customer' pentru a vedea toti clientii sau 'admin' pentru a vedea toti adminii");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        User user = controlUser.findBYType(type);
        if (user!=null) {
            ArrayList<User> users = controlUser.findByTypeArr(type);
            for (int i=0; i<users.size(); i++){
                User user1 = controlUser.findBYType(type);
                System.out.println(user1.toString());

            }
        }
    }

    public void readProducts(){
        controlProducts.read();
    }

    public void adaugareProduse(){
        System.out.println("Introduceti numele produsului");
        Scanner scanner = new Scanner(System.in);
        String produs=scanner.nextLine();
        Products products = controlProducts.findByName(produs);
        if (products==null){
            System.out.println("Introduceti SKU pentru noul produs");
            String sku=scanner.nextLine();
            System.out.println("Introduceti pretul noului produs");
            int price=Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti greutatea noului produs");
            int weight=Integer.parseInt(scanner.nextLine());
            Products newProduct = new Products(controlProducts.nextId(),sku,produs,price,weight);
            controlProducts.add(newProduct);
            System.out.println("Produsul a fost adaugat cu succes");
        }else {
            System.out.println("produsul exista deja");
        }
    }

}
