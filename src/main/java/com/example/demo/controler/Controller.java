package com.example.demo.controler;

import com.example.demo.model.Product;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shop")
public class Controller
{

    private final Service service;

    @Autowired
    public Controller(Service service)
    {
        this.service = service;
    }

    @GetMapping("product")
    public List<Product> getProductByRegex(@RequestParam String nameFilter)
    {
        return service.getProductByRegex(nameFilter);
    }

}
