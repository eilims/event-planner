<!DOCTYPE html>
<html>
    <script>
        function user(){
            document.getElementById("user").submit();
        }        
        function admin(){
            document.getElementById("admin").submit();
        }
    </script>
    <body>
        <#if model.auth == "USER">
        <form id="user" action="/userPage.html" method="Get">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
        </form>  
        <script>
        user()
        </script>
        </#if>
        <#if model.auth == "ADMIN">
        <form id="admin" action="/admin/groups.html" method="Get">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
        </form>  
        <script>
        admin()
        </script>
        </#if>
    </body>
</html>
