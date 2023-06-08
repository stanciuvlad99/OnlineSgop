package ro.mycode.utils;

public class CartItem {


    private int productId;
    private int ammount;
    private CartItem cartItem;

    public CartItem(int productId, int ammount){
        this.productId=productId;
        this.ammount = ammount;


    }

    @Override
    public String toString(){
        String text="";
        text+="product id " + productId + "\n";
        text+="ammount " + ammount + "\n";
        return text;
    }

    public int getProductId(){
        return productId;
    }

    public void setProductId(int productId){
        this.productId=productId;
    }

    public int getAmmount(){
        return ammount;
    }

    public void setAmmount(int ammount){
        this.ammount = ammount;
    }

    public void add(CartItem cartItem){
        this.cartItem.add(cartItem);
    }


}
