<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="PageStyle.css">
    <header><b>Add An Event</b></header>
    <script type="text/javascript">
    function changeDayLimit(){
        var month = document.getElementById("2").value;
        var day = document.getElementById("3");
        if(month == 2)
                    {
            day.max = 28;
        } 
                    else if(month%2 == 0)
                    {
            day.max = 30;
        } 
                    else 
                    {
            day.max = 31;
        }
    } 
		
    var textClick= [0,0,0]
    function clearText(string, int) 
    {
        if(textClick[int] == 0) 
        {
            document.getElementById(string).value="";
            textClick[int]=1;
        }
    }

        </script>
    <br/>
    <br/>
    </head>
<body>

    <form name="event" action="createEvent" method="post" >
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
        <table id="table">
            <tr>
                <th>Start Year:</th> <td><select class="box" id="1" name="startYear" value= required>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option> 
                        </select></td>
                <th>Month:</th> <td><select class="box" id="2" name="startMonth" onchange="changeDayLimit()">
                        <option value="1">January</option>
                        <option value="2">February</option>
                        <option value="3">March</option> 
                        <option value="4">April</option>
                        <option value="5">May</option>
                        <option value="6">June</option>
                        <option value="7">July</option> 
                        <option value="8">August</option>
                        <option value="9">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option> 
                        <option value="12">December</option>
                        </select></td>
                <th>Day:</th> <td><input class="box" id="3" type="number" name="startDay" min="1" max="31"/></td>
                </tr>
            <tr>
                <th>Hour:</th> <td><select class="box"  name="startHour" required>
                        <option value="0">12AM</option>
                        <option value="1">1AM</option>
                        <option value="2">2AM</option>
                        <option value="3">3AM</option> 
                        <option value="4">4AM</option>
                        <option value="5">5AM</option>
                        <option value="6">6AM</option>
                        <option value="7">7AM</option> 
                        <option value="8">8AM</option>
                        <option value="9">9AM</option>
                        <option value="10">10AM</option>
                        <option value="11">11AM</option> 
                        <option value="12">12PM</option>
                        <option value="13">1PM</option>
                        <option value="14">2PM</option>
                        <option value="15">3PM</option> 
                        <option value="16">4PM</option>
                        <option value="17">5PM</option>
                        <option value="18">6PM</option>
                        <option value="19">7PM</option> 
                        <option value="20">8PM</option>
                        <option value="21">9PM</option>
                        <option value="22">10PM</option>
                        <option value="23">11PM</option>
                        </select></td>

                <th>Minute:</th> <td><input type="number" class="box" name="startMinute" min="0" max="59" required/></td>
                </tr>
            <tr>
                <th>End Year:</th> <td><select class="box" id="1" name="endYear" value= required>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option> 
                        </select></td>
                <th>Month:</th> <td><select class="box" id="2" name="endMonth" onchange="changeDayLimit()">
                        <option value="1">January</option>
                        <option value="2">February</option>
                        <option value="3">March</option> 
                        <option value="4">April</option>
                        <option value="5">May</option>
                        <option value="6">June</option>
                        <option value="7">July</option> 
                        <option value="8">August</option>
                        <option value="9">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option> 
                        <option value="12">December</option>
                        </select></td>
                <th>Day:</th> <td><input class="box" id="3" type="number" name="endDay" min="1" max="31"/></td>
                </tr>
            <tr>
                <th>Hour:</th> <td><select class="box"  name="endHour" required>
                        <option value="0">12AM</option>
                        <option value="1">1AM</option>
                        <option value="2">2AM</option>
                        <option value="3">3AM</option> 
                        <option value="4">4AM</option>
                        <option value="5">5AM</option>
                        <option value="6">6AM</option>
                        <option value="7">7AM</option> 
                        <option value="8">8AM</option>
                        <option value="9">9AM</option>
                        <option value="10">10AM</option>
                        <option value="11">11AM</option> 
                        <option value="12">12PM</option>
                        <option value="13">1PM</option>
                        <option value="14">2PM</option>
                        <option value="15">3PM</option> 
                        <option value="16">4PM</option>
                        <option value="17">5PM</option>
                        <option value="18">6PM</option>
                        <option value="19">7PM</option> 
                        <option value="20">8PM</option>
                        <option value="21">9PM</option>
                        <option value="22">10PM</option>
                        <option value="23">11PM</option>
                        </select></td>

                <th>Minute:</th> <td><input type="number" class="box" name="endMinute" min="0" max="59" required/></td>
                </tr>
            <tr>
                <td><input type="submit" class="box" value="   Save   "/></td>
                </tr>
            </table>
        </form>

    </body>
</html>


<ol>
<#list model.eventList as event>
    <li>
        <b>Event: </b>${event.name?html}
        <b>Start Date: </b>${event.startDate.toLocalDate()} 
        <b>Start Time: </b>${event.startDate.toLocalTime()} 
        <b>End Date: </b>${event.endDate.toLocalDate()} 
        <b>End Time: </b>${event.endDate.toLocalTime()} 
        <b>Description: </b>${event.description?html}
        <form name="member" action="addMember/${event.id}" method="post">
            MemberId: <input type="number" name="memberId" min="0"/>
            <input type="submit" value="Add"/>
        </form>
        <ol>
            <#list event.getAttendeeList() as members>
                <li>
                    <b>Member: </b>${members}
                </li>
            </#list>
        </ol>
        
        <form name="delevent" action="deleteEvent/${event.id}" method="post">
            <input type="submit" value="Delete">
        </form>
        </li>
</#list>
    </ol>
</body>
</html>
