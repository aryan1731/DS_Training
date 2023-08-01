/**
 * 
 */
 
function validateEmail(email) {
   // const emailField = document.getElementById('uemail');
    //const emailValidationMsg = document.getElementById('emailValidationMsg');

    // Regular expression for email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    

    if (email.trim() === '') {
        document.getElementById("emailValidationMsg").innerHTML="email cannot be blank";
        return false;
    } 
    else if (!emailRegex.test(email)) {
        document.getElementById("emailValidationMsg").innerHTML="invalid email format";
        return false;
    } 
    else{
		document.getElementById("emailValidationMsg").innerHTML="";
    return true;
	}
    
    
    
  
}

function validateAge(dobValue) {
    //const dobField = document.getElementsByName('udob')[0];
    //const ageValidationMsg = document.getElementById('ageValidationMsg');

    if (dobValue.trim() === '') {
        document.getElementById("ageValidationMsg").innerHTML="age cannot be blank";
        return false;
    } else {
        const dob = new Date(dobValue);
        const now = new Date();
        const ageDiff = now - dob;
        const ageDate = new Date(ageDiff);

        const age = Math.abs(ageDate.getUTCFullYear() - 1970);

        if (age < 18) {
        	document.getElementById("ageValidationMsg").innerHTML="age cannot be less than 18";
            return false;
        }
    }
    document.getElementById("ageValidationMsg").innerHTML="";
    return true;
}

function validateUsername() {
    const usernameField = document.getElementById('uname');
    //const nameErrSpan = document.getElementById('nameErr');

    // Regular expression to allow only alphabets (letters)
    const alphabetRegex = /^[a-zA-Z]+$/;

    const username = usernameField.value;

    if (username.trim() === '') {
        //nameErrSpan.textContent = 'Username is required.';
        document.getElementById("nameErrSpan").innerHTML="Username is required.";
        return false;
    } else if (!alphabetRegex.test(username)) {
        document.getElementById("nameErrSpan").innerHTML="Invaid username format";
        return false;
    }
        
    document.getElementById("nameErrSpan").innerHTML="";
    return true;
}

function validatePassword() {
    const passwordField = document.getElementById('upass');
    //const passErrSpan = document.getElementById('passErr');

    // Regular expression to check for the password criteria
    const passwordRegex =/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z!#$%&? "])[a-zA-Z0-9!#$%&?]{8,}$/;

    const password = passwordField.value;

    if (password.trim() === '') {
        document.getElementById("passErrSpan").innerHTML="password cannot be blank";
        return false;
    } else if (!passwordRegex.test(password)) {
		
		document.getElementById("passErrSpan").innerHTML="Password must be alphanumeric and contain at least one special character, one number, one uppercase letter, and one lowercase letter.";
        return false;
    }
    document.getElementById("passErrSpan").innerHTML="";

    return true;
}

function validator() {
    

    // Check if any fields have the 'invalid' 
    //const invalidFields = document.querySelectorAll('.invalid');

    // If any invalid fields 
    return (validateEmail(document.getElementById('uemail').value) && validateAge(document.getElementsByName('udob')[0].value) &&  validateUsername() && validatePassword());
    
}

 function validate() {
				var x=document.getElementById('uname').value;
				var y=document.getElementById('upass').value;
				
				console.log('value of x '+x);
				console.log('value of y '+y);

				if(x =="") {
					//alert('Username cannot be blank');	
					document.getElementById("nameErr").innerHTML="Username cannot be blank";
					return false;
				}		
				
				if(y =="") {
					//alert('Password cannot be blank');	return false
					document.getElementById("passErr").innerHTML="Password cannot be blank";
					return false;
				}			
				return true;
			}	
 
 function clearTheForm() {
				document.getElementById('uname').value="";
				document.getElementById('upass').value="";
				
}

function clearNameErrMsg() {
				document.getElementById('nameErr').innerHTML="";

}
			
function clearPassErrMsg() {
				document.getElementById('passErr').innerHTML="";

}