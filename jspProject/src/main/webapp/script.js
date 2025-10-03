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
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!emailPattern.test(emailInput.value)) {
       emailErrormsg.textContent = "Invalid Email Address";
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
			phoneInput.classList.remove("valid");
		}
    else{
		phoneErrormsg.textContent="";
		phoneInput.classList.add("valid");
		phoneInput.classList.remove("invalid");
		
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
			passwordErrormsg.style.color = "orange";
			passwordInput.classList.add("invalid");
			passwordInput.classList.remove("valid");
		}
    else{
		passwordErrormsg.textContent="";
		passwordInput.classList.add("valid");
		passwordInput.classList.remove("invalid");
		
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
			passwordInput.classList.remove("valid");
		}
});






function fetchTrains() {
    let from = document.getElementById("fromStation").value;
    let to = document.getElementById("toStation").value;
    let date = document.getElementById("travelDate").value;

    if(from && to && date) {
        $.ajax({
            url: 'LiveUpdateServlet',
            method: 'GET',
            data: {from: from, to: to, date: date},
            success: function(data) {
                let table = document.getElementById("trainTable");
                table.innerHTML = "<tr><th>Train No</th><th>Name</th><th>Departure</th><th>Arrival</th><th>Duration</th><th>Seats</th></tr>";
                data.forEach(function(train){
                    let row = table.insertRow();
                    row.insertCell(0).innerText = train.trainNo;
                    row.insertCell(1).innerText = train.name;
                    row.insertCell(2).innerText = train.departureTime;
                    row.insertCell(3).innerText = train.arrivalTime;
                    row.insertCell(4).innerText = train.duration;
                    row.insertCell(5).innerText = train.seatsAvailable;
                });
            }
        });
    }
}

setInterval(fetchTrains, 30000); // update every 30 seconds
