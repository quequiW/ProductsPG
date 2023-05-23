package com.challenge.productspg.Controller;

import com.challenge.productspg.DTO.request.ProductRequest;
import com.challenge.productspg.DTO.response.ProductResponseDTO;
import com.challenge.productspg.Service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productx")
@Validated
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        List<ProductResponseDTO> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    //PLEASE READ: README.md
    @PostMapping()
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequest request) {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<String>(productService.deleteProduct(id), HttpStatus.OK);
    }

    //PLEASE READ: README.md
    //write "/api/v1/games/count GET" API
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        //complete the missing code
        return new ResponseEntity<>(productService.updateProduct(id, request), HttpStatus.CREATED);
    }
}
