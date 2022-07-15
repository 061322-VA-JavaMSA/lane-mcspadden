let apiUrl = 'http://127.0.0.1:8080/project-one';


//NavBar
let home = document.getElementById('home');
let viewPending = document.getElementById('viewPending');
let history = document.getElementById('viewHistory');
let indHistory = document.getElementById('indHistory');

//Buttons
let submitChoice = document.getElementById('submitButton');
let select = document.getElementById('names')

//Forms
let pendingPage = document.getElementById('pending');
let historyPage = document.getElementById('history');
let indHistoryPage = document.getElementById('indHistoryScreen');

//Event Listeners
select.addEventListener('change', loadUserRequests)
viewPending.addEventListener('click', loadPendingPage);
indHistory.addEventListener('click', loadIndHistoryPage)
history.addEventListener('click', loadHistoryPage)
submitChoice.addEventListener('click', submitResponse)



//Magician Methods

async function loadUserRequests() {
    let choice = select.value;
    let response = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams ({
            'mode' : 'ALL_USER_INFO',
            'id': `${choice}`
        })
    });

    let table = document.getElementById('indHistoryTbl').getElementsByTagName('tbody')[0];

    
    while (table.hasChildNodes()) {
        table.removeChild(table.firstChild);
    }

    if (response.status == 200) {
        let data = await response.json();

        console.log(data);
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
            let date2 = new Date(`${data[counter].dateSubmitted}` * 1);
            cell01.innerHTML = date2.toLocaleDateString('en-US');
            var cell01 = row.insertCell(4);
            cell01.innerHTML = `${data[counter].ammount}`
            var cell01 = row.insertCell(5);
            cell01.innerHTML = `${data[counter].desc}`
            var cell01 = row.insertCell(6);
            cell01.innerHTML = `${data[counter].type}`
            var cell01 = row.insertCell(7);
            cell01.innerHTML = `${data[counter].status}`

            if(`${data[counter].status}` != 'PENDING') {
                var cell01 = row.insertCell(8);

                cell01.innerHTML = `${data[counter].caseManager.firstName} ${data[counter].caseManager.lastName}`;

            }
            
            counter++;
        }
    }
}

async function loadIndHistoryPage() {
    indHistoryPage.setAttribute('style', 'display: true');
    pendingPage.setAttribute('style', 'display: none');
    historyPage.setAttribute('style', 'display: none');

    let response = await fetch(`${apiUrl}/users`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams ({
            'mode' : 'ALL',
            'id': '1'
        })
    });
    let data = await response.json();
    let nameDropDown = document.getElementById('names');

    while (nameDropDown.hasChildNodes()) {
        nameDropDown.removeChild(nameDropDown.firstChild);
    }
    let counter = 0;
    for(each in data) {
        console.log(data)
        let option = document.createElement('option');
        option.value = `${data[counter].id}`
        option.text = `${data[counter].firstName} ${data[counter].lastName}`
        nameDropDown.add(option);
        counter++;
    }


}

async function loadHistoryPage() {
    indHistoryPage.setAttribute('style', 'display: none');
    pendingPage.setAttribute('style', 'display: none');
    historyPage.setAttribute('style', 'display: true');

    let principal = JSON.parse(sessionStorage.getItem('principal'));
    let idDropDown = document.getElementById('id');
    principal = principal.id;

    let table = document.getElementById('historyTbl').getElementsByTagName('tbody')[0];

    while (table.hasChildNodes()) {
        table.removeChild(table.firstChild);
    }

    let response = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams ({
            'mode' : 'ALL',
            'id': '1'
        })
    });

    if (response.status == 200) {
        let data = await response.json();
        console.log(data);
        let counter = 0;
        for (each in data) {
            console.log(counter)
            var row = table.insertRow(counter);
            var cell01 = row.insertCell(0);
            cell01.innerHTML = `${data[counter].requestId}`
            let option = document.createElement('option');
            option.value = `${data[counter].requestId}`;
            option.text = `${data[counter].requestId}`
            idDropDown.add(option)
            var cell01 = row.insertCell(1);
            cell01.innerHTML = `${data[counter].author.firstName} ${data[counter].author.lastName}`
            var cell01 = row.insertCell(2);
            let date = new Date(`${data[counter].dateSubmitted}` * 1);
            cell01.innerHTML = date.toLocaleDateString('en-US');
            var cell01 = row.insertCell(3);
            let date2 = new Date(`${data[counter].dateSubmitted}` * 1);
            cell01.innerHTML = date.toLocaleDateString('en-US');
            var cell01 = row.insertCell(4);
            cell01.innerHTML = `${data[counter].ammount}`
            var cell01 = row.insertCell(5);
            cell01.innerHTML = `${data[counter].desc}`
            var cell01 = row.insertCell(6);
            cell01.innerHTML = `${data[counter].type}`
            var cell01 = row.insertCell(7);
            cell01.innerHTML = `${data[counter].status}`
            if(`${data[counter].status}` != 'PENDING') {
                var cell01 = row.insertCell(8);

                cell01.innerHTML = `${data[counter].caseManager.firstName} ${data[counter].caseManager.lastName}`;

            }

            
            counter++;
        }
    }
}

async function submitResponse() {
    let id = document.getElementById('id').value;
    let accden = document.getElementById('choice').value;
    if (accden === 'ACCEPT') {
        accden = 'ACCEPTED';
    } else {
        accden = 'DENIED';
    }
    let principal = JSON.parse(sessionStorage.getItem('principal'));
    principal = principal.id;

    let response = await fetch(`${apiUrl}/status`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'id': `${id}`,
            'accden': `${accden}`,
            'emp_id': `${principal}`
        })
    });



}



async function loadPendingPage() {
    indHistoryPage.setAttribute('style', 'display: none');
    pendingPage.setAttribute('style', 'display: true');
    historyPage.setAttribute('style', 'display: none');

    let principal = JSON.parse(sessionStorage.getItem('principal'));
    let idDropDown = document.getElementById('id');
    principal = principal.id;

    let table = document.getElementById('pending').getElementsByTagName('tbody')[0];


    let response = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'mode': 'ALL_PENDING',
            'id': `${principal}`
        })
    });

    if (response.status == 200) {
        let data = await response.json();
        while (idDropDown.hasChildNodes()) {
            idDropDown.removeChild(idDropDown.firstChild);
        }

        while (table.hasChildNodes()) {
            table.removeChild(table.firstChild);
        }


        let counter = 0;
        for (each in data) {
            console.log(counter)
            var row = table.insertRow(counter);
            var cell01 = row.insertCell(0);
            cell01.innerHTML = `${data[counter].requestId}`
            let option = document.createElement('option');
            option.value = `${data[counter].requestId}`;
            option.text = `${data[counter].requestId}`
            idDropDown.add(option)
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
}

