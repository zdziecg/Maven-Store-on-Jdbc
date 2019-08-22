package info.zdziech.g.ShopProducts;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

    public class Basket {
        private static final String PRODUCT_ORDER_FORMAT = "%s (%.2f x %d = %.2f)";

        private final Map<Product, Integer> order = new LinkedHashMap<>();

        public void add(Product product) {
            add(product, 1);
        }

        public void add(Product product, int quantity) {
            if (product.getName() == null) {
                throw new IllegalArgumentException("Product is not exist");
            }

            if (quantity <= 0) {
                throw new IllegalArgumentException(String.format("Illegal quantity %d!", quantity));
            }
            if (order.containsKey(product)) {
                quantity = order.get(product) + quantity;
            }
                order.put(product, quantity);

        }

        public void remove(Product product) {
            remove(product, 1);
        }

        public void remove(Product product, int quantity) {

            if (order.containsKey(product)) {

                if (quantity <= 0) {
                    throw new IllegalArgumentException(String.format("Illegal quantity %d!", quantity));
                }
                quantity = order.get(product) - quantity;
                if (quantity == 0) {
                    order.remove(product);
                } else if (quantity < 0) {
                    throw new IllegalStateException("There is no that many products to remove");
                } else {
                    order.put(product, quantity);
                }
            }

              else{
                    throw new NullPointerException("Product is not in the basket");
                }

        }
        public void clearBasket(){
            order.clear();
        }

        public double getOrderValue() {
            double orderValue = 0;

            for(Map.Entry<Product, Integer> productOrder : order.entrySet()) {
                orderValue += productOrder.getKey().getPrice() * productOrder.getValue();
            }

            return orderValue;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();

            for(Map.Entry<Product, Integer> productOrder : order.entrySet()) {
                Product product = productOrder.getKey();
                Integer quantity = productOrder.getValue();
                String productString = String.format(
                        PRODUCT_ORDER_FORMAT,
                        product.getName(),
                        product.getPrice(),
                        quantity,
                        product.getPrice() * quantity
                );
                result.append(productString);
                result.append(System.lineSeparator());
            }
            result.append(String.format("Total: %.2f", getOrderValue()));

            return result.toString();
        }

        public Map<Product, Integer> getOrder() {
            return Collections.unmodifiableMap(order);
        }

    }

