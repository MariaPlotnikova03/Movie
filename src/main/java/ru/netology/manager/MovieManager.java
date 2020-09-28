package ru.netology.manager;

import ru.netology.domain.MovieItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieManager {
    //число показываемых фильмов
    private int numberFilms = 10;
    private MovieItem[] items = new MovieItem[0];

    public MovieManager (int numberFilms){
        this.numberFilms = numberFilms;
    }

    public void add(MovieItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }


    public MovieItem[] getItems() {
        int resultSize = items.length;
        if (resultSize > numberFilms){
            resultSize = numberFilms;
        }

        MovieItem[] result = new MovieItem[items.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    // наивная реализация
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
        // меняем наши элементы
        items = tmp;
    }

   }