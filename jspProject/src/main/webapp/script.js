var emailInput=document.getElementById("email");
var phoneInput=document.getElementById("phone");
var passwordInput=document.getElementById("password");

var emailErrormsg=document.getElementById("emailError");
var phoneErrormsg=document.getElementById("phoneError");
var passwordErrormsg=document.getElementById("passwordError");

emailInput.addEventListener("input",function()
{
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	if(!emailPattern.test(emailInput.value))
		{
			emailErrormsg.textContent="Example: abcd@gmail.com";
			emailErrormsg.style.color = "orange";
			emailInput.classList.add("invalid");
			emailInput.classList.remove("valid")
		}
	else
		{
			emailErrormsg.textContent="";
			emailInput.classList.add("valid");
			emailInput.classList.remove("invalid")
		}	
	}
);
emailInput.addEventListener("blur", function() {
    var emailPattern = /^\d{10}$/;
    if (!emailPattern.test(phoneInput.value)) {
       emailErrormsg.textContent = "Invalid Email  Number";
       emailErrormsg.style.color = "red";  
        emailInput.classList.add("invalid");
       emailInput.classList.remove("valid");
    }
});

phoneInput.addEventListener("input",function()
{
	var phonePattern=/^\d{10}$/;
	if(!phonePattern.test(phoneInput.value))
		{
			phoneErrormsg.textContent="Phone Number must be 10 digits";
			phoneErrormsg.style.color = "orange"; 
			phoneInput.classList.add("invalid");
			phoneInput.classList.add("valid");
		}
    else{
		phoneErrormsg.textContent="";
		phoneInput.classList.add("valid");
		phoneInput.classList.add("invalid");
		
	}		
}
);
phoneInput.addEventListener("blur", function() {
    var phonePattern = /^\d{10}$/;
    if (!phonePattern.test(phoneInput.value)) {
        phoneErrormsg.textContent = "Invalid Phone Number";
        phoneErrormsg.style.color = "red";  
        phoneInput.classList.add("invalid");
        phoneInput.classList.remove("valid");
    }
});

passwordInput.addEventListener("input",function()
{
	var passwordPattern=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
	if(!passwordPattern.test(passwordInput.value))
		{
			passwordErrormsg.textContent="Password must have 1 upper case,1 lower case,digit,special character within 8-12 characters";
			phoneErrormsg.style.color = "orange";
			passwordInput.classList.add("invalid");
			passwordInput.classList.add("valid");
		}
    else{
		passwordErrormsg.textContent="";
		passwordInput.classList.add("valid");
		passwordInput.classList.add("invalid");
		
	}		
}
);
passwordInput.addEventListener("blur", function() {

	var passwordPattern=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
	if(!passwordPattern.test(passwordInput.value))
		{
			passwordErrormsg.textContent="Invalid Password";
			passwordErrormsg.style.color = "red";  
			passwordInput.classList.add("invalid");
			passwordInput.classList.add("valid");
		}
});






