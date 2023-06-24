package ro.mycode.controllers;

import ro.mycode.utils.Utile;
import ro.mycode.models.Admin;
import ro.mycode.models.Customer;
import ro.mycode.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser {

    private String FINAL_URL = "C:\\mycode\\OOP\\OnlineShop\\src\\ro\\mycode\\data\\users.txt";
    private ArrayList<User> users;

    ControlUser(ArrayList<User> user){
        this.users=user;
    }



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

    public User findByType(String type){
        for (int i=0; i<users.size(); i++){
            if (users.get(i).getType().equals(type)){
                return users.get(i);
            }
        }
        return null;
    }

    public User findByTypeEmail(String type,String email){
        for (int i=0; i<this.users.size(); i++){
            if (this.users.get(i).getType().equals(type) && this.users.get(i).getEmail().equals(email)){
                return this.users.get(i);
            }
        }
        return null;
    }

    public void remove(User user){
        this.users.remove(user);
    }

    public int nextId(){
        if (this.users.size()==0){
            return -1;
        }
        return this.users.get(users.size()-1).getId()+1;
    }

    public void add(User user){
        this.users.add(user);
    }

    public boolean checkCustomer(String type){
        if (type.equals("customer")){
            return true;
        }
        return false;
    }

    public User findByEmailPassword(String email, String password){
        for (int i=0; i<this.users.size(); i++){
            if (this.users.get(i).getEmail().equals(email)&&this.users.get(i).getPassword().equals(password)){
                return this.users.get(i);
            }
        }
        return null;
    }

    public String toSave(){
        if (users.size()==0){
            return "";
        }
        int i;
        String text="";
        for (i=0; i<users.size()-1; i++){
            text+=users.get(i).toSave()+"\n";
        }
        text+=users.get(i).toSave();
        return text;
    }

    public void save(String path){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
