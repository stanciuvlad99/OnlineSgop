package ro.mycode.controllers;

import ro.mycode.utils.Utile;
import ro.mycode.models.Admin;
import ro.mycode.models.Customer;
import ro.mycode.models.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser {

    private String FINAL_URL = "C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\users.txt";
    private ArrayList<User> users;

    public ControlUser() {
        this.users = new ArrayList<>();
        load();
    }

    private void load() {
        try {
            File file = new File(FINAL_URL);
            Scanner scanner = new Scanner(file);
            this.users.clear();
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();

                switch (text.split(",")[0]) {

                    case "customer":
                        this.users.add(new Customer(text));
                        break;
                    case "admin":
                        this.users.add(new Admin(text));
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        Utile.read(users);
    }

    public ArrayList<User> findByTypeArr(String type){
        ArrayList<User> list = new ArrayList<>();
        for (int i=0; i<users.size(); i++){
            if (users.get(i).getType().equals(type)){
                list.add(users.get(i));
            }
        }
        return list;
    }

    public User findBYType(String type){
        for (int i=0; i<users.size(); i++){
            if (users.get(i).getType().equals(type)){
                return users.get(i);
            }
        }
        return null;
    }





}
