package com.grpc.poc.server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Product {

    private Long id;
    private String name;
    private String description;
    private ProductType productType;
}
