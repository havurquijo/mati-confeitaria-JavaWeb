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
public class DeletedUser implements User,Ids,Dates{
    //Attributes
    private int id_people = 0;
    private String type = null;
    private String user_name = null;
    private String user_password = null;
    private String name = null;
    private String phone_number = null;
    private String cpf = null;
    private String email = null;
    private String address = null;
    private String cep = null;
    private int age = 0;
    private MyDate created_at = null;
    private MyDate deleted_at = null;

    public DeletedUser() {
    }
    
    public DeletedUser(int id_people, String type, String user_name, String user_password, String name, String phone_number, String cpf, String email, String address, String cep, int age, MyDate created_at, MyDate deleted_at) {
        this.id_people = id_people;
        this.type = type;
        this.user_name = user_name;
        this.user_password = user_password;
        this.name = name;
        this.phone_number = phone_number;
        this.cpf = cpf;
        this.email = email;
        this.address = address;
        this.cep = cep;
        this.age = age;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }

    
    @Override
    public int getId() {
        return id_people;
    }

    @Override
    public void setId(int id_people) {
        this.id_people = id_people;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getUser_name() {
        return user_name;
    }

    @Override
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String getUser_password() {
        return user_password;
    }

    @Override
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhone_number() {
        return phone_number;
    }

    @Override
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getCep() {
        return cep;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public MyDate getCreatedAt() {
        return created_at;
    }

    @Override
    public void setCreatedAt(MyDate created_at) {
        this.created_at = created_at;
    }

    @Override
    public MyDate getDeletedAt() {
        return deleted_at;
    }

    @Override
    public void setDeletedAt(MyDate deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
}
