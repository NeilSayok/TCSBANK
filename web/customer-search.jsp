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

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="assets/js/script.js"></script>
</head>

<body style="display: grid;grid-template-rows: 40px auto;background-color: rgb(239,239,239);">
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("emp_name") == null) {
        response.sendRedirect("index.jsp");
    }
    String job = "";
    if(request.getParameter("job").equals("upadate_cust")){
        job = "Updated";
    }else if (request.getParameter("job").equals("delete_cust")){
        job = "Deleted";
    }
%>
    <div style="display: flex;justify-content: center;height: 100%;width: 100%;background-image: radial-gradient(rgb(242,242,242),rgb(222,218,215));">
        <h4>Search Customer to be <%=job%></h4>
    </div>
    <div style="display: flex;width: 100%;height: calc(100vh - 40px);align-items: center;justify-content: center;">
        <div class="container create-customer">
            <div class="row">
                <div class="col" style="padding-bottom: 20px;">
                    <p class="create-customer-fieldtext" style="text-align: center;">Either one of the details should be entered.<span style="color: red;"></span></p>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="create-customer-fieldtext">Enter SSN ID</p>
                </div>
                <div class="col" style="align-items: center;"><input id="ssnid_inp" type="number" class="createcustomer-input non-neg-dec" pattern="\d*" maxlength="9" oninput="on_input(this)" onfocusout="inputValidate(this)"></div>
            </div>
            <div class="row">
                <div class="col" style="padding: 20px 0px;">
                    <p class="create-customer-fieldtext" style="text-align: center;">OR</p>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="create-customer-fieldtext">Enter Customer ID<span style="color: red;"></span></p>
                </div>
                <div class="col" style="align-items: center;"><input id="custid_inp" type="number" class="createcustomer-input non-neg-dec" pattern="\d*" maxlength="9" oninput="on_input(this)" onfocusout="inputValidate(this)"></div>
            </div>
            <div class="row" style="/*text-align: center;*/">
                <div class="col" style="text-align: center;margin-right: 0px;padding-top: 20px;"><button class="btn btn-primary tcs-button create-customer-btn" type="button" onclick="continueJob()" style="margin-right: 0px;color: rgb(239,239,239);border-radius: 4px;width: 40%;">View</button></div>
            </div>
        </div>
    </div>

<script>
    function continueJob(){
        //console.log($("#ssnid_inp").val());
        //console.log($("#custid_inp").val());
        if ($("#ssnid_inp").val() || $("#custid_inp").val()){
            if ($("#ssnid_inp").val() && $("#ssnid_inp").val().length !== 9){
                alert("Please Enter a Valid SSN ID");
            }else{
                $.ajax({
                    type: "post",
                    url : "SearchCustomer",
                    data : "ssnid="+$("#ssnid_inp").val()+"&custid="+$("#custid_inp").val(),
                    success: function (data) {

                        let json = JSON.parse(JSON.parse(data).toString());
                        if (json['found']===false){
                            alert("No customer with the respective ID found");
                        }else{
                            <%
                                if(request.getParameter("job").equals("upadate_cust")){%>
                                    window.location.href = "update_customer.jsp?custid="+json['cust_id']+"&ssnid="+json['ssn_id'];
                                <%}else if (request.getParameter("job").equals("delete_cust")){%>
                                    window.location.href = "delete_customer.jsp?custid="+json['cust_id']+"&ssnid="+json['ssn_id'];
                            <%}
                        %>

                        }
                    },
                    error: function (a,b,c) {
                        alert("Error");
                    }
                });
            }
        }else{
            alert("Please Enter a SSN ID or Customer ID.");
        }

    }
</script>

</body>

</html>