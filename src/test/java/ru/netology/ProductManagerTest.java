package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product firstBook = new Book(1, "Core", 1000, "Jub");
    Product secondBook = new Book(2, "Star", 350, "Wars");
    Product thirdBook = new Book(3, "Soft", 500, "Smile");
    Product fourthBook = new Book(4, "Pickle", 1100, "Jacca");
    Product firstSmartphone = new Smartphone(5, "MyPhone", 200, "Lenovo");
    Product secondSmartphone = new Smartphone(6, "E398", 100, "Moto");
    Product thirdSmartphone = new Smartphone(7, "K750i", 500, "Sony");
    Product fourthSmartphone = new Smartphone(8, "iPhone", 300, "Apple");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
        manager.add(fourthSmartphone);
    }

    @Test
    void shouldSearchBookByName() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Wars");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] expected = new Product[]{thirdBook};
        Product[] actual = manager.searchBy("Smile");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("MyPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByGenerator() {
        Product[] expected = new Product[]{thirdSmartphone};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        Product[] expected = new Product[]{firstBook, secondBook, thirdBook, fourthBook, firstSmartphone, secondSmartphone, thirdSmartphone, fourthSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDeleteById( ) {
        repository.removeById(1);
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{thirdBook, fourthBook, firstSmartphone, secondSmartphone, thirdSmartphone, fourthSmartphone};
    }
}