document.addEventListener('DOMContentLoaded', function() {

  // --- Elements ---
  const emailInput = document.getElementById("email");
  const phoneInput = document.getElementById("phone");
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirmPassword");

  const emailError = document.getElementById("emailError");
  const phoneError = document.getElementById("phoneError");
  const passwordError = document.getElementById("passwordError");
  const confirmPasswordError = document.getElementById("confirmPasswordError");

  const togglePassword = document.getElementById('togglePassword');
  const toggleConfirmPassword = document.getElementById('toggleConfirmPassword');

  // --- Email Validation ---
  emailInput.addEventListener("input", function() {
    const pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!pattern.test(emailInput.value)) {
      emailError.textContent = "Example: abcd@gmail.com";
      emailError.style.color = "orange";
      emailInput.classList.add("invalid");
      emailInput.classList.remove("valid");
    } else {
      emailError.textContent = "";
      emailInput.classList.add("valid");
      emailInput.classList.remove("invalid");
    }
  });

  emailInput.addEventListener("blur", function() {
    const pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!pattern.test(emailInput.value)) {
      emailError.textContent = "Invalid Email Address";
      emailError.style.color = "red";
      emailInput.classList.add("invalid");
      emailInput.classList.remove("valid");
    }
  });

  // --- Phone Validation ---
  phoneInput.addEventListener("input", function() {
    const pattern = /^\d{10}$/;
    if (!pattern.test(phoneInput.value)) {
      phoneError.textContent = "Phone Number must be 10 digits";
      phoneError.style.color = "orange";
      phoneInput.classList.add("invalid");
      phoneInput.classList.remove("valid");
    } else {
      phoneError.textContent = "";
      phoneInput.classList.add("valid");
      phoneInput.classList.remove("invalid");
    }
  });

  phoneInput.addEventListener("blur", function() {
    const pattern = /^\d{10}$/;
    if (!pattern.test(phoneInput.value)) {
      phoneError.textContent = "Invalid Phone Number";
      phoneError.style.color = "red";
      phoneInput.classList.add("invalid");
      phoneInput.classList.remove("valid");
    }
  });

  // --- Password Validation ---
  passwordInput.addEventListener("input", function() {
    const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
    if (!pattern.test(passwordInput.value)) {
      passwordError.textContent = "Password must have 1 upper case,1 lower case,digit,special character within 8-12 characters";
      passwordError.style.color = "orange";
      passwordInput.classList.add("invalid");
      passwordInput.classList.remove("valid");
    } else {
      passwordError.textContent = "";
      passwordInput.classList.add("valid");
      passwordInput.classList.remove("invalid");
    }

    // Check confirm password match on password change
    if (confirmPasswordInput.value !== "") {
      if (confirmPasswordInput.value !== passwordInput.value) {
        confirmPasswordError.textContent = "Passwords do not match!";
        confirmPasswordError.style.color = "red";
        confirmPasswordInput.classList.add("invalid");
        confirmPasswordInput.classList.remove("valid");
      } else {
        confirmPasswordError.textContent = "";
        confirmPasswordInput.classList.add("valid");
        confirmPasswordInput.classList.remove("invalid");
      }
    }
  });

  // --- Confirm Password Validation ---
  confirmPasswordInput.addEventListener("input", function() {
    if (confirmPasswordInput.value !== passwordInput.value) {
      confirmPasswordError.textContent = "Passwords do not match!";
      confirmPasswordError.style.color = "red";
      confirmPasswordInput.classList.add("invalid");
      confirmPasswordInput.classList.remove("valid");
    } else {
      confirmPasswordError.textContent = "";
      confirmPasswordInput.classList.add("valid");
      confirmPasswordInput.classList.remove("invalid");
    }
  });

  // --- Toggle Password Visibility ---
  togglePassword.addEventListener('click', function() {
    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    passwordInput.setAttribute('type', type);
    this.classList.toggle('fa-eye-slash');
  });

  toggleConfirmPassword.addEventListener('click', function() {
    const type = confirmPasswordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    confirmPasswordInput.setAttribute('type', type);
    this.classList.toggle('fa-eye-slash');
  });

});
