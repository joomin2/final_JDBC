package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

import java.util.List;

public class CartSelectUser {
    public static void main(String[] args) {
        CartService cartService = new CartService(); // CartService 인스턴스 생성

        // 특정 memberId를 지정합니다. 예를 들어 1번 회원의 카트 정보를 조회합니다.
        int memberId = 2; // 이 값을 필요에 따라 변경하세요.

        try {
            // memberId에 해당하는 카트 정보를 조회합니다.
            List<Cart> carts = cartService.getByMemberId(memberId);

            // 조회된 카트 정보를 출력합니다.
            if (carts != null && !carts.isEmpty()) {
                for (Cart cart : carts) {
                    System.out.println(cart);
                }
            } else {
                System.out.println("해당 회원의 카트 정보가 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
