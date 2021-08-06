$(document).ready(function () {
    getNote();
});

function getNote() {
    $("#note_title").attr("disabled", true)
    $("#note_content").attr("disabled", true)
    $("#updateBtn").html("Update");
    $.ajax({
        type: "POST",
        url: './../getNote',
        contentType: 'text/plain;',
        data: $("#id").val() + "",
        success: function (data) {
            $("#note_title").val(data.title);
            $("#note_content").html(data.content);
        }, error: function (data) {
            if (data.responseText == "UNAUTHORIZED") {
                errorAlert("Unauthorized Request !!!");
                setTimeout(function () {
                    window.history.back();
                }, 2000);
            }else{
                alert("Error occurred while getting note");
            }

        }
    });

}

var updated = false;

function update() {
    if (!updated) {
        $("#note_title").attr("disabled", false)
        $("#note_content").attr("disabled", false)
        $("#updateBtn").html("Save");
    } else {
        updateNote()
    }
    updated = !updated;

}

function updateNote() {
    var param = {
        id: $("#id").val(),
        title: $('#note_title').val(),
        content: $('#note_content').val()
    }
    var ser_data = JSON.stringify(param);
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=UTF-8',
        url: './../updateNote',
        data: ser_data,
        success: function (data) {
            getNote();
            succesAlert();
        }, error: function (data) {
            errorAlert("Error occurred while updating note");

        }

    });
}

function succesAlert() {
    Swal.fire(
        'Good job!',
        'Your note has been saved successfully',
        'success',
    )

}

function errorAlert(message) {
    Swal.fire(
        'Opps...!',
        message,
        'error',
    )
}

function deleteNote() {
    var param = {
        id: $("#id").val(),
    }
    var ser_data = JSON.stringify(param);
    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=UTF-8',
        url: './../deleteNote',
        data: ser_data,
        success: function (data) {
            succesAlert();
            setTimeout(function () {
                window.history.back();
            }, 2000);
        }, error: function (data) {
            errorAlert("Error occurred while deleting note");
        }

    });

}

function openModel() {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!',
        customClass: 'sweetalert-lg'
    }).then((result) => {
        if (result.value) {
            deleteNote();
        }
    });


}


