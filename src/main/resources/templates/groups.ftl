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
                <form name="event" action="createEvent/${group.id}" method="post" >
                    <table id="table">
                        <tr>
                            <th>Event Name:</th> <td><input type="text" class="long" id="name" name="name" value="Enter Event Name" onClick="clearText('name', 0)" required/><td>
                            </tr>
                        <tr>
                            <th>Description:</th> <td><textarea class="description" id="description" name="description" value="Enter Description" onClick="clearText('description', 1)"></textarea>
                            </tr>
                        <tr>
                            <th>Location:</th> <td><input type="text" class="long" id="location" name="location" value="Enter Location" onClick="clearText('location', 2)" required></td>
                            </tr>

                        </table>
                        Start Time: <input type="datetime-local" name="startDate"/>
                        <br/>
                        End Time: <input type="datetime-local" name="endDate"/>
                        <tr>
                        <td><input type="submit" class="box" value="   Save   "/></td>
                        </tr>
                        </table>
                    </form>
                <ol>
                <#list group.getEventList() as event>
                    <li>
                        <b>Event Name: </b>${event.name?html}
                        </li>
                    <form name="deleteGroup" action="deleteGroup/${group.id}" method="post">
                        <input type="submit" value="Delete"/>
                        </form>
                </#list>
                    </ol>
                </li>
        </#list>
            </ol>
        </body>
    </html>
