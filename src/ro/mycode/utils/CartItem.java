package ro.mycode.models;

public class Bag {

    private int id;
    private int productId;
    private int customerId;
    private int quantity;

    public Bag(int id, int productId, int customerId, int quantity){
        this.id=id;
        this.productId=productId;
        this.customerId=customerId;
        this.quantity=quantity;
    }

    public Bag(String text){
        String[] split=text.split(",");
        this.id=Integer.parseInt(split[0]);
        this.productId=Integer.parseInt(split[1]);
        this.customerId=Integer.parseInt(split[2]);
        this.quantity=Integer.parseInt(split[3]);
    }

    @Override
    public String toString(){
        String text="";
        text+="id " + id + "\n";
        text+="product id" + productId + "\n";
        text+="customer id" + customerId + "\n";
        text+="quantity " + quantity + "\n";
    }

}
