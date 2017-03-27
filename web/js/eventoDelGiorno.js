$(document).ready(function(){
    $('#delGiorno').change(function () {
    $('#dataInizio').attr('disabled', this.checked);
    $('#dataFine').attr('disabled', this.checked);

});  
});