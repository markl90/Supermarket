import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarket.Product;
import supermarket.Supermarket;

public class SupermarketTest {

    Supermarket supermarket;

    @BeforeEach
    public void setup(){
        supermarket = new Supermarket(  new Product("A",50),
                                        new Product("B",30),
                                        new Product("C",20),
                                        new Product("D",15));
    }

    @Test
    public void test(){

        System.out.println(supermarket.getProduct("A").getPrice() );
    }

}
