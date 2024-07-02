/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import util.MyDate;

/**
 *
 * @author hvurq
 */
public interface Dates {
    /*This interface will help to create the Dao classes that which have Date values*/    
    public MyDate getCreatedAt();
    public MyDate getDeletedAt();
    public void setCreatedAt(MyDate var);
    public void setDeletedAt(MyDate var);
}
