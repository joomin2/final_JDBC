package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;


public class ProductDelete {
    public static void main(String[] args) {
        ProductService custService = new ProductService();
        int id = 6;

        try {
            custService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}








