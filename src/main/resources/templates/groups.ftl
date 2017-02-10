<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            function createGroup(username){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var group = {
                    name: document.getElementById("groupName").value,
                    username: username
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
            function createEvents(groupName, groupId) {
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var event = {
                    name: document.getElementById(groupName).rows.namedItem("nameRow").cells.namedItem("nameCell").children[0].value,
                    groupId: groupId,
                    description: document.getElementById(groupName).rows.namedItem("desRow").cells.namedItem("desCell").children[0].value,
                    location: document.getElementById(groupName).rows.namedItem("locRow").cells.namedItem("locCell").children[0].value,
                    startDate: document.getElementById(groupName).rows.namedItem("strRow").cells.namedItem("strCell").children[0].value,
                    endDate: document.getElementById(groupName).rows.namedItem("endRow").cells.namedItem("endCell").children[0].value,
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
            function addGroupMember(groupName, groupId, username){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var data = {
                    groupId: groupId,
                    username: document.getElementById(groupName).rows.namedItem("usernameRow").cells.namedItem("usernameCell").children[0].value
                }
                $.ajax({
                    url: "/admin/group/addMember",
                    type: "post",
                    data: data,
                    headers: csrf,
                    complete: completeCallBack
                });
            }
            function removeGroupMember(groupId, username){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var data = {
                    groupId: groupId,
                    username: username
                }
                $.ajax({
                    url: "/admin/group/removeMember",
                    type: "post",
                    data: data,
                    headers: csrf,
                    complete: completeCallBack
                });
            }  
            function completeCallBack(){
                location.reload();
            }
        </script>
    </head>
    <body>
            <form action="/logout" method="POST">
                <input type="submit" value="Logout"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
            </form>  
            Group Name:<input type="text" id="groupName"/>
            <input type="button" value="Save" onClick="createGroup('${model.username}')"/>
        <ol>
            <#list model.groupList as group>
            <li>
                <b>Group Name: </b>${group.groupName?html}
                <input type="button" value="Delete Group" onClick="deleteGroup(${group.groupId})"/>
                    <table id="${group.groupName}">
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
                            <td><input type="button" value="Add Member" onClick="addMember(${event.eventId})"/></td> </tr>
                            <ol>
                                <#list event.getEventMemberList() as member>
                                    <li>
                                        <tr id="member.username"><th><b>Member: </b></th><td>${member.username}</td>
                                        <td><input type="button" value="Remove Member" onClick="removeMember(${event.eventId},'${member.username}')"/></td></tr>
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