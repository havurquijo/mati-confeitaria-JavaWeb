/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.util.ArrayList;

/**
 *
 * @author hvurq
 * @param <Type>
 */
public interface ElementDao <Type>{
    /*Here are pressented all the methods for getting values from database. 
    Each element is a row of an specific table named Type, because each table will have a class associated.*/
    public boolean insertElement(Type element)throws Exception;
    public Type getElementById(int id)throws Exception;
    public ArrayList<Type> getElements()throws Exception;
    public ArrayList<Type> getElementsSubset(int id_start, int id_end)throws Exception;/*This is a function to catch a subset of all elements via API*/
    public boolean updateElement(Type element)throws Exception;
    public boolean deleteElement(int id)throws Exception;
}
