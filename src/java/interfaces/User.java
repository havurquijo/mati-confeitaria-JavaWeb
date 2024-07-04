/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author hvurq
 */
public interface User {
    /*This interface will be used at least 2 times to cosntruct account and deleted users */
    public void setType(String var);
    public void setUser_name(String var);
    public void setName(String var);
    public void setPhone_number(String var);
    public void setCpf(String var);
    public void setEmail(String var);
    public void setAddress(String var);
    public void setCep(String var);
    public void setAge(int var);

    public String getType();
    public String getUser_name();
    public String getName();
    public String getPhone_number();
    public String getCpf();
    public String getEmail();
    public String getAddress();
    public String getCep();
    public int getAge();
}
