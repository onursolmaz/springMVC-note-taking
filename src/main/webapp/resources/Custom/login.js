function addUser() {
    var param = {
        username: $('#username').val(),
        name: $('#name').val(),
        surname: $('#surname').val(),
        email: $('#email').val(),
        pass: $('#pass').val(),
        pass2: $('#pass2').val(),

    }
    var ser_data = JSON.stringify(param);
    $.ajax({

        type: "POST",
        contentType: 'application/json; charset=UTF-8',
        url: 'addUser',
        data: ser_data,
        success: function (data) {
            if (data == "Passwords not match") {
                errorAlert("Passwords not match !!! ");
            } else if (data == "ERROR") {
                errorAlert("Error Occurred!");
            } else {
                successAlert();
                goLoginPage();

            }

        }, error: function (data) {
            alert("Error Occurred");
        }

    });
}

function goLoginPage(){
    setTimeout(function () {
        $(location).attr("href", "/register?status=checkMail")
    }, 1350);
}

function login() {
    var param = {
        username: $('#username').val(),
        pass: $('#pass').val(),
    }
    var ser_data = JSON.stringify(param);
    $.ajax({

        type: "POST",
        contentType: 'application/json; charset=UTF-8',
        url: 'loginUser',
        data: ser_data,
        success: function (data) {
            if (data == "OK") {
                successLoginAlert();
                setTimeout(function () {
                    $(location).attr("href", "/")
                }, 1500);
            } else if (data == "ERROR") {
                errorAlert("Username or Password incorrect");
            }
        }, error: function (data) {
            errorAlert("Error Occurred");
        }
    });
}


function successAlert() {
    Swal.fire(
        'Good job!',
        'Successfully, please check your E-mail !!! ',
        'success'
    )
}

function successLoginAlert() {
    Swal.fire(
        'Good job!',
        'Successfully logged in',
        'success'
    )
}

function errorAlert(message) {
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: message,
    })
}

