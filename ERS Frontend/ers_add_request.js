//the base URL for making calls to the server
const url = "http://localhost:8090/";

//get the current employee's username from url
var url2 = window.location;
var username = url2.toString().split('=')[1];

//add functionality to buttons by using eventlistener
document.getElementById("SubmitButton").addEventListener("click", addRequestFunc.bind(null, username));
document.getElementById("CancleButton").addEventListener("click", cancleRequestFunc.bind(null, username));
document.getElementById("SignoutButton").addEventListener("click", signOutFunc);


//function for adding request
async function addRequestFunc(username){

    let reimb_amount_value = document.getElementById("reimb_amount").value; 
    let reimb_description_value = document.getElementById("reimb_description").value;
    let reimb_type_id_value = document.querySelector('input[name="reimb_type_id"]:checked').value;

    let request_info = {
        reimb_amount:reimb_amount_value,
        reimb_description:reimb_description_value,
        ers_username:username,
        reimb_type_id:reimb_type_id_value
    }

    let response = await fetch(url + "reimbursement/add", {

        method: "Post", 
        body: JSON.stringify(request_info)

    });

    //control flow based on success or failed 
    if(response.status === 200){
        window.location.replace("./back_re_succe.html?username=" + username);
    } else {
        window.location.replace("./back_re_fail.html?username=" + username);
    }    
}

//function for cancling request, then return to home page
function cancleRequestFunc(username){
    window.location.replace("./ers_past_tickets.html?username=" + username);
}

//function for signing out, then return to sign in page
function signOutFunc(){
    window.location.replace("./ers_login.html");
}