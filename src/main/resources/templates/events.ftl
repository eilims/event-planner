<!DOCTYPE html>
<html>
<body>

<h1>My First Heading</h1>
<p>My first paragraph.</p>
<p>Make a new event</p>

<form name="event" action="createEvent" method="post">
    Event Name: <input type="text" name="name" /> <br/>
    <input type="submit" value="   Save   "/>
</form>

<ol>
<#list model.eventList as event>
    <li>
        The event name is ${event.name?html} and its ID is ${event.id}
        <form name="delevent" action="deleteEvent/${event.id}" method="post">
        <input type="submit" value="Delete">
        </form>
    </li>
</#list>
</ol>
</body>
</html>
