const FIO = document.getElementById('fullname');
const email = document.getElementById('email');
const phone	 = document.getElementById('phone');
const form = document.getElementById('form');
const errorElement = document.getElementById('error');
const textArea = document.getElementById('message');

function is_checked() {
	var choice1_checked =  document.getElementById('Choice1').checked;
	var choice2_checked =  document.getElementById('Choice2').checked;
	if (choice1_checked == false && choice2_checked == false){
		return false;
	} else {
		return true;
	}
}

form.addEventListener('submit', (e) => {
	let messages = [];

	let phoneReg = /^[+][7|3]\d{8,10}$/g;
	let FIORegEng = /[A-Za-z]+ [A-Za-z]+ [A-Za-z]+/;
	let FIORegRus = /[А-ЯЁа-яё]+ [А-ЯЁа-яё]+ [А-ЯЁа-яё]+/;
	let emailReg = /\.ru$/;

	if (FIO.value === '' || FIO.value == null) {
		FIO.focus();
		messages.push('Поле ФИО не заполнено');
	} else if (FIORegEng.test(FIO.value) == false && FIORegRus.test(FIO.value) == false) {
		FIO.focus();
		messages.push('Поле ФИО заполнено не верно');
	}

	if (email.value === '' || email.value == null) {
		email.focus();
		messages.push('Поле Емаил не заполнено');
	} else if (emailReg.test(email.value) == false && emailReg.test(email.value) == false) {
		email.focus();
		messages.push('.ru');
	}

	if (phone.value === '' || phone.value == null) {
		phone.focus();
		messages.push('Поле телефон не заполнено');
	} else if (phoneReg.test(phone.value) == false) {
		phone.focus();
		messages.push('Поле телефон заполнено не верно');
	}

	if (is_checked() == false) {
		messages.push('Пол не выбран');
	}
		
	if (textArea.value === '' || textArea.value == null) {
		textArea.focus();
		messages.push('Поле текста не заполнено');
	}
	if (messages.length > 0) {
		e.preventDefault();
		errorElement.innerText = messages.join(', ');
	}

})

function checkForm(form) {

	var inputs = form.elements;

	for (i = 0; i < inputs.length; i++){
		if (inputs[i].nodeName === "INPUT" && inputs[i].type === "text") {
			if (checkTextNull(inputs[i])) {
				
			}
		  }
		if (inputs[i].nodeName === "INPUT" && inputs[i].type === "checkbox") {
			if (!checkCheckBox(inputs[i])) {

			}	
		}
		if (inputs[i].nodeName === "INPUT" && inputs[i].type === "radio") {
			if (!checkRadio(inputs[i])) {
				
			}
		}
	}

	function checkTextNull(input) {
		return input.value == null;
	}

	function checkCheckBox(input){
		return input.checked;
	}

}