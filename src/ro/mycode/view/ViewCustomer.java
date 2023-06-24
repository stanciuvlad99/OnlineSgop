package ro.mycode.view;

import ro.mycode.controllers.ControlOrders;
import ro.mycode.controllers.ControlOrderDetails;
import ro.mycode.controllers.ControlProducts;
import ro.mycode.models.*;
import ro.mycode.utils.Cart;
import ro.mycode.utils.CartItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewCustomer {

    private Customer customer;
    private ControlOrders controlOrders;
    private ControlOrderDetails controlOrderDetails;
    private ControlProducts controlProducts;
    private Cart cart;

    public ViewCustomer( Customer customer) {

        this.customer = customer;
        this.controlOrders = new ControlOrders();
        this.controlOrderDetails = new ControlOrderDetails();
        this.controlProducts = new ControlProducts();
        this.cart = new Cart(customer.getId());
        play();
    }

    public void menu() {
        System.out.println("Bine ai venit " + customer.getFullName() + "!");
        System.out.println("");
        System.out.println("Apasati tasta 1 pentru a vedea toate produsele");
        System.out.println("Apasati tasta 2 pentru a vedea produsele comandate");
        System.out.println("Apasati tasta 3 pentru a vedea detalii despre comanda dumneavoastra");
        System.out.println("Apasati tsata 4 pentru a adauga prdose in cos");
        System.out.println("Apasati tasta 5 pentru a vedea produsele din cos");
        System.out.println("Apasati tasta 6 pentru a comanda produsele din cos");
        System.out.println("Apasati tasta 7 pentru a comanda un nou produs");
        System.out.println("Apasati tasta 8 pentru a anula o comanda");
        System.out.println("Apasati tasta 9 pentru a schimba adresa de livrare");
    }

    public void play() {
        menu();
        boolean running = true;
        while (running) {
            Scanner scanner = new Scanner(System.in);
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    afisareProduse();
                    break;
                case 2:
                    comenzi();
                    break;
                case 3:
                    detaliiComenzi();
                    break;
                case 4:
                    adaugareProduseCos();
                    break;
                case 5:vizualizareCos();
                    break;
                case 6:
                    comandaProduseCos();
                    break;
                case 7:

            }
        }
    }

    public void afisareProduse() {
        controlProducts.read();
    }

    public void comenzi() {
        ArrayList<Orders> orders = controlOrders.findByCustomerIdArr(customer.getId());
        for (int i = 0; i < orders.size(); i++) {
            Products products = controlProducts.findByProductsId(orders.get(i).getId());
            System.out.println(products.toString());
        }
    }

    public void detaliiComenzi() {
        ArrayList<Orders> orders = controlOrders.findByCustomerIdArr(customer.getId());
        for (int i = 0; i < orders.size(); i++) {
            Orders orders1 = controlOrders.findByCustomerId(orders.get(i).getId());
            System.out.println(orders1.toString());
        }
    }

    public void adaugareProduseCos() {
        System.out.println("Introduceti numele produsului pe care doriti sa il adaugati in cos");
        Scanner scanner = new Scanner(System.in);
        String produs = scanner.nextLine();
        Products products = controlProducts.findByName(produs);
        if (products!= null) {
            System.out.println("Cate produse doriti sa comandati");
            int quantity = Integer.parseInt(scanner.nextLine());
            CartItem cartItem1 = new CartItem(controlProducts.returnIdByName(produs),quantity, produs, products.getPrice());
            cart.add(cartItem1);
            System.out.println("Produsul a fost adauga cu succes");
        } else {
            System.out.println("Prodususl " + produs + " nu exista");
        }
    }

    public void vizualizareCos(){

        List<CartItem> cartItemList = cart.getCartItems();
        for (int i=0; i<cartItemList.size();i++){
            System.out.println(cartItemList.get(i).toString());
        }

    }

    public void comandaProduseCos() {


        Orders orders= new Orders(controlOrders.nextId(),customer.getId(),0,"qwerty",customer.getEmail(),"qwerty",
                LocalDate.now(),"qwerty");
        cart.getCartItems().forEach(ci->{

            controlOrderDetails.add(new OrderDetails(controlOrderDetails.nextId(),orders.getId(),ci.getProductId(),
                    ci.getProductPrice(), ci.getQuantity()));

        });
        controlOrderDetails.toSave();
    }


//
//    public void eliminareComanda() {
//        System.out.println("Introduceti numele prdusului pe care doriti sa il elimianati din comanda");
//        Scanner scanner = new Scanner(System.in);
//        String produs = scanner.nextLine();
//        Products products = controlProducts.findByName(produs);
//        if (products != null) {
//            int orderId = controlOrderDetails.findByProductIdReturnOrderId(products.getId());
//            Orders orders = controlOrders.findById(orderId);
//            controlOrders.remove(orders);
//            System.out.println("Produsul a fost eliminat cu succes");
//        }
//        System.out.println("Produsul respectiv nu exista");
//    }
//
//    public void adresaLivrare() {
//        System.out.println("Introduceti numele produsului");
//        Scanner scanner = new Scanner(System.in);
//        String product = scanner.nextLine();
//        int productId=controlProducts.returnIdByName(product);
//        Orders orders = controlOrders.findByOrderIdCustomerId(controlOrderDetails.findByProductIdReturnOrderId(productId), customer.getId());
//        if (orders != null) {
//            int id = controlProducts.returnIdByName(product);
//            System.out.println("Introduceti noua adresa de livrare");
//            String shippingAdress = scanner.nextLine();
//            Orders orders1 = new Orders(id, customer.getId(), orders.getAmmount(), shippingAdress, orders.getOrderEmail(), orders.getOrderAdress(),
//                    orders.getOrderDate(), orders.getOrderStatus(), orders.getType());
//            if (orders.getOrderStatus().equals("canceled")) {
//                System.out.println("Comanda a fost anulata");
//            }
//            controlOrders.editShippingAdress(orders1);
//            System.out.println("Locatia de livrare a fost schimbata cu succes");
//
//        }
//    }
}
