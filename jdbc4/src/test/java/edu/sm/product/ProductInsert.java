package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.service.ProductService;


public class ProductInsert {
    public static void main(String[] args) {
        ProductService proService = new ProductService();
        Product product = Product.builder()
                .id(77)
                .name("박주민 모자")
                .price(11111)
                .build();
        try {
            proService.add(product);
        } catch(DuplicatedIdException e){
            System.out.println("ID가 중복 되어 입력이 안됩니다.");
        } catch (Exception e) {
            System.out.println("시스템 장애");
        }

    }
}


