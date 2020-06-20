<%@ page import="neilsayok.github.io.Database.DAO" %>
<%@ page import="neilsayok.github.io.Models.State" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html style="position: relative;min-height: 100%;">

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

<body class="base-body" style="display: grid;grid-template-rows: 120px auto 220px;">


<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("emp_name") == null) {
        response.sendRedirect("index.jsp");
    }
%>


<header style="height: 120px;width: 100%;background-color: rgb(27,27,26);position: relative;">
    <div style="padding-top: 20px;">
        <p style="margin-left: 10%;color: rgb(255,215,0);font-weight: 700;font-size: x-large;display: inline;">
            FedChoice</p>
        <p style="display: inline;font-weight: 700;font-size: x-large;color: rgb(241,241,241);">&nbsp;Bank</p>
        <div style="width: 100%;text-align: center;position: absolute;bottom: 0;left: 0;display: inline-block;">
            <ul class="nav nav-tabs"
                style="width: 80%;text-align: center;margin: auto;/*position: absolute;*/top: 0;background-color: rgb(255,215,0);">
                <li class="nav-item">
                    <a class="nav-link active" href="home.jsp">Home</a>
                </li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown"
                                                 aria-expanded="false" href="#">Customer Management</a>
                    <div class="dropdown-menu" role="menu">
                        <a class="dropdown-item" role="presentation" href="create_customer_screen.jsp">Create
                            Customer</a>
                        <a class="dropdown-item" role="presentation" href="customer-search.jsp?job=upadate_cust">Update Customer</a>
                        <a class="dropdown-item" role="presentation" href="customer-search.jsp?job=delete_cust">Delete Customer</a>
                        <a class="dropdown-item" role="presentation" href="customer_status.jsp">Customer Status</a>
                    </div>
                </li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown"
                                                 aria-expanded="false" href="#">Account Management</a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation"
                                                              href="create_account.jsp">Create Account
                    </a><a class="dropdown-item" role="presentation" href="delete_account.jsp">Delete Account</a><a
                            class="dropdown-item" role="presentation" href="account_status.jsp">Account Status</a></div>
                </li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown"
                                                 aria-expanded="false" href="#">Status Details</a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">First
                        Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a
                            class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                </li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown"
                                                 aria-expanded="false" href="#">Account Operations</a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">First
                        Item</a><a class="dropdown-item" role="presentation" href="#">Second Item</a><a
                            class="dropdown-item" role="presentation" href="#">Third Item</a></div>
                </li>
                <li class="nav-item"><a onclick="logout()" class="nav-link" href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</header>

