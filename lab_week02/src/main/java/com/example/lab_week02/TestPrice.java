package com.example.lab_week02;

import models.ProductPrice;
import repositories.ProductPriceRespository;

public class TestPrice {
    public static void main(String[] args) {
        ProductPriceRespository productPriceRespository = new ProductPriceRespository();
        double price = productPriceRespository.getPriceOfProduct(1).get();
        System.out.println(price);
    }
}
