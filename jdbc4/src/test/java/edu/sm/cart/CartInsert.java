package edu.sm.cart;

import edu.sm.dto.Cart;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.service.CartService;

public class CartInsert {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        Cart cart = Cart.builder()
                .cartId(0)         // cart_id는 DB에서 자동 생성되므로 0 또는 임의 값
                .memberId(2)       // 실제 회원 ID로 대체
                .itemId(3)         // 실제 아이템 ID로 대체
                .quantity(2)       // 원하는 수량 설정
                .build();

        try {
            cartService.add(cart);
            System.out.println("장바구니에 아이템이 성공적으로 추가되었습니다.");
        } catch(DuplicatedIdException e){
            System.out.println("중복된 장바구니 ID가 존재합니다. 입력이 안됩니다.");
        } catch (Exception e) {
            System.out.println("시스템 장애");
        }
    }
}
