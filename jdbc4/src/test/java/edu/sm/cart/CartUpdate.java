package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartUpdate {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        Cart cart = Cart.builder()
                .cartId(4)         // 업데이트할 장바구니 ID
                .memberId(1)       // 실제 회원 ID로 대체
                .itemId(2)         // 실제 아이템 ID로 대체
                .quantity(99)      // 새로운 수량 설정
                .build();

        try {
            cartService.modify(cart);
            System.out.println("장바구니가 성공적으로 업데이트되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
