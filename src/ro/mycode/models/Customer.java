package ro.mycode.models;

import java.time.LocalDate;

public class Customer extends User {

    private LocalDate lastOrderDate;

    private LocalDate registerDate;

    private boolean isBlocked;

    public Customer(int id, String email, String password, String fullName, int phone, String type,
                    LocalDate lastOrderDate, LocalDate registerDate, boolean isBlocked) {
        super(id, email, password, fullName, phone, type);
        this.lastOrderDate = lastOrderDate;
        this.registerDate = registerDate;
        this.isBlocked = isBlocked;
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
}
