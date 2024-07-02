/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import interfaces.ElementDao;
import java.util.ArrayList;

import tableObjects.Account;
import tableObjects.Cart;
import util.MyDate;

/**
 *
 * @author hvurq
 */
public class CartDao extends Dao implements ElementDao<Cart>{

    @Override
    public boolean insertElement(Cart cart) throws Exception {
        try {
            openConnection();
            //SQL statement with jockers ?
            preparedStatement = connection.prepareStatement("insert into mati_db.cart "
                        + "(id_customer,"
                        + "cart_items,"
                        + ") values (?,?)");   
                //preparing each statement
                preparedStatement.setInt(1,cart.getId_customer());
                preparedStatement.setString(2,cart.getCart_items().toString());//must be a json object
                //executing the query
                preparedStatement.execute();
                //clossing the connection
                closeConnection();
                return true;
            } catch (Exception e) {
                return false;
            }
    }

    @Override
    public Cart getElementById(int id) throws Exception {
        openConnection();
        preparedStatement = connection.prepareStatement("select * from mati_db.cart where id_people = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        Cart cart = new Cart();
        if(resultSet.next()){
            cart.setId_cart(id);;
            cart.setId_customer(resultSet.getInt("id_customer"));
            cart.setCart_items(resultSet.getString("cart_items"));
            closeConnection();
        }else{
            return null;
        }
        return cart;
    }

    @Override
    public ArrayList<Cart> getElements() throws Exception {
        ArrayList<Cart> carts = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from mati_db.cart");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Cart cart =  new Cart();
                cart.setId_cart(resultSet.getInt("id_cart"));
                cart.setId_customer(resultSet.getInt("id_customer"));
                cart.setCart_items(resultSet.getString("cart_item"));
                carts.add(cart);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return carts;
    }

    @Override
    public ArrayList<Cart> getElementsSubset(int id_start, int id_end) throws Exception {
        ArrayList<Cart> carts = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from mati_db.cart"+
            "order by id_cart"+
            "offset ?"+
            "limit ?");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Cart cart =  new Cart();
                cart.setId_cart(resultSet.getInt("id_cart"));
                cart.setId_customer(resultSet.getInt("id_customer"));
                cart.setCart_items(resultSet.getString("cart_item"));
                carts.add(cart);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return carts;
    }

    @Override
    public boolean updateElement(Cart element) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteElement(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
