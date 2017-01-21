<#ftl strip_whitespace = true>
<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <body>
    <h3>Login with Username and Password</h3>
        <form action='/login' method='POST'>
            <table>
                <#if model??>
                <#if model.error == true>
                    Bad Login
                </#if>
                <#if model.logout == true>
                    Logged Out
                </#if>
                </#if>
                <tr><td>User:</td><td><input type='text' id='username' name='username' value=''></td></tr>
                <tr><td>Password:</td><td><input type='password' i='password' name='password'/></td></tr>
                <tr><td><input name="submit" type="submit" value="Login"/></td></tr>
            </table>
        </form>
    </body>
</html>
