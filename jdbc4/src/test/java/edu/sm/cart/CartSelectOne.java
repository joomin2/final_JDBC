package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartSelectOne {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int cartId = 2; // 조회할 장바구니 ID
        Cart cart = null;
        try {
            cart = cartService.get(cartId);
            System.out.println(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
