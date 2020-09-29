package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class AfishaRepository {


    private MovieItem[] items = new MovieItem[0];

    public void save(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] findAll() {
        return items;
    }

    public MovieItem findById(int id) {
        for (MovieItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeAll() {
        items = new MovieItem[]{};
    }

    public void removeById(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public MovieItem[] getAll() {
        MovieItem[] item = findAll();
        MovieItem[] result = new MovieItem[item.length];
        for (int i = 0; i < result.length; i++) {
            int index = item.length - i - 1;
            result[i] = item[index];
        }
        return result;
    }

}