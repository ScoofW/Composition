package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "The Man in the High Castle", 39, "Philip K. Dick");
    Book book2 = new Book(2, "Not Dead Yet", 35, "Phil Collins");
    Smartphone smartphone1 = new Smartphone(3, "9R", 13, "OnePlus");
    Smartphone smartphone2 = new Smartphone(4, "Iphone 13 Pro", 16, "Apple");

    @Test
    public void shouldRemoveByID(){

        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = {book2,smartphone1,smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByID2(){
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });
    }
}