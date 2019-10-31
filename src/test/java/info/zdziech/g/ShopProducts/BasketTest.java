package info.zdziech.g.ShopProducts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class BasketTest {

    private Basket basket;
    private Product milk;
    private static Map<Product, Integer> createOrder(Object ... mapContent) {
        Map<Product, Integer> order = new LinkedHashMap<>();

        for (int index = 0; index < mapContent.length; index += 2) {
            Product product = (Product) mapContent[index];
            Integer quantity = (Integer) mapContent[index +1];
            order.put(product, quantity);
        }
        return order;
    }

    @BeforeEach
     void setUp() {
        milk = new Product("milk", 19.99);
        basket = new Basket();
    }

    @Test
    void shouldAddOneProductToBasket(){
        basket.add(milk, 1);
        Map<Product, Integer > expected = createOrder(milk,1);
        assertEquals(expected, basket.getOrder());
    }

    @Test
    void shouldAddSameProductsToBasket(){
        basket.add(milk, 1);
        basket.add(milk, 2);
        Map<Product, Integer > expected = createOrder(milk,3);
        assertEquals(expected, basket.getOrder());
    }
    @Test
    void shouldAddDifferentproductToBasket (){
        basket.add(milk,1);
        Product bread = new Product("bread", 0.99);
        basket.add(bread,1);
        Map<Product, Integer > expected = createOrder(milk,1, bread,1);
        assertEquals(expected, basket.getOrder());
    }

    @Test
    void shouldntItAddNegativeNumberOfProducts() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> basket.add(milk, -4)
        );
        assertEquals(String.format("Illegal quantity %d!", -4), exception.getMessage());
    }

    @Test
    void shouldntAddProductWithQuantityZero(){
        IllegalArgumentException exception=Assertions.assertThrows(
                IllegalArgumentException.class,
                ()-> basket.add(milk, 0)
        );
        assertEquals(String.format("Illegal quantity %d!", 0), exception.getMessage());
    }
    @Test
    void shouldRemoweLessProductaThenInBasket(){
        basket.add(milk, 3);
        basket.remove(milk,2);
        Map<Product, Integer > expected = createOrder(milk, 1);
        assertEquals(expected, basket.getOrder());
    }

    @Test
    void shouldRemoweAllProductFromBasket (){
        basket.add(milk, 3);
        basket.remove(milk,3);
        Map<Product, Integer > expected = createOrder();
        assertEquals(expected, basket.getOrder());
    }
    @Test
    void skouldntRemoweProductWithNegativeNumberOfProduct(){
        basket.add(milk,3);
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->basket.remove(milk,-3)
        );
        assertEquals(String.format("Illegal quantity %d!", -3), exception.getMessage());
    }
    @Test
    void shouldntRemoveProductWithZeroNumberOfProduct () {
         basket.add(milk,3);
         IllegalArgumentException exception = Assertions.assertThrows(
                 IllegalArgumentException.class,
                 ()->basket.remove(milk,0)
         );
         assertEquals(String.format("Illegal quantity %d!", 0), exception.getMessage());
     }
    @Test
    void shouldntRemowMoreProductsThenInBasket(){
        basket.add(milk,3);
        IllegalStateException exception = Assertions.assertThrows(
                IllegalStateException.class,
                () -> basket.remove(milk, 4)
        );
        assertEquals(("There is no that many products to remove" ),exception.getMessage());
    }
    @Test
    void shouldtRemoveProductWhenIsntInBasket(){
        NullPointerException exception = Assertions.assertThrows(
                NullPointerException.class,
                ()-> basket.remove(milk,1)
        );
        assertEquals(("Product is not in the basket"),exception.getMessage());
    }
    @Test
      void shouldComputeOrderValueWithOneProduct() {
         basket.add(milk, 3);

         double expectedValue = milk.getPrice() * 3;

         assertEquals(expectedValue, basket.getOrderValue());
     }
     @Test
     void shouldClearMap(){
         basket.add(milk,1);
        basket.clearBasket();
         Map<Product, Integer > expected = createOrder();
        assertEquals(expected, basket.getOrder());

     }
     @Test
     void shouldComputeManyDifferentProducts(){
         Product bread = new Product("bread", 1.99);
         Product chips = new Product("chips",0.99);
         basket.add(milk,1);
         basket.add(bread,2);
         basket.add(chips,3);

         double expectedValue = milk.getPrice()*1 +bread.getPrice()*2+ chips.getPrice()*3;

         assertEquals(expectedValue,basket.getOrderValue());
     }
     @Test
     void cantAddProductWithNullName(){
         Product chips = new Product(null, 122.22);
         IllegalArgumentException exception = Assertions.assertThrows(
                 IllegalArgumentException.class,
                 ()->basket.add(chips,1)
         );
         assertEquals("Product doesn't have an appropriate name", exception.getMessage());
     }
     @Test
     void cantAddProductWithEmptyName(){
         Product chips = new Product("", 122.22);
         IllegalArgumentException exception = Assertions.assertThrows(
                 IllegalArgumentException.class,
                 ()->basket.add(chips,1)
         );
         assertEquals("Product doesn't have an appropriate name", exception.getMessage());
     }
     @Test
     void shouldntAddNullProduct(){
        Product chips = null;
        NullPointerException exception = Assertions.assertThrows(
                NullPointerException.class,
                ()->basket.add(chips, 1)
        );
        assertEquals("Product cannot be a null", exception.getMessage());
     }










}
