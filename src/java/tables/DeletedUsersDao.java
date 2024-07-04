/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import interfaces.ElementDao;
import java.util.ArrayList;
import java.util.HashMap;

import tableObjects.DeletedUser;
import util.MyDate;
/**
 *
 * @author hvurq
 */
public class DeletedUsersDao extends Dao implements ElementDao<DeletedUser> {

    @Override
    public HashMap<String,Object> insertElement(DeletedUser deletedUser) throws Exception {
        HashMap<String,Object> toReturn = new HashMap<>();
        toReturn.put("reason", null);
        try {
            openConnection();
            //SQL statement with jockers ?
            preparedStatement = connection.prepareStatement("insert into mati_db.deletedusers "
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
                    + "created_at,"
                    + "deleted_at"
                    + ") values (?,?,?,?,?,?,?,?,?,?,?,?)");   
            //preparing each statement
            preparedStatement.setString(1,deletedUser.getType());
            preparedStatement.setString(2,deletedUser.getUser_name());
            preparedStatement.setString(3,deletedUser.getUser_password());
            preparedStatement.setString(4,deletedUser.getName());
            preparedStatement.setString(5,deletedUser.getPhone_number());
            preparedStatement.setString(6,deletedUser.getCep());
            preparedStatement.setString(7,deletedUser.getEmail());
            preparedStatement.setString(8,deletedUser.getAddress());
            preparedStatement.setString(9,deletedUser.getCep());
            preparedStatement.setInt(10,deletedUser.getAge());
            preparedStatement.setTimestamp(12,deletedUser.getCreated_at().parse());
            preparedStatement.setTimestamp(13,deletedUser.getDeleted_at().parse());
            //executing the query
            preparedStatement.execute();
            //clossing the connection
            closeConnection();
            toReturn.put("response", true);
            return toReturn;
        } catch (Exception e) {
            toReturn.put("response", true);
            return toReturn;
        }
    }

    @Override
    public DeletedUser getElementById(int id) throws Exception {
        openConnection();
        preparedStatement = connection.prepareStatement("select * from mati_db.deletedusers where id_deleted_user = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        DeletedUser deletedUser = new DeletedUser();
        if(resultSet.next()){
            deletedUser.setId(id);
            deletedUser.setType(resultSet.getString("type"));
            deletedUser.setUser_name(resultSet.getString("user_name"));
            deletedUser.setUser_password(resultSet.getString("user_password"));
            deletedUser.setName(resultSet.getString("name"));
            deletedUser.setPhone_number(resultSet.getString("phone_number"));
            deletedUser.setCpf(resultSet.getString("cpf"));
            deletedUser.setEmail(resultSet.getString("email"));
            deletedUser.setAddress(resultSet.getString("address"));
            deletedUser.setCep(resultSet.getString("cep"));
            deletedUser.setAge(resultSet.getInt("age"));
            deletedUser.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
            deletedUser.setDeleted_at(new MyDate(resultSet.getTimestamp("deleted_at")));
            closeConnection();
        }else{
            return null;
        }
        return deletedUser;
    }

    @Override
    public ArrayList<DeletedUser> getElements() throws Exception {
        ArrayList<DeletedUser> deletedUsers = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from mati_db.deletedusers");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                DeletedUser deletedUser =  new DeletedUser();
                deletedUser.setId(resultSet.getInt("id_deleted_user"));
                deletedUser.setType(resultSet.getString("type"));
                deletedUser.setUser_name(resultSet.getString("user_name"));
                deletedUser.setUser_password(resultSet.getString("user_password"));
                deletedUser.setName(resultSet.getString("name"));
                deletedUser.setPhone_number(resultSet.getString("phone_number"));
                deletedUser.setCpf(resultSet.getString("cpf"));
                deletedUser.setEmail(resultSet.getString("email"));
                deletedUser.setAddress(resultSet.getString("address"));
                deletedUser.setCep(resultSet.getString("cep"));
                deletedUser.setAge(resultSet.getInt("age"));
                deletedUser.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
                deletedUser.setDeleted_at(new MyDate(resultSet.getTimestamp("deleted_at")));
                deletedUsers.add(deletedUser);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return deletedUsers;
    }

    @Override
    public ArrayList<DeletedUser> getElementsSubset(int start_column, int end_column) throws Exception {
        ArrayList<DeletedUser> deletedUsers = new ArrayList();
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("select * from mati_db.deletedusers"+
            "order by id_deleted_user"+
            "offset ?"+
            "limit ?");
            preparedStatement.setInt(1, start_column);
            preparedStatement.setInt(2, end_column);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                DeletedUser deletedUser =  new DeletedUser();
                deletedUser.setId(resultSet.getInt("id_deleted_user"));
                deletedUser.setType(resultSet.getString("type"));
                deletedUser.setUser_name(resultSet.getString("user_name"));
                deletedUser.setUser_password(resultSet.getString("user_password"));
                deletedUser.setName(resultSet.getString("name"));
                deletedUser.setPhone_number(resultSet.getString("phone_number"));
                deletedUser.setCpf(resultSet.getString("cpf"));
                deletedUser.setEmail(resultSet.getString("email"));
                deletedUser.setAddress(resultSet.getString("address"));
                deletedUser.setCep(resultSet.getString("cep"));
                deletedUser.setAge(resultSet.getInt("age"));
                deletedUser.setCreated_at(new MyDate(resultSet.getTimestamp("created_at")));
                deletedUser.setDeleted_at(new MyDate(resultSet.getTimestamp("deleted_at")));
                deletedUsers.add(deletedUser);
            }
            closeConnection();
        } catch (Exception e) {
            System.err.println("Error when executing the query: "+e);
        }
        return deletedUsers;
    }

    @Override
    public boolean updateElement(DeletedUser deletedUser) throws Exception {
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("update mati_db.deletedusers set "
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
                    + "created_at = ?,"
                    + "deleted_at = ?"
                    + " where id_people = ?");
            preparedStatement.setString(1,deletedUser.getType());
            preparedStatement.setString(2,deletedUser.getUser_name());
            preparedStatement.setString(3,deletedUser.getUser_password());
            preparedStatement.setString(4,deletedUser.getName());
            preparedStatement.setString(5,deletedUser.getPhone_number());
            preparedStatement.setString(6,deletedUser.getCep());
            preparedStatement.setString(7,deletedUser.getEmail());
            preparedStatement.setString(8,deletedUser.getAddress());
            preparedStatement.setString(9,deletedUser.getCep());
            preparedStatement.setInt(10,deletedUser.getAge());
            preparedStatement.setTimestamp(12,deletedUser.getCreated_at().parse());
            preparedStatement.setTimestamp(13,deletedUser.getDeleted_at().parse());
            preparedStatement.setInt(14, deletedUser.getId());
            closeConnection();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteElement(int id) throws Exception {
        try {
            openConnection();
            preparedStatement = connection.prepareStatement("delete mati_db.deletedusers where id_people = ?");
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
