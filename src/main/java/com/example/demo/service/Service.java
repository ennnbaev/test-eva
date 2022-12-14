package com.example.demo.service;

import com.example.demo.dao.Dao;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service
{

    private final Dao dao;

    @Autowired
    public Service(Dao dao)
    {
        this.dao = dao;
    }

    public List<Product> getProductByRegex(String nameFilter)
    {
        return dao.getProductByRegex().parallelStream().filter(x -> x.getName().matches(nameFilter))
                .toList();
    }
}
