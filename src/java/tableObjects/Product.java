/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableObjects;

import interfaces.Dates;
import interfaces.Ids;
import util.MyDate;

/**
 *
 * @author hvurq
 */
public class Product implements Ids,Dates{
    private int id_product = 0;
    private int inventory_number = 0;
    private String name = null;
    private String description = null;
    private boolean available = false;
    private int stock = 0;
    private float price = 0;
    private float discount = 0;//Quantity of money to be discounted not porcentage
    private MyDate created_at = null;
    private MyDate deleted_at = null;

    @Override
    public int getId() {
        return id_product;
    }

    @Override
    public void setId(int id_product) {
        this.id_product = id_product;
    }

    public int getInventory_number() {
        return inventory_number;
    }

    public void setInventory_number(int inventory_number) {
        this.inventory_number = inventory_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public MyDate getCreated_at() {
        return created_at;
    }

    @Override
    public void setCreated_at(MyDate created_at) {
        this.created_at = created_at;
    }

    @Override
    public MyDate getDeleted_at() {
        return deleted_at;
    }

    @Override
    public void setDeleted_at(MyDate deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
    
}
