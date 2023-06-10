package ro.mycode.utils;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int customerId;
    private List<CartItem> cartItems;

    public Cart(int customerId){
        this.customerId=customerId;
        this.cartItems=new ArrayList<CartItem>();
    }

    @Override
    public String toString(){
        String text="";
        text+="customer id " + customerId + "\n";
        text+="cart items " + cartItems + "\n";
        return text;
    }

    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId=customerId;
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems){
        this.cartItems =cartItems;
    }

    public void add(CartItem cart){
        cartItems.add(cart);
    }
}