<div class="main-div" style="width: 100%;height: 100%;">
    <h1 class="item-heading" style="text-align: center;padding-bottom: 16px;padding-top: 16px;font-size: x-large;">
        Create Customer Screen</h1>
    <div class="container create-customer">
        <div class="row">
            <div class="col">
                <p class="create-customer-fieldtext">Customer SSN ID<span style="color: red;">*</span></p>
            </div>
            <div class="col" style="align-items: center;"><input id="ssn_id_input" type="number"
                                                                 class="createcustomer-input non-neg-dec"
                                                                 pattern="\d*" maxlength="9" oninput="on_input(this)"
                                                                 onfocusout="inputValidate(this)"></div>
        </div>
        <div class="row">
            <div class="col">
                <p class="create-customer-fieldtext">Customer Name<span style="color: red;">*</span></p>
            </div>
            <div class="col" style="align-items: center;"><input id="cust_name_input" type="text"
                                                                 class="createcustomer-input"
                                                                 x="/*line-height: .1em;*/height: 1.5em;"></div>
        </div>
        <div class="row">
            <div class="col">
                <p class="create-customer-fieldtext">Age<span style="color: red;">*</span></p>
            </div>
            <div class="col" style="align-items: center;"><input id="age_input" type="number"
                                                                 class="createcustomer-input non-neg-dec"
                                                                 pattern="\d*" maxlength="3" oninput="on_input(this)"
                                                                 onfocusout="inputValidate(this)"></div>
        </div>
        <div class="row">
            <div class="col">
                <p class="create-customer-fieldtext">Address<span style="color: red;">*</span></p>
            </div>
            <div class="col" style="align-items: center;"><input id="address_input" type="text"
                                                                 class="createcustomer-input"
                                                                 style="/*line-height: .1em;*/height: 1.5em;"></div>
        </div>
        <div class="row">
            <div class="col" style="max-width: 191px;">
                <p class="create-customer-fieldtext">State<span style="color: red;">*</span></p>
            </div>
            <div class="col" style="align-items: center;">
                <select onchange="setStateSelect(this.value)" id="state_select" style="margin-left: 0px;">
                    <option value="" selected disabled hidden>--Select State--</option>
                    <%
                        DAO dao = new DAO();
                        for (State s : dao.getAllState()) {
                    %>
                    <option value="<%=s.getId()%>"><%=s.getName()%>
                    </option>
                    <%}%>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col" style="max-width: 192px;">
                <p class="create-customer-fieldtext">City<span style="color: red;">*</span></p>
            </div>
            <div class="col" style="align-items: center;">
                <select id="city_select" style="margin-left: 0px;">
                    <option value="" selected disabled hidden>--Select City--</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p style="color: red;font-weight: 700;">(*) Fields are compulsory</p>
            </div>
        </div>
        <div class="row" style="/*text-align: center;*/">
            <div class="col" style="text-align: right;margin-right: 0px;">
                <button id="submit_btn" onclick="createCustomer()"
                        class="btn btn-primary tcs-button create-customer-btn" type="button" style="margin-right: 0px;">
                    Submit
                </button>
            </div>
            <div class="col" style="text-align: left;margin-left: 0px;">
                <button class="btn btn-primary tcs-button create-customer-btn" type="button" onclick="location.reload()"
                        style="margin-left: 0px;">Reset
                </button>
            </div>
        </div>
    </div>
</div>

<footer class="footer">
    <div style="width: 100%;height: 100%;display: grid;grid-template-rows: 3% 75% 22%;">
        <div class="footer-row-divs" style="background-color: rgb(255,215,0);margin: 0px;border-width: 0px;"></div>
        <div class="footer-row-divs"
             style="display: grid;grid-template-columns: 50% auto auto;width: 80%;height: 100%;margin: auto;">
            <div class="footer-text-divs">
                <div class="div-footer-internal">
                    <h3 class="footer-text-heading">About Us</h3>
                </div>
                <div class="div-footer-internal">
                    <p class="footer-text-paragraph"><br>FedChoice Bank was founded on 14th June 2016 with the objective
                        of providing with the detail services based on Retail Banking operations The Retail Internet
                        Banking of FedChoice Bank offers a plethora of products and services, to cater its customers by
                        providing certain animus services with an easy evolving offers and ways to do the required job
                        without hurdling the process</p>
                </div>
            </div>
            <div class="footer-text-divs">
                <div>
                    <h3 class="footer-text-heading">Services</h3>
                </div>
                <div>
                    <p class="footer-text-paragraph">
                        <br>Retail and Consumer Banking
                        <br>Personal Internet Banking
                        <br>Corporate Internet Banking
                        <br>Debit and Credit Card
                    </p>
                </div>
            </div>
            <div class="footer-text-divs">
                <div>
                    <h3 class="footer-text-heading">Contact Us</h3>
                </div>
                <div>
                    <p class="footer-text-paragraph">
                        <br>Email: customer.service@fedchoice.com
                        <br>Contact No : 02242406778, 02254567890
                        <br>Address Corporate Office, Madame Cama Road, Nariman Point, Mumbai, Maharashtra 400021</p>
                </div>
            </div>
        </div>
        <div class="footer-row-divs"
             style="background-color: rgb(39,39,39);display: grid;grid-template-columns: 50% 50%;">
            <div class="copytightdiv-containers"><p style="font-weight: 600;margin: auto;">Copyright&copy; All rights
                reserved by<span style="color: rgb(255,215,0);"> FedChoice Bank</span></p></div>
            <div class="copytightdiv-containers">
                <div>
                    <p style="color: rgb(255,215,0);display: inline;">Connect Us</p><a data-toggle="tooltip"
                                                                                       data-bs-tooltip=""
                                                                                       href="https://facebook.com/"
                                                                                       style="margin-left: 8px;"
                                                                                       title="Facebook"><i
                        class="icon ion-social-facebook footer-icons"></i></a><a data-toggle="tooltip"
                                                                                 data-bs-tooltip=""
                                                                                 href="https://twitter.com/"
                                                                                 title="Twitter"><i
                        class="icon ion-social-twitter footer-icons" title="Twitter"></i></a><a data-toggle="tooltip"
                                                                                                data-bs-tooltip=""
                                                                                                href="https://www.google.com/"
                                                                                                title="Google+"><i
                        class="icon ion-social-googleplus footer-icons" title="Google+"></i></a>
                    <a
                            data-toggle="tooltip" data-bs-tooltip="" href="https://in.linkedin.com/" title="Linkdin"><i
                            class="icon ion-social-linkedin footer-icons"></i></a><a data-toggle="tooltip"
                                                                                     data-bs-tooltip=""
                                                                                     href="https://www.instagram.com/"
                                                                                     title="Instagram"><i
                        class="icon ion-social-instagram footer-icons"></i></a></div>
            </div>
        </div>
    </div>
</footer>

<script>
    //ssn_id_input cust_name_input age_input address_input state_select city_select submit_btn
    function createCustomer() {

        if (!$('#ssn_id_input').val() || $('#ssn_id_input').val().length !== 9) {
            alert("SSN ID is empty or half filled.");
        } else if (!$('#cust_name_input').val()) {
            alert("Please Enter Customer Name.");
        } else if (!$('#age_input').val() || $('#age_input').val() < 16) {
            alert("Please enter a valid age.");
        } else if (!$('#address_input').val()) {
            alert("Address field is empty.");
        } else if (!$('#state_select option:selected').val()) {
            alert("Select state.");
        } else if (!$('#city_select option:selected').val()) {
            alert("Select city");
        } else {

            let data = "ssn_id=" + $('#ssn_id_input').val() + "&cust_name=" + $('#cust_name_input').val()
                + "&cust_age=" + $('#age_input').val() + "&cust_add=" + $('#address_input').val()
                + "&cust_city=" + $('#city_select option:selected').val()
                + "&cust_state=" + $('#state_select option:selected').val()
                + "&cust_msg=Account creation initiated successfully";

            $.ajax({
                type: "post",
                url: "CreateCustomer",
                data: data,

                success: function (data) {
                    if (data === "success") {
                        console.log("Superb");
                        if (!window.confirm("Account creation initiated successfully\nPress Ok to go to view Customer Status Page\nPress Cancel to go to Home page")) {
                            window.location.href = "home.jsp";
                        } else {
                            window.location.href = "customer_status.jsp";
                        }
                    } else {
                        console.log("Error");
                        alert(data);
                    }
                },
                error: function (a, b, c) {
                    alert("Please Try Again");
                }

            })
        }
    }

    function setStateSelect(value) {
        $('#city_select').empty();
        $('#city_select').append('<option value="" selected disabled hidden>--Loading--</option>');
        $.ajax({
            type: "get",
            url: "GetCities",
            data: "state_id=" + value,
            success: function (data) {
                if (data === "error")
                    alert("Please Relogin");
                else {
                    try {

                        let jsonData = JSON.parse(data);
                        if (jsonData.length > 0) {
                            $('#city_select').empty();
                            $('#city_select').prop('disabled', false);
                            $('#city_select').append('<option value="" selected disabled hidden>--Select City--</option>');
                            jsonData.forEach(function (item, index) {
                                //console.log(index, '<option value="' + item.id + '" >' + item.city_name + '</option>');
                                $('#city_select').append('<option value="' + item.id + '" >' + item.city_name + '</option>');
                            });
                        } else {
                            $('#city_select').empty();
                            $('#city_select').prop('disabled', true);
                            $('#city_select').append('<option value="-1" selected disabled hidden>--No City To Select--</option>');
                        }

                    } catch (e) {
                        console.log(e);
                    }
                }

            },
            error: function (a, b, c) {
                alert("Error");

            }
        });


    }
</script>


</body>

</html>