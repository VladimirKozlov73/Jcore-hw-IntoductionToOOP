package org.skypro.skyshop;

import org.skypro.skyshop.product.Searchable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items;

    public SearchEngine(int size) {
        this.items = new LinkedList<>();
    }

    public void add(Searchable item) {
            items.add(item);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();

        for (Searchable item : items) {
            if (item.getSearchTerm().contains(query)) {
                results.add(item);
            }
        }

        return results;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {

        if (search == null || search.trim().isEmpty()){
            throw new IllegalArgumentException("Строка поиска не может быть пустой или null");
        }

        Searchable bestResult = null;
        int maxCount = 0;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm(), search);
            if (count > maxCount) {
                maxCount = count;
                bestResult = item;
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }

        return bestResult;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int indexSubstring = str.indexOf(substring, index);

        while (indexSubstring != -1) {
            count++;
            index = indexSubstring + substring.length();
            indexSubstring = str.indexOf(substring, index);
        }

        return count;
    }
}