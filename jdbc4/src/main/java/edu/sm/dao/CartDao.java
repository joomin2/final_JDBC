package edu.sm.dao;

import edu.sm.dto.Cart;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class CartDao implements Dao<Integer, Cart> {

    @Override
    public Cart insert(Cart cart, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.insertCart);
            ps.setInt(1, cart.getMemberId());
            ps.setInt(2, cart.getItemId());
            ps.setInt(3, cart.getQuantity());
            ps.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException e) {
            throw new DuplicatedIdException("EX0001");
        } catch(Exception e) {
            throw e;
        } finally {
            if(ps != null){
                ps.close();
            }
        }
        return cart;
    }

    @Override
    public Cart update(Cart cart, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.updateCart);
            ps.setInt(1, cart.getMemberId());
            ps.setInt(2, cart.getItemId());
            ps.setInt(3, cart.getQuantity());
            ps.setInt(4, cart.getCartId());  // update할 때 cart_id로 식별
            ps.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if(ps != null){
                ps.close();
            }
        }
        return cart;
    }

    @Override
    public Boolean delete(Integer cartId, Connection con) throws Exception {
        Boolean isDeleted = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.deleteCart);
            ps.setInt(1, cartId);
            int result = ps.executeUpdate();
            if(result == 1){
                isDeleted = true;
            }
        } catch(Exception e) {
            throw e;
        } finally {
            if(ps != null){
                ps.close();
            }
        }
        return isDeleted;
    }

    public List<Cart> selectByMemberId(int memberId, Connection con) throws Exception {
        List<Cart> carts = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(Sql.selectCartByMemberId); // 적절한 JOIN 쿼리 사용
            ps.setInt(1, memberId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cart_id"));
                cart.setMemberId(rs.getInt("member_id"));
                cart.setItemId(rs.getInt("item_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setItemName(rs.getString("item_name")); // Item 테이블의 정보
                cart.setItemPrice(rs.getDouble("item_price")); // Item 테이블의 정보
                carts.add(cart);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return carts;
    }

    @Override
    public Cart select(Integer cartId, Connection con) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cart cart = null;
        try {
            ps = con.prepareStatement(Sql.selectOneCart);
            ps.setInt(1, cartId);
            rs = ps.executeQuery();
            if(rs.next()) {
                cart = new Cart();
                cart.setCartId(rs.getInt("cart_id"));
                cart.setMemberId(rs.getInt("member_id"));
                cart.setItemId(rs.getInt("item_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setItemName(rs.getString("item_name"));          // Item 테이블의 정보
                cart.setItemPrice(rs.getDouble("item_price"));         // Item 테이블의 정보
                // 필요한 경우 추가적인 필드 설정
            }
        } catch(Exception e) {
            throw e;
        } finally {
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return cart;
    }

    @Override
    public List<Cart> select(Connection con) throws Exception {
        List<Cart> carts = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(Sql.selectCartWithItemDetails); // JOIN 쿼리 사용
            rs = ps.executeQuery();
            while(rs.next()) {
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cart_id"));
                cart.setMemberId(rs.getInt("member_id"));
                cart.setItemId(rs.getInt("item_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setItemName(rs.getString("item_name"));          // Item 테이블의 정보
                cart.setItemPrice(rs.getDouble("item_price"));         // Item 테이블의 정보
                // 필요한 경우 추가적인 필드 설정
                carts.add(cart);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return carts;
    }
}
