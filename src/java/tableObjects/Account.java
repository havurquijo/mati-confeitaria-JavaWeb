/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableObjects;

import interfaces.Dates;
import interfaces.Ids;
import interfaces.User;
import util.MyDate;

/**
 *
 * @author hvurq
 */
public class Account implements User,Ids,Dates{
    //Attributes
    private int id_people = 0;
    private String type = null;
    private String user_name = null;
    private String user_password = null;
    private String salt = null;
    private String name = null;
    private String phone_number = null;
    private String cpf = null;
    private String email = null;
    private String address = null;
    private String cep = null;
    private int age = 0;
    private float user_discount = 0;
    private MyDate created_at = null;

    //Constructor
    public Account(){
    }

    public Account(String type, String user_name, String name, String user_password, String salt, String phone_number, String cpf, String email, String address, String cep, int age, float user_discount, MyDate created_at) {
        this.type = type;
        this.user_name = user_name;
        this.name = name;
        this.phone_number = phone_number;
        this.cpf = cpf;
        this.email = email;
        this.address = address;
        this.cep = cep;
        this.age = age;
        this.user_discount = user_discount;
        this.created_at = created_at;
        this.user_password = user_password;
        this.salt = salt;
    }
    
    //Getter setter functions
    public float getUser_discount() {
        return user_discount;
    }

    public void setUser_discount(float user_discount) {
        this.user_discount = user_discount;
    }
    
    //Overriding methods
    @Override
    public int getId() {
        return this.id_people;
    }

    @Override
    public void setId(int id_people) {
        this.id_people=id_people;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getUser_name() {
        return this.user_name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPhone_number() {
        return this.phone_number;
    }

    @Override
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getCep() {
        return this.cep;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public MyDate getCreated_at() {
        return this.created_at;
    }

    @Override
    public void setCreated_at(MyDate created_at) {
        this.created_at = created_at;
    }

    @Override
    public void setDeleted_at(MyDate deleted_at) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    

    @Override
    public String toString() {
        return "Account{" + "id_people=" + id_people + ", type=" + type + ", user_name=" + user_name + ", name=" + name + ", phone_number=" + phone_number + ", cpf=" + cpf + ", email=" + email + ", address=" + address + ", cep=" + cep + ", age=" + age + ", user_discount=" + user_discount + ", created_at=" + created_at + '}';
    }

    @Override
    public MyDate getDeleted_at() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
