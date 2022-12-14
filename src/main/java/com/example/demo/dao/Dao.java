package com.example.demo.dao;

import com.example.demo.config.ConnectionFactory;
import com.example.demo.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component public class Dao
{
    private static final String SQL_SELECT_PRODUCT = "SELECT * FROM products";

    @Cacheable("products")
    public List<Product> getProductByRegex()
    {

        List<Product> productList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection
                .prepareStatement(SQL_SELECT_PRODUCT))
        {
            ResultSet resultOfProducts = statement.executeQuery();
            while(resultOfProducts.next())
            {
                int resultId = resultOfProducts.getInt(1);
                String name = resultOfProducts.getString(2);
                String description = resultOfProducts.getString(3);
                productList.add(new Product(resultId, name, description));
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        return productList;
    }
}
