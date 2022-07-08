let title = document.getElementById('user');
let user = sessionStorage.getItem('principal');

principal = JSON.parse(user);
console.log(`${principal.username}`);
title.innerHTML = `Welcome ${principal.username}`