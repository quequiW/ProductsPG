package com.challenge.productspg.Service;

import com.challenge.productspg.DTO.request.ProductRequest;
import com.challenge.productspg.DTO.response.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    ProductResponseDTO getProductById(Long id);
    List<ProductResponseDTO> findAll();
    String createProduct(ProductRequest request);
    String deleteProduct(Long id);
    String updateProduct(Long id, ProductRequest request);

}
