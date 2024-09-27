package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    private int cartId;      // cart_id
    private int memberId;    // member_id
    private int itemId;      // item_id
    private int quantity;    // quantity
    private String itemName; // item name from Item table
    private double itemPrice; // item price from Item table
}
