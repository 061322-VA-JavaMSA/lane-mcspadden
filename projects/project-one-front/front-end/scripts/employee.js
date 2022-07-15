let apiUrl = 'http://127.0.0.1:8080/project-one';

//NavBar
let home = document.getElementById('home');
let newRequest = document.getElementById('loadRequests');
let history = document.getElementById('history');

//Forms
let subForm = document.getElementById('submissionForm');
let historyForm = document.getElementById('historyScreen')

//Submit Button
let subButton = document.getElementById('submitButton');

//Event Listeners
newRequest.addEventListener('click', loadSubmissionScreen);
history.addEventListener('click', loadHistoryScreen);
history.addEventListener('click', loadHistoryScreen2);
home.addEventListener('click', goToHome);
subButton.addEventListener('click', submitRequestForm);


//Magician Methods

function loadSubmissionScreen() {
    subForm.setAttribute('style', 'display: true');
    historyForm.setAttribute('style', 'display: none');
}

function loadHistoryScreen2() {
    historyForm.setAttribute('style', 'display: true');
    subForm.setAttribute('style', 'display: none');
}

function goToHome() {
    subForm.setAttribute('style', 'display: none');
    historyForm.setAttribute('style', 'display: none');
}



//Servlet Methods
async function loadHistoryScreen() {
    let principal = JSON.parse(sessionStorage.getItem('principal'));
    principal = principal.id;

    let table = document.getElementById('pending').getElementsByTagName('tbody')[0];

    while (table.hasChildNodes()) {
        table.removeChild(table.firstChild);
    }

//Pending
    let response = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'mode': 'PENDING_BY_ID',
            'id': `${principal}`
        })
    });

    if (response.status == 200) {
        let data = await response.json();
        let counter = 0;
        for (each in data) {
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
    }

    //Accepted
    let table2 = document.getElementById('accepted').getElementsByTagName('tbody')[0];

    while (table2.hasChildNodes()) {
        table2.removeChild(table2.firstChild);
    }

    let response2 = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'mode': 'ACCEPTED_BY_ID',
            'id': `${principal}`
        })
    });

    if (response2.status == 200) {
        let data = await response2.json();
        console.log(data)
        let counter = 0;
        for (each in data) {
            console.log(counter)
            var row = table2.insertRow(counter);
            var cell01 = row.insertCell(0);
            cell01.innerHTML = `${data[counter].requestId}`
            var cell01 = row.insertCell(1);
            cell01.innerHTML = `${data[counter].author.firstName} ${data[counter].author.lastName}`
            var cell01 = row.insertCell(2);
            let date = new Date(`${data[counter].dateSubmitted}` * 1);
            cell01.innerHTML = date.toLocaleDateString('en-US');
            var cell01 = row.insertCell(3);
            let date2 = new Date(`${data[counter].dateResolved}` * 1);
            cell01.innerHTML = date2.toLocaleDateString('en-US');
            var cell01 = row.insertCell(4);
            cell01.innerHTML = `${data[counter].ammount}`
            var cell01 = row.insertCell(5);
            cell01.innerHTML = `${data[counter].desc}`
            var cell01 = row.insertCell(6);
            cell01.innerHTML = `${data[counter].type}`
            var cell01 = row.insertCell(7);
            cell01.innerHTML = `${data[counter].caseManager.firstName} ${data[counter].caseManager.lastName}`
            counter++;
        }
    }

    let table3 = document.getElementById('denied').getElementsByTagName('tbody')[0];

    while (table3.hasChildNodes()) {
        table3.removeChild(table3.firstChild);
    }

    let response3 = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'mode': 'DENIED_BY_ID',
            'id': `${principal}`
        })
    });

    if (response3.status == 200) {
        let data = await response3.json();
        let counter = 0;
        for (each in data) {
            console.log(counter)
            var row = table3.insertRow(counter);
            var cell01 = row.insertCell(0);
            cell01.innerHTML = `${data[counter].requestId}`
            var cell01 = row.insertCell(1);
            cell01.innerHTML = `${data[counter].author.firstName} ${data[counter].author.lastName}`
            var cell01 = row.insertCell(2);
            let date = new Date(`${data[counter].dateSubmitted}` * 1);
            cell01.innerHTML = date.toLocaleDateString('en-US');
            var cell01 = row.insertCell(3);
            let date2 = new Date(`${data[counter].dateResolved}` * 1);
            cell01.innerHTML = date2.toLocaleDateString('en-US');
            var cell01 = row.insertCell(4);
            cell01.innerHTML = `${data[counter].ammount}`
            var cell01 = row.insertCell(5);
            cell01.innerHTML = `${data[counter].desc}`
            var cell01 = row.insertCell(6);
            cell01.innerHTML = `${data[counter].type}`
            var cell01 = row.insertCell(7);
            cell01.innerHTML = `${data[counter].caseManager.firstName} ${data[counter].caseManager.lastName}`
            counter++;
        }
    }
}




async function submitRequestForm() {
    let ammount = document.getElementById('amount').value;
    let desc = document.getElementById('desc').value;
    let type = document.getElementById('type').value;
    let author = JSON.parse(sessionStorage.getItem('principal'));
    let email = document.getElementById('email').value;
    author = author.id;




    let response = await fetch(`${apiUrl}/create`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'ammount': `${ammount}`,
            'desc': `${desc}`,
            'type': `${type}`,
            'author': `${author}`,
            'email': `${email}`
        })
    });

    if (response.status == 200) {
        console.log('Complete!')
    }
}


