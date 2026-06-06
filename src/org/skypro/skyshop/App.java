package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

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
        System.out.println(separator);

        // тест поиска
        System.out.println("\nтест поиска\n");

        SearchEngine searchEngine = new SearchEngine(10);

        // товары
        Product product1 = new SimpleProduct("Телефон", 10000);
        Product product2 = new SimpleProduct("Часы", 5000);
        Product product3 = new DiscountedProduct("Наушники", 3000, 20);
        Product product4 = new FixPriceProduct("Флэшка");

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);

        // статьи
        Article article1 = new Article("Как выбрать телефон", "Советы по выбору смартфона в 2026 году");
        Article article2 = new Article("Наушники и здоровье", "Влияние наушников на слух");
        Article article3 = new Article("Флэшки сегодня", "Какие флэшки покупать сейчас");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println("Поиск по 'телефон':");
        System.out.println(Arrays.toString(searchEngine.search("телефон")));
        System.out.println(separator);

        System.out.println("Поиск по 'науш':");
        System.out.println(Arrays.toString(searchEngine.search("науш")));
        System.out.println(separator);

        System.out.println("Поиск по 'здоровье':");
        System.out.println(Arrays.toString(searchEngine.search("здоровье")));
        System.out.println(separator);

        System.out.println("Поиск по 'флэ':");
        System.out.println(Arrays.toString(searchEngine.search("флэ")));
        System.out.println(separator);

        System.out.println("Поиск по 'Часы':");
        System.out.println(Arrays.toString(searchEngine.search("Часы")));
    }
}