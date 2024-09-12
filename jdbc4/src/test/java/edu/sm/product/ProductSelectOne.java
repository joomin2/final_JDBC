package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductSelectOne {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        int id = 4;
        Product product = null;
        try {
            product = productService.get(id);
            System.out.println(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
