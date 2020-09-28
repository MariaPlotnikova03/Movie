package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTestNonEmptyWithSetup {

  private MovieManager manager = new MovieManager();

  private MovieItem first = new MovieItem(1, 1, "first", "1", "comedy");
  private MovieItem second = new MovieItem(2, 2, "second", "2", "drama");
  private MovieItem third = new MovieItem(3, 3, "third", "3", "horror");

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

//  @Test
//  public void shouldNotRemoveIfNotExists() {
//    int idToRemove = 4;
//
//    manager.removeById(idToRemove);
//
//    MovieItem[] actual = manager.getItems();
//    MovieItem[] expected = new MovieItem[]{third, second, first};
//
//    assertArrayEquals(expected, actual);
//  }


}