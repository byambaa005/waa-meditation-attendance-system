// Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#dataTable').DataTable({
        // dom: 'B<"clear">lfrtip',
        buttons: [ 'copy', 'csv', 'excel' ]
    });

});
