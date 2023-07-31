/**
 * 
 */
 

function validateEmail(email) {
    const emailField = document.getElementById('uemail');
    const emailValidationMsg = document.getElementById('emailValidationMsg');

    // Regular expression for email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (email.trim() === '') {
        emailValidationMsg.textContent = 'Email is required.';
        emailField.classList.add('invalid');
    } else if (!emailRegex.test(email)) {
        emailValidationMsg.textContent = 'Invalid email format.';
        emailField.classList.add('invalid');
    } else {
        emailValidationMsg.textContent = '';
        emailField.classList.remove('invalid');
    }
}
function validateAge(dobValue) {
    const dobField = document.getElementsByName('udob')[0];
    const ageValidationMsg = document.getElementById('ageValidationMsg');

    if (dobValue.trim() === '') {
        ageValidationMsg.textContent = 'Birthdate is required.';
        dobField.classList.add('invalid');
    } else {
        const dob = new Date(dobValue);
        const now = new Date();
        const ageDiff = now - dob;
        const ageDate = new Date(ageDiff);

        const age = Math.abs(ageDate.getUTCFullYear() - 1970);

        if (age < 18) {
            ageValidationMsg.textContent = 'You must be at least 18 years old.';
            dobField.classList.add('invalid');
        } else {
            ageValidationMsg.textContent = '';
            dobField.classList.remove('invalid');
        }
    }
}
function validateUsername() {
    const usernameField = document.getElementById('uname');
    const nameErrSpan = document.getElementById('nameErr');

    // Regular expression to allow only alphabets (letters)
    const alphabetRegex = /^[a-zA-Z]+$/;

    const username = usernameField.value;

    if (username.trim() === '') {
        nameErrSpan.textContent = 'Username is required.';
        usernameField.classList.add('invalid');
    } else if (!alphabetRegex.test(username)) {
        nameErrSpan.textContent = 'Username should only contain alphabets.';
        usernameField.classList.add('invalid');
    } else {
        nameErrSpan.textContent = '';
        usernameField.classList.remove('invalid');
    }
}
function validatePassword() {
    const passwordField = document.getElementById('upass');
    const passErrSpan = document.getElementById('passErr');

    // Regular expression to check for the password criteria
    const passwordRegex = /^(?=.*[!@#$%^&*()\-_=+{}[\]:";'<>,.?/])(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*()\-_=+{}[\]:";'<>,.?/]{8,}$/;

    const password = passwordField.value;

    if (password.trim() === '') {
        passErrSpan.textContent = 'Password is required.';
        passwordField.classList.add('invalid');
    } else if (!passwordRegex.test(password)) {
        passErrSpan.textContent = 'Password must be alphanumeric and contain at least one special character, one number, one uppercase letter, and one lowercase letter.';
        passwordField.classList.add('invalid');
    } else {
        passErrSpan.textContent = '';
        passwordField.classList.remove('invalid');
    }
}
function validator() {
    // Perform individual validations for each field
    validateEmail(document.getElementById('uemail').value);
    validateAge(document.getElementsByName('udob')[0].value);
    validateUsername();
    validatePassword();

    // Check if any fields have the 'invalid' class, which indicates invalid input
    const invalidFields = document.querySelectorAll('.invalid');

    // If any invalid fields are found, prevent form submission
    if (invalidFields.length > 0) {
        return false;
    }

    // If all fields are valid, allow form submission
    return true;
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