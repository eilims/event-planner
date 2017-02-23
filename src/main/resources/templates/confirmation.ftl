<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        var csrf = {
            "${_csrf.headerName?js_string}": "${_csrf.token?js_string}"
        }
    </script>
    <script src="/js/confirmation.js"></script>
</head>
<body>
<#if model.activated == true>
Thank you for confirming your account!
You will be redirected to the login page shortly!
<script>
    setUserEnabled(${model.id});
</script>

<#else>
You shouldn't be here!
Begone to the login page!
</#if>
<script>
    setTimeout(function () {
        window.location = "http://localhost:8080/login.html";
    }, 2500);
</script>
</body>
</html>