package com.ecomm.app.service;

import com.ecomm.app.dto.ProductRequest;
import com.ecomm.app.dto.ProductResponse;
import com.ecomm.app.entity.Product;
import com.ecomm.app.mapper.TestMapper;
import com.ecomm.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final TestMapper testMapper;

  public ProductResponse createProduct(ProductRequest productRequest) {
    Product product = productRepository.save(testMapper.productDTOTOProduct(productRequest));
    return testMapper.productToProductResponse(product);
  }

  public Optional<ProductResponse> updateProduct(Long id, ProductRequest productRequest) {
    return productRepository
        .findById(id)
        .map(
            response -> {
              Product request =  testMapper.productDTOTOProduct(productRequest);
              request.setId(response.getId());
              Product product =
                  productRepository.save(request);
              return testMapper.productToProductResponse(product);
            });
  }
}
