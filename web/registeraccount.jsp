<%@page import="tableObjects.Account" %>
<%@page import="tables.AccountDao" %>
<%@page import="util.MyDate" %>
<%@page import="util.PasswordHashingPBKDF2" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date" %>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Retrive information from submitted register
    String type = "user";
    Date currentDate = new Date();
    //byte[] saltByte = PasswordHashingPBKDF2.generateSalt();
    String password = request.getParameter("password");
    String user_name = request.getParameter("user_name");

    //
    // Check for null password
    if (password == null || password.isEmpty()) {
        response.sendRedirect("registerpage.jsp?inserted=false&reason=missing_password");
        return;
    }

    byte[] saltByte = PasswordHashingPBKDF2.generateSalt();
    
    // Check if salt generation failed
    if (saltByte == null) {
        response.sendRedirect("registerpage.jsp?inserted=false&reason=salt_generation_failed");
        return;
    }

    String user_password;
    try {
        user_password = PasswordHashingPBKDF2.hashPassword(password, saltByte);
    } catch (Exception e) {
        // Handle any exception during password hashing
        response.sendRedirect("registerpage.jsp?inserted=false&reason=password_hashing_failed");
        return;
    }
    //



    //String user_password = PasswordHashingPBKDF2.hashPassword(password, saltByte);
    String salt = PasswordHashingPBKDF2.saltToString(saltByte);
    String name = request.getParameter("name");
    String phone_number = request.getParameter("phone");
    String cpf = request.getParameter("cpf");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String cep = request.getParameter("cep");
    String date = request.getParameter("borndate");
    int age = 0;
    // Parse the date
    if(!date.isEmpty()){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bornDate;
        try {
            bornDate = sdf.parse(date);
        } catch (Exception e) {
            // Handle parsing exception
            response.sendRedirect("registerpage.jsp?inserted=false&reason=invalid_date_format&borndate="+date);
            return;
        }

        // Calculating age from the born date
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(bornDate);
        Calendar nowCal = Calendar.getInstance();
        age = nowCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
        if (nowCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
    }
    float user_discount = 0;
    MyDate created_at = new MyDate();
    // Create an object for saving the account's properties
    Account account = new Account(
            type,
            user_name,
            name,
            user_password,
            salt,
            phone_number,
            cpf,
            email,
            address,
            cep,
            age,
            user_discount,
            created_at);

    // Insert into database
    AccountDao accountDao = new AccountDao();
    HashMap<String, Object> responseInsertAccount = accountDao.insertElement(account);

    // Handle the response
    if ((boolean) responseInsertAccount.get("response")) {
        response.sendRedirect("logginpage.jsp?inserted=true&reason=null");
    } else if (responseInsertAccount.get("reason") == null) {
        response.sendRedirect("registerpage.jsp?inserted=false&reason=null");
    } else {
        response.sendRedirect("registerpage.jsp?inserted=false&reason=" + (String) responseInsertAccount.get("reason"));
    }
%>
