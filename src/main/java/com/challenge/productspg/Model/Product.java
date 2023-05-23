package com.challenge.productspg.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "price")
    BigInteger price;
}
