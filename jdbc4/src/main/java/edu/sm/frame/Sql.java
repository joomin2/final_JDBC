package edu.sm.frame;

public class Sql {
    //Sql 문만 관리

    public static String insertCust = "INSERT INTO cust VALUES(?,?,?)";
    public static String selectCust = "SELECT * FROM cust";
    public static String selectOneCust = "SELECT * FROM cust WHERE id = ?";
    public static String deleteCust = "DELETE FROM cust WHERE id = ?";
    public static String updateCust = "UPDATE cust SET pwd = ?,name = ? WHERE id = ?";

    public static String insertProduct = "INSERT INTO product VALUES(0,?,?,sysdate())";
    public static String selectProduct = "SELECT * FROM product";
    public static String selectOneProduct = "SELECT * FROM product WHERE id = ?";
    public static String deleteProduct = "DELETE FROM product WHERE id = ?";
    public static String updateProduct = "UPDATE product SET name = ?,price = ?,regdate = sysdate()  WHERE id = ?";
}