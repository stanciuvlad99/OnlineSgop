package ro.mycode.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Customer extends User{

    private LocalDate lastOrderDate;

    private LocalDate registerDate;

    private boolean isBlocked;

    public Customer(int id, String email, String password, String fullName, int phone,
                    LocalDate lastOrderDate, LocalDate registerDate, boolean isBlocked) {
        super(id, email, password, fullName, phone, "customer");
        this.lastOrderDate = lastOrderDate;
        this.registerDate = registerDate;
        this.isBlocked = isBlocked;
    }

    public Customer(){

    }

    public Customer(String text){
        super(text);
        this.lastOrderDate=LocalDate.parse(text.split(",")[6]);
        this.registerDate=LocalDate.parse(text.split(",")[7]);
        this.isBlocked=Boolean.parseBoolean(text.split(",")[8]);
    }

    @Override
    public String toString() {
        String text = "";
        text += "id " + super.getId() + "\n";
        text += "email " + super.getEmail() + "\n";
        text += "password " + super.getPassword() + "\n";
        text += "phone " + super.getPhone() + "\n";
        text += "type " + super.getType() + "\n";
        text += "last order date " + this.lastOrderDate + "\n";
        text += "register date " + this.registerDate + "\n";
        text += "is blocked " + this.isBlocked + "\n";
        return text;
    }

    @Override
    public boolean equals(Object object) {
        Customer customer = (Customer) object;
        return this.lastOrderDate.equals(customer.lastOrderDate) && this.registerDate.equals(customer.registerDate)
                && this.isBlocked == customer.isBlocked;
    }

    public LocalDate getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(LocalDate lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public int compareTo(User o){
        Customer customer= (Customer) o;
     if (this.registerDate.compareTo(customer.getRegisterDate())>0) {
         return 1;
     }
     else if (this.registerDate.compareTo(customer.getRegisterDate())<0){
         return -1;
     }
     return 0;
    }
}
