package com.grpc.poc.gateway;

import org.springframework.stereotype.Component;

import com.grpc.poc.models.ProductRequestDto;
import com.grpc.poc.models.ProductResponseDto;
import com.grpc.poc.models.ProductServiceGrpc;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Component
public class GrpcGateway {

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub productStub;

    public ProductResponseDto getProducts(ProductRequestDto productRequestDto) {
        return productStub.getProduct(productRequestDto);
    }
}
