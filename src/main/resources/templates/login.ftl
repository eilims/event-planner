<#ftl strip_whitespace = true>
<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <body>
    <h3>Login with Username and Password</h3>
        <form action='/login' method='POST'>
            <table>
                <#if RequestParameters.error??>
                    Bad Login
                </#if>
                <#if RequestParameters.logout??>
                    Logged Out
                </#if>
                <#if model.badUsername??>
                    Successful Registration!
                </#if>
                <tr><td>User:</td><td><input type='text' id='username' name='username' value=''></td></tr>
                <tr><td>Password:</td><td><input type='password' i='password' name='password'/></td></tr>
                <tr><td><input name="submit" type="submit" value="Login"/></td></tr>
                <tr><td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td></tr>
            </table>
        </form>
        <form action="http://localhost:8080/register/user.html" method="get">
            <input id="register" type="submit" value="Register New User"/>
        </form>
        <form action="http://localhost:8080/register/admin.html" method="get">
            <input id="register" type="submit" value="Register New Admin"/>
        </form>
    </body>
</html>
