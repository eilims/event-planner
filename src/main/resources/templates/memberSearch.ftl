
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript">
            function parseQuery()
            {
                
               
            }
            function completeCallBack(){
            }
            function submitNames(list)
            {
                var csrf = {
                   "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
               }
                $.ajax({
                   url: "/admin/event/addMember",
                   type: "post",
                   data: list,
                   headers: csrf,
                   complete: completeCallBack
               }); 
            }
        </script>
    </head>
        <body>
            <ol>
                <form>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <#list model.memList as member>
                    <li>
                        member: ${member.username}
                        <input type="checkbox" name="${member.username}"/>
                    </li>
                    </#list>
                    <input type="submit" value="Add" onclick="parseQuery()"/>
                </form>
            </ol>
        </body>
    </html>
