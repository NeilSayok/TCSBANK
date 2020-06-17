function inputValidate(x) {
	if(x.value.length < x.maxLength && x.maxLength>3){
 		 x.style.border = "1px solid red"; 
	}else
 		 x.style.border = "1px solid black"; 
}

function on_input(x) {
    let inp = x.value;
    let len = x.value.length
	 if (len > x.maxLength) 
         x.value = x.value.slice(0, x.maxLength);
}

$(".non-neg-dec").keydown(function(e){
  if(!((e.keyCode > 95 && e.keyCode < 106)
      || (e.keyCode > 47 && e.keyCode < 58) 
      || e.keyCode == 8)) {
        return false;
    }
});

$( ".date-input" ).datepicker({
    changeMonth: true,
    changeYear: true,
    dateFormat: 'dd/mm/yy',
    yearRange: '1900:'+(new Date()).getFullYear()
});


function logout() {
    console.log("Logout")
    $.ajax({
        type: "post",
        url: "Logout",
        success: function (data) {
            if (data==="success"){
                window.location.href = "index.jsp";
            }
        },
        error: function (a, b, c) {
            alert("Error");

        }
    })
}

