package com.challenge.productspg.Service.impl;

import com.challenge.productspg.DTO.request.ProductRequest;
import com.challenge.productspg.DTO.response.ProductResponseDTO;
import com.challenge.productspg.Model.Product;
import com.challenge.productspg.Repository.IProductRepository;
import com.challenge.productspg.Service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private final ModelMapper modelMapper;
    private IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(value -> modelMapper.map(value, ProductResponseDTO.class)).orElse(null);
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        products = new ArrayList<>(productRepository.findAll());
        return  products.stream().map(x -> modelMapper.map(x, ProductResponseDTO.class)).toList();
    }

    @Override
    public String createProduct(ProductRequest request) {
        productRepository.save(modelMapper.map(request, Product.class));
        return "Ok";
    }

    @Override
    public String deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (productRepository.findById(id).isEmpty()) {
            return "Product not found";
        } else {
            productRepository.delete(modelMapper.map(product.get(), Product.class));
            return "Product deleted";
        }
    }

    @Override
    public String updateProduct(Long id, ProductRequest request) {
        Optional<Product> newProduct = productRepository.findById(id);
        if(newProduct.isPresent()){
            newProduct.get().setName(request.getName());
            newProduct.get().setPrice(request.getPrice());
            productRepository.save(newProduct.get());
            return "Product updated";
        }else{
            return "Couldn't update product";
        }
    }
}
