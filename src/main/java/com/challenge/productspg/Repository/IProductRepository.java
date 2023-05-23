package com.challenge.productspg.Repository;

import com.challenge.productspg.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
