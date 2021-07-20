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

            let cell10 = document.createElement("button"); //create a header element (DOM manipulation);
            cell10.innerHTML = document.createElement("button"); //populating the h3 with the name of the Pokemon
            row.appendChild(cell10);
            
            document.getElementById("displayEmployeeTickets").appendChild(row);
        } 
    }   
}


document.getElementById("viewApprovedTickets").addEventListener('click', viewApprovedTickets);
async function viewApprovedTickets(){

    let response = await fetch(url + 'managerviewalltickets', {credentials: 'include'});

    if(response.status === 200) {
        console.log(response);

        let data = await response.json(); //get the JSON data from the response, turn it into JS object

        for(let ticket of data) { //for every ability in the abilitiesArray...
            console.log(ticket);

            if(ticket.reimb_status_fk.reimb_status === "approved") {

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
} 


document.getElementById("viewDeniedTickets").addEventListener('click', viewDeniedTickets);
async function viewDeniedTickets(){

    let response = await fetch(url + 'managerviewalltickets', {credentials: 'include'});

    if(response.status === 200) {
        console.log(response);

        let data = await response.json(); //get the JSON data from the response, turn it into JS object

        for(let ticket of data) { //for every ability in the abilitiesArray...
            console.log(ticket);

            if(ticket.reimb_status_fk.reimb_status === "denied") {

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
} 


document.getElementById("viewUnresolved").addEventListener('click', viewUnresolvedTickets);
async function viewUnresolvedTickets(){

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
            document.getElementById("displayUnresolvedTickets").appendChild(row);
            } 
        }   
    }
} 





//resolve ticket!!!