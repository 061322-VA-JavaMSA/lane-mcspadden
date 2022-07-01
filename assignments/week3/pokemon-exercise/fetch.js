// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);
document.getElementById('next').addEventListener("click", NextData);
document.getElementById('prev').addEventListener("click", PrevData);

/*
    - When button is clicked, send http request to API for a specific id
    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object
    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';
let subApiURL = 'https://github.com/filipekiss/pokemon-type-chart/blob/master/types.json'

async function NextData() {
    document.getElementById('dataInput').value--;
    getData();
}

async function PrevData() {
    document.getElementById('dataInput').value++;
    getData();
}

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);
    let data = null;
    let data2 = null;
    let data3 = null;
    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){
    data = await httpResponse.json();

    } else {
        let name = document.getElementById('name');
        name.innerHTML = 'Missingno.';

        let invalid = document.getElementById('invalid');
        invalid.innerHTML = 'You have entered an invalid pokemon number, enjoy the easter egg';
        let type1 = document.getElementById('type1');
        type1.innerHTML = "Missingno."
        let type2 = document.getElementById('type2');
        type2.innerHTML = "Missingno."

        let picture = document.getElementById('picture');
        let shiny_picture = document.getElementById('shiny_picture');
        
        picture.setAttribute('src', 'https://static.wikia.nocookie.net/errors/images/d/d3/Missingno.jpg');
        shiny_picture.setAttribute('src', '');
        console.log('Invalid request.');
    }

    id--;
    console.log(id);
    let httpResponse2 = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse2.status >= 200 && httpResponse2.status < 300) {
    data2 = await httpResponse2.json();
    }
    id+=2;
    console.log(id);
    let httpResponse3 = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse3.status >= 200 && httpResponse3.status < 300) {
    data3 = await httpResponse3.json();
    }

    populateData(data3, data, data2);
}



function populateData(prevR, response, nextR) {

    let picture = document.getElementById('picture');
    let shiny_picture = document.getElementById('shiny_picture');
    let type1 = document.getElementById('type1');
    let type2 = document.getElementById('type2');
    let name = document.getElementById('name');
    let weight = document.getElementById('weight')
    let invalid = document.getElementById('invalid');

    let prevPic = document.getElementById('prevImg');
    
    prevPic.setAttribute('src',`${prevR.sprites.front_default}`)

    
    let nextPic = document.getElementById('nextImg');
    

    nextPic.setAttribute('src',`${nextR.sprites.front_default}`)
    


    invalid.innerHTML = '';

    picture.setAttribute('src', `${response.sprites.front_default}`);
    shiny_picture.setAttribute('src', `${response.sprites.front_shiny}`);
    name.innerHTML = (`${response.name}`);

    type1.innerHTML =  (`${response.types[0].type.name}`);
    console.log((`${response.types.length}`))
    if((`${response.types.length}`) == 2) {
        type2.innerHTML =  (`${response.types[1].type.name}`);
    } else {
        type2.innerHTML = ' ';
    }

    console.log(response);
}