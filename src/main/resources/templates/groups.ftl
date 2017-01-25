<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            function createGroup(){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var group = {
                    name: document.getElementById("groupName").value,
                }
                $.ajax({
                    url: "/admin/group/createGroup",
                    type: "post",
                    data: group,
                    headers: csrf,
                    complete: completeCallBack
                });
            }
                
            function deleteGroup(groupId){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var group = {
                    eventGroupId: groupId
                }
                $.ajax({
                    url: "/admin/group/deleteGroup",
                    type: "post",
                    data: group,
                    headers: csrf,          
                    complete: completeCallBack
                });
            }
            function createEvents(groupId) {
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var event = {
                    name: document.getElementById(groupId).rows.namedItem("nameRow").cells.namedItem("nameCell").children[0].value,
                    eventGroupId: groupId,
                    description: document.getElementById(groupId).rows.namedItem("desRow").cells.namedItem("desCell").children[0].value,
                    location: document.getElementById(groupId).rows.namedItem("locRow").cells.namedItem("locCell").children[0].value,
                    startDate: document.getElementById(groupId).rows.namedItem("strRow").cells.namedItem("strCell").children[0].value,
                    endDate: document.getElementById(groupId).rows.namedItem("endRow").cells.namedItem("endCell").children[0].value,
                }
                if (event.name == "" || event.description == "" || event.location == "" || startDate == "" || endDate == "") {
                    alert("Please fill out all fields");
                    return;
                }
                $.ajax({
                    url: "/admin/event/createEvent",
                    type: "post",
                    data: event,
                    headers: csrf,            
                    complete: completeCallBack
                });
            }
            function deleteEvent(eventId){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var event = {
                    eventId: eventId
                }
                $.ajax({
                    url: "/admin/event/deleteEvent",
                    type: "post",
                    data: event,
                    headers: csrf,            
                    complete: completeCallBack
                });
            }
            function addMember(eventId){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var data = {
                    eventId: eventId,
                    username: document.getElementById(eventId).rows.namedItem("usernameRow").cells.namedItem("usernameCell").children[0].value
                }
                $.ajax({
                    url: "/admin/event/addMember",
                    type: "post",
                    data: data,
                    headers: csrf,
                    complete: completeCallBack
                });
            }
            function removeMember(eventId, username){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var data = {
                    eventId: eventId,
                    username: username
                }
                $.ajax({
                    url: "/admin/event/removeMember",
                    type: "post",
                    data: data,
                    headers: csrf,
                    complete: completeCallBack
                });
            }
            function completeCallBack(){
                location.reload();
            }
            function fuckYou(){
                alert("Fuck You");
            }
        </script>
    </head>
    <body>
            <form action="/logout" method="POST">
                <input type="submit" value="Logout"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
            </form>  
            Group Name:<input type="text" id="groupName"/>
            <input type="button" value="Save" onClick="createGroup()"/>
        <ol>
            <#list model.groupList as group>
            <li>
                <b>Group Name: </b>${group.name?html}
                <input type="button" value="Delete Group" onClick="deleteGroup(${group.id})"/>
                    <table id="${group.id}">
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
                        <td><input type="button" value="Save" onClick="createEvents(${group.id})"/></td>
                        </tr>
                        </table>
                <ol>
                    <#list group.getEventList() as event>
                        <li>
                            <table id="${event.id}"
                            <tr><th><b>Event: </b></th><td>${event.name?html}</td></tr>
                            <tr><th><b>Start Date: </b></th><td>${event.startDate.toLocalDate()} </td></tr>
                            <tr><th><b>Start Time: </b></th><td>${event.startDate.toLocalTime()} </td></tr>
                            <tr><th><b>End Date: </b></th><td>${event.endDate.toLocalDate()} </td></tr>
                            <tr><th><b>End Time: </b></th><td>${event.endDate.toLocalTime()} </td></tr>
                            <tr><th><b>Description: </b></th><td>${event.description?html}</td></tr>
                            <tr><th><b>Location: </b></th><td>${event.location?html}</td></tr>
                            </br>
                            <tr id="usernameRow"><th><b>Member Username: </b></th><td id="usernameCell"><input type="text" id="memberUsername" name="memberUsername"/></td>
                            <td><input type="button" value="Add Member" onClick="addMember(${event.id})"/></td> </tr>
                            <tr><td><input type="button" value="Delete Event" onClick="deleteEvent(${event.id})"></td></tr>
                            <ol>
                                <#list event.getAttendeeList() as member>
                                    <li>
                                        <tr id="member.username"><th><b>Member: </b></th><td>${member.username}</td>
                                        <td><input type="button" value="Remove Member" onClick="removeMember(${event.id},'${member.username}')"/></td></tr>
                                    </li>
                                </#list>
                            </ol>
                                
                            </li>
                            </table>
                    </#list>
                </ol>
            </li>
            </#list>
        </ol>
    </body>
</html>