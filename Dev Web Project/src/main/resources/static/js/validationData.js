/**
 * fonction qui vérifie si les deux mot de passes
 * rentrés par le USER lors de l'inscription 
 * sont bien identiques
 */
function checkPass() {
	var pass1 = document.getElementById('pass1');
	var pass2 = document.getElementById('pass2');
	var message = document.getElementById('confirmMessage');
	var goodColor = "#66cc66";
	var badColor = "#ff6666";

	if (pass1.value == pass2.value) {
		pass2.style.backgroundColor = goodColor;
		message.style.color = goodColor;
		message.innerHTML = "Mot de passe correct"
	} else {
		pass2.style.backgroundColor = badColor;
		message.style.color = badColor;
		message.innerHTML = "Mot de passe incorrect"
	}
}

function checkEMail() {
	var mail = document.getElementById('email');
	var msgmail = document.getElementById('msgmail');
	var goodColor = "#66cc66";
	var badColor = "#ff6666";
	
	//email is mandatory
	if (mail.value== "") {
		msgmail.style.color = badColor;
		msgmail.innerHTML = "Email obligatoire";
		mail.focus();
		return false;
	} else {
		msgmail.innerHTML = "";
	}
	return true;
}


/**
 * vérifie que le mot de passe est conforme aux règles
 */
function checkPassword(str) {
	// au moins :
	//un nombre
	//une minuscule
	//une majuscule
	//6 caractères
	var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
	return re.test(str);
}

/**
 * vérifie que le nom est conforme aux règles
 */
function checkName(str) {
	var re = /.{2,30}/;
	return re.test(str);
}

/**
 * vérifie que l'âge est conforme aux règles
 */
function checkAge(str) {
	var re = /(?=.*\d)/;
	return re.test(str);
}

function checkPopUp()
{
	var email = document.getElementById('emailPopUp');
	var message = document.getElementById('msgerror');
	var goodColor = "#66cc66";
	var badColor = "#ff6666";
	
	//email is mandatory
	if (email.value== "") {
		message.style.color = badColor;
		message.innerHTML = "E-mail obligatoire";
		email.focus();
		return false;
	} else {
		message.innerHTML = "";
	}
	return true;
}

function checkFormReinit() {

	var pass1 = document.getElementById('pass1');
	var pass2 = document.getElementById('pass2');
	var message = document.getElementById('msgpwd');
	var code = document.getElementById('code');
	var msgcode = document.getElementById('msgcode');

	var goodColor = "#66cc66";
	var badColor = "#ff6666";

	//code is mandatory
	if (code.value== "") {
		msgcode.style.color = badColor;
		msgcode.innerHTML = "Code obligatoire";
		code.focus();
		return false;
	} else {
		msgcode.innerHTML = "";
	}
	//password -> at least one Uppercase letter, at least one lowercase letter, at least one number and at least 8 caracters
	if (!checkPassword(pass1.value)) {
		message.style.color = badColor;
		message.innerHTML = "Le mot de passe doit respecter les règles suivantes :<br />"   +
				"- au moins 8 caractères<br />" +
				"- au moins une minuscule<br />" +
				"- au moins une majuscule<br />" +
				"- au moins un chiffre<br />";
		pass1.focus();
		return false;
	} else {
		message.innerHTML = "";
	}
	return true;
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
		msg1name.innerHTML = "Entre 2 et 30 caractères";
		firstname.focus();
		return false;
	} else {
		msg1name.innerHTML = "";
	}
	//lastname -> >=2 and <=30
	if (!checkName(name.value) || name.value.length>30) {
		msgname.style.color = badColor;
		msgname.innerHTML = "Entre 2 et 30 caractères";
		name.focus();
		return false;
	} else {
		msgname.innerHTML = "";
	}
	//age -> mandatory and >=18 and has to be a number
	if (age.value== "" || age.value<18 || !checkAge(age.value)) {
		msgage.style.color = badColor;
		msgage.innerHTML = "L'âge doit être un nombre et la personne doit être majeur";
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
		message.innerHTML = "Le mot de passe doit respecter les règles suivantes :<br />"   +
				"- au moins 8 caractères<br />" +
				"- au moins une minuscule<br />" +
				"- au moins une majuscule<br />" +
				"- au moins un chiffre<br />";
		pass1.focus();
		return false;
	} else {
		message.innerHTML = "";
	}
	return true;
}
