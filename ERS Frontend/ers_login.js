//the base URL for making calls to the server
const url = "http://localhost:8090/"; 

//add functionality to buttons by using eventlistener
document.getElementById("signinButton").addEventListener("click", signInFunc);

//function for signing in
async function signInFunc(){

    //gather the user input from the signin inputs
    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;

    //make a JS object to send
    let user = {
        username:usern,
        password:userp
    }

    let response = await fetch(url + "login", {

        method: "POST", 
        body: JSON.stringify(user), 
        credentials: "include"

    });

    //control flow based on success or failed login
    if(response.status === 200){
        
        let euForRole = await response.json();

        //control flow based on the employee's role
        if(euForRole.user_role_fk.user_role == "employee"){
            
            window.location.replace("./ers_past_tickets.html?username=" + usern);

        }else{

            window.location.replace("./ers_manager_all.html?username=" + usern);
        }
        
    } else {
        
        window.location.replace("./login_back.html");
        
    }

}

