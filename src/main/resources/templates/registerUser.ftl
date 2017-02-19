<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            var csrf = {
                "${_csrf.headerName?js_string}": "${_csrf.token?js_string}"
            }
        </script>
        <script src="/js/register.js"></script>
    </head>
    <body>
            Username: <input name="username" id="username" type="text" required/>
            </br>
            Password: <input name="password" id="password" type="password" required/>
            </br>
            Email: <input name="email" id="email" type="text" required/>
            </br>
            <input type="button" value="Submit" onClick="sendNewMember('USER')"/>
            </br>
            <div id="error"></div>
    </body>
</html>
