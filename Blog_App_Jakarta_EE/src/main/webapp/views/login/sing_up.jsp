<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Form-v2 by Colorlib</title>
    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- Font-->
    <link rel="stylesheet" type="text/css" href="css/roboto-font.css">
    <link rel="stylesheet" type="text/css" href="fonts/line-awesome/css/line-awesome.min.css">
    <!-- Jquery -->
    <link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
    <!-- Main Style Css -->
    <style><%@ include file="../../registerStyle.css"%></style>

</head>
<body class="form-v2">
<div class="page-content">
    <div class="form-v2-content">
        <div class="form-left">
<%--            <img src="../images/form-v2.jpg" alt="form">--%>
<%--            <div class="text-1">--%>
<%--                <p>Bring Your Music Along<span>try Unlimited</span></p>--%>
<%--            </div>--%>
<%--            <div class="text-2">--%>
<%--                <p><span>$9.99</span>/ Month</p>--%>
<%--            </div>--%>
        </div>
        <form class="form-detail" action="register.do" method="POST" id="myform">
            <h2>Registration Form</h2>
            <div class="form-row">
                <label >Full Name:</label>
                <input type="text" name="full_name" id="full_name" class="input-text" placeholder="ex: Lindsey Wilson">
            </div>
            <div class="form-row">
                <label for="your_email">Your Email:</label>
                <input type="text" name="your_email" id="your_email" class="input-text" required pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}">
            </div>
            <div class="form-row">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" class="input-text" required>
            </div>
            <div class="form-row">
                <label >Confirm Password:</label>
                <input type="password" name="confirm_password" id="confirm_password" class="input-text" required>
            </div>
            <div class="form-row-last">
                <input type="submit" name="register" class="register" value="Register">
            </div>
        </form>
    </div>
</div>

</body>
</html>