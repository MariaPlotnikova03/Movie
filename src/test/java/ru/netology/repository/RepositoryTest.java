package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest {

    private AfishaRepository repository = new AfishaRepository();

    private MovieItem first = new MovieItem(1, 1, "first", "link1", "cartoon");
    private MovieItem second = new MovieItem(2, 2, "second", "link2", "drama");
    private MovieItem third = new MovieItem(3, 3, "third", "link3", "horror");


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        MovieItem[] actual = repository.getAll();
        MovieItem[] expected = new MovieItem[]{third, second};
        assertArrayEquals(expected, actual);
    }
//
//    @Test
//    public void shouldNotRemoveIfNotExists() {
//        int idToRemove = 4;
//        repository.removeById(idToRemove);
//        Film[] actual = repository.getAll();
//        Film[] expected = new Film[]{third, second, first};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveAll() {

        repository.removeAll();
        MovieItem[] actual = repository.getAll();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindById() {
        int idToFind = 3;

        MovieItem expected = third;
        MovieItem actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNonExists() {
        int idToFind = 4;

        MovieItem expected = null;
        MovieItem actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

}
