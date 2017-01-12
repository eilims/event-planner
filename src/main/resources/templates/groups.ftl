<!DOCTYPE html>
<html>
    <body>
    <form name="group" action="createGroup" method="post">
        Group Name:<input type="text" name="name"/>
        <input type="submit" value="Save"/>
        </form>
    <ol>
        <#list model.groupList as group>
        <li>
            <b>Group Name: </b>${group.name?html}
            </li>
        </#list>
        </ol>
        </body>
    </html>
