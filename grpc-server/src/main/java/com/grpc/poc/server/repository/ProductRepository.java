package com.grpc.poc.server.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grpc.poc.server.entity.Product;
import com.grpc.poc.server.entity.ProductType;

@Repository
public class ProductRepository {

    private final Map<ProductType, List<Product>> productsMap;

    public ProductRepository() {
        productsMap = new HashMap<>();
        productsMap.put(
                ProductType.MEDIA,
                Arrays.asList(Product.builder().productType(ProductType.MEDIA).name("Media1").description("Some Media").id(1l).build())
        );
        productsMap.put(
                ProductType.SOFTWARE,
                Arrays.asList(Product.builder().productType(ProductType.SOFTWARE).name("Software1").description("Some Software").id(2l).build())
        );
        productsMap.put(
                ProductType.HARDWARE,
                Arrays.asList(Product.builder().productType(ProductType.HARDWARE).name("Hardware1").description("Some Hardware").id(3l).build())
        );
    }

    public List<Product> getProduct(ProductType productType) {
        return productsMap.get(productType);
    }
}
