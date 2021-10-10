
(function() {
    var url4 = window.location;
    var username4 = url4.toString().split('=')[1];
    var backLink = "./ers_past_tickets.html?username=" + username4;
    document.getElementById("backlink").setAttribute("href",backLink);
})();

document.getElementById("SignoutButton").addEventListener("click", signOutFunc);


function signOutFunc(){
    window.location.replace("./ers_login.html");
}
