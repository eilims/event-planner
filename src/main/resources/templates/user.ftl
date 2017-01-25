<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            function sendNewMember(){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var eventMember = {
                    username: document.getElementById("username").value,
                    password: document.getElementById("password").value,
                    email: document.getElementById("email").value,
                    role: "USER"    
                }
                $.ajax({
                    url: "/createMember",
                    type: "post",
                    data: eventMember,
                    headers: csrf,
                    complete: completeCallBack
                });
            }
            
            function completeCallBack(){
                window.location = "http://localhost:8080/login.html";
            }
        </script>
    </head>
    <body>
            Username: <input name="username" id="username" type="text" required/>
            Password: <input name="password" id="password" type="password" required/>
            Email: <input name="email" id="email" type="text" required/>
            <input type="button" value="Submit" onClick="sendNewMember()"/>
    </body>
</html>
