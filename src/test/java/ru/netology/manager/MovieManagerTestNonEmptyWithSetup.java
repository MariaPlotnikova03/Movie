package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTestNonEmptyWithSetup {

    private MovieManager manager = new MovieManager();

    private MovieItem first = new MovieItem(1, 1, "first", "link1", "cartoon");
    private MovieItem second = new MovieItem(2, 2, "second", "link2", "drama");
    private MovieItem third = new MovieItem(3, 3, "third", "link3", "horror");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getItems();
        MovieItem[] expected = new MovieItem[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

        @Test
    public void shouldGetFilms() {

        MovieManager manager = new MovieManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getItems();
        MovieItem[] expected = new MovieItem[]{third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGetFilmsIfOne() {

        MovieManager manager = new MovieManager(1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getItems();
        MovieItem[] expected = new MovieItem[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetNonFilms() {

        MovieManager manager = new MovieManager(0);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getItems();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);
    }

}