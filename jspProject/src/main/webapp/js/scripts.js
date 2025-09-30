var emailInput=document.getElementById("email");
var phoneInput=document.getElementById("phone");
var passwordInput=document.getElementById("password");

var emailErrormsg=document.getElementById("emailError");
var phoneErrormsg=document.getElementById("phoneError");
var passwordErrormsg=document.getElementById("passwordError");

emailInput.addEvenListener("input",function()
{
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	if(!emailPattern.test(emailInput))
		{
			emailErrormsg.textContent="Invalid E-mail Address";
			emailInput.classList.add("invalid");
			emailInput.classList.remove("valid")
		}
	else
		{
			emailErrormsg.textContent="";
			emailInput.classList.add("invalid");
			emailInput.classList.remove("valid")
		}	
	}
);

phoneInput.addEventListener("input",function()
{
	var phonePattern=/^\d{10}$/;
	if(!phonePattern.test(phoneInput))
		{
			phoneErrormsg.textContent="Invalid PhoneNumber";
			phoneInput.classList.add("invalid");
			phoneInput.classList.add("valid");
		}
    else{
		phoneErrormsg.textContent="";
		phoneInput.classList.add("invalid");
		phoneInput.classList.add("valid");
		
	}		
}
);

passwordInput.addEventListener("input",function()
{
	var passwordPattern=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
	if(!passwordPattern.test(phoneInput))
		{
			passwordErrormsg.textContent="Invalid PhoneNumber";
			passwordInput.classList.add("invalid");
			passwordInput.classList.add("valid");
		}
    else{
		passwordErrormsg.textContent="";
		passwordInput.classList.add("invalid");
		password.classList.add("valid");
		
	}		
}
);





