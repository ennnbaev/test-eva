package com.example.demo;

import com.example.demo.dao.Dao;
import com.example.demo.model.Product;
import com.example.demo.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceTest
{
    @Autowired
    Service service;

    @MockBean
    Dao dao;

    @Test 
    void testGetByRegexFromFirstTestDescriptionCorrect()
    {
        Mockito.when(dao.getProductByRegex())
                .thenReturn(List.of(new Product(1, "Enam", "description"),
                        new Product(2, "Ukraine", "description")));
        Assertions
                .assertEquals(List.of(new Product(2, "Ukraine", "description")),
                        service.getProductByRegex("[^E].*$"));
    }

    @Test 
    void testGetByRegexFromFirstTestDescriptionIncorrect()
    {
        Mockito.when(dao.getProductByRegex())
                .thenReturn(List.of(new Product(1, "Enam", "description"),
                        new Product(2, "Ukraine", "description")));
        Assertions.assertNotSame(List.of(new Product(1, "Enam", "description")),
                service.getProductByRegex("[^E].*$"));
    }
    @Test 
    void testGetByRegexSecondTestDescriptionCorrect()
    {
        Mockito.when(dao.getProductByRegex())
                .thenReturn(List.of(new Product(1, "eva-theBest", "description"),
                        new Product(2, "Ukraine", "description")));
        Assertions
                .assertEquals(List.of(new Product(2, "Ukraine", "description")),
                        service.getProductByRegex("[^.*eva].*$"));
    }
    @Test 
    void testGetByRegexSecondTestDescriptionIncorrect()
    {
        Mockito.when(dao.getProductByRegex())
                .thenReturn(List.of(new Product(1, "eva-theBest", "description"),
                        new Product(2, "Ukraine", "description")));
        Assertions.assertNotSame(List.of(new Product(1, "eva-theBest", "description")),
                        service.getProductByRegex("[^.*eva].*$"));
    }
}
