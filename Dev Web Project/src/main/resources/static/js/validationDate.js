function checkForm() {

	var date = document.getElementById('datepicker');
	var msg = document.getElementById('msg');
	
	var goodColor = "#66cc66";
	var badColor = "#ff6666";

	// date-> mandatory
	if (date.value == "")
	{
		msg.style.color = badColor;
		msg.innerHTML = "Il faut sélectionner une date pour enregistrer la réservation";
		return false;
	} else {
		msg.innerHTML = "";
	}
}