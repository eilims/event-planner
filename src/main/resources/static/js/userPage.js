/**
 * Created by DanielB on 2/19/2017.
 */
function leaveEvent(eventId, username) {
    var data = {
        eventId: eventId,
        username: username
    };
    $.ajax({
        url: "/user/leaveEvent",
        type: "post",
        data: data,
        headers: csrf,
        complete: successCallBack
    });
}
function leaveGroup(groupId, username) {

    var data = {
        groupId: groupId,
        username: username
    };
    $.ajax({
        url: "/user/leaveGroup",
        type: "post",
        data: data,
        headers: csrf,
        success: successCallBack
    });
}
function successCallBack(data) {
    /*
     Do other things here to display messages!
     */
    location.reload();
}
