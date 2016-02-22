function checkPass() {
	// Store the password field objects into variables ...
	var pass1 = document.getElementById('pass1');
	var pass2 = document.getElementById('pass2');
	// Store the Confimation Message Object ...
	var message = document.getElementById('confirmMessage');
	// Set the colors we will be using ...
	var goodColor = "#66cc66";
	var badColor = "#ff6666";
	// Compare the values in the password field
	// and the confirmation field
	if (pass1.value == pass2.value) {
		// The passwords match.
		// Set the color to the good color and inform
		// the user that they have entered the correct password
		pass2.style.backgroundColor = goodColor;
		message.style.color = goodColor;
		message.innerHTML = "Mot de passe correct"
	} else {
		// The passwords do not match.
		// Set the color to the bad color and
		// notify the user.
		pass2.style.backgroundColor = badColor;
		message.style.color = badColor;
		message.innerHTML = "Mot de passe incorrect"
	}
}

function checkPassword(str) {
	// at least one number, one lowercase and one uppercase letter
	// at least six characters
	var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
	return re.test(str);
}

function checkName(str) {
	var re = /.{2,30}/;
	return re.test(str);
}

function checkAge(str) {
	var re = /(?=.*\d)/;
	return re.test(str);
}


function checkForm() {

	var pass1 = document.getElementById('pass1');
	var pass2 = document.getElementById('pass2');
	var message = document.getElementById('msgpwd');
	var firstname = document.getElementById('firstname');
	var name = document.getElementById('name');
	var age = document.getElementById('age');
	var mail = document.getElementById('email');
	var male = document.getElementById('male');
	var female = document.getElementById('female');
	var msg1name = document.getElementById('msg1name');
	var msgname = document.getElementById('msgname');
	var msgage = document.getElementById('msgage');
	var msgmail = document.getElementById('msgmail');
	var msggender = document.getElementById('msggender');
	var goodColor = "#66cc66";
	var badColor = "#ff6666";

	//gender-> mandatory
	if (!male.checked && !female.checked) {
		msggender.style.color = badColor;
		msggender.innerHTML = "Civilité obligatoire";
		return false;
	} else {
		msggender.innerHTML = "";
	}
	//firstname -> >=2 and <=30
	if (!checkName(firstname.value) || firstname.value.length>30) {
		msg1name.style.color = badColor;
		msg1name.innerHTML = "Prénom non valide";
		firstname.focus();
		return false;
	} else {
		msg1name.innerHTML = "";
	}
	//lastname -> >=2 and <=30
	if (!checkName(name.value) || name.value.length>30) {
		msgname.style.color = badColor;
		msgname.innerHTML = "Nom non valide";
		name.focus();
		return false;
	} else {
		msgname.innerHTML = "";
	}
	//age -> mandatory and >=18 and has to be a number
	if (age.value== "" || age.value<18 || !checkAge(age.value)) {
		msgage.style.color = badColor;
		msgage.innerHTML = "Age non valide";
		age.focus();
		return false;
	} else {
		msgage.innerHTML = "";
	}
	//email is mandatory
	if (mail.value== "") {
		msgmail.style.color = badColor;
		msgmail.innerHTML = "Email obligatoire";
		mail.focus();
		return false;
	} else {
		msgmail.innerHTML = "";
	}
	//password -> at least one Uppercase letter, at least one lowercase letter, at least one number and at least 8 caracters
	if (!checkPassword(pass1.value)) {
		message.style.color = badColor;
		message.innerHTML = "Mot de passe non valide";
		pass1.focus();
		return false;
	} else {
		message.innerHTML = "";
	}
	return true;
}
