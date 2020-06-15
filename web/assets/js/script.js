$( function() {
    $( ".date-input" ).datepicker({
      changeMonth: true,
      changeYear: true,
      dateFormat: 'dd/mm/yy',
      yearRange: '1900:'+(new Date()).getFullYear()  
    });
  } );

function inputValidate(x) {
	if(x.value.length < x.maxLength){
 		 x.style.border = "1px solid red"; 
         }
    else
 		 x.style.border = "1px solid black"; 
}

function on_input(x) {
    let inp = x.value;
    let len = x.value.length
	 if (len > x.maxLength) 
         x.value = x.value.slice(0, x.maxLength);
//      if(inp[len-1] >= '0' && inp[len-1] <='9' ){
//          console.log(inp);
//      }
//     else{
        
//         x.value = x.value.replace(".","");
//         x.value = x.value.replace("-","");
//          console.log("non char");  
//     }


}

$(".non-neg-dec").keydown(function(e){
  if(!((e.keyCode > 95 && e.keyCode < 106)
      || (e.keyCode > 47 && e.keyCode < 58) 
      || e.keyCode == 8)) {
        return false;
    }
});

