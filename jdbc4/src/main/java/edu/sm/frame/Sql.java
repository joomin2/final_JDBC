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

    public static String insertCart = "INSERT INTO cart (member_id, item_id, quantity) VALUES (?, ?, ?)";
    public static String selectOneCart =
            "SELECT c.cart_id, c.member_id, c.item_id, c.quantity, " +
                    "i.name AS item_name, i.price AS item_price " +
                    "FROM cart c " +
                    "JOIN item i ON c.item_id = i.item_id " +
                    "WHERE c.cart_id = ?";
    public static String selectCartWithItemDetails =
            "SELECT c.cart_id, c.member_id, c.item_id, c.quantity, " +
                    "i.name AS item_name, i.price AS item_price " +
                    "FROM cart c " +
                    "JOIN item i ON c.item_id = i.item_id";
    public static String deleteCart = "DELETE FROM cart WHERE cart_id = ?";
    public static String updateCart = "UPDATE cart SET member_id = ?, item_id = ?, quantity = ? WHERE cart_id = ?";


    public static String selectCartByMemberId =
            "SELECT c.cart_id, c.member_id, c.item_id, c.quantity, i.name AS item_name, i.price AS item_price " +
                    "FROM cart c " +
                    "JOIN item i ON c.item_id = i.item_id " +
                    "WHERE c.member_id = ?";

}