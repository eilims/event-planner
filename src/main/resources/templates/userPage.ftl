<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>
        function removeMember(eventId, username){
                var csrf = {
                    "${_csrf.headerName?js_string}" : "${_csrf.token?js_string}"
                }
                var data = {
                    eventId: eventId,
                    username: username
                }
                $.ajax({
                    url: "/user/removeMember",
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
        Welcome ${model.username}!
        <#list model.groupList as group>
            <table id="${group.groupName}">
                <ol>
                    <tr> <th>Group Name:</th><td>${group.groupName}</td></tr>
                    <tr><th>Members:</th></tr>
                    <#list group.getGroupMemberList() as member>
                        
                            <tr id="member.username"><th></th><td>${member.username}</td></tr>
                        
                    </#list>
                </ol>
            </table>
                <ol>
                    <#list group.getGroupEventList() as event>
                        <#if event.eventMemberList?seq_contains(model.user)>
                            <table id="${event.eventId}">
                            <tr><th><b>Event: </b></th><td>${event.eventName?html}</td></tr>
                            <tr><th><b>Start Date: </b></th><td>${event.startDate.toLocalDate()} </td></tr>
                            <tr><th><b>Start Time: </b></th><td>${event.startDate.toLocalTime()} </td></tr>
                            <tr><th><b>End Date: </b></th><td>${event.endDate.toLocalDate()} </td></tr>
                            <tr><th><b>End Time: </b></th><td>${event.endDate.toLocalTime()} </td></tr>
                            <tr><th><b>Description: </b></th><td>${event.description?html}</td></tr>
                            <tr><th><b>Location: </b></th><td>${event.location?html}</td></tr>
                            </br>
                            <ol>
                                <tr><th>Attendees:</th></tr>
                                <#list event.getEventMemberList() as member>
                                        <tr id="${member.username}"><th></th><td>${member.username}</td></tr>
                                </#list>
                            </ol>
                            <tr><td><input type="button" value="I can't go" onClick="removeMember(${event.eventId},'${model.username}')"/></td></tr>
                            </table>
                        </#if>
                    </#list>
                </ol>
        </#list>
    </body>
</html>
