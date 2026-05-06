package kr.hnu.ice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private Map<String, Product> products;

    public ProductService() {
        products = new HashMap<String, Product>();

        Product product1 = new Product("p101", "Galaxy S26", "Samsung", 1590000, "2026-03-15");
        Product product2 = new Product("p102", "iPhone 18", "Apple", 1690000, "2026-09-20");
        Product product3 = new Product("p103", "Pixel 11", "Google", 1290000, "2026-10-10");
        Product product4 = new Product("p104", "Xperia 1 VIII", "Sony", 1490000, "2026-05-30");
        Product product5 = new Product("p105", "Xiaomi 16 Pro", "Xiaomi", 1090000, "2026-04-12");

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
