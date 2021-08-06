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
            if(data=="Passwords not match"){
                errorAlert();
            }else if(data=="ERROR"){
                errorAlert("Error Occurred");
            }
            else{
                successAlert();
            }

        }, error: function (data) {
            alert("Error Occurred");
        }

    });
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
            if(data=="OK"){
                successLoginAlert();
                setTimeout(function(){
                    $(location).attr("href","/")
                }, 1300);
            }else if(data=="ERROR"){
                errorAlert("Username or Password incorrect");
            }
        }, error: function (data) {
            errorAlert("Error Occurred");
        }
    });
}







function successAlert(){
    Swal.fire(
        'Good job!',
        'Successfully registered Please check the your e-mail for complete the registration',
        'success'
    )
}

function successLoginAlert(){
    Swal.fire(
        'Good job!',
        'Successfully logged into the system',
        'success'
    )
}

function errorAlert(message){
    Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: message,
    })
}

