function addNote() {
    var param = {
        title: $('#note_title').val(),
        content: $('#note_content').val()
    }
    var ser_data = JSON.stringify(param);
    $.ajax({

        type: "POST",
        contentType: 'application/json; charset=UTF-8',
        url: 'addNote',
        data: ser_data,
        success: function (data) {
            successAlert();
            setTimeout(function(){
                window.history.back();
            }, 2000);
        }, error: function (data) {
            alert("Occured a error");
        }

    });
}

function successAlert(){
    Swal.fire(
        'Good job!',
        'Your note has been saved successfully',
        'success'
    )

}

$(document).ready(function () {

    getNotes();

    setInterval(function () {
        getNotes();
    }, 2500);

});


function getNotes() {
    $.ajax({
        type: "POST",
        url: 'getNotes',
        success: function (data) {
            var note_list = "";
            $(data).each(function (i, val) {
                note_list = note_list
                    + ' <article className="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12">'
                    + '    <h2 className="fh5co-article-title"><a href="detail/' + val.id + '">' + val.title + '</a></h2>'
                    + '    <h3><a href="detail/' + val.id + '" style="color:#999999">' + val.content + '</a></h3>'
                    + '   <span className="fh5co-meta fh5co-date">' + new Date(val.create_date).toLocaleString() + '</span>'
                    + '  </article> ';
            });

            $("#note_list").html(note_list)
            mobileMenuOutsideClick();
            burgerMenu();
            scrolledWindow();

            Animations
            contentWayPoint();
        }, error: function (data) {
            alert("Notlar yüklenirken bir hata oluştu");
        }
    });

}


