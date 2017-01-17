/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"
function sendNewEvent(groupId){
    alert("submitted");
    var event = {
        name: document.getElementById(groupId).rows[0].cells[0].getElementsById("name")[0].value
        
    }
}

