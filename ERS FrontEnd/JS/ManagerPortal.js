const url = 'http://localhost:8080/P1-najmendes/'//make sure it's the right url!!!

document.getElementById("managerProfile").addEventListener('click', getProfile);

async function getProfile() {

    let employeeID = document.getElementById("managerId").value;

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
        head1.innerHTML = "Manager Id"; //populating the h3 with the name of the Pokemon
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


document.getElementById("viewAllTickets").addEventListener('click', populateAllEmplyeeTickets);
async function populateAllEmplyeeTickets(){

    let response = await fetch(url + 'managerviewalltickets', {credentials: 'include'});

    if(response.status === 200) {
        console.log(response);

        let data = await response.json(); //get the JSON data from the response, turn it into JS object

        for(let ticket of data) { //for every ability in the abilitiesArray...
            console.log(ticket);

            let row = document.createElement("tr"); 

            let cell1 = document.createElement("td"); //create a header element (DOM manipulation);
            cell1.innerHTML = ticket.reimb_id; //populating the h3 with the name of the Pokemon
            row.appendChild(cell1);

            let cell2 = document.createElement("td"); //create a header element (DOM manipulation);
            cell2.innerHTML = ticket.reimb_type_fk.reimb_type; //populating the h3 with the name of the Pokemon
            row.appendChild(cell2)

            let cell3 = document.createElement("td"); //create a header element (DOM manipulation);
            cell3.innerHTML = ticket.reimb_amount; //populating the h3 with the name of the Pokemon
            row.appendChild(cell3);

            let cell4 = document.createElement("td"); //create a header element (DOM manipulation);
            cell4.innerHTML = ticket.date_submitted; //populating the h3 with the name of the Pokemon
            row.appendChild(cell4)

            let cell5 = document.createElement("td"); //create a header element (DOM manipulation);
            cell5.innerHTML = ticket.date_resolved; //populating the h3 with the name of the Pokemon
            row.appendChild(cell5);

            let cell6 = document.createElement("td"); //create a header element (DOM manipulation);
            cell6.innerHTML = ticket.reimb_description; //populating the h3 with the name of the Pokemon
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); //create a header element (DOM manipulation);
            cell7.innerHTML = ticket.author.user_email; //populating the h3 with the name of the Pokemon
            row.appendChild(cell7)

            let cell8 = document.createElement("td"); //create a header element (DOM manipulation);
            cell8.innerHTML = ticket.resolver.user_email; //populating the h3 with the name of the Pokemon
            row.appendChild(cell8)

            let cell9 = document.createElement("td"); //create a header element (DOM manipulation);
            cell9.innerHTML = ticket.reimb_status_fk.reimb_status; //populating the h3 with the name of the Pokemon
            row.appendChild(cell9);
            
            document.getElementById("displayEmployeeTickets").appendChild(row);
        } 
    }   
}





document.getElementById("viewPending").addEventListener('click', viewPendingTickets);
async function viewPendingTickets(){

    let response = await fetch(url + 'managerviewalltickets', {credentials: 'include'});

    if(response.status === 200) {
        console.log(response);

        let data = await response.json(); //get the JSON data from the response, turn it into JS object

        for(let ticket of data) { //for every ability in the abilitiesArray...
            console.log(ticket);

            if(ticket.reimb_status_fk.reimb_status === "pending") {
                let row = document.createElement("tr"); 

                let cell1 = document.createElement("td"); //create a header element (DOM manipulation);
                cell1.innerHTML = ticket.reimb_id; //populating the h3 with the name of the Pokemon
                row.appendChild(cell1);

                let cell2 = document.createElement("td"); //create a header element (DOM manipulation);
                cell2.innerHTML = ticket.reimb_type_fk.reimb_type; //populating the h3 with the name of the Pokemon
                row.appendChild(cell2)

                let cell3 = document.createElement("td"); //create a header element (DOM manipulation);
                cell3.innerHTML = ticket.reimb_amount; //populating the h3 with the name of the Pokemon
                row.appendChild(cell3);

                let cell4 = document.createElement("td"); //create a header element (DOM manipulation);
                cell4.innerHTML = ticket.date_submitted; //populating the h3 with the name of the Pokemon
                row.appendChild(cell4)

                let cell5 = document.createElement("td"); //create a header element (DOM manipulation);
                cell5.innerHTML = ticket.date_resolved; //populating the h3 with the name of the Pokemon
                row.appendChild(cell5);

                let cell6 = document.createElement("td"); //create a header element (DOM manipulation);
                cell6.innerHTML = ticket.reimb_description; //populating the h3 with the name of the Pokemon
                row.appendChild(cell6);

                let cell7 = document.createElement("td"); //create a header element (DOM manipulation);
                cell7.innerHTML = ticket.author.user_email; //populating the h3 with the name of the Pokemon
                row.appendChild(cell7)

                let cell8 = document.createElement("td"); //create a header element (DOM manipulation);
                cell8.innerHTML = ticket.reimb_status_fk.reimb_status; //populating the h3 with the name of the Pokemon
                row.appendChild(cell8)
                

            // if(ticket.reimb_status_fk.reimb_status === "unresolved"){
            //     console.log("ticket unresolved")
            //     let cell7 = document.getElementById("button");
            //     // cell7.innerHTML = <button type="button" class="btn btn-success"><i class="fas fa-edit"></i></button>;
            //     row.appendChild(cell7);
            // }else{
            //     let cell8 = document.getElementById("td"); //create a header element (DOM manipulation);
            //     cell8.innerHTML = ticket.reimb_status_fk.reimb_status; //populating the h3 with the name of the Pokemon
            //     row.appendChild(cell8);
            // } 
            document.getElementById("displayPendingTickets").appendChild(row);
            } 
        }   
    }
} 


