<%-- 
    Document   : registerpage
    Created on : 3 Jul 2024, 02:45:48
    Author     : hvurq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
      <!--Header extracted from index.html-->
      <header>
        <nav class="navbar fixed-top bg-body-tertiary bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Navbar</a>
              <a class="nav-link active" href="index.html" style="color:antiquewhite">Home</a>
              <a class="nav-link active" aria-current="page" href="#" style="color:antiquewhite">Other link</a>
              <a class="nav-link active" aria-current="page" href="#" style="color:antiquewhite">Anotehr link</a>
              <form class="d-flex mt-3" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
              </form>
              <!--Can put buttons rigth here-->
              <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <!--The colapse parte starts here-->
              <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header">
                  <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Offcanvas</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                  <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li class="nav-item">
                      <a class="nav-link active" aria-current="page" href="logginpage.jsp">Loggin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="registerpage.jsp">Register</a>
                      </li>
                  </ul>
                </div>
              </div>
            </div>
          </nav>
      </header>
<!--Formulary-->
        <div class="container-fluid" style="margin-top: 15%; margin-bottom: 5%;">
          <div class="row justify-content-center text-center">
            <div class="col-md-6">
              <form class="row g-5 needs-validation" style="background-color: rgb(196, 230, 249);border-radius: 10%;"  action="registeraccount.jsp" method="POST" novalidate>
                <p style="font-size:x-large; color: rgb(7, 1, 95);">Register your account</p>
<!-------------Required------------------>
<!--User name input-->
                <div class="col-md-6">
                  <label for="user_name" class="form-label">User name</label>
                  <input type="text" class="form-control" id="user_name" name="user_name" placeholder="Set an User Name" required pattern="\w{2,20}">
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    The user name must have at least 2 letters and 20 letters at most.
                  </div>
                </div>
