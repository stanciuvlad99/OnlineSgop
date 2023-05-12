package ro.mycode.models;

public class Products {

    private int id;
    private String sku;
    private String name;
    private int price;
    private int weight;

    public Products(int id, String sku, String name, int price, int weight, String description,
                    String thumbnail, String image, String category, String creteDate, int stock) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        String text = "";
        text += "products id " + id;
        text += "sku " + sku;
        text += "name " + name;
        text += "price " + price;
        text += "weight " + weight;
        return text;
    }

    @Override
    public boolean equals(Object object) {
        Products products = (Products) object;
        return this.id == products.id && this.sku.equals(products.sku) && this.name.equals(products.name)
                && this.price == products.price && this.weight==(products.weight);
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
