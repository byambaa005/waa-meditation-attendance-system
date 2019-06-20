// Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#dataTable').DataTable({
        // dom: 'B<"clear">lfrtip',
        buttons: [ 'copy', 'csv', 'excel' ]
    });

    $("#btnSubmit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

    $("#logoutButton").click(function(event) {
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "http://localhost:8082/uploadFile",
            data: fd,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                $("#result").text(data);
                console.log("SUCCESS : ", data);
                $("#btnSubmit").prop("disabled", false);

            },
            error: function (e) {

                $("#result").text(e.responseText);
                console.log("ERROR : ", e);
                $("#btnSubmit").prop("disabled", false);

            }
        });
    })

});

function fire_ajax_submit() {

    let fd = new FormData();
    let file = document.forms['fileForm']['file'].files[0];
    fd.append( 'file', file);

    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "http://localhost:8082/uploadFile",
        data: fd,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $("#result").text(data);
            console.log("SUCCESS : ", data);
            $("#btnSubmit").prop("disabled", false);

        },
        error: function (e) {

            $("#result").text(e.responseText);
            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);

        }
    });

}
