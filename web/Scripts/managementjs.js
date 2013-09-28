
$(function() {
    var buttonpressed;
    $(".submitbutton").click(function() {
        buttonpressed = $(this).attr('value');
        if (buttonpressed === "Delete") {
            $('#form1').submit(function() {
                if (!$('#form1 input[type="checkbox"]').is(':checked')) {
                    alert("Please check at least one.");
                    return false;
                }
            });
        } else if (buttonpressed === "Add/Change") {
            
            return true;
            
        }

    });


});


