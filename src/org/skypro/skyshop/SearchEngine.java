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
}