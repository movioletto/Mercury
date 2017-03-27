            $(document).scroll(function () {
                if ($(this).scrollTop() > 10) {
                    $("#imgLogo").css("height", "60px");
                    $("#imgLogo").css("margin-top", "-4px");
                    $("#imgLogo").css("transition", "height 0.3s, width 0.3s, display 0.2s");
                    $("#imgLogo").css("transition-delay", "0s, 0s, 0.4s");
                    $("#divLogo").css("width", "300px");
                    $("#divLogo").css("height", "50px");
                    $("#divLogo").css("transition", "height 0.3s, width 0.2s");
                    $("#divLogo").css("transition-delay", "0s, 0.3s");
                    $("#hiddenItem").css("width", "116px");
                    $("#hiddenItem").css("transition", "width 0.2s");
                    $("#hiddenItem").css("transition-delay", "0.3s");
                    


                }
            });
            $(document).scroll(function () {
                if ($(this).scrollTop() < 9) {
                    $("#hiddenItem").css("width", "1px");
                    $("#hiddenItem").css("transition", "width 0.2s");
                    $("#hiddenItem").css("transition-delay", "0s");
                    $("#imgLogo").css("margin-top", "0px");
                    $("#divLogo").css("width", "140px");
                    $("#divLogo").css("height", "145px");
                    $("#divLogo").css("transition", "height 0.3s, width 0.2s");
                    $("#divLogo").css("transition-delay", "0.1s, 0s");
                    $("#imgLogo").css("height", "140px");
                    $("#imgLogo").css("transition", "height 0.3s, width 0.3s, display 0.2s");                    
                    $("#imgLogo").css("transition-delay", "0.1s, 0.1s, 0.4s");
                    $("#divLogo").css("width", "140px");
                    $("#divLogo").css("height", "145px");


                }
            });   