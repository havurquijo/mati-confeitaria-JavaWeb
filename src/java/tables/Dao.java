/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;
import connections.Connect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author hvurq
 */
public class Dao {
    String databaseName = "mati_db.public";
    Connection connection;//Create Connection
    PreparedStatement preparedStatement;//Access table with sql statements (insert update delete)
    ResultSet resultSet;//Consult the sql table (select)
    CallableStatement callableStatement;//Procedures abd functions
    //open conection, create a function that opens the connection with database
    public void openConnection()throws Exception{
        try {
            connection = new Connect().getConnection();
        } catch (SQLException | ClassNotFoundException exception) {
            System.err.println("Error connecting the database"+exception);
        }
    }
    
    public void closeConnection() throws Exception{
        try {
            Class.forName("org.postgresql.Driver");
            connection.close();
        } catch (NullPointerException | ClassNotFoundException exception) {//NullPointerException if tyr to close something that doesn't exist
            System.err.println("Error while closing the databse: "+exception);
        }
    }
}
