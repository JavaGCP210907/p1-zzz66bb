//the base URL for making calls to the server
const url = "http://localhost:8090/"; 

//get the current employee's username from url
var url1 = window.location;
var username = url1.toString().split('=')[1];

//when page loaded, employee can see his reimbursements history
(function() {
    pastReimbursementFunc(username);
})();

//add functionality to buttons by using eventlistener
document.getElementById("pastReimbursement").addEventListener("click",pastReimbursementFunc.bind(null, username));
document.getElementById("pendingReimbursement").addEventListener("click",pendingReimbursementFunc.bind(null, username));
document.getElementById("addRequestButton").addEventListener("click", addRequestFunc.bind(null, username));
document.getElementById("signoutButton").addEventListener("click", signOutFunc);

//function for getting current employee's reimbursements history
async function pastReimbursementFunc(username){ 
    
    //describe the table
    var info = "Your Past Reimbursments Information"
    document.getElementById("info").innerHTML = info;

    var Table = document.getElementById("reimbursementBody");
    Table.innerHTML = ""; 
    
    let response = await fetch(url + "reimbursements/past/" + username);

    //if the request comes back successful
    if(response.status === 200) { 

        let data = await response.json(); 
        //for colume #
        var count = 0;

        //for every reimbursement object we get back, put it in the table
        for(let reimbursement of data){

            //create a table row
            let row = document.createElement("tr");

            //create a cell for the field
            let cell1 = document.createElement("td");
            count = count + 1;
            cell1.innerHTML = count; 
            row.appendChild(cell1); 

            let cell2 = document.createElement("td"); 
            cell2.innerHTML = reimbursement.reimb_amount; 
            row.appendChild(cell2); 
            
            let cell3 = document.createElement("td"); 
            cell3.innerHTML = reimbursement.reimb_description; 
            row.appendChild(cell3);

            let cell4 = document.createElement("td"); 
            cell4.innerHTML = reimbursement.reimb_type_fk.reimb_type; 
            row.appendChild(cell4);

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = reimbursement.reimb_submitted; 
            row.appendChild(cell5);

            let cell6 = document.createElement("td"); 
            if(reimbursement.reimb_resolved){
                cell6.innerHTML = reimbursement.reimb_resolved; 
            }else{
                cell6.innerHTML = ""
            }
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            if(reimbursement.reimb_resolver_fk){
                cell7.innerHTML = reimbursement.reimb_resolver_fk.ers_username; 
            }else{
                cell7.innerHTML = ""
            }
            row.appendChild(cell7);
            
            let cell8= document.createElement("td"); 
            cell8.innerHTML = reimbursement.reimb_status_fk.reimb_status; 
            row.appendChild(cell8);

            //the tr called row that we created in the for loop gets appended to the table body
            document.getElementById("reimbursementBody").appendChild(row);
        }
    }    
}

//function for getting current employee's pending reimbursement
async function pendingReimbursementFunc(username) { 

    var info = "Your Pending Reimbursments Information"
    document.getElementById("info").innerHTML = info;

    var Table = document.getElementById("reimbursementBody");
    Table.innerHTML = ""; 

    let response = await fetch(url + "reimbursements/pending/" + username);

    if(response.status === 200) { 

        let data = await response.json(); 
        var count = 0;

        for(let reimbursement of data){

            let row = document.createElement("tr"); 

            let cell1 = document.createElement("td");
            count = count + 1;
            cell1.innerHTML = count; 
            row.appendChild(cell1); 

            let cell2 = document.createElement("td"); 
            cell2.innerHTML = reimbursement.reimb_amount; 
            row.appendChild(cell2); 
            
            let cell3 = document.createElement("td"); 
            cell3.innerHTML = reimbursement.reimb_description; 
            row.appendChild(cell3);

            let cell4 = document.createElement("td"); 
            cell4.innerHTML = reimbursement.reimb_type_fk.reimb_type; 
            row.appendChild(cell4);

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = reimbursement.reimb_submitted; 
            row.appendChild(cell5);

            let cell6 = document.createElement("td"); 
            if(reimbursement.reimb_resolved){
                cell6.innerHTML = reimbursement.reimb_resolved; 
            }else{
                cell6.innerHTML = ""
            }
            row.appendChild(cell6);
            
            let cell7 = document.createElement("td"); 
            if(reimbursement.reimb_resolver_fk){
                cell7.innerHTML = reimbursement.reimb_resolver_fk.ers_username; 
            }else{
                cell7.innerHTML = ""
            }
            row.appendChild(cell7);
            
            let cell8= document.createElement("td"); 
            cell8.innerHTML = reimbursement.reimb_status_fk.reimb_status; 
            row.appendChild(cell8);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }
}

//function for redirecting to add Request 
function addRequestFunc(username){
    window.location.replace("./ers_add_request.html?username=" + username);
}

//function for signing out
function signOutFunc(){
    window.location.replace("./ers_login.html");
}


