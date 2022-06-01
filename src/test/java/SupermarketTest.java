import pricingrules.PricingRule;
import pricingrules.ThreeFor130Implementation;
import pricingrules.TwoFor45Implementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarket.Checkout;
import supermarket.Product;
import supermarket.Supermarket;

public class SupermarketTest {

    Supermarket supermarket;
    Checkout checkout;

    @BeforeEach
    public void setup(){
        supermarket = new Supermarket(  new Product("A",50),
                                        new Product("B",30),
                                        new Product("C",20),
                                        new Product("D",15));
        checkout = new Checkout(supermarket);
    }

    @Test
    public void testEmptyBasket(){
        Assertions.assertEquals(0, checkout.calculateTotal());
    }

    @Test
    public void testSingleItemInBasket(){
        double expectedPrice = supermarket.getProduct("A").getPrice();
        checkout.addProducts("A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testTwoUniqueItemsInBasket(){
        double expectedPrice =  sumProductPrices("A", "B");
        checkout.addProducts("A", "B");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testThreeUniqueItemsInBasket(){
        double expectedPrice =  sumProductPrices("A", "B", "C");
        checkout.addProducts("A", "B", "C");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testFourUniqueItemsInBasket(){
        double expectedPrice =  sumProductPrices("A", "B", "C", "D");
        checkout.addProducts("A", "B", "C", "D");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testTwoIdenticalItemsInBasket(){
        double expectedPrice =  sumProductPrices("A", "A");
        checkout.addProducts("A", "A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testThreeIdenticalItemsInBasket(){
        double expectedPrice =  sumProductPrices("A", "A", "A");
        checkout.addProducts("A", "A", "A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testFourIdenticalItemsInBasket(){
        double expectedPrice =  sumProductPrices("A", "A", "A", "A");
        checkout.addProducts("A", "A", "A", "A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testThreeFor130(){
        double expectedPrice = 130;
        PricingRule threeFor130 = new ThreeFor130Implementation("A");
        supermarket.addPricingRule(threeFor130);
        checkout.addProducts("A", "A", "A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testThreeFor130WithTwo(){
        double expectedPrice =  sumProductPrices("A", "A");
        PricingRule threeFor130 = new ThreeFor130Implementation("A");
        supermarket.addPricingRule(threeFor130);
        checkout.addProducts("A", "A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testThreeFor130WithSix(){
        double expectedPrice =  260;
        PricingRule threeFor130 = new ThreeFor130Implementation("A");
        supermarket.addPricingRule(threeFor130);
        checkout.addProducts("A", "A", "A", "A", "A", "A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testThreeFor130WithFour(){
        double expectedPrice =  130 + supermarket.getProduct("A").getPrice();
        PricingRule threeFor130 = new ThreeFor130Implementation("A");
        supermarket.addPricingRule(threeFor130);
        checkout.addProducts("A", "A", "A", "A");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testTwoFor45(){
        double expectedPrice = 45;
        PricingRule twoFor45 = new TwoFor45Implementation("B");
        supermarket.addPricingRule(twoFor45);
        checkout.addProducts("B", "B");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testTwoFor45WithOne(){
        double expectedPrice = supermarket.getProduct("B").getPrice();
        PricingRule twoFor45 = new TwoFor45Implementation("B");
        supermarket.addPricingRule(twoFor45);
        checkout.addProducts("B");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testTwoFor45WithThree(){
        double expectedPrice = 45 + supermarket.getProduct("B").getPrice();
        PricingRule twoFor45 = new TwoFor45Implementation("B");
        supermarket.addPricingRule(twoFor45);
        checkout.addProducts("B", "B", "B");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testTwoFor45WithFour(){
        double expectedPrice = 90;
        PricingRule twoFor45 = new TwoFor45Implementation("B");
        supermarket.addPricingRule(twoFor45);
        checkout.addProducts("B", "B", "B", "B");
        Assertions.assertEquals(expectedPrice, checkout.calculateTotal());
    }

    @Test
    public void testBothRulesTogether(){
        double expectedPrice = 130 + 45;
        PricingRule threeFor130 = new ThreeFor130Implementation("A");
        PricingRule twoFor45 = new TwoFor45Implementation("B");
        supermarket.addPricingRule(threeFor130);
        supermarket.addPricingRule(twoFor45);
        checkout.addProducts("A", "A", "A", "B", "B");
    }

    @Test
    public void testBothRulesWithExtraItems(){
        double expectedPrice = 130 + 45 + sumProductPrices("C", "D");
        PricingRule threeFor130 = new ThreeFor130Implementation("A");
        PricingRule twoFor45 = new TwoFor45Implementation("B");
        supermarket.addPricingRule(threeFor130);
        supermarket.addPricingRule(twoFor45);
        checkout.addProducts("A", "A", "A", "B", "B", "C", "D");
    }

    private double sumProductPrices(String... SKU){
        double total = 0;
        for (String sku : SKU){
           total +=  supermarket.getProduct(sku).getPrice();
        }
        return total;
    }





}
