package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new LinkedList<>();

    public void add(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
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

        for (Product p : products) {
            System.out.println(p.toString());
                if (p.isSpecial()) {
                    specialCount++;
                }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean contains(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}