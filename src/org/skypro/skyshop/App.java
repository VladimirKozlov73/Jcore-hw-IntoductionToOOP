package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        String separator = "-".repeat(11);

        ProductBasket basket = new ProductBasket();

        // Обычный товар
        Product phone = new SimpleProduct("Телефон", 10000);
        basket.add(phone);

        // Несколько обычных товаров
        for (int i = 0; i < 4; i++) {
            basket.add(new SimpleProduct("Товар" + i, 1000));
        }
        basket.add(new SimpleProduct("Ещё товар", 500));
        basket.print();
        System.out.println(separator);

        // Товары со скидкой
        basket.clear();
        basket.add(new SimpleProduct("Часы", 5000));
        basket.add(new DiscountedProduct("Наушники", 3000, 20));
        basket.add(new FixPriceProduct("Флэшка"));

        basket.print();

        System.out.println("Стоимость: " + basket.getTotalPrice());
        System.out.println(separator);

        System.out.println("Есть часы: " + basket.contains("Часы"));
        System.out.println("Есть несуществующий: " + basket.contains("Нет"));
        System.out.println(separator);

        basket.clear();
        basket.print();
        System.out.println(separator);

        System.out.println("Стоимость пустой: " + basket.getTotalPrice());
        System.out.println("Поиск в пустой: " + basket.contains("Телефон"));
    }
}