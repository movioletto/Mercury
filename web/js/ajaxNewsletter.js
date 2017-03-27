$(document).ready(function(){
        $("#regione").change(function(){
           var regione = $(this).val();
           
            $.ajax({
            url: "Controller",
            method:"POST",
            data: "idregione="+regione+"&codice="+101,
            dataType:"text",
            async: "true",
            success:function(data){
                $('#provincia').html(data);
            }
        })
        
    
    
    })
    });
    
     $(document).ready(function(){
        $("#provincia").change(function(){
           var provincia = $(this).val();
           
            $.ajax({
            url: "Controller",
            method:"POST",
            data: "idprovincia="+provincia+"&codice="+102,
            dataType:"text",
            async: "true",
            success:function(data){
                $('#comune').html(data);
            }
        })
        
    
    
    })
    });
    

