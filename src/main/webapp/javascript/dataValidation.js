


const Date = document.getElementById("date");


const validate = () => {
  let date = Date.value;
  console.log(date)
	
    if( checkDate(date)){
	   document.getElementById("submitForm").submit();   
    }
	
}

const checkDate = (date) =>{
	
	let new_date = date.trim();
	const tag = document.getElementById("errorDate");
	
	if(new_date.length == 0){
		const message = "this filed cannot be empty" ;
		triggerError(message, tag);
		Date.style.border = '2px solid red';
		return false;
	}else {
		Date.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}	
}

const triggerError = (message, tag) => {
     tag.innerHTML = message ;
     tag.style.display = 'block';    	
}
















































































