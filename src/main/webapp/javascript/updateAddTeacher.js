

const Fname = document.getElementById("Fname");
const Lname = document.getElementById("Lname");
const address = document.getElementById("address");
const phone = document.getElementById("phone");
const uname = document.getElementById("uname");
const upass = document.getElementById("pass");
const module = document.getElementById("module");

const validate = () => {
	let Firstname = Fname.value;
	let Lastname = Lname.value;
	let Address = address.value;
	let Phone = phone.value;
	let username = uname.value;
	let password = pass.value;
	let Module = module.value;

	
    if( checkFname(Firstname) && checkLname(Lastname) && checkAddress(Address)
                                     && checkPhone(Phone) && checkUsername(username) && checkPassword(password)  && checkModule(Module)){
	   document.getElementById("submitForm").submit();   
    }
	
}



const checkFname = (name) => {
	
    let firstname = name.trim();
	const tag = document.getElementById("errorFirstname");
	
	if(firstname.length == 0){
		const message = "this filed cannot be empty" ;
		triggerError(message, tag);
		Fname.style.border = '2px solid red';
		return false;
	}else if(firstname.length < 4){
		const message = "first name too small" ;
		triggerError(message, tag);
		Fname.style.border = '2px solid red';
		return false;
	}else {
		Fname.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}
	
}

const checkLname = (name) => {
	
	let lastname = name.trim();
	const tag = document.getElementById("errorLastname");
	
	if(lastname.length == 0){
		const message = "this filed cannot be empty" ;
		triggerError(message, tag);
		Lname.style.border = '2px solid red';
		return false;
	}else if(lastname.length < 4){
		const message = "last name too small" ;
		triggerError(message, tag);
		Lname.style.border = '2px solid red';
		return false;
	}else {
		Lname.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}
}

const checkAddress = (name) => {

	let address_name = name.trim();
	const tag = document.getElementById("errorAddress");
	if(address_name.length == 0){
		const message = "this filed cannot be empty" ;
		triggerError(message, tag);
		address.style.border = '2px solid red';
		return false;
	}else if(address_name.length < 6){
		const message = "enter full address" ;
		triggerError(message, tag);
		address.style.border = '2px solid red';
		return false;
	}else {
		address.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}
}


const checkPhone = (number) => {
	
	let phone_no = number.trim();
	const tag = document.getElementById("errorPhone");
	if(phone_no.length == 0){
		const message = "this filed cannot be empty" ;
		triggerError(message, tag);
		phone.style.border = '2px solid red';
		return false;
	}else if(phone_no.length < 10 || phone_no.length > 10){
		const message = "enter a correct phone number" ;
		triggerError(message, tag);
		phone.style.border = '2px solid red';
		return false;
	}else {
		phone.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
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

const checkModule = (name) => {
	
	let module_name = name.trim();
	const tag = document.getElementById("errorModule");
	
	if(module_name.length <= 0){
		const message = "choose a module" ;
		triggerError(message, tag);
		module.style.border = '2px solid red';
		return false;
	}else {
		module.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}
	
}


const triggerError = (message, tag) => {
     tag.innerHTML = message ;
     tag.style.display = 'block';    	
}


























