const url = 'http://localhost:8080/P1-najmendes/'//make sure it's the right url!!!

document.getElementById("employeeProfile").addEventListener('click', getProfile);
async function getProfile() {

    let employeeID = document.getElementById("empId").value;

    let user = {
        user_id : employeeID
    }

    console.log(user);

    let response = await fetch(url + "employeeviewtickets", {

        method: "POST", //send as a POST request
        body: JSON.stringify(user), //turn into JSON
        credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    console.log(response.status);

    if(response.status === 200) {
        console.log(response);

        let data = await response.json(); //get the JSON data from the response, turn it into JS object
        console.log(user);

        let headrow = document.createElement("tr"); 

        let head1 = document.createElement("th"); //create a header element (DOM manipulation);
        head1.innerHTML = "Employee Id"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head1);

        let head2 = document.createElement("th"); //create a header element (DOM manipulation);
        head2.innerHTML = "First Name"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head2);

        let head3 = document.createElement("th"); //create a header element (DOM manipulation);
        head3.innerHTML = "Last Name"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head3);

        let head4 = document.createElement("th"); //create a header element (DOM manipulation);
        head4.innerHTML = "Email"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head4);

        document.getElementById("profileTableHead").appendChild(headrow);

        let row = document.createElement("tr"); 

        let cell1 = document.createElement("td"); //create a header element (DOM manipulation);
        cell1.innerHTML = data.user_id; //populating the h3 with the name of the Pokemon
        row.appendChild(cell1);

        let cell2 = document.createElement("td"); //create a header element (DOM manipulation);
        cell2.innerHTML = data.first_name; //populating the h3 with the name of the Pokemon
        row.appendChild(cell2);

        let cell3 = document.createElement("td"); //create a header element (DOM manipulation);
        cell3.innerHTML = data.last_name; //populating the h3 with the name of the Pokemon
        row.appendChild(cell3)

        let cell4 = document.createElement("td"); //create a header element (DOM manipulation);
        cell4.innerHTML = data.user_email; //populating the h3 with the name of the Pokemon
        row.appendChild(cell4);

        document.getElementById("displayProfile").appendChild(row);

        } 
}    


document.getElementById("employeeTickets").addEventListener('click', populateReimbursements);
async function populateReimbursements(){

    let employeeID = document.getElementById("empId").value;

    let user = {
        user_id : employeeID
    }

    console.log(user);

    let response = await fetch(url + "employeeviewtickets", {

        method: "POST", //send as a POST request
        body: JSON.stringify(user), //turn into JSON
        credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    console.log(response.status);

    if(response.status === 200) {
        console.log(response);

        let data = await response.json(); //get the JSON data from the response, turn it into JS object
        

        let headrow = document.createElement("tr"); 

        let head1 = document.createElement("th"); //create a header element (DOM manipulation);
        head1.innerHTML = "Reimbursement Id"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head1);

        let head2 = document.createElement("th"); //create a header element (DOM manipulation);
        head2.innerHTML = "Type"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head2);

        let head3 = document.createElement("th"); //create a header element (DOM manipulation);
        head3.innerHTML = "Amount"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head3);

        let head4 = document.createElement("th"); //create a header element (DOM manipulation);
        head4.innerHTML = "Date Submitted"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head4);

        let head5 = document.createElement("th"); //create a header element (DOM manipulation);
        head5.innerHTML = "Date Resolved"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head5);

        let head6 = document.createElement("th"); //create a header element (DOM manipulation);
        head6.innerHTML = "Description"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head6);

        let head7 = document.createElement("th"); //create a header element (DOM manipulation);
        head7.innerHTML = "Resolver"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head7);

        let head8 = document.createElement("th"); //create a header element (DOM manipulation);
        head8.innerHTML = "Status"; //populating the h3 with the name of the Pokemon
        headrow.appendChild(head8);

        document.getElementById("ticketsTableHead").appendChild(headrow);



        let employeesReimbursementsArray = data.reimbursementsOfAuthor;

        for(let oneReimbursement of employeesReimbursementsArray) { //for every ability in the abilitiesArray...
            console.log(employeesReimbursementsArray);

        let row = document.createElement("tr"); 

        let cell1 = document.createElement("td"); //create a header element (DOM manipulation);
        cell1.innerHTML = oneReimbursement.reimb_id; //populating the h3 with the name of the Pokemon
        row.appendChild(cell1);

        let cell2 = document.createElement("td"); //create a header element (DOM manipulation);
        cell2.innerHTML = oneReimbursement.reimb_type_fk.reimb_type; //populating the h3 with the name of the Pokemon
        row.appendChild(cell2)

        let cell3 = document.createElement("td"); //create a header element (DOM manipulation);
        cell3.innerHTML = oneReimbursement.reimb_amount; //populating the h3 with the name of the Pokemon
        row.appendChild(cell3);

        let cell4 = document.createElement("td"); //create a header element (DOM manipulation);
        cell4.innerHTML = oneReimbursement.date_submitted; //populating the h3 with the name of the Pokemon
        row.appendChild(cell4)

        let cell5 = document.createElement("td"); //create a header element (DOM manipulation);
        cell5.innerHTML = oneReimbursement.date_resolved; //populating the h3 with the name of the Pokemon
        row.appendChild(cell5);

        let cell6 = document.createElement("td"); //create a header element (DOM manipulation);
        cell6.innerHTML = oneReimbursement.reimb_description; //populating the h3 with the name of the Pokemon
        row.appendChild(cell6);

        let cell7 = document.createElement("td"); //create a header element (DOM manipulation);
        cell7.innerHTML = oneReimbursement.resolver.user_email; //populating the h3 with the name of the Pokemon
        row.appendChild(cell7)

        let cell8 = document.createElement("td"); //create a header element (DOM manipulation);
        cell8.innerHTML = oneReimbursement.reimb_status_fk.reimb_status; //populating the h3 with the name of the Pokemon
        row.appendChild(cell8);



        document.getElementById("displayTickets").appendChild(row);

        } 
    }   



}


document.getElementById("submitNewTicket").addEventListener('click',submitNewTicket);   
async function submitNewTicket() {

    let userId = document.getElementById("user_id").value;
    let amount = document.getElementById("reimb_amount").value;
    let type  = document.getElementById("reimb_type").value;
    let description = document.getElementById("reimb_description").value;
    let submitted  = document.getElementById("date_submitted").value;

    let reimbursement = {
        reimb_amount: amount,
        date_submitted: submitted,
        date_resolved: "n/a",
        reimb_description: description,
        author: {
            user_id: userId
        },
        resolver: {
           user_id: 8
        },
        reimb_status_fk: {
            reimb_status_id: 3
        },
        reimb_type_fk: {
            reimb_type_id: type
        }
    }

    console.log(reimbursement);

    let response = await fetch(url + "employeesubmitticket", {

        method: "POST", //send as a POST request
        body: JSON.stringify(reimbursement), //turn into JSON
        credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    if(response.status === 200) {
        console.log(response);
        alert("New Ticket Submitted!");
        window.location.assign("EmployeePortal.html");
    }

}








// //WAS TRYING TO TOGGLE VISIBILITY OF DIVS...HAVEN'T FIGURED IT OUT YET...
//     document.getElementById("employeeProfile").addEventListener('dblclick', showTicketSubmission);
//     function showTicketSubmission() {
//         var toggle = document.getElementById("profileTable");
//         // div.style.display = div.style.display ==="none" ? "block" : "none;" 
//         if (toggle.style.display === "none") {
//             toggle.style.display = "initial";
//           } else {
//             toggle.style.display = "none";
//           }
//     }