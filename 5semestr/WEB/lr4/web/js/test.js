const FIO = document.getElementById('fullname');
const question1 = document.getElementById('1st-question');
const form = document.getElementById('form');
const errorElement = document.getElementById('error');

function is_checked() {
	var choice1_checked =  document.getElementById('Choice1').checked;
	var choice2_checked =  document.getElementById('Choice2').checked;
	var choice3_checked =  document.getElementById('Choice3').checked;
	var boxes = form.querySelectorAll('input[type=checkbox]:checked').length;
	if (boxes < 2){
		return false;
	} else {
		return true;
	}
}

form.addEventListener('submit', (e) => {
	let messages = [];
	let FIORegEng = /[A-Za-z]+ [A-Za-z]+ [A-Za-z]+/;
	let FIORegRus = /[А-ЯЁа-яё]+ [А-ЯЁа-яё]+ [А-ЯЁа-яё]+/;

	if (FIO.value === '' || FIO.value == null) {
		FIO.focus();
		messages.push('Поле ФИО не заполнено');
	} else if (FIORegEng.test(FIO.value) == false  && FIORegRus.test(FIO.value) == false) {
		FIO.focus();
		messages.push('Поле ФИО заполнено не верно');
	}

	if (question1.value === '' || question1.value == null) {
		question1.focus();
		messages.push('Ответ на 1 вопрос не заполнен');
	}

	if (is_checked() == false) {
		messages.push('В 3 вопросе надо выбрать не менее 2 вариантов ответа');
	}

	if (messages.length > 0) {
		e.preventDefault();
		errorElement.innerText = messages.join(', ');
	}

})