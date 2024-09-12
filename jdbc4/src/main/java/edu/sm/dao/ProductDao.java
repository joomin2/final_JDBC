package edu.sm.dao;

import edu.sm.dto.Cust;
import edu.sm.dto.Product;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Integer,Product> {

    @Override
    public Product insert(Product product, Connection con) throws Exception {
        PreparedStatement ps = null;
        ps = con.prepareStatement(Sql.insertProduct);

        ps.setString(1, product.getName());
        ps.setInt(2, product.getPrice());
        ps.executeUpdate();//여기서 Exception 나면 던지고 말아서 아래 close가 안됨.
        ps.close();

        return product;
    }

    @Override
    public Product update(Product product, Connection con) throws Exception {
        PreparedStatement ps = null;
        ps = con.prepareStatement(Sql.updateProduct);
        ps.setString(1, product.getName());
        ps.setInt(2, product.getPrice());
        ps.setInt(3, product.getId());
        ps.executeUpdate();
        ps.close();
        return product;
    }

    @Override
    public Boolean delete(Integer s, Connection con) throws Exception {
        PreparedStatement ps = null;
        Boolean b = false;
        ps = con.prepareStatement(Sql.deleteProduct);
        ps.setInt(1, s);
        int result = ps.executeUpdate();

        if (result == 1) {
            b = true;
        }
        return b;
    }

    @Override
    public Product select(Integer s, Connection con) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = null;
        ps = con.prepareStatement(Sql.selectOneProduct);
        ps.setInt(1, s);
        rs = ps.executeQuery();
        rs.next();
        product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        product.setRegdate(rs.getDate("regdate").toLocalDate());
        return product;
    }

    @Override
    public List<Product> select(Connection con) throws Exception {
        List<Product> products = new ArrayList<Product>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(Sql.selectProduct);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setRegdate(rs.getDate("regdate").toLocalDate());
                products.add(product);
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
        return products;
    }
}










