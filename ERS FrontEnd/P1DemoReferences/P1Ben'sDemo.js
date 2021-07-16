//I grabbed this base url from postman...what shows up 
//when you run as server & get your 404 page eventually we'll use this base url and make calls 
//to the server by adding endpoints to it
const url = 'http://localhost:8080/P1Demo/' 

//add functionality to our button using an eventListener
document.getElementById('getAvengerButton').addEventListener('click', assembleFunc);
//so when this button gets clicked, the function called assembleFunc will run
//we could've also used: document.getElementById('getAvengerButton').onclick(assembleFunc)

//this function will get all avengers from our Java based server
async function assembleFunc() { //asyn returns a promise (which fetch returns)

    //we weill send a fetch request to get out avenger data
    //await makes the asyn function wait until the promise returns with the fetched data
    let response = await fetch(url + 'avengers'); 

    if(response.status === 200) { //if the request is successful
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the json data from the response, & turn it into a JS object

        //now, I want to put each avenger into my table
        for(let avenger of data) { //for every avenger in the data variable object

            console.log(avenger); //just for debug, print avenger in the console

            let row = document.createElement("tr"); //create a table row 

            let cell = document.createElement("td");//create a cell for the field
            cell.innerHTML = avenger.av_id; //fill the cell w/ avenger data
            row.appendChild(cell); //this row now has the first cell (av_id)

            //then we'll do that ^ for each field in the avenger model
            let cell2 = document.createElement("td");
            cell2.innerHTML = avenger.av_name;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = avenger.av_power;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = avenger.first_name;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = avenger.last_name;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = avenger.power_level;
            row.appendChild(cell6);


            //if the avenger has a home, just fill the cell with the home name
            if(avenger.home_fk != null){
                console.log("home came through")
                let cell7 = document.createElement("td");
                cell7.innerHTML = avenger.home_fk.homeName;
                row.appendChild(cell7);
            } else { //otherwise, still append the cell but leave it empty
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            document.getElementById("avengerBody").appendChild(row);
            //so that the variable "row" created allll the way at the top of our loop
            //will be appended to our empty body in the HTML
        }
    }
}




