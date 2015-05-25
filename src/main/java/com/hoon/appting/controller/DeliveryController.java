package com.hoon.appting.controller;

import com.hoon.appting.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoon on 2015-04-06.
 */
@Controller
public class DeliveryController {

    @RequestMapping(value = "/products")
    @ResponseBody
    public List<Product> getProducts() {
        System.out.println("==> product 가져오기");
        List<Product> list = new ArrayList<Product>();
        createData(list);
        return list;
    }

    private void createData(List<Product> list) {
        Product product = new Product();
        product.setId("1");
        product.setCategory("카테고리1");
        product.setDescription("설명");
        product.setPrice(1500);
        list.add(product);

        Product product2 = new Product();
        product2.setId("2");
        product2.setCategory("카테고리2");
        product2.setDescription("설명2");
        product2.setPrice(2500);
        list.add(product2);
    }
}
