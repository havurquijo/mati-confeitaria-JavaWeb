/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import tableObjects.Account;
import util.MyDate;
import interfaces.ElementDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import util.PasswObject;

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
    public HashMap<String,Object> insertElement(Account account) throws Exception{
        HashMap<String,Object> existenceResponse = new HashMap<>();
        existenceResponse.put("response", false);
        existenceResponse.put("reason", null);
        try {
            openConnection();
            //SQL statement with jockers ?
            preparedStatement = connection.prepareStatement("insert into "+databaseName+".account "
                    + "(type,"
                    + "user_name,"
                    + "user_password,"
                    + "salt,"
                    + "name,"
                    + "phone_number,"
                    + "cpf,"
                    + "email,"
                    + "address,"
                    + "cep,"
                    + "age,"
                    + "user_discount,"
                    + "created_at"
                    + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)");   
            //preparing each statement
            preparedStatement.setString(1,account.getType());
            preparedStatement.setString(2,account.getUser_name());
            preparedStatement.setString(3,account.getUser_password());
            preparedStatement.setString(4, account.getSalt());
            preparedStatement.setString(5,account.getName());
            preparedStatement.setString(6,account.getPhone_number());
            preparedStatement.setString(7,account.getCpf());
            preparedStatement.setString(8,account.getEmail());
            preparedStatement.setString(9,account.getAddress());
            preparedStatement.setString(10,account.getCep());
            preparedStatement.setInt(11,account.getAge());
            preparedStatement.setFloat(12,account.getUser_discount());
            preparedStatement.setTimestamp(13,account.getCreated_at().parse());
            //executing the query
            preparedStatement.execute();
            //clossing the connection
            closeConnection();
            existenceResponse.replace("response", true);
            return existenceResponse;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            //SQL Error treatment
            if ("23505".equals(e.getSQLState())){
                System.out.println("Duplicate key value violates unique constraint."+e.getMessage());
                existenceResponse = this.checkAccount(account); 
                if((boolean) existenceResponse.get("response")){
                    existenceResponse.replace("response", false);
                    return existenceResponse;
                }           
            }
            System.out.println("General error when inserting in database.\n Error Code:"+e.getMessage()+"\n");
            return existenceResponse;
        }
    }

    @Override
    public Account getElementById(int id) throws Exception{
        openConnection();
        preparedStatement = connection.prepareStatement("select * from "+databaseName+".account where id_people = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        if(resultSet.next()){
            account.setId(id);
            account.setType(resultSet.getString("type"));
            account.setUser_name(resultSet.getString("user_name"));
            account.setName(resultSet.getString("name"));
            account.setPhone_number(resultSet.getString("phone_number"));
            account.setCpf(resultSet.getString("cpf"));
            account.setEmail(resultSet.getString("email"));
            account.setAddress(resultSet.getString("address"));
            account.setCep(resultSet.getString("cep"));
            account.setAge(resultSet.getInt("age"));
            account.setUser_discount(resultSet.getFloat("user_discount"));
            account.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
            closeConnection();
        }else{
            return null;
        }
        return account;
    }

    public Account getElementByUserName(String user_name) throws Exception{
        openConnection();
        preparedStatement = connection.prepareStatement("select * from "+databaseName+".account where user_name = ?");
        preparedStatement.setString(1, user_name);
        resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        if(resultSet.next()){
            account.setId(resultSet.getInt("id_people"));
            account.setType(resultSet.getString("type"));
            account.setUser_name(user_name);
            account.setName(resultSet.getString("name"));
            account.setPhone_number(resultSet.getString("phone_number"));
            account.setCpf(resultSet.getString("cpf"));
            account.setEmail(resultSet.getString("email"));
            account.setAddress(resultSet.getString("address"));
            account.setCep(resultSet.getString("cep"));
            account.setAge(resultSet.getInt("age"));
            account.setUser_discount(resultSet.getFloat("user_discount"));
            account.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
            closeConnection();
        }else{
            return null;
        }
        return account;
    }

    @Override
    public ArrayList<Account> getElements() throws Exception{
        ArrayList<Account> accounts = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from "+databaseName+".account");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Account account =  new Account();
                account.setId(resultSet.getInt("id_people"));
                account.setType(resultSet.getString("type"));
                account.setUser_name(resultSet.getString("user_name"));
                account.setName(resultSet.getString("name"));
                account.setPhone_number(resultSet.getString("phone_number"));
                account.setCpf(resultSet.getString("cpf"));
                account.setEmail(resultSet.getString("email"));
                account.setAddress(resultSet.getString("address"));
                account.setCep(resultSet.getString("cep"));
                account.setAge(resultSet.getInt("age"));
                account.setUser_discount(resultSet.getFloat("user_discount"));
                account.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
                accounts.add(account);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return accounts;
    }

    @Override
    public ArrayList<Account> getElementsSubset(int start_column, int end_column) throws Exception{
        ArrayList<Account> accounts = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from "+databaseName+".account"+
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
                account.setName(resultSet.getString("name"));
                account.setPhone_number(resultSet.getString("phone_number"));
                account.setCpf(resultSet.getString("cpf"));
                account.setEmail(resultSet.getString("email"));
                account.setAddress(resultSet.getString("address"));
                account.setCep(resultSet.getString("cep"));
                account.setAge(resultSet.getInt("age"));
                account.setUser_discount(resultSet.getFloat("user_discount"));
                account.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
                accounts.add(account);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return accounts;
    }

    @Override
    public boolean updateElement(Account account) throws Exception{
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("update "+databaseName+".account set "
                    + "type = ?,"
                    + "user_name = ?,"
                    + "user_password = ?,"
                    + "salt,"
                    + "name = ?,"
                    + "phone_number = ?,"
                    + "cpf = ?,"
                    + "email = ?,"
                    + "address = ?,"
                    + "cep = ?,"
                    + "age = ?,"
                    + "user_discount = ?,"
                    + "created_at = ?"
                    + " where id_people = ?");
            preparedStatement.setString(1,account.getType());
            preparedStatement.setString(2,account.getUser_name());
            preparedStatement.setString(3,account.getUser_password());
            preparedStatement.setString(4, account.getSalt());
            preparedStatement.setString(5,account.getName());
            preparedStatement.setString(6,account.getPhone_number());
            preparedStatement.setString(7,account.getCpf());
            preparedStatement.setString(8,account.getEmail());
            preparedStatement.setString(9,account.getAddress());
            preparedStatement.setString(10,account.getCep());
            preparedStatement.setInt(11,account.getAge());
            preparedStatement.setFloat(12,account.getUser_discount());
            preparedStatement.setTimestamp(13,account.getDeleted_at().parse());
            preparedStatement.setInt(15, account.getId());
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteElement(int id) throws Exception{
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("delete from "+databaseName+".account where id_people = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }
    
    public PasswObject getPassword(String user_name)throws Exception{
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select id_people,user_password,salt from "+databaseName+".account where user_name = ?");
            preparedStatement.setString(1, user_name);
            resultSet = preparedStatement.executeQuery();
            closeConnection();
            if (resultSet.next()){
                int id = resultSet.getInt("id_people");
                return new PasswObject(id,
                        resultSet.getString("user_password"), 
                        resultSet.getString("salt")
                        );
            }
        } catch (SQLException e) {
            //TODO
        }
        return null;
    }
    
    public HashMap<String,Object> checkAccount(Account account)throws Exception{
        HashMap<String,Object> toReturn = new HashMap<>();
        toReturn.put("response", false);
        toReturn.put("reason", null);
        try {
            openConnection();
            //Prepared Statement for chacking various situations
            ArrayList<PreparedStatement> preparedStatements = new ArrayList();
            ArrayList<ResultSet> resultSets = new ArrayList<>();
            String[] columns = {"user_name","email","phone_number","cpf"};
            for (String string : columns) {
                preparedStatements.add(connection.prepareStatement("select exists(select 1 from "+databaseName+".account where "+string+" = ?)"));
            }
            //preparing
            String[] properties = {account.getUser_name(),account.getEmail(),account.getPhone_number(),account.getCpf()};
            for (int i = 0; i < properties.length; i++) {
                preparedStatements.get(i).setString(1, properties[i]);
            }
            //Executing
            for (PreparedStatement statement:preparedStatements) {
                resultSets.add(statement.executeQuery());
            }
            closeConnection();
            //Analyzing
            for (ResultSet resultSet : resultSets) {
                if (resultSet.next()) {
                    if(resultSet.getBoolean(1)){
                        toReturn.put("response", true);
                        toReturn.put("reason", columns[resultSets.indexOf(resultSet)]);
                        return toReturn;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when connecting database from checkAccount(Account account)\n. Error code: "+e.getMessage()+"\n");
            // TODO: handle exception
        }
        return toReturn;
    }
}
