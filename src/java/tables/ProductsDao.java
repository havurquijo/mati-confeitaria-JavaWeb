/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import interfaces.ElementDao;
import java.util.ArrayList;

import tableObjects.Account;
/**
 *
 * @author hvurq
 */
import tableObjects.Product;
import util.MyDate;
public class ProductsDao extends Dao implements ElementDao<Product>{

    @Override
    public boolean insertElement(Product product) throws Exception {
        try {
            openConnection();
            //SQL statement with jockers ?
            preparedStatement = connection.prepareStatement("insert into mati_db.products "
                    + "("
                    + "inventory_number,"
                    + "name,"
                    + "description,"
                    + "available,"
                    + "stock,"
                    + "price,"
                    + "discount,"
                    + "created_at,"
                    + "deleted_at,"
                    + ") values (?,?,?,?,?,?,?,?,?)");   
            //preparing each statement
            preparedStatement.setInt(1,product.getInventory_number());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setBoolean(4,product.isAvailable());
            preparedStatement.setInt(5, product.getStock());
            preparedStatement.setFloat(6,product.getPrice());
            preparedStatement.setFloat(7,product.getDiscount());
            preparedStatement.setTimestamp(8,product.getCreated_at().parse());
            preparedStatement.setTimestamp(9,product.getDeleted_at().parse());
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
    public Product getElementById(int id) throws Exception {
        openConnection();
        preparedStatement = connection.prepareStatement("select * from mati_db.account where id_product = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        Product product = new Product();
        if(resultSet.next()){
            product.setId(id);
            product.setInventory_number(resultSet.getInt("inventory_number"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setAvailable(resultSet.getBoolean("available"));
            product.setStock(resultSet.getInt("stock"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDiscount(resultSet.getFloat("discount"));
            product.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
            product.setDeleted_at(new MyDate(resultSet.getTimestamp("deleted_at")));
            closeConnection();
        }else{
            return null;
        }
        return product;
    }

    @Override
    public ArrayList<Product> getElements() throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        openConnection();
        preparedStatement = connection.prepareStatement("select * from mati_db.account");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Product product = new Product();
            product.setId(resultSet.getInt("id_product"));
            product.setInventory_number(resultSet.getInt("inventory_number"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setAvailable(resultSet.getBoolean("available"));
            product.setStock(resultSet.getInt("stock"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDiscount(resultSet.getFloat("discount"));
            product.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
            product.setDeleted_at(new MyDate(resultSet.getTimestamp("deleted_at")));
            products.add(product);
        }
        closeConnection();
        return products;
    }

    @Override
    public ArrayList<Product> getElementsSubset(int id_start, int id_end) throws Exception {
        ArrayList<Product> products = new ArrayList<>();
        openConnection();
        preparedStatement = connection.prepareStatement("select * from mati_db.account "
            +"order by id_people"+
            "offset ?"+
            "limit ?");
        preparedStatement.setInt(1, id_start);
        preparedStatement.setInt(2, id_end);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Product product = new Product();
            product.setId(resultSet.getInt("id_product"));
            product.setInventory_number(resultSet.getInt("inventory_number"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setAvailable(resultSet.getBoolean("available"));
            product.setStock(resultSet.getInt("stock"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDiscount(resultSet.getFloat("discount"));
            product.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
            product.setDeleted_at(new MyDate(resultSet.getTimestamp("deleted_at")));
            products.add(product);
        }
        closeConnection();
        return products;
    }

    @Override
    public boolean updateElement(Product product) throws Exception {
        try {
            openConnection();
            //SQL statement with jockers ?
            preparedStatement = connection.prepareStatement("update mati_db.products set "
                        + "inventory_number = ?,"
                        + "name = ?,"
                        + "description = ?,"
                        + "available = ?,"
                        + "stock = ?,"
                        + "price = ?,"
                        + "discount = ?,"
                        + "created_at = ?,"
                        + "deleted_at = ?,"
                        + " where id_people = ?");  
            //preparing each statement
            preparedStatement.setInt(1,product.getInventory_number());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setBoolean(4,product.isAvailable());
            preparedStatement.setInt(5, product.getStock());
            preparedStatement.setFloat(6,product.getPrice());
            preparedStatement.setFloat(7,product.getDiscount());
            preparedStatement.setTimestamp(8,product.getCreated_at().parse());
            preparedStatement.setTimestamp(9,product.getDeleted_at().parse());
            preparedStatement.setInt(10, product.getId());
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
    public boolean deleteElement(int id) throws Exception {
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("delete mati_db.product where id_people = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }
    
}
