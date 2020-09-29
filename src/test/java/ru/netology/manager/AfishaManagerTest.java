package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager afishaManager;

    private MovieItem first = new MovieItem(1, 1, "first", "link1", "cartoon");
    private MovieItem second = new MovieItem(2, 2, "second", "link2", "drama");
    private MovieItem third = new MovieItem(3, 3, "third", "link3", "horror");


    @BeforeEach
    public void setUp() {
        afishaManager.add(first);
        afishaManager.add(second);
        afishaManager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        // настройка заглушки
        MovieItem[] returned = new MovieItem[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        afishaManager.removeById(idToRemove);
        MovieItem[] expected = new MovieItem[]{third, second};
        MovieItem[] actual = afishaManager.getAll();
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        MovieItem[] returned = new MovieItem[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        afishaManager.removeById(idToRemove);
        MovieItem[] expected = new MovieItem[]{third, second, first};
        MovieItem[] actual = afishaManager.getAll();

        assertArrayEquals(expected, actual);
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldRemoveAll() {

        afishaManager.removeAll();
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeAll();
    }

    @Test
    public void shouldFindById() {
        int idToFind = 3;
        // настройка заглушки
        doReturn(third).when(repository).findById(idToFind);

        MovieItem expected = third;
        MovieItem actual = afishaManager.findById(idToFind);
        assertEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).findById(idToFind);
    }

}