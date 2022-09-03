package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "The Man in the High Castle", 39, "Philip K. Dick");
    Book book2 = new Book(2, "Not Dead Yet", 35, "Phil Collins");
    Smartphone smartphone1 = new Smartphone(3, "9r", 13, "OnePlus");
    Smartphone smartphone2 = new Smartphone(4, "Iphone 13 Pro", 16, "Apple");

    @Test
    public void shouldFindQuery() {
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("r");
        Product[] expected = {smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProduct() {
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQuery2() {
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);

        Product[] actual = manager.searchBy("Man");
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQuery3() {
        ProductManager manager = new ProductManager(repository);

        Product[] actual = manager.searchBy("9");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQuery4() {
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);


        Product[] actual = manager.searchBy("phone");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}