$(document).ready(function() {
    $(function() {
        $(".submitbutton").click(function() {
            var buttonpressed = $(this).attr('value');
            if (buttonpressed === "Add/Change") {
                return true;
            } else if (buttonpressed === "Delete") {
                $('#form1').submit(function() {
                    if (!$('#form1 input[type="checkbox"]').is(':checked')) {
                        alert("Please check at least one.");
                        return false;
                    }
                });

            }
        });
    });
});

