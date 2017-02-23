/**
 * Created by DanielB on 2/19/2017.
 */
function createGroup(username) {
    var group = {
        name: document.getElementById("groupName").value,
        username: username
    };
    $.ajax({
        url: "/admin/group/createGroup",
        type: "post",
        data: group,
        headers: csrf,
        success: successCallBack
    });
}

function deleteGroup(groupId) {
    var group = {
        eventGroupId: groupId
    };
    $.ajax({
        url: "/admin/group/deleteGroup",
        type: "post",
        data: group,
        headers: csrf,
        success: successCallBack
    });
}
function createEvents(groupName, groupId) {
    var event = {
        name: document.getElementById(groupName).rows.namedItem("nameRow").cells.namedItem("nameCell").children[0].value,
        groupId: groupId,
        description: document.getElementById(groupName).rows.namedItem("desRow").cells.namedItem("desCell").children[0].value,
        location: document.getElementById(groupName).rows.namedItem("locRow").cells.namedItem("locCell").children[0].value,
        startDate: document.getElementById(groupName).rows.namedItem("strRow").cells.namedItem("strCell").children[0].value,
        endDate: document.getElementById(groupName).rows.namedItem("endRow").cells.namedItem("endCell").children[0].value
    };
    if (event.name == "" || event.description == "" || event.location == "" || startDate == "" || endDate == "") {
        alert("Please fill out all fields");
        return;
    }
    $.ajax({
        url: "/admin/event/createEvent",
        type: "post",
        data: event,
        headers: csrf,
        success: successCallBack
    });
}
function deleteEvent(eventId) {
    var event = {
        eventId: eventId
    };
    $.ajax({
        url: "/admin/event/deleteEvent",
        type: "post",
        data: event,
        headers: csrf,
        complete: successCallBack
    });
}
function addEventMember(eventId) {
    var data = {
        eventId: eventId,
        username: document.getElementById(eventId).rows.namedItem("usernameRow").cells.namedItem("usernameCell").children[0].value
    };
    $.ajax({
        url: "/admin/event/addMember",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function removeEventMember(eventId, username) {
    var data = {
        eventId: eventId,
        username: username
    };
    $.ajax({
        url: "/admin/event/removeMember",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function addGroupMember(groupName, groupId) {
    var data = {
        groupId: groupId,
        username: document.getElementById(groupName).rows.namedItem("usernameRow").cells.namedItem("usernameCell").children[0].value
    };
    $.ajax({
        url: "/admin/group/addMember",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function removeGroupMember(groupId, username) {
    var data = {
        groupId: groupId,
        username: username
    };
    $.ajax({
        url: "/admin/group/removeMember",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function addGroupAdmin(groupName, groupId) {
    var data = {
        groupId: groupId,
        username: document.getElementById(groupName).rows.namedItem("adminRow").cells.namedItem("adminCell").children[0].value
    };
    $.ajax({
        url: "/admin/group/addAdmin",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function removeGroupAdmin(groupId, username) {
    var data = {
        groupId: groupId,
        username: username
    };
    $.ajax({
        url: "/admin/group/removeAdmin",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function resendEmail(id) {
    var data = {
        id: id
    };
    $.ajax({
        url: "/register/resendEmail",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function successCallBack(data) {
    if (typeof(data) === "boolean") {
        if (data) {
            alert("Successful Operation!");
        } else {
            alert("Failed Operation :(");
        }
    }
    location.reload();
}
