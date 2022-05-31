package Pricingrules;
import supermarket.Product;

import java.util.ArrayList;

public class ThreeFor130Implementation implements PricingRule{

    private String SKU;

    public ThreeFor130Implementation(String SKU) {
        this.SKU = SKU;
    }

    @Override
    public double modifyTotal(ArrayList<Product> basket) {
        double productPrice = 0;
        double total = 0;
        int count = 0;
        for(Product product : basket) {
            total += product.getPrice();
            if(product.getSKU().equals(SKU)){
                count++;
                productPrice = product.getPrice();
            }
        }
        int multiplesOfThree = count/3;
        total = total - (multiplesOfThree * productPrice);
        total = total + 130;
        return total;
    }
}
