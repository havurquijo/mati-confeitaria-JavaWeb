/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableObjects;


/**
 *
 * @author hvurq
 */
public class Cart {
    private int id_cart = 0;
    private int id_customer = 0;
    private Object cart_items = null;

    public Cart() {
    }
    
    public Cart(int id_cart,int id_customer,Object cart_items){
        setCart_items(cart_items);
        setId_cart(id_cart);
        setId_customer(id_customer);
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public Object getCart_items() {
        return cart_items;
    }

    public void setCart_items(Object cart_items) {
        this.cart_items = cart_items;
    }
    
    
}
