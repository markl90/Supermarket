package pricingrules;

import supermarket.Product;

import java.util.ArrayList;

public class TwoFor45Implementation implements PricingRule {

    private String SKU;

    public TwoFor45Implementation(String SKU) {
        this.SKU = SKU;
    }

    @Override
    public double modifyTotal(ArrayList<Product> basket, double total) {
        double productPrice = 0;
        int count = 0;
        for (Product product : basket){
            if(product.getSKU().equals(SKU)){
                count++;
                productPrice = product.getPrice();
            }
        }
        int multiplesOfTwo = count/2;
        total = total - (multiplesOfTwo * (2*productPrice));
        total = total + (multiplesOfTwo * 45);
        return total;
    }

}
