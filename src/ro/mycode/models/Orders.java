package ro.mycode.models;

import java.time.LocalDate;

public class Orders {
    private int id;
    private int customerID;
    private int ammount;
    private String shippingAdress;
    private String orderEmail;
    private String orderAdress;
    private LocalDate orderDate;
    private String orderStatus;

    public Orders(int id, int customerID, int ammount, String shippingAdress, String orderEmail, String orderAdress, LocalDate orderDate, String orderStatus) {
        this.id = id;
        this.customerID = customerID;
        this.ammount = ammount;
        this.shippingAdress = shippingAdress;
        this.orderEmail = orderEmail;
        this.orderAdress = orderAdress;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        String text = "";
        text += "id " + id + "\n";
        text += "customer id" + customerID + "\n";
        text += "amount " + ammount + "\n";
        text += "shipping adress " + shippingAdress + "\n";
        text += "order email " + orderEmail + "\n";
        text += "order adress " + orderAdress + "\n";
        text += "order date " + orderDate + "\n";
        text += "order status " + orderStatus + "\n";
        return text;
    }

    @Override
    public boolean equals(Object object) {
        Orders orders = (Orders) object;
        return this.id == orders.id && this.customerID == orders.customerID && this.ammount==ammount &&
                this.shippingAdress.equals(orders.shippingAdress) && this.orderEmail && this.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public String getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(String orderAdress) {
        this.orderAdress = orderAdress;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
