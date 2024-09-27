package edu.sm.cart;

import edu.sm.service.CartService;

public class CartDelete {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int cartId = 5; // 삭제할 장바구니 ID

        try {
            boolean result = cartService.remove(cartId);
            if (result) {
                System.out.println("장바구니가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("장바구니 삭제에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
