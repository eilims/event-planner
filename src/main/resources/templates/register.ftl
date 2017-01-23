<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            function sendNewMember(){
                var eventMember = {
                    username: document.getElementById("username").value,
                    password: document.getElementById("password").value,
                    email: document.getElementById("email").value
                }
                $.ajax({
                    url: "/createMember",
                    type: "post",
                    data: eventMember,
                    complete: completeCallBack
                });
            }
            
            function completeCallBack(){
                window.location = "http://localhost:8080/login.html";
            }
        </script>
    </head>
    <body>
        <form>
            Username: <input name="username" id="username" type="text" required/>
            Password: <input name="password" id="password" type="password" required/>
            Email: <input name="email" id="email" type="text" required/>
            <input type="button" value="Submit" onClick="sendNewMember()"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </body>
</html>
