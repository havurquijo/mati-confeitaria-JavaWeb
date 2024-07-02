/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import tableObjects.Account;
import util.MyDate;
import interfaces.ElementDao;
import java.util.ArrayList;

/**
 *
 * @author hvurq
 */
public class AccountDao extends Dao implements ElementDao<Account>{//implements an interface of type Account

    //Constructor
    public AccountDao(){
    }
    
    //Dao extention and override
    @Override
    public boolean insertElement(Account account) {
        try {
            openConnection();
            //SQL statement with jockers ?
            preparedStatement = connection.prepareStatement("insert into mati_db.account "
                    + "(type,"
                    + "user_name,"
                    + "user_password,"
                    + "name,"
                    + "phone_number,"
                    + "cpf,"
                    + "email,"
                    + "address,"
                    + "cep,"
                    + "age,"
                    + "user_discount,"
                    + "created_at,"
                    + "deleted_at"
                    + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)");   
            //preparing each statement
            preparedStatement.setString(1,account.getType());
            preparedStatement.setString(2,account.getUser_name());
            preparedStatement.setString(3,account.getUser_password());
            preparedStatement.setString(4,account.getName());
            preparedStatement.setString(5,account.getPhone_number());
            preparedStatement.setString(6,account.getCep());
            preparedStatement.setString(7,account.getEmail());
            preparedStatement.setString(8,account.getAddress());
            preparedStatement.setString(9,account.getCep());
            preparedStatement.setInt(10,account.getAge());
            preparedStatement.setString(11,account.getUser_discount());
            preparedStatement.setTimestamp(12,account.getCreatedAt().parse());
            preparedStatement.setTimestamp(13,account.getDeletedAt().parse());
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
    public Account getElementById(int id) throws Exception{
        openConnection();
        preparedStatement = connection.prepareStatement("select * from mati_db.account where id_people = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        if(resultSet.next()){
            account.setId(id);
            account.setType(resultSet.getString("type"));
            account.setUser_name(resultSet.getString("user_name"));
            account.setUser_password(resultSet.getString("user_password"));
            account.setName(resultSet.getString("name"));
            account.setPhone_number(resultSet.getString("phone_number"));
            account.setCpf(resultSet.getString("cpf"));
            account.setEmail(resultSet.getString("email"));
            account.setAddress(resultSet.getString("address"));
            account.setCep(resultSet.getString("cep"));
            account.setAge(resultSet.getInt("age"));
            account.setUser_discount(resultSet.getString("user_discount"));
            account.setCreatedAt(new MyDate(resultSet.getTimestamp("created_at")));
            account.setDeletedAt(new MyDate(resultSet.getTimestamp("deleted_at")));
            closeConnection();
        }else{
            return null;
        }
        return account;
    }

    @Override
    public ArrayList<Account> getElements() {
        ArrayList<Account> accounts = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from mati_db.account");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Account account =  new Account();
                account.setId(resultSet.getInt("id_people"));
                account.setType(resultSet.getString("type"));
                account.setUser_name(resultSet.getString("user_name"));
                account.setUser_password(resultSet.getString("user_password"));
                account.setName(resultSet.getString("name"));
                account.setPhone_number(resultSet.getString("phone_number"));
                account.setCpf(resultSet.getString("cpf"));
                account.setEmail(resultSet.getString("email"));
                account.setAddress(resultSet.getString("address"));
                account.setCep(resultSet.getString("cep"));
                account.setAge(resultSet.getInt("age"));
                account.setUser_discount(resultSet.getString("user_discount"));
                account.setCreatedAt(new MyDate(resultSet.getTimestamp("created_at")));
                account.setDeletedAt(new MyDate(resultSet.getTimestamp("deleted_at")));
                accounts.add(account);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return accounts;
    }

    @Override
    public ArrayList<Account> getElementsSubset(int start_column, int end_column) {
        ArrayList<Account> accounts = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from mati_db.account"+
            "order by id_people"+
            "offset ?"+
            "limit ?");
            preparedStatement.setInt(1, start_column);
            preparedStatement.setInt(2, end_column);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Account account =  new Account();
                account.setId(resultSet.getInt("id_people"));
                account.setType(resultSet.getString("type"));
                account.setUser_name(resultSet.getString("user_name"));
                account.setUser_password(resultSet.getString("user_password"));
                account.setName(resultSet.getString("name"));
                account.setPhone_number(resultSet.getString("phone_number"));
                account.setCpf(resultSet.getString("cpf"));
                account.setEmail(resultSet.getString("email"));
                account.setAddress(resultSet.getString("address"));
                account.setCep(resultSet.getString("cep"));
                account.setAge(resultSet.getInt("age"));
                account.setUser_discount(resultSet.getString("user_discount"));
                account.setCreatedAt(new MyDate(resultSet.getTimestamp("created_at")));
                account.setDeletedAt(new MyDate(resultSet.getTimestamp("deleted_at")));
                accounts.add(account);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return accounts;
    }

    @Override
    public boolean updateElement(Account account) {
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("update mati_db.account set "
                    + "type = ?,"
                    + "user_name = ?,"
                    + "user_password = ?,"
                    + "name = ?,"
                    + "phone_number = ?,"
                    + "cpf = ?,"
                    + "email = ?,"
                    + "address = ?,"
                    + "cep = ?,"
                    + "age = ?,"
                    + "user_discount = ?,"
                    + "created_at = ?,"
                    + "deleted_at = ?"
                    + " where id_people = ?");
            preparedStatement.setString(1,account.getType());
            preparedStatement.setString(2,account.getUser_name());
            preparedStatement.setString(3,account.getUser_password());
            preparedStatement.setString(4,account.getName());
            preparedStatement.setString(5,account.getPhone_number());
            preparedStatement.setString(6,account.getCep());
            preparedStatement.setString(7,account.getEmail());
            preparedStatement.setString(8,account.getAddress());
            preparedStatement.setString(9,account.getCep());
            preparedStatement.setInt(10,account.getAge());
            preparedStatement.setString(11,account.getUser_discount());
            preparedStatement.setTimestamp(12,account.getCreatedAt().parse());
            preparedStatement.setTimestamp(13,account.getDeletedAt().parse());
            preparedStatement.setInt(14, account.getId());
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteElement(int id) {
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("delete mati_db.account where id_people = ?");
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
