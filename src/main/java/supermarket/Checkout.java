package supermarket;

import pricingrules.PricingRule;

import java.util.ArrayList;

public class Checkout {

    private ArrayList<Product> basket;
    private Supermarket supermarket;

    public Checkout(Supermarket supermarket){
        basket = new ArrayList<>();
        this.supermarket = supermarket;
    }

    public void addProducts(String... SKU){
       for (String sku : SKU){
           if(supermarket.getProduct(sku) != null){
               basket.add(supermarket.getProduct(sku));
           }
       }
    }

    public double calculateTotal(){
        double total = sumOfBasket();
        for (PricingRule pricingRule : supermarket.getPricingRules()){
            total =  pricingRule.modifyTotal(basket,total);
        }
        return total;
    }

    private double sumOfBasket(){
        double total = 0;
        for (Product product : basket){
            total += product.getPrice();
        }
        return total;
    }


}
