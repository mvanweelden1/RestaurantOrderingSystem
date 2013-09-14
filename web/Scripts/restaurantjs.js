
$(document).ready(function() {

    $('#form1').submit(function() {
        if (!$('#form1 input[type="checkbox"]').is(':checked')) {
            alert("Please check at least one.");
            return false;
        }
    });
});


