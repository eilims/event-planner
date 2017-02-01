<!DOCTYPE html>
<html>
    <body>
        This worked!
        ${model.username}
        <ol>
        <#list model.groupList as group>
            ${group.groupName}
        </#list>
        <ol>
    </body>
</html>
