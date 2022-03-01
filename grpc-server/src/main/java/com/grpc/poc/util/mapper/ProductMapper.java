package com.grpc.poc.util.mapper;

import com.grpc.poc.models.Product;
import com.grpc.poc.models.ProductType;

public class ProductMapper {

    public static Product getProductDto(com.grpc.poc.server.entity.Product product) {
        return Product.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setProductType(ProductType.forNumber(product.getProductType().ordinal()))
                .build();
    }
}
