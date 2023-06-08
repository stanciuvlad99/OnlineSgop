package ro.mycode.models;

public class Products implements Comparable<Products>{

    private int id;
    private String sku;
    private String name;
    private int price;
    private double weight;

    public Products(int id, String sku, String name, int price, int weight, String description,
                    String thumbnail, String image, String category, String creteDate, int stock) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Products(String text){
        String []split=text.split(",");
        this.id=Integer.parseInt(split[0]);
        this.sku=split[1];
        this.name=split[2];
        this.price=Integer.parseInt(split[3]);
        this.weight=Double.parseDouble(split[4]);
    }

    @Override
    public String toString() {
        String text = "";
        text += "products id " + id+"\n";
        text += "sku " + sku+"\n";
        text += "name " + name+"\n";
        text += "price " + price+"\n";
        text += "weight " + weight+ " kg"+"\n";
        return text;
    }

    @Override
    public boolean equals(Object object) {
        Products products = (Products) object;
        return this.id == products.id && this.sku.equals(products.sku) && this.name.equals(products.name)
                && this.price == products.price && this.weight == (products.weight);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Products o){
        if (this.price>o.price){
            return 1;
        }else if (this.price<o.price){
            return -1;
        }
        return 0;
    }
}
