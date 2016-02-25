function checkForm() {

	var carburant = document.getElementById('carburant');
	var transmission = document.getElementById('transmission');
	var boite = document.getElementById('boite');
	var puissance = document.getElementById('puissance');
	var jante = document.getElementById('jante');
	var couleur = document.getElementById('couleur');
	var msgCarbu = document.getElementById('msgCarbu');
	var msgTrans = document.getElementById('msgTrans');
	var msgBoite = document.getElementById('msgBoite');
	var msgPuiss = document.getElementById('msgPuiss');
	var msgJante = document.getElementById('msgJante');
	var msgColor = document.getElementById('msgColor');
	
	var goodColor = "#66cc66";
	var badColor = "#ff6666";

	// carburant-> mandatory
	if (carburant.value == "Tous")
	{
		msgCarbu.style.color = badColor;
		msgCarbu.innerHTML = "Choisissez une option";
		return false;
	} else {
		msgCarbu.innerHTML = "";
	}
	// transmission-> mandatory
	if (transmission.value == "Tous")
	{
		msgTrans.style.color = badColor;
		msgTrans.innerHTML = "Choisissez une option";
		return false;
	} else {
		msgTrans.innerHTML = "";
	}
	// boite-> mandatory
	if (boite.value == "Tous")
	{
		msgBoite.style.color = badColor;
		msgBoite.innerHTML = "Choisissez une option";
		return false;
	} else {
		msgBoite.innerHTML = "";
	}
	// puissance-> mandatory
	if (puissance.value == "0")
	{
		msgPuiss.style.color = badColor;
		msgPuiss.innerHTML = "Choisissez une option";
		return false;
	} else {
		msgPuiss.innerHTML = "";
	}
	// jante-> mandatory
	if (jante.value == "0")
	{
		msgJante.style.color = badColor;
		msgJante.innerHTML = "Choisissez une option";
		return false;
	} else {
		msgJante.innerHTML = "";
	}
	// couleur-> mandatory
	if (couleur.value == "Tous")
	{
		msgColor.style.color = badColor;
		msgColor.innerHTML = "Choisissez une option";
		return false;
	} else {
		msgColor.innerHTML = "";
	}
}