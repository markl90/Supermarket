package pricingrules;


import supermarket.Product;

import java.util.ArrayList;
    

public interface PricingRule {

    double modifyTotal(ArrayList<Product> basket, double total);
}
