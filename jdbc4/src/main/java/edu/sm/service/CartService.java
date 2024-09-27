package edu.sm.service;

import edu.sm.dao.CartDao;
import edu.sm.dto.Cart;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.Dao;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartService implements MService<Integer, Cart> {

    private CartDao dao;
    private ConnectionPool cp;

    public CartService() {
        dao = new CartDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Cart> getByMemberId(int memberId) throws Exception {
        Connection con = cp.getConnection();
        List<Cart> result = null;
        try {
            result = dao.selectByMemberId(memberId, con); // CartDao에서 해당 메서드를 호출
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }
    @Override
    public Cart add(Cart cart) throws Exception {
        Connection con = cp.getConnection();
        try {
            con.setAutoCommit(false);
            dao.insert(cart, con);
            // 추가적인 로직이 필요하면 여기서 처리
            System.out.println("Cart added with itemId: " + cart.getItemId());
            con.commit();
        } catch(Exception e) {
            con.rollback();
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return cart;
    }

    @Override
    public Cart modify(Cart cart) throws Exception {
        Connection con = cp.getConnection();
        try {
            dao.update(cart, con);
            // 추가적인 로직이 필요하면 여기서 처리
            System.out.println("Cart updated with itemId: " + cart.getItemId());
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return cart;
    }



    @Override
    public Boolean remove(Integer cartId) throws Exception {
        Connection con = cp.getConnection();
        Boolean result = false;
        try {
            result = dao.delete(cartId, con);
            // 추가적인 로직이 필요하면 여기서 처리
            System.out.println("Cart removed with id: " + cartId);
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    @Override
    public Cart get(Integer cartId) throws Exception {
        Connection con = cp.getConnection();
        Cart result = null;
        try {
            result = dao.select(cartId, con);
            // 추가적인 로직이 필요하면 여기서 처리
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    @Override
    public List<Cart> get() throws Exception {
        Connection con = cp.getConnection();
        List<Cart> result = null;
        try {
            result = dao.select(con);
            // 추가적인 로직이 필요하면 여기서 처리
        } catch(Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }
}
