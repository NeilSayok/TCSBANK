<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Bank 2</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/TCS-Bank-Button.css">
    <link rel="stylesheet" href="assets/css/TCS-Bank-Footer-1.css">
    <link rel="stylesheet" href="assets/css/TCS-Bank-Footer.css">
    <link rel="stylesheet" href="assets/css/TCS-Bank-Header.css">
    <link rel="stylesheet" href="assets/css/TCS-Bank-Table.css">
</head>
<body style="display: grid;grid-template-rows: 40px auto;background-color: rgb(239,239,239);">
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("emp_name")!=null){
        response.sendRedirect("home.jsp");
    }
%>
<div style="height: 100%;width: 100%;background-image: radial-gradient(rgb(242,242,242),rgb(222,218,215));"></div>
<div style="display: flex;width: 100%;height: calc(100vh - 40px);align-items: center;justify-content: center;">
    <div style="width: 40%;height: 45%;background-color: white;border: 2px solid rgb(79,72,66);display: grid;grid-template-rows: 60px auto auto;">
        <div class="login-internal-divs" style="background-color: rgb(79,72,66);display: flex;align-items: center;">
            <h4 style="color: white;font-weight: 300;padding-left: 8px;">Login</h4>
        </div>

        <div class="login-internal-divs" style="display: flex;flex-direction: column;align-items: center;">
            <input type="text" class="login-text-input" id="uname" placeholder="UserName">
            <input type="password" class="login-text-input" id="upass" placeholder="Password"></div>
        <div class="login-internal-divs" style="display: flex;justify-content: center;align-items: center;">
            <button class="btn btn-primary login-btn" type="button" onclick="login_submit()">Login</button>
        </div>


    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="assets/js/script.js"></script>
<script type="text/javascript">
    function login_submit() {
        console.log("Hello");
        $.ajax({
            type: "post",
            url: "Login",
            data: "uname=" + $('#uname').val() + "&upass=" + $('#upass').val(),
            success: function (data) {
                if (data === "error")
                    alert("Please Check Your UserName or Password");
                else if (data==="success"){
                    window.location.href = "home.jsp";
                    $('body').fadeOut(500);
                }else{
                    alert("Error");
                }

            },
            error: function (a, b, c) {
                alert("Error");

            }
        })
    }
</script>
</body>
</html>