<!--Password input-->
                <div class="col-md-6">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="Password" required ><!--pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}">-->
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    <ul>
                      <li>At least 8 characters long.</li>
                      <li>Contains at least one uppercase letter.</li>
                      <li>Contains at least one lowercase letter.</li>
                      <li>Contains at least one number.</li>
                      <li>Contains at least one special character (e.g., !@#$%^&*).</li>
                    </ul>
                  </div>
                </div>
<!--Email input-->
                <div class="col-md-6">
                  <label for="email" class="form-label">Email</label>
                  <input type="email" class="form-control" id="email" name="email" placeholder="user@subdomain.domain" required>
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    Must be a valid email.
                  </div>
                </div>
<!-------------Not Required------------------>
<!--CPF-->
                <div class="col-md-6">
                  <label for="cpf" class="form-label">CPF</label>
                  <input type="text" class="form-control" id="cpf" name="cpf" placeholder="000.000.000-00" onchange="maskCpf()" pattern="\d{3}.\d{3}.\d{3}-\d{2}">
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    Must be a valid CPF.
                  </div>
                  <p style="font-size:small;color: rgb(106, 106, 108);">You may need to fill this latter.</p>
                </div>    
<!--Name input-->
                <div class="col-md-8">
                  <label for="name" class="form-label">Name and Lastname</label>
                  <input type="text" class="form-control" id="name" name="name" placeholder="Whole Name" pattern="[a-zA-ZáâéêíîóôúûüÁÂÉÊÍÎÓÔÚÛÜñÑ]{2,}(?:\s[a-zA-ZáâéêíîóôúûüÁÂÉÊÍÎÓÔÚÛÜñÑ]{2,})?(?:\s[a-zA-ZáâéêíîóôúûüÁÂÉÊÍÎÓÔÚÛÜñÑ]{2,})+">
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    Must be a real name.
                  </div>
                  <p style="font-size:small;color: rgb(106, 106, 108);">You may need to fill this latter.</p>
                </div>                   
<!--Born date-->
                <div class="col-md-4">
                  <label for="borndate" class="form-label">Born Date</label>
                  <input type="date" class="form-control" id="borndate" name="borndate" placeholder="2010-01-01" max="2010-01-01">
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div>
                    <p style="font-size:small;color: rgb(106, 106, 108);">You may need to fill this latter.</p>
                  </div>
                </div>  
<!--Address-->
                <div class="col-md-12">
                  <label for="address" class="form-label">Address</label>
                  <input type="text" class="form-control" id="address" name="address" placeholder="Stret name, number, complementary information" pattern="[a-zA-Z0-9áâéêíîóôúûüÁÂÉÊÍÎÓÔÚÛÜñÑ\s,.-]">
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    Must be a valid email.
                  </div>
                  <p style="font-size:small; color: rgb(106, 106, 108);">You may need to fill this latter.</p>
                </div>                                         
<!--Phone input-->
                <div class="col-md-6">
                  <label for="phone" class="form-label">Telephone number</label>
                  <input type="tel" class="form-control" id="phone" name="phone" placeholder="(00) 0 0000-0000" onchange="maskPhone()" pattern="\(\d{2}\)\s9\s\d{4}-\d{4}">
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    Must be a valid cellphone number.
                  </div>
                  <p style="font-size:small;color: rgb(106, 106, 108);">You may need to fill this latter.</p>
                </div>
<!--CEP-->
                <div class="col-md-5">
                  <label for="cep" class="form-label">CEP</label>
                  <input type="text" class="form-control" id="cep" name="cep" placeholder="00000-000" onchange="maskCep()" pattern="\d{5}-\d{3}">
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    Must be a valid cep.
                  </div>
                    <p style="font-size:small;color: rgb(106, 106, 108);">You may need to fill this latter.</p>
                </div>
<!-------------Button------------------>
<!--Button submit-->
                <div class="col-md-6 text-center" style="padding-bottom: 2%;">
                  <button class="btn btn-primary" style="color: rgb(155, 0, 0);background-color: rgb(255, 188, 43);" type="button" onclick="fillForm()" contextmenu="For testing the formulary" >Fill Random</button>
                </div>
                <div class="col-md-6 text-center" style="padding-bottom: 2%;">
                  <button class="btn btn-primary" type="submit">Register</button>
                </div>
              </form>
            </div>
          </div>
        </div>

        <!--Footer equaly extracted from index.html-->
        <footer class="footer mt-auto py-3 bg-light">
            <div class="container text-center">
                <span class="text-muted">&reg; Hermes A V Urquijo</span>
            </div>
        </footer>
        <!-- Include jQuery library -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
        <!-- Include Inputmask library -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.9/jquery.inputmask.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        <!--Script for form validation, it cames from Bootstrap website-->
        <script>
          //JavaScript for disabling form submissions if there are invalid fields
          (() => {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            const forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.from(forms).forEach(form => {
              form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                  event.preventDefault()
                  event.stopPropagation()
                }

                form.classList.add('was-validated')
              }, false)
            })
          })()
        </script>
        <!--Script for masking inputs-->
        <script>
          // Ensure the document is fully loaded before executing the script
          $(document).ready(function(){
            // Function to apply input mask
            function maskPhone(){
              $('#phone').inputmask('(99) 9 9999-9999');
            }
            function maskCep(){
              $('#cep').inputmask('99999-999');
            }
            function maskCpf() {
              $('#cpf').inputmask('999.999.999-99');
            }
            
            // Call mask function to apply the mask
            maskPhone();
            maskCep();
            maskCpf();
          });
        </script>
        <!--Script for filling the register Formulary-->
        <script>
          function genRandomString(length,charSet){
              var result = '';
              const lengthCharSet = charSet.length;
              for (let index = 0; index < length; index++) {
                result += charSet.charAt(Math.floor(Math.random()*lengthCharSet));
              }
              return result;
          }
          function fillForm() {
            $('#name').val(genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                                +genRandomString(4,'qwertyuiopasdfghjklzxcvbnm')
                                +" "
                                +genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                                +genRandomString(4,'qwertyuiopasdfghjklzxcvbnm')
                                +" "
                                +genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                                +genRandomString(4,'qwertyuiopasdfghjklzxcvbnm'));

            $('#password').val(genRandomString(2,'qwertyuiopasdfghjklzxcvbnm')
                                +genRandomString(2,'QWERTYUIOPASDFGHJKLZXCVBNM')
                                +genRandomString(2,'0123456789')
                                +genRandomString(2,'!@#$%¨&*()_+=-/.,?|'));
            $('#email').val(genRandomString(5,'qwertyuiopasdfghjklzxcvbnm._')
                              +'@'
                              +genRandomString(4,'qwertyuiopasdfghjklzxcvbnm')
                              +'.'
                              +genRandomString(3,'qwertyuiopasdfghjklzxcvbnm'));
            $('#cpf').val(genRandomString(11,'0123456789'));
            $('#phone').val(genRandomString(2,'0123456789')
                            +'9'
                            +genRandomString(8,'0123456789'));
            $('#address').val(genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                            +". "
                            +genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                            +genRandomString(5,'qwertyuiopasdfghjklzxcvbnm')
                            +" "
                            +genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                            +genRandomString(5,'qwertyuiopasdfghjklzxcvbnm')
                            +" "
                            +genRandomString(3,'0123456789')
                            +", "
                            +genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                            +genRandomString(5,'qwertyuiopasdfghjklzxcvbnm')
                            +" "
                            +genRandomString(1,'QWERTYUIOPASDFGHJKLZXCVBNM')
                            +genRandomString(5,'qwertyuiopasdfghjklzxcvbnm'));
          $('#cep').val(genRandomString(1,'123456789')+genRandomString(7,'0123456789'));
          $('#user_name').val(genRandomString(3,'qwertyuiopasdfghjklzxcvbnm')
                              +genRandomString(Math.floor(Math.random()*6),'qwertyuiopasdfghjklzxcvbnm0123456789._'));
          }
        </script>
    </body>
</html>
