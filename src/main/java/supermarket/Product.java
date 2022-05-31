package supermarket;

public class Product {

    private String SKU;
    private double price;

    public Product(String SKU, double price){
        this.price = price;
        this.SKU = SKU;
    }

    public String getSKU() {
        return SKU;
    }

    public double getPrice() {
        return price;
    }
}
