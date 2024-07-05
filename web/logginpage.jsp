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
              <form class="row g-3 needs-validation" style="background-color: rgb(196, 230, 249);border-radius: 10%;"  method="POST" action="logginconfirmation.jsp" novalidate>
                <p style="font-size:x-large; color: rgb(7, 1, 95);">Loggin account</p>
<!-------------Required------------------>
<!--User name input-->
                <div class="col-md-12">
                  <label for="user_name" class="form-label">User name</label>
                  <input type="text" class="form-control" id="user_name" name="user_name" placeholder="Set an User Name" required pattern="\w{2,20}">
                  <div class="invalid-feedback">
                    Did you forgot your user name. <a href="#">Click here to reset</a>
                  </div>
                </div>
<!--Password input-->
                <div class="col-md-12">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="Password" required><!-- pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}">-->
                  <div class="valid-feedback">
                    Looks good!
                  </div>
                  <div class="invalid-feedback">
                    Did you forgot your password. <a href="#">Click here to reset</a>
                  </div>
                  <div class="alert alert-danger" role="alert" hidden>
                    A simple danger alert—check it out!
                  </div>      
                </div>
<!-------------Button------------------>
<!--Button submit-->
                <div class="col-md-12 text-center" style="padding-bottom: 2%;">
                  <button class="btn btn-primary" type="submit">Loggin</button>
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
    </body>
</html>
