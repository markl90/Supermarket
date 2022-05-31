package supermarket;

import Pricingrules.PricingRule;

import java.util.ArrayList;
import java.util.Collections;

public class Supermarket {

    private ArrayList<Product> products;
    private ArrayList<PricingRule> pricingRules;

    public Supermarket(Product... product){
        products = new ArrayList<>();
        pricingRules = new ArrayList<>();
        Collections.addAll(products, product);
    }

    private void addProduct(Product product){
        products.add(product);
    }

    public Product getProduct(String SKU){
        for(Product product : products) {
            if(product.getSKU().equals(SKU)){
                return product;
            }
        }
        return null;
    }

    private void addPricingRule(PricingRule pricingRule){
        pricingRules.add(pricingRule);
    }
}
