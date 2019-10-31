package info.zdziech.g.ShopProducts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProductTest {
    @Test
    void productsWithSameNameAndPriceShouldBeEqual () {
        assertEquals(new Product("Product", 122.2), new Product("Product", 122.2));
    }
    @Test
    void  productsWithSamenameAndOtherPricesShoulbBeNotEquals () {
        assertNotEquals( new Product("Product", 122.22), new Product("Product",123.22));
    }
    @Test
    void productsWithDifferentNameAndSamePriceShoulBeNotEquals(){
        assertNotEquals(new Product("Product1", 122.21), new Product("Product2", 122.21));
    }

}

