package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void add(Product product) {
        products.computeIfAbsent(product.getName(), key -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        int total = getTotalPrice();
        int specialCount = 0;

        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            System.out.println("Итого: 0");
            System.out.println("Специальных товаров: 0");
            return;
        }

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean contains(String name) {
        return products.containsKey(name);
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = products.remove(name);
            if (removedProducts == null) {
                return new ArrayList<>();
            }
        return removedProducts;
    }
}