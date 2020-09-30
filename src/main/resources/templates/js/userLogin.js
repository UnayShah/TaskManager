document.addEventListener("DOMContentLoaded", function () {
    console.log("Loaded");
    var username = document.getElementById("username");
    var password = document.getElementById("password");

    var emptyFieldUsername = document.getElementById("emptyFieldUsername");
    var emptyFieldPassword = document.getElementById("emptyFieldPassword");

    username.addEventListener("blur", function (event) {
        if (validateEmpty(event.target)) {
            emptyFieldUsername.style.visibility = 'visible';
            emptyData(event.target, 'Username');
            event.target.style.border = "2px solid red"
        }
        else {
            event.target.style.border = "0"
            emptyFieldUsername.style.visibility = 'hidden';
        }
    });

    password.addEventListener("blur", function (event) {
        if (validateEmpty(event.target)) {
            emptyFieldPassword.style.visibility = 'visible';
            emptyData(event.target, 'password');

        }
        else {
            emptyFieldPassword.style.visibility = 'hidden';
        }
    });

    // var loginButton = document.getElementById("loginButton");
    var signUpButton = document.getElementById("signUpButton");
    signUpButton.addEventListener("click", () => {
        if (username.value == null || username.value == undefined || username.value.length == 0) {
            username.value = "";
        }
    })
    loginButton.addEventListener("click", function (event) {
        const url = "http://localhost:8080/login";
        const params = { 'username': username.value, 'password': password.value };
        loginFunction(params, url);
    });

});

async function loginFunction(params, url) {
    var errorCredentials = document.getElementById('errorCredentials');
    try {
        let value = await axios.post(url, params);
        console.log(value.data);
        if (value.data == true) {
            localStorage.setItem('userLogin', JSON.stringify(params));
            window.location.replace("noteTemplate.html");
            errorCredentials.style.visibility = 'hidden';
        }
        else {
            errorCredentials.style.visibility = 'visible';
        }
    } catch (e) {
        console.log(e);
    }
}
function printValue(element) {
    console.log(element.value);
}

function emptyData(element, field) {
    console.log("EMPTY", field, element.value);
}

function validateEmpty(element) {
    if (element.value == "" || element.value == null || element.value == undefined) {
        return true;
    }
    else {
        return false;
    }
}
