<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
            function createGroup(){
                var group = {
                    name: document.getElementById("groupName").value
                }
                $.ajax({
                    url: "/createGroup",
                    type: "post",
                    data: group,
                    complete: completeCallBack
                });
            }
                
            function deleteGroup(groupId){
                var group = {
                    eventGroupId: groupId
                }
                $.ajax({
                    url: "/deleteGroup",
                    type: "post",
                    data: group,
                    complete: completeCallBack
                });
            }
            function createEvents(groupId) {
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
                    url: "/createEvent",
                    type: "post",
                    data: event,
                    complete: completeCallBack
                });
            }
            function deleteEvent(eventId){
                var event = {
                    eventId: eventId
                }
                $.ajax({
                    url: "/deleteEvent",
                    type: "post",
                    data: event,
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
                            <b>Event: </b>${event.name?html}
                            <b>Start Date: </b>${event.startDate.toLocalDate()} 
                            <b>Start Time: </b>${event.startDate.toLocalTime()} 
                            <b>End Date: </b>${event.endDate.toLocalDate()} 
                            <b>End Time: </b>${event.endDate.toLocalTime()} 
                            <b>Description: </b>${event.description?html}
                                MemberId: <input type="number" name="memberId" min="0"/>
                                <input type="button" value="Add" onClick="fuckYou()"/>
                            <ol>
                                <#list event.getAttendeeList() as members>
                                    <li>
                                        <b>Member: </b>${members}
                                    </li>
                                </#list>
                            </ol>
                                <input type="button" value="Delete" onClick="deleteEvent(${event.id})">
                            </li>
                    </#list>
                </ol>
            </li>
            </#list>
        </ol>
    </body>
</html>