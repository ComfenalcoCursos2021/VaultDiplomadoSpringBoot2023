package com.diplomado.ventas.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class ProductosHystrixFallBackFactory implements FallbackFactory<ProductosHystrixFallBack>{
	@Override
    public ProductosHystrixFallBack create(Throwable cause) {
        return new ProductosHystrixFallBack();
    }

}
