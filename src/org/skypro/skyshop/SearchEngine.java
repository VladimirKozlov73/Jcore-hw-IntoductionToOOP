package org.skypro.skyshop;

import org.skypro.skyshop.product.Searchable;
import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] items;
    private int count = 0;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < items.length) {
            items[count] = item;
            count++;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;

        for (int i = 0; i < count && found < 5; i++) {
            Searchable item = items[i];
            if (item != null && item.getSearchTerm().contains(query)) {
                results[found] = item;
                found++;
            }
        }

        return results;
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            Searchable item = items[i];
            if (item != null) {
                String searchTerm = item.getSearchTerm();
                int count = countOccurrences(searchTerm, search);

                if (count > maxCount) {
                    maxCount = count;
                    bestResult = item;
                }
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