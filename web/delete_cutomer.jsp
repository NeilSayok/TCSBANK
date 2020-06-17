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
    <div style="display: flex;justify-content: center;height: 100%;width: 100%;background-image: radial-gradient(rgb(242,242,242),rgb(222,218,215));">
        <h4>Delete Customer</h4>
    </div>
    <div style="display: flex;width: 100%;height: calc(100vh - 40px);align-items: center;justify-content: center;">
        <div class="container create-customer">
            <div class="row">
                <div class="col">
                    <p class="create-customer-fieldtext">SSN ID:<span style="color: red;"></span></p>
                </div>
                <div class="col" style="align-items: center;"><input type="number" class="createcustomer-input non-neg-dec" pattern="\d*" maxlength="9" oninput="on_input(this)" onfocusout="inputValidate(this)"></div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="create-customer-fieldtext">Customer ID:</p>
                </div>
                <div class="col" style="align-items: center;"><input type="number" class="createcustomer-input non-neg-dec" pattern="\d*" maxlength="9" oninput="on_input(this)" onfocusout="inputValidate(this)"></div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="create-customer-fieldtext">Customer Name<span style="color: red;"></span></p>
                </div>
                <div class="col" style="align-items: center;"><input type="text" class="createcustomer-input" x="/*line-height: .1em;*/height: 1.5em;"></div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="create-customer-fieldtext">Age</p>
                </div>
                <div class="col" style="align-items: center;"><input type="number" class="createcustomer-input non-neg-dec" pattern="\d*" maxlength="3" oninput="on_input(this)" onfocusout="inputValidate(this)"></div>
            </div>
            <div class="row">
                <div class="col">
                    <p class="create-customer-fieldtext">Address</p>
                </div>
                <div class="col" style="align-items: center;"><input type="text" class="createcustomer-input" style="/*line-height: .1em;*/height: 1.5em;"></div>
            </div>
            <div class="row" style="/*text-align: center;*/">
                <div class="col" style="text-align: right;margin-right: 0px;"><button class="btn btn-primary tcs-button create-customer-btn" type="button" style="margin-right: 0px;color: rgb(239,239,239);border-radius: 4px;">Confirm Delete</button></div>
                <div class="col" style="text-align: left;margin-left: 0px;"><button class="btn btn-primary login-btn" type="button" style="width: 90%;">Cancel</button></div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="assets/js/script.js"></script>
</body>

</html>