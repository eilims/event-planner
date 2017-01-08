<!DOCTYPE html>
<html>
<body>

<h1>My First Heading</h1>
<p>My first paragraph.</p>

<ol>
<#list model.eventList as event>
    <li>
        The event name is ${event.name} and its ID is ${event.id}
    </li>
</#list>
</ol>
</body>
</html>
