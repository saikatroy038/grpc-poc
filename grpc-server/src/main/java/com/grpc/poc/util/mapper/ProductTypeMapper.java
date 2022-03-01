package com.grpc.poc.util.mapper;

import com.grpc.poc.server.entity.ProductType;

public class ProductTypeMapper {

    public static ProductType getProductType(int val) {
        switch (val) {
        case 0:
            return ProductType.SOFTWARE;
        case 1:
            return ProductType.HARDWARE;
        case 2:
            return ProductType.MEDIA;
        default:
            throw new IllegalArgumentException();
        }
    }
}
