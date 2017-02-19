<!DOCTYPE html>
<html>
<head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            var csrf = {
                "${_csrf.headerName?js_string}": "${_csrf.token?js_string}"
            }
        </script>
    <script src="/js/adminPage.js"></script>
    </head>
    <body>
            <form action="/logout" method="POST">
                <input type="submit" value="Logout"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <div name="message"></div>
            Group Name:<input type="text" id="groupName"/>
            <input type="button" value="Save" onClick="createGroup('${model.username}')"/>
        <ol>
            <#list model.groupList as group>
            <li>
                <b>Group Name: </b>${group.groupName?html}
                <input type="button" value="Delete Group" onClick="deleteGroup(${group.groupId})"/>
                    <table id="${group.groupName}">
                        <tr id="adminRow">
                            <th><b> Admin Username: </b></th><td id="adminCell"><input type="text" id="adminUsername" name="adminUsername"/></td>
                            <td><input type="button" value="Add Admin" onClick="addGroupAdmin('${group.groupName}', ${group.groupId})"/></td>
                        </tr>
                        <tr id="usernameRow">
                            <th><b>Member Username: </b></th><td id="usernameCell"><input type="text" id="memberUsername" name="memberUsername"/></td>
                        <td><input type="button" value="Add Member" onClick="addGroupMember('${group.groupName}', ${group.groupId})"/></td>
                        </tr>
                        <tr id="nameRow">
                            <th>Event Name:</th> <td id="nameCell"><input type="text" class="long" id="eventName" required/><td>
                        </tr>
                        <tr id="desRow">
                            <th>Description:</th> <td id="desCell"><textarea class="description" id="description" name="description" required></textarea>
                        </tr>
                        <tr id="locRow">
                            <th>Location:</th> <td id="locCell"><input type="text" class="long" id="location" name="location" required></td>
                        </tr>
                        <tr id="strRow">
                            <th>Start Time: </th><td id="strCell"><input type="datetime-local" id="startDate" name="startDate" max="9999-12-31T00:00" required/></td>
                        </tr>
                        <tr id="endRow">
                            <th>End Time:</th> <td id="endCell"><input type="datetime-local" id="endDate"name="endDate" max="9999-12-31T00:00" required/></td>
                        </tr>
                        <tr id="button">
                        <td><input type="button" value="Save" onClick="createEvents('${group.groupName}', ${group.groupId})"/></td>
                        </tr>
                        </table>
                            <ol>
                                <#list group.getGroupMemberList() as member>
                                    <li>
                                        <tr id="member.username"><th><b>Member: </b></th><td>${member.username}</td>
                                        <td><input type="button" value="Remove Member" onClick="removeGroupMember('${group.groupId}','${member.username}')"/></td></tr>
                                    </li>
                                </#list>
                            </ol>
                <ol>
                    <#list group.getGroupEventList() as event>
                        <li>
                            <table id="${event.eventId}">
                            <tr><th><b>Event: </b></th><td>${event.eventName?html}</td></tr>
                            <tr><th><b>Start Date: </b></th><td>${event.startDate.toLocalDate()} </td></tr>
                            <tr><th><b>Start Time: </b></th><td>${event.startDate.toLocalTime()} </td></tr>
                            <tr><th><b>End Date: </b></th><td>${event.endDate.toLocalDate()} </td></tr>
                            <tr><th><b>End Time: </b></th><td>${event.endDate.toLocalTime()} </td></tr>
                            <tr><th><b>Description: </b></th><td>${event.description?html}</td></tr>
                            <tr><th><b>Location: </b></th><td>${event.location?html}</td></tr>
                            </br>
                            <tr id="usernameRow"><th><b>Member Username: </b></th><td id="usernameCell"><input type="text" id="memberUsername" name="memberUsername"/></td>
                            <td><input type="button" value="Add Member" onClick="addEventMember(${event.eventId})"/></td> </tr>
                            <ol>
                                <#list event.getEventMemberList() as member>
                                    <li>
                                        <tr id="member.username"><th><b>Member: </b></th><td>${member.username}</td>
                                        <td><input type="button" value="Remove Member" onClick="removeEventMember(${event.eventId},'${member.username}')"/></td></tr>
                                    </li>
                                </#list>
                            </ol>
                            <tr><td><input type="button" value="Delete Event" onClick="deleteEvent(${event.eventId})"></td></tr>
                            </table>    
                        </li>       
                    </#list>
                </ol>
            </li>
            </#list>
        </ol>
    </body>
</html>
