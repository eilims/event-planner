/**
 * Created by DanielB on 2/18/2017.
 */
function sendNewMember(role) {
    var eventMember = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value,
        email: document.getElementById("email").value,
        role: role
    };
    $.ajax({
        url: "/register/createMember",
        type: "post",
        data: eventMember,
        headers: csrf,
        success: successCallback
    });
}

function successCallback(data) {
    if (data) {
        window.location = "http://localhost:8080/login.html";
    } else {
        document.getElementById("username").value = "";
        document.getElementById("password").value = "";
        document.getElementById("error").innerHTML = "Username is already in use!";
    }

}
