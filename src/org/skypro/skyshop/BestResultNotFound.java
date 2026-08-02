package org.skypro.skyshop;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Не найдено наиболее подходящего результата для поискового запроса: " + search);
    }
}