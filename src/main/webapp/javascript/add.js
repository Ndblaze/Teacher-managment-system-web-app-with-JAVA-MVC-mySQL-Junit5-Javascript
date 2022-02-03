

const groupName = document.getElementById("groupName");

const validate = () => {
	
	let name = groupName.value;
	
    if( checkGroupName(name)){
	   document.getElementById("submitForm").submit();   
    }
	
} 

const checkGroupName = (name) => {
	const tag = document.getElementById("errorCreatGroup");
	let Gname = name.trim();
	
	if(Gname.length <= 0){
		const message = "this filed cannot be empty" ;
		triggerError(message, tag);
		groupName.style.border = '2px solid red';
		return false;
	}else {
		groupName.style.border = '1px solid pink';
		tag.style.display = 'none'; 
		return true;
	}
	
}

const triggerError = (message, tag) => {
     tag.innerHTML = message ;
     tag.style.display = 'block';    	
}