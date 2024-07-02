/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author hvurq
 */
public class Connect {
    
    public Connect(){
    }
    
    public Connection getConnection() throws Exception{
        try {
            String dbUrl = this.getEnvVar(envVar.DB_URL.name());
            String dbUser = this.getEnvVar(envVar.DB_USER.name());
            String dbPassword = this.getEnvVar(envVar.DB_PASSWORD.name());
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(dbUrl,dbUser,dbPassword);//Connect to database
        } catch (Exception e) {
            System.out.println("Error when connecting to SQL database: "+e);
            return null;
        }
    }

    private String getEnvVar(String envar) {
        String envvarString = System.getenv(envar);
        if (envvarString.isEmpty()){
            System.err.println("Enviromental variables not set");
        }
        return envvarString;
    }
    
    private enum envVar{
        DB_URL, 
        DB_USER, 
        DB_PASSWORD
    }
    
}



