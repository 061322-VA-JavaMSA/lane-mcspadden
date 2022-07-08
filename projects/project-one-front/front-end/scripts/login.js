let apiUrl = 'http://127.0.0.1:8080/project-one';

let loginButton = document.getElementById('submitButton');
loginButton.addEventListener('click', login);

if(sessionStorage.getItem('principal')) {
    window.location.href="./home.html";
};

async function login(){
    console.log("Ran login");
    let incorrectSplash = document.getElementById('incorrect');
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    let response = await fetch(`${apiUrl}/auth`, {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },

        body: new URLSearchParams({
            'username': `${username}`,
            'password': `${password}`
        })
    });

    if(response.status == 200){
        let data = await response.json();

        sessionStorage.setItem('principal', JSON.stringify(data));

        window.location.href="./home.html";
    } else {
        incorrectSplash.style.visibility = "visible";
    }


}