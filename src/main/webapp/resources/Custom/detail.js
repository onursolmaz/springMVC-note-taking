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
            alert("Notlar yüklenirken bir hata oluştu");
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
    updated=!updated;

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
            errorAlert()

        }

    });
}

function succesAlert(){
    Swal.fire(
        'Good job!',
        'Your note has been saved successfully',
        'success'
    )

}

function errorAlert(){
    Swal.fire(
        'Good job!',
        'Your note has been saved successfully',
        'success'
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
            setTimeout(function(){
                window.history.back();
            }, 2000);
        }, error: function (data) {
            errorAlert();
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
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            deleteNote();
        }
    });




}

