let apiUrl = 'http://127.0.0.1:8080/project-one';
let user = sessionStorage.getItem('principal');
let menuTitle = document.getElementById('title');
let welcome = document.getElementById('welcome');
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

        break;
    default:
        break;
}

async function  generateNewTix() {
    let response = await fetch(`${apiUrl}/tix`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
    });
}

