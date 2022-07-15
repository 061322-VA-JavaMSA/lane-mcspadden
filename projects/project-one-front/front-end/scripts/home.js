let apiUrl = 'http://127.0.0.1:8080/project-one';
let user = sessionStorage.getItem('principal');
let menuTitle = document.getElementById('title');
let welcome = document.getElementById('welcome');
let accden = document.getElementById('acceptordeny');
accden.addEventListener('click', changeButtonValue);
principal = JSON.parse(user);
console.log(principal)
menuTitle.innerHTML = `${principal.title} Home`;
welcome.innerText = `Welcome ${principal.fname}`;


switch (`${principal.title}`) {
    case "MANAGER":
        let generatorButton = document.getElementById('submitButton');
        generatorButton.innerHTML = "Generate New Requests";
        generatorButton.addEventListener('click', generateNewTix);

    
        break;
    case "EMPLOYEE":
        let generatorButton1 = document.getElementById('submitButton');
        let form = document.getElementById('submissionForm')
        form.setAttribute(
            'style', 'visibility: true; display: true;'
        )
        generatorButton1.addEventListener('click', createNewTix);
        generatorButton1.innerHTML = "Submit request";
        break;
    default:
        break;
}

async function createNewTix() {
    let ammount = document.getElementById('ammount').value;
    let dateSub = new Date().getDate();
    let desc = document.getElementById('desc').value;
    let author = principal.id;
    let type = document.getElementById('type').value; 
console.log('hello')
    let response = await fetch(`${apiUrl}/create`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },        
        body: new URLSearchParams({
            'ammount': `${ammount}`,
            'dateSub': `${dateSub}`,
            'desc': `${desc}`,
            'author': `${author}`,
            'type': `${type}`
        })
    });

    let data = await response.json();
}

function changeButtonValue() {
    if(document.getElementById('acceptordeny').value === 'false') {
        document.getElementById('acceptordeny').value = 'true'
    } else {
        document.getElementById('acceptordeny').value = 'false'
    }
    ;
}

async function  generateNewTix() {
    document.getElementById('acceptordeny').value = false;


    let response = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: {

        }
    });
    let table2 = document.getElementById('pending')
    table2.setAttribute('style', 'display: true;')
    
    let data = await response.json();
    let table = document.getElementById('pending').getElementsByTagName('tbody')[0];

    while(table.hasChildNodes())
    {
        table.removeChild(table.firstChild);
    }


    let counter = 0;
    for(each in data) {
        console.log(counter)
        var row = table.insertRow(counter);
        var cell01 = row.insertCell(0);
        cell01.innerHTML = `${data[counter].requestId}`
        var cell01 = row.insertCell(1);
        cell01.innerHTML = `${data[counter].author.firstName} ${data[counter].author.lastName}`
        var cell01 = row.insertCell(2);
        let date = new Date(`${data[counter].dateSubmitted}` * 1);
        cell01.innerHTML = date.toLocaleDateString('en-US');
        var cell01 = row.insertCell(3);
        cell01.innerHTML = `${data[counter].ammount}`
        var cell01 = row.insertCell(4);
        cell01.innerHTML = `${data[counter].desc}`
        var cell01 = row.insertCell(5);
        cell01.innerHTML = `${data[counter].type}`
        counter++;
    }

    console.log(data);
}

async function updateTix() {
    let choice = document.getElementById('choice').value;
    let value = document.getElementById('acceptordeny').value;
    let status = null
    if(value === 'false') {
        status = 'DENIED'
    } 
    if(value === 'true') {
        status = 'ACCEPTED'
    }
    console.log(status);

    let response = await fetch(`${apiUrl}/status`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'reqID': `${choice}`,
            'newStatus': `${status}`,
        })
    });
}

