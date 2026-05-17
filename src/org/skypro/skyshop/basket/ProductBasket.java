package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];

    public void add(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product p : products) {
            if (p != null) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void print() {
        int total = getTotalPrice();  // Вычисляем один раз для эффективности
        if (total == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        for (Product p : products) {
            if (p != null) {
                System.out.println(p.getName() + ": " + p.getPrice());
            }
        }
        System.out.println("Итого: " + total);
    }

    public boolean contains(String name) {
        for (Product p : products) {
            if (p != null && p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}