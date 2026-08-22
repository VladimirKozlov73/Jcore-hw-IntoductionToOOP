package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void add(Product product) {
        products.computeIfAbsent(product.getName(), key -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            System.out.println("Итого: 0");
            System.out.println("Специальных товаров: 0");
            return;
        }

        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
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