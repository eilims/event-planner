<!DOCTYPE html>
<html>
    <head>
        <script>
        function changeDayLimit(){
            var month = document.getElementById("2").value;
            var day = document.getElementById("3");
            if(month == 2){
                day.max = 28;
            } else if(month%2 == 0){
                day.max = 30;
            } else {
                day.max = 31;
            }
        } 
        </script>
        </head>
    <body>

        <form name="event" action="createEvent" method="post">
            Event Name: <input type="text" name="name" required/>
            <br/>
            Year: <select id="1" name="year" required>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option> 
                </select>
            Month: <select id="2" name="month" onchange="changeDayLimit()">
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
                </select>
            Day: <input id="3" type="number" name="day" min="1" max="31"/>

            <br/>
            Hour: <select name="hour" required>
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
                </select>

            Minute: <input type="number" name="minute" min="0" max="59" required/>
            <br/>
            Description: <input type="text" name="description" value="Enter Description Here">
            <br/>
            <input type="submit" value="   Save   "/>
            </form>

        <ol>
<#list model.eventList as event>
            <li>
                <b>Event: </b>${event.name?html}
                <b>Date: </b>${event.date.toLocalDate()} 
                <b>Time: </b>${event.date.toLocalTime()} 
                <b>Description: </b>${event.description?html()}

                <form name="delevent" action="deleteEvent/${event.id}" method="post">
                    <input type="submit" value="Delete">
                </form>
                </li>
</#list>
            </ol>
        </body>
    </html>
