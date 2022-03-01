package com.grpc.poc.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grpc.poc.models.ProductRequestDto;
import com.grpc.poc.models.ProductResponseDto;
import com.grpc.poc.models.ProductServiceGrpc;
import com.grpc.poc.server.entity.Product;
import com.grpc.poc.server.repository.ProductRepository;
import com.grpc.poc.util.mapper.ProductMapper;
import com.grpc.poc.util.mapper.ProductTypeMapper;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void getProduct(ProductRequestDto request, StreamObserver<ProductResponseDto> responseObserver) {
        List<Product> products = productRepository.getProduct(ProductTypeMapper.getProductType(request.getProductTypeValue()));

        ProductResponseDto.Builder productResponseBuilder = ProductResponseDto.newBuilder();
        for (Product product : products) {
            productResponseBuilder.addProduct(ProductMapper.getProductDto(product));
        }

        responseObserver.onNext(productResponseBuilder.build());
        responseObserver.onCompleted();
    }
}