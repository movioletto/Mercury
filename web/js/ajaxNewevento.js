 $(document).ready(function(){
        $("#regione3").change(function(){
           var regione3 = $(this).val();
           
           $.ajax({
            url: "Controller",
            method:"POST",
            data: "idregione="+regione3+"&codice="+101,
            dataType:"text",
            async: "true",
            success:function(data){
                $('#provincia3').html(data);
            }
        })
           
           
            
            })
        });
    
    $(document).ready(function(){
        $("#provincia3").change(function(){
           var provincia3 = $(this).val();
           
            $.ajax({
            url: "Controller",
            method:"POST",
            data: "idprovincia="+provincia3+"&codice="+102,
            dataType:"text",
            async: "true",
            success:function(data){
                $('#comune3').html(data);
            }
        })
        
    
    
    })
    });
    