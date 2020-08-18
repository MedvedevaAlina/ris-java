$(document).ready(function() {
    $("#personal-account").toggle(function() {
            $("#authentication_modal").fadeIn();
            return false; // не производить переход по ссылке
        },
        function() {
            $("#authentication_modal").fadeOut();
            return false; // не производить переход по ссылке
        });
});


$("#remove-td").live('click', function(event) {
    $(this).parent().remove();
});

// $(document).ready(function(){
//     $('.links').click(function(){
//         $(this).parent().children('div.update-body').toggle('normal');
//         return false;
//     });
// });

$(document).ready(function() {
    $(".links").toggle(function() {
            $(this).parent().children('div.update-body').fadeIn();
            return false; // не производить переход по ссылке
        },
        function() {
            $(this).parent().children('div.update-body').fadeOut();
            return false; // не производить переход по ссылке
        });
});



$( document ).ready(function(){
    $( "#checked-label" ).is(function(){
        $(this).parent(".update-body").css("display", "block");
    })
});

$(document).ready(function(){
    $('#checked-label').live("click",function(){
        $(this).parent("div.update-body").parent().parent().hide("slow");
        return false;
    });
});


$( document ).ready(function(){
    $(".convertDate").each(function (index, data) {
        var item = $(data).text();
        var options = {day:'2-digit', month: '2-digit', year:'numeric'}
        var deliveryTime = new Date(item*1);
        var fodeliveryTime  = deliveryTime.toLocaleDateString("ru-RU", options)
        $(this).replaceWith("<span>" + fodeliveryTime +"</span>");
    })
});

$( document ).ready(function(){
    $(".convertDate-td").each(function (index, data) {
        var item = $(data).text();
        var options = {day:'2-digit', month: 'long', year:'numeric'}
        var deliveryTime = new Date(item*1);
        var fodeliveryTime  = deliveryTime.toLocaleDateString("ru-RU", options)
        $(this).replaceWith("<td>" + fodeliveryTime +"</td>");
    })
});

// $( document ).ready(function(){
//     $("#count-item").each(function (index, data) {
//         var item = $(data).val();
//         var x= item.toFixed(2);
//         $(this).replaceWith("<span>"+ x +"</span>");
//     })
// });


$(document).ready(function($) {
    $('.popup-open').click(function() {
        $('.popup-fade').fadeIn();
        return false;
    });

    $('.popup-close').click(function() {
        $('.popup-fade').css("display","none");
        return false;
    });

    $('.popup-fade').click(function(e) {
        if ($(e.target).closest('.popup').length == 0) {
            $(this).fadeOut();
        }
    });
});