document.getElementById("resolveTicket").addEventListener('click', loadSpecificTicket);
async function loadSpecificTicket(){

    let ticketID = document.getElementById("ticketId").value;

    let ticket = {
        reimb_id : ticketID
    }

    console.log(ticket);

    let response = await fetch(url + "managerviewresolvingticket", {

        method: "POST", //send as a POST request
        body: JSON.stringify(ticket), //turn into JSON
        credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    console.log(response.status);

    let data;

    if(response.status === 200) {
        console.log(response);

        data = await response.json(); //get the JSON data from the response, turn it into JS object
        console.log(data);

        // let headrow = document.createElement("tr"); 

        // let head1 = document.createElement("th"); //create a header element (DOM manipulation);
        // head1.innerHTML = "Ticket Id"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head1);

        // let head2 = document.createElement("th"); //create a header element (DOM manipulation);
        // head2.innerHTML = "Type"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head2);

        // let head3 = document.createElement("th"); //create a header element (DOM manipulation);
        // head3.innerHTML = "Amount"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head3);

        // let head4 = document.createElement("th"); //create a header element (DOM manipulation);
        // head4.innerHTML = "Date Submitted"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head4);

        // let head5 = document.createElement("th"); //create a header element (DOM manipulation);
        // head5.innerHTML = "Date Resolved"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head5);

        // let head6 = document.createElement("th"); //create a header element (DOM manipulation);
        // head6.innerHTML = "Description"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head6);

        // let head7 = document.createElement("th"); //create a header element (DOM manipulation);
        // head7.innerHTML = "Employee Contact"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head7);

        // let head8 = document.createElement("th"); //create a header element (DOM manipulation);
        // head8.innerHTML = "Status"; //populating the h3 with the name of the Pokemon
        // headrow.appendChild(head8);

        // document.getElementById("specificTicket").appendChild(headrow);



        // let row = document.createElement("tr"); 

        // let cell1 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell1.innerHTML = data.reimb_id; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell1);

        // let cell2 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell2.innerHTML = data.reimb_type_fk.reimb_type; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell2)

        // let cell3 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell3.innerHTML = data.reimb_amount; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell3);

        // let cell4 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell4.innerHTML = data.date_submitted; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell4)

        // let cell5 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell5.innerHTML = data.date_resolved; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell5);

        // let cell6 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell6.innerHTML = data.reimb_description; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell6);

        // let cell7 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell7.innerHTML = data.author.user_email; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell7)

        // let cell8 = document.createElement("td"); //create a header element (DOM manipulation);
        // cell8.innerHTML = data.reimb_status_fk.reimb_status; //populating the h3 with the name of the Pokemon
        // row.appendChild(cell8);

        // document.getElementById("displaySpecificTicket").appendChild(row);

     

            let reimbursement;

                ///if radio1.checked
                if(document.getElementById('customRadio1').checked == true) {   

                let ticketId = data.reimb_id;
                let amount = data.reimb_amount;
                let submitted  = data.date_submitted;
                let resolvedDate =  document.getElementById("todaysDate").value;
                let description = data.reimb_description;
                let userId =  data.author.user_id;
                let type  = data.reimb_type_fk.reimb_type_id;
                let resolver  = document.getElementById("managerID").value;
                

            
                 reimbursement = {
                    reimb_id: ticketId,
                    reimb_amount: amount,
                    date_submitted: submitted,
                    date_resolved: resolvedDate,
                    reimb_description: description,
                    author: {
                        user_id: userId
                    },
                    resolver: {
                    user_id: resolver
                    },
                    reimb_status_fk: {
                        reimb_status_id: 1
                    },
                    reimb_type_fk: {
                        reimb_type_id: type
                    }
                }
                document.getElementById("submitResolve").addEventListener("click", submitResolve(reimbursement));

            }    


        ///if radio2.checked
               if(document.getElementById('customRadio2').checked == true) {   

                let ticketId = data.reimb_id;
                let amount = data.reimb_amount;
                let submitted  = data.date_submitted;
                let resolvedDate = document.getElementById("todaysDate").value;
                let description = data.reimb_description;
                let userId =  data.author.user_id;
                let type  = data.reimb_type_fk.reimb_type_id; //make sure this is the id and not the "string" type
                let resolver  = document.getElementById("managerID").value;

            
                 reimbursement = {
                    reimb_id: ticketId,
                    reimb_amount: amount,
                    date_submitted: submitted,
                    date_resolved: resolvedDate,
                    reimb_description: description,
                    author: {
                        user_id: userId
                    },
                    resolver: {
                       user_id: resolver
                    },
                    reimb_status_fk: {
                        reimb_status_id: 2
                    },
                    reimb_type_fk: {
                        reimb_type_id: type
                    }
                }
                document.getElementById("submitResolve").addEventListener("click", submitResolve(reimbursement));
            
            }        

        }
        

    }   

  
    async function submitResolve(object) {


        let response = await fetch(url + "managerresolveticket", {

            method: "POST", //send as a POST request
            body: JSON.stringify(object), //turn into JSON
            credentials: "include" //this will ensure that the cookie is captured
                                //future fetches will also require this value to send the cookie back
            //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
            //Don't worry too much, we will learn Angular and life will be grand
        });

        if(response.status === 200) {
            console.log(response);
            alert("Ticket Resolved!");
            window.location.assign("ManagerPortal.html");
        }
    }










    // document.getElementById("viewApprovedTickets").addEventListener('click', viewApprovedTickets);
// async function viewApprovedTickets(){

//     let response = await fetch(url + 'managerviewalltickets', {credentials: 'include'});

//     if(response.status === 200) {
//         console.log(response);

//         let data = await response.json(); //get the JSON data from the response, turn it into JS object

//         for(let ticket of data) { //for every ability in the abilitiesArray...
//             console.log(ticket);

//             if(ticket.reimb_status_fk.reimb_status === "approved") {

//                 let row = document.createElement("tr"); 

//                 let cell1 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell1.innerHTML = ticket.reimb_id; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell1);
    
//                 let cell2 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell2.innerHTML = ticket.reimb_type_fk.reimb_type; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell2)
    
//                 let cell3 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell3.innerHTML = ticket.reimb_amount; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell3);
    
//                 let cell4 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell4.innerHTML = ticket.date_submitted; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell4)
    
//                 let cell5 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell5.innerHTML = ticket.date_resolved; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell5);
    
//                 let cell6 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell6.innerHTML = ticket.reimb_description; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell6);
    
//                 let cell7 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell7.innerHTML = ticket.author.user_email; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell7)
    
//                 let cell8 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell8.innerHTML = ticket.resolver.user_email; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell8)
    
//                 let cell9 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell9.innerHTML = ticket.reimb_status_fk.reimb_status; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell9);

//             document.getElementById("displayEmployeeTickets").appendChild(row);
//             } 
//         }   
//     }
// } 


// document.getElementById("viewDeniedTickets").addEventListener('click', viewDeniedTickets);
// async function viewDeniedTickets(){

//     let response = await fetch(url + 'managerviewalltickets', {credentials: 'include'});

//     if(response.status === 200) {
//         console.log(response);

//         let data = await response.json(); //get the JSON data from the response, turn it into JS object

//         for(let ticket of data) { //for every ability in the abilitiesArray...
//             console.log(ticket);

//             if(ticket.reimb_status_fk.reimb_status === "denied") {

//                 let row = document.createElement("tr"); 

//                 let cell1 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell1.innerHTML = ticket.reimb_id; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell1);
    
//                 let cell2 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell2.innerHTML = ticket.reimb_type_fk.reimb_type; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell2)
    
//                 let cell3 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell3.innerHTML = ticket.reimb_amount; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell3);
    
//                 let cell4 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell4.innerHTML = ticket.date_submitted; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell4)
    
//                 let cell5 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell5.innerHTML = ticket.date_resolved; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell5);
    
//                 let cell6 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell6.innerHTML = ticket.reimb_description; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell6);
    
//                 let cell7 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell7.innerHTML = ticket.author.user_email; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell7)
    
//                 let cell8 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell8.innerHTML = ticket.resolver.user_email; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell8)
    
//                 let cell9 = document.createElement("td"); //create a header element (DOM manipulation);
//                 cell9.innerHTML = ticket.reimb_status_fk.reimb_status; //populating the h3 with the name of the Pokemon
//                 row.appendChild(cell9);

//             document.getElementById("displayEmployeeTickets").appendChild(row);
//             } 
//         }   
//     }
// } 