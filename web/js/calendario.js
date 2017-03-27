$(function () {
    $("#dataStart").datepicker({
        dateFormat: "yy-mm-dd"
    });
    $("#dataFine").datepicker({
        dateFormat: "yy-mm-dd"
    });
    
    $("#dataInizio").datepicker({
        dateFormat: "yy-mm-dd"
    });
    
    $("#dataInizio").change(function () {
        
        $("#dataFine").datepicker("option", "minDate", $(this).datepicker('getDate'));
        
    });
});