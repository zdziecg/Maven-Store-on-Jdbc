package info.zdziech.g.ShopProducts;

public final class Product implements Comparable<Product> {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || ! (otherObject instanceof Product)) {
            return false;
        }

        Product product = (Product) otherObject;

        if (Double.compare(product.price, price) != 0) {
            return false;
        }
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode();
    }

    @Override
    public int compareTo(Product other) {
        if (other == null) {
            return 1;
        }
        int comparision = this.getName().compareTo(other.getName());
        if (comparision != 0) {
            return comparision;
        }
        return Double.compare(this.getPrice(), other.getPrice());
    }

    @Override
    public String toString() {
        return "" +
                 name  +
                ", price " + price +" "
                ;
    }
}

