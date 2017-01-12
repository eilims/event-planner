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
            <form name="event" action="addEvent/${group.id}" method="post">
                Event Name:<input type="text" name="name"/>
                <input type="submit" value="Save Event"/>
            <ol>
                <#list group.getEventList() as event>
                <li>
                    <b>Event Name: </b>${event.name?html}
                    </li>
                </#list>
                </ol>
            </li>
        </#list>
        </ol>
        </body>
    </html>
