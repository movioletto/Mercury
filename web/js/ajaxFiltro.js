 $(document).ready(function(){
        $("#regione2").change(function(){
           var regione2 = $(this).val();
           
           $.ajax({
            url: "Controller",
            method:"POST",
            data: "idregione="+regione2+"&codice="+101,
            dataType:"text",
            async: "true",
            success:function(data){
                $('#provincia2').html(data);
            }
        })
           
           
            
            })
        });
    
    $(document).ready(function(){
        $("#provincia2").change(function(){
           var provincia2 = $(this).val();
           
            $.ajax({
            url: "Controller",
            method:"POST",
            data: "idprovincia="+provincia2+"&codice="+102,
            dataType:"text",
            async: "true",
            success:function(data){
                $('#comune2').html(data);
            }
        })
        
    
    
    })
    });
    