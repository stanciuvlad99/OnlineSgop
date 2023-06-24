package ro.mycode.models;

public class OrderDetails{
    private int id;
    private int orderId;
    private int productId;
    private int price;
    private int quantity;

    public OrderDetails(int id, int orderId, int productId, int price, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetails(String text){
        String []split= text.split(",");
        this.id=Integer.parseInt(split[0]);
        this.orderId=Integer.parseInt(split[1]);
        this.productId=Integer.parseInt(split[2]);
        this.price=Integer.parseInt(split[3]);
        this.quantity=Integer.parseInt(split[4]);
    }

    @Override
    public String toString(){
        String text="";
        text+="id " + id + "\n";
        text+="order id " + orderId+ "\n";
        text+="product id " + productId+"\n";
        text+="price " + price + "\n";
        text+="quantity " + quantity + "\n";
        return text;
    }

    @Override
    public boolean equals(Object object){
        OrderDetails o = (OrderDetails) object;
        return this.id==o.id && this.orderId==o.orderId && this.productId==o.productId && this.price==o.price
                && this.quantity==o.quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toSave(){
        return this.id + "," + this.orderId + ","+ this.productId + ","+ this.price + ","+this.quantity;
    }

}
