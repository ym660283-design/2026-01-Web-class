package kr.hnu.ice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService {
    private HashMap<String, Product> products;

    public ProductService() {
        products = new HashMap<String, Product>();

        Product product1 = new Product("p101", "Galaxy S26", "Samsung", 1590000, "AI camera and high-performance Android phone");
        Product product2 = new Product("p102", "iPhone 18", "Apple", 1690000, "iOS smartphone with premium display and camera");
        Product product3 = new Product("p103", "Pixel 11", "Google", 1290000, "Android phone focused on Google AI features");
        Product product4 = new Product("p104", "Xperia 1 VIII", "Sony", 1490000, "Creator-focused smartphone with advanced media features");
        Product product5 = new Product("p105", "Xiaomi 16 Pro", "Xiaomi", 1090000, "High-spec smartphone with fast charging");

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
        products.put(product4.getId(), product4);
        products.put(product5.getId(), product5);
    }

    public List<Product> findAll() {
        return new ArrayList<Product>(products.values());
    }

    public Product find(String id) {
        return products.get(id);
    }
}
