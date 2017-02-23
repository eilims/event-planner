/**
 * Created by DanielB on 2/23/2017.
 */
function setUserEnabled(id) {

    var data = {
        id: id
    };
    $.ajax({
        url: "/register/setUserEnabled",
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