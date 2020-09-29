package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    private int numberFilms = 10;
    private MovieItem[] items = new MovieItem[0];

    public AfishaManager(int numberFilms) {
        this.numberFilms = numberFilms;
    }

    public void add(MovieItem item) {
        repository.save(item);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public MovieItem[] getAll() {
        MovieItem[] items = repository.findAll();
        MovieItem[] result = new MovieItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public MovieItem findById(int id) {
        return repository.findById(id);
    }

}