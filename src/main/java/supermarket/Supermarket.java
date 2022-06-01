package supermarket;

import pricingrules.PricingRule;

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

    public void addProduct(Product product){
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

    public void addPricingRule(PricingRule... pricingRule){
        Collections.addAll(pricingRules, pricingRule);
    }

    public ArrayList<PricingRule> getPricingRules() {
        return pricingRules;
    }
}
