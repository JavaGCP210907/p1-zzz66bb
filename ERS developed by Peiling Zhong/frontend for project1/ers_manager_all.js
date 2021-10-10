//the base URL for making calls to the server
const url = "http://localhost:8090/";

//get the current manager's username from url
var url5 = window.location;
var username = url5.toString().split('=')[1];

//when page loaded, manager can see all reimbursement of employees
(function() {
    AllReimbursementEmployeesFunc();
})();

//add functionality to buttons by using eventlistener
document.getElementById("AllReimbursementEmployees").addEventListener("click",AllReimbursementEmployeesFunc);
document.getElementById("pendingReimbursementEmployees").addEventListener("click",PendingReimbursementEmployeesFunc);
document.getElementById("ApprovedReimbursementEmployees").addEventListener("click",ApprovedReimbursementEmployeesFunc);
document.getElementById("DeniedReimbursementEmployees").addEventListener("click",DeniedReimbursementEmployeesFunc);
document.getElementById("signoutButton").addEventListener("click", signOutFunc);

//function for getting all reimbursement of employees
async function AllReimbursementEmployeesFunc() { 

    //describe the table
    var info = "Empployees Reimbursments Information"
    document.getElementById("info").innerHTML = info;

    var Table = document.getElementById("reimbursementBody");
    Table.innerHTML = ""; 

    let response = await fetch(url + "reimbursements");

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
            cell6.innerHTML = reimbursement.reimb_author_fk.ers_username; 
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            if(reimbursement.reimb_resolved){
                cell7.innerHTML = reimbursement.reimb_resolved; 
            }else{
                cell7.innerHTML = ""
            }
            row.appendChild(cell7);
            
            let cell8 = document.createElement("td"); 
            if(reimbursement.reimb_resolver_fk){
                cell8.innerHTML = reimbursement.reimb_resolver_fk.ers_username; 
            }else{
                cell8.innerHTML = ""
            }
            row.appendChild(cell8);
            
            let cell9= document.createElement("td"); 
            cell9.innerHTML = reimbursement.reimb_status_fk.reimb_status; 
            row.appendChild(cell9);

            //the tr called row that we created in the for loop gets appended to the table body
            document.getElementById("reimbursementBody").appendChild(row);
        }
    }
}

//function for getting all pending reimbursement of employees
async function PendingReimbursementEmployeesFunc() { 
    
    var info = "Empployees Pending Reimbursments Information"
    document.getElementById("info").innerHTML = info;

    var Table = document.getElementById("reimbursementBody");
    Table.innerHTML = ""; 

    let response = await fetch(url + "reimbursements/pending");

    if(response.status === 200) { 

        let data = await response.json(); 
        var count = 0;

        for(let reimbursement of data){

            let reimb_id = reimbursement.reimb_id;

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
            cell6.innerHTML = reimbursement.reimb_author_fk.ers_username; 
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            if(reimbursement.reimb_resolved){
                cell7.innerHTML = reimbursement.reimb_resolved; 
            }else{
                cell7.innerHTML = ""
            }
            row.appendChild(cell7);

            let cell8 = document.createElement("td"); 
            if(reimbursement.reimb_resolver_fk){
                cell8.innerHTML = reimbursement.reimb_resolver_fk.ers_username; 
            }else{
                cell8.innerHTML = ""
            }
            row.appendChild(cell8);

            let cell9= document.createElement("td"); 
            cell9.innerHTML = "<select id='updateStatus' onchange='updateStatus(this.value, "+ reimb_id +");'><option value=''>Choose approve/deny</option><option value='toapprove'>to approve</option><option value='todeny'>to deny</option></select>";
            row.appendChild(cell9);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }
}

//function for getting all approved reimbursement of employees
async function ApprovedReimbursementEmployeesFunc() { 

    var info = "Empployees Approved Reimbursments Information"
    document.getElementById("info").innerHTML = info;

    var Table = document.getElementById("reimbursementBody");
    Table.innerHTML = ""; 

    let response = await fetch(url + "reimbursements/approved");

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
            cell6.innerHTML = reimbursement.reimb_author_fk.ers_username; 
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            if(reimbursement.reimb_resolved){
                cell7.innerHTML = reimbursement.reimb_resolved; 
            }else{
                cell7.innerHTML = ""
            }
            row.appendChild(cell7);
   
            let cell8 = document.createElement("td"); 
            if(reimbursement.reimb_resolver_fk){
                cell8.innerHTML = reimbursement.reimb_resolver_fk.ers_username; 
            }else{
                cell8.innerHTML = ""
            }
            row.appendChild(cell8);
            
            let cell9= document.createElement("td"); 
            cell9.innerHTML = reimbursement.reimb_status_fk.reimb_status; 
            row.appendChild(cell9);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }
}

//function for getting all denied reimbursement of employees
async function DeniedReimbursementEmployeesFunc() { 

    var info = "Empployees Denied Reimbursments Information"
    document.getElementById("info").innerHTML = info;

    var Table = document.getElementById("reimbursementBody");
    Table.innerHTML = ""; 

    let response = await fetch(url + "reimbursements/denied");

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
            cell6.innerHTML = reimbursement.reimb_author_fk.ers_username; 
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            if(reimbursement.reimb_resolved){
                cell7.innerHTML = reimbursement.reimb_resolved; 
            }else{
                cell7.innerHTML = ""
            }
            row.appendChild(cell7);

            let cell8 = document.createElement("td"); 
            if(reimbursement.reimb_resolver_fk){
                cell8.innerHTML = reimbursement.reimb_resolver_fk.ers_username; 
            }else{
                cell8.innerHTML = ""
            }
            row.appendChild(cell8);
          
            let cell9= document.createElement("td"); 
            cell9.innerHTML = reimbursement.reimb_status_fk.reimb_status; 
            row.appendChild(cell9);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }
}



async function updateStatusFunc(status_id, reimb_id, reimb_resolver_name){

    
    let reimb_id_value = reimb_id
    let reimb_resolver_name_value = reimb_resolver_name;
    let reimb_status_id_value = status_id;

    let request_info = {
        reimb_id:reimb_id_value,
        reimb_resolver_name:reimb_resolver_name_value,
        reimb_status_id:reimb_status_id_value
    }

    console.log(request_info)


    let response = await fetch(url + "reimbursement/updatestatus", {

        method: "Put", 
        body: JSON.stringify(request_info)

    });

    console.log(response.status); 

    if(response.status === 200){
        window.location.replace("./back_st_succe.html?username=" + username);
    } else {
        window.location.replace("./back_st_fail.html?username=" + username);
    }

    
}

//function for approving or denying employees' requests
function updateStatus(value, reimb_id){
    
    if(value == "toapprove"){
        updateStatusFunc(3, reimb_id, username);
    }
    if(value == "todeny"){
        updateStatusFunc(2, reimb_id, username);    
    }
}

//function for signing out
function signOutFunc(){
    window.location.replace("./ers_login.html");
}


