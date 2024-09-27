package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

import java.util.List;

public class CartSelect {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        List<Cart> carts = null;
        try {
            carts = cartService.get();
            System.out.println(carts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
