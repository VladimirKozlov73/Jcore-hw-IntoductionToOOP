package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        // Добавление продукта в корзину
        Product phone = new Product("Телефон", 10000);
        basket.add(phone);

        // Добавление продуктов в корзину, добавление продукта в заполненную корзину
        for (int i = 0; i < 4; i++) {
            basket.add(new Product("Товар" + i, 1000));
        }
        basket.add(new Product("Ещё товар", 500));  // Вывод: "Невозможно добавить продукт"

        // Печать содержимого корзины
        basket.print();

        // Получение стоимости корзины
        System.out.println("Стоимость: " + basket.getTotalPrice());

        // Поиск существующего продукта в корзине
        System.out.println("Есть телефон: " + basket.contains("Телефон"));

        // Поиск несуществующего продукта в корзине
        System.out.println("Есть несуществующий: " + basket.contains("Нет"));

        // Очистка корзины
        basket.clear();

        // Печать пустой корзины
        basket.print();

        // Стоимость пустой корзины
        System.out.println("Стоимость пустой: " + basket.getTotalPrice());

        // Поиск в пустой корзине
        System.out.println("Поиск в пустой: " + basket.contains("Телефон"));
    }
}