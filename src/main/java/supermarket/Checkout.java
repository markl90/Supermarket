package supermarket;

import supermarket.Supermarket;

import java.util.ArrayList;

public class Checkout {

    private ArrayList<Product> basket;
    private Supermarket supermarket;

    public Checkout(Supermarket supermarket){
        basket = new ArrayList<>();
        this.supermarket = supermarket;
    }

    private void add(String SKU){
        if(supermarket.getProduct(SKU) != null){
            basket.add(supermarket.getProduct(SKU));
        }
    }
}
