<%-- 
    Document   : logginconfirmation
    Created on : 5 Jul 2024, 01:39:50
    Author     : hvurq
--%>
<%@page import = "util.PasswObject" %>
<%@page import = "tables.AccountDao" %>
<%@page import = "util.PasswordHashingPBKDF2" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    AccountDao accountDao = new AccountDao();
    String user_name = request.getParameter("user_name");
    PasswObject  passwordObjDB = accountDao.getPassword(user_name);
    String saltString = passwordObjDB.getSalt();
    byte[] salt  = PasswordHashingPBKDF2.saltToByte(saltString);

    String hashedPasswordSubmitted = PasswordHashingPBKDF2.hashPassword(request.getParameter("password"),salt);
    if(hashedPasswordSubmitted.equals(passwordObjDB.getPassword())){
        response.sendRedirect("accountpage.jsp");
        //save session here
    }else{
        response.sendRedirect("logginpage.jsp?wrongPassword=true");
    }
    
%>

