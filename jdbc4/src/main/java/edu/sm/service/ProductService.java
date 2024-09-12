package edu.sm.service;

import edu.sm.dao.CustDao;
import edu.sm.dao.ProductDao;
import edu.sm.dto.Cust;
import edu.sm.dto.Product;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductService implements MService<Integer, Product> {

    ProductDao productDao;
    ConnectionPool cp;

    public ProductService() {
        productDao = new ProductDao();
        try {
            cp = ConnectionPool.create();//connection pool을 이용한 connection도 준비 완료.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Product add(Product product) throws Exception {
        Connection con = cp.getConnection();

        con.setAutoCommit(false);
        productDao.insert(product, con);// 예외 EX0001이 여기로 날라옴.

        con.commit();//두개가 정상이면 commit을 한다.
        System.out.println("Send SMS to:" + product.getId());


        return product;
    }

    @Override
    public Product modify(Product product) throws Exception {//update
        Connection con = cp.getConnection();
        productDao.update(product, con);
        System.out.println("Send SMS to:" + product.getId());

        return product;
    }

    @Override
    public Boolean remove(Integer s) throws Exception {
        Connection con = cp.getConnection();
        Boolean b = false;
        b = productDao.delete(s, con);
        System.out.println("Send SMS to:" + s);


        return null;
    }

    @Override
    public Product get(Integer s) throws Exception {
        Connection con = cp.getConnection();
        Product p = null;
        p = productDao.select(s,con);
        System.out.println("Send SMS to:" + s);
        return p;
    }

    @Override
    public List<Product> get() throws Exception {
        Connection con = cp.getConnection();
        List<Product> p = null;
        p = productDao.select(con);
        //System.out.println("Send SMS to:" + p);
        return p;
    }
}