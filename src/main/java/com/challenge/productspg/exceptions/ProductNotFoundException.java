package com.challenge.productspg.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        //We avoid the id of the game for security
        super("Error - Product Not found");
        System.err.println("Error - Product Not found");
    }
}
