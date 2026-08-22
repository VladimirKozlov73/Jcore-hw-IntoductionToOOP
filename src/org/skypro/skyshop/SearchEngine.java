package org.skypro.skyshop;

import org.skypro.skyshop.product.Searchable;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items;

    public SearchEngine(int size) {
        this.items = new HashSet<>(size);
    }

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String query) {
        return items.stream()
                .filter(item -> item.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparingInt((Searchable s) -> s.getName().length())
                                .reversed()
                                .thenComparing(Searchable::getName)
                )));
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