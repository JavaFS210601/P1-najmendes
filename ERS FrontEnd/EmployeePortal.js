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


// WAS TRYING TO TOGGLE VISIBILITY OF THE "submit ticket below" DIV...HAVEN'T FIGURED IT OUT YET...
    //document.getElementById("newTicket").addEventListener('click', showTicketSubmission);
    // function showTicketSubmission() {
    //     var toggle = document.getElementById("hiddenTicketSubmission");
    //     // div.style.display = div.style.display ==="none" ? "block" : "none;" 
    //     if (toggle.style.display === "none") {
    //         toggle.style.display = "initial";
    //       } else {
    //         toggle.style.display = "none";
    //       }
    // }