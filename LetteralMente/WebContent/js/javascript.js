function login(){
      if($("#loginform").hasClass("d-none")){
        $("#loginform").fadeToggle(1500).removeClass("d-none")
      }else{
        $("#loginform").fadeToggle(1500)
      }
    }


    function info(){
      $("#descr").fadeToggle(1000).removeClass("d-none")
      $("#descr").after()
    }
// fallo apparire alla fine del div row in cui è contenuto
    

    $(function scrollTop() {

      $(window).scroll(function() {
        if($(this).scrollTop() != 0) {
          $('#go_top').fadeIn(); //faccio apparire il bottone
        } else {
          $('#go_top').fadeOut();//Il bottone scompare
        }
        
      })
        
      $('#go_top').click(function() {
        $('body,html').animate({scrollTop:0},800);  
      });
        
    });