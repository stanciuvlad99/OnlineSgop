package ro.mycode.view;

import ro.mycode.controllers.ControlOrderDetails;
import ro.mycode.controllers.ControlOrders;
import ro.mycode.controllers.ControlProducts;
import ro.mycode.controllers.ControlUser;
import ro.mycode.models.Admin;
import ro.mycode.models.Products;
import ro.mycode.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAdmin {
    private ArrayList<Admin> admins;
    private Admin admin;
    private ControlUser controlUser;
    private ControlProducts controlProducts;
    private ControlOrders controlOrders;
    private ControlOrderDetails controlOrderDetails;

    public ViewAdmin(Admin admin) {
        this.admin = admin;
        this.controlUser = new ControlUser();
        this.controlProducts = new ControlProducts();
        this.controlOrders = new ControlOrders();
        this.controlOrderDetails = new ControlOrderDetails();
        this.admins = new ArrayList<>();
        play();
    }

    public void menu() {
        System.out.println("Bine ai venit " + admin.getFullName() + "!");
        System.out.println("");
        System.out.println("Apasati tasta 1 pentru a vedea customerii sau adminii");
        System.out.println("Apasati tsata 2 pentru a vedea toate produsele");
        System.out.println("Apasati tsata 3 pentru a dauga produse");
        System.out.println("Apasati tasta 4 pentru a edita pretul unui produs");
        System.out.println("Apasati tasta 5 pentru a elimina un produs");
        System.out.println("Apasati tasta 6 pentru a elimina un customer");
        System.out.println("Apasati tasta 7 pentru a adauga un customer");
    }

    public void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    read();
                    break;
                case 2:
                    readProducts();
                    break;
                case 3:
                    adaugareProduse();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:eliminareCustomer();
                break;
                case 7:adaugareCustomer();
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
        User user = controlUser.findByType(type);
        if (user != null) {
            ArrayList<User> users = controlUser.findByTypeArr(type);
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).toString());
//                User user1 = controlUser.findBYType(type);
//                System.out.println(user1.toString());
            }
        }
    }

    public void readProducts() {
        controlProducts.read();
    }

    public void adaugareProduse() {
        System.out.println("Introduceti numele produsului");
        Scanner scanner = new Scanner(System.in);
        String produs = scanner.nextLine();
        Products products = controlProducts.findByName(produs);
        if (products == null) {
            System.out.println("Introduceti SKU pentru noul produs");
            String sku = scanner.nextLine();
            System.out.println("Introduceti pretul noului produs");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Introduceti greutatea noului produs");
            int weight = Integer.parseInt(scanner.nextLine());
            Products newProduct = new Products(controlProducts.nextId(), produs, price, weight);
            controlProducts.add(newProduct);
            System.out.println("Produsul a fost adaugat cu succes");
        } else {
            System.out.println("produsul exista deja");
        }
    }

    //Nu merge daca nu comentez Eqals() din Customer
    public void eliminareCustomer(){
        System.out.println("Introcueti tipul contului");
        Scanner scanner = new Scanner(System.in);
        String type=scanner.nextLine();
        System.out.println("Introduceti adresa de mail");
        String email=scanner.nextLine();
        User user = controlUser.findByTypeEmail(type,email);
        if (user!=null){
            controlUser.remove(user);
            System.out.println("Clientul a fost eliminat cu succes");
        }else {
            System.out.println("Adresa de mail " + email + " nu exista in baza de date sau tipul contului este incorect");
        }
    }

    public void adaugareCustomer(){
        System.out.println("Introduceti tipul contului");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        System.out.println("Introduceti adrsa de mail");
        String email= scanner.nextLine();
        User user = controlUser.findByTypeEmail(type,email);
        boolean check= controlUser.checkCustomer(type);
        if (user==null&&check==true){
            System.out.println("Introduceti parola");
            String password=scanner.nextLine();
            System.out.println("Introduceti prenume si nume");
            String fullname=scanner.nextLine();
            System.out.println("Introduceti nuamarul de telefon");
            int phone=Integer.parseInt(scanner.nextLine());
            User user1 = new User(controlUser.nextId(),password,email,fullname,phone,type);
            controlUser.add(user1);
            System.out.println("Clientul a fost adugat cu succes");
        }else {
            System.out.println("Adresa de mail " + email + " nu exista in baza de date sau tipul contului este incorect");
        }
    }



}






















