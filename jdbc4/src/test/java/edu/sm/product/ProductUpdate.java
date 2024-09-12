package edu.sm.product;

import edu.sm.dto.Cust;
import edu.sm.dto.Product;
import edu.sm.service.CustService;
import edu.sm.service.ProductService;

public class ProductUpdate {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product = Product.builder()
                .id(2)
                .name("pwd888")
                .price(20000)
                .build();

        try {
            productService.modify(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

