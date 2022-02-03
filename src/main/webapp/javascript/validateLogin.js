/**
 * 
 */

const uname = document.getElementById("uname");
const upass = document.getElementById("upass");

const validate = () => {
	
	let name = uname.value;
	let pass = upass.value;
	
    if( checkUsername(name) && checkPassword(pass)){
	   document.getElementById("submitForm").submit();   
    }
	
} 

const checkUsername = (name) => {
	let username = name.trim();
	const tag = document.getElementById("errorUsername");
	
	if(username.length == 0){
		const message = "this filed cannot be empty" ;
		triggerError(message, tag);
		uname.style.border = '2px solid red';
		return false;
	}else if(username.length < 4 || username.length > 15){
		const message = "username too small or too large" ;
		triggerError(message, tag);
		uname.style.border = '2px solid red';
		return false;
	}else {
		uname.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}
}

const checkPassword = (pass) => {
	let password = pass.trim();
	const tag = document.getElementById("errorPassword");
	
	if(password.length < 6){
		const message = "password length cannot be less then 6" ;
		triggerError(message, tag);
		upass.style.border = '2px solid red';
		return false;
	}else {
		upass.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}
	
}


const triggerError = (message, tag) => {
     tag.innerHTML = message ;
     tag.style.display = 'block';    	
}











