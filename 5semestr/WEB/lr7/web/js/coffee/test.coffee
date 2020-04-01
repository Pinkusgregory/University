FIO = document.getElementById('fullname')
question1 = document.getElementById('1st-question')
form = document.getElementById('form')
errorElement = document.getElementById('error')

is_checked = ->
  choice1_checked = document.getElementById('Choice1').checked
  choice2_checked = document.getElementById('Choice2').checked
  choice3_checked = document.getElementById('Choice3').checked
  boxes = form.querySelectorAll('input[type=checkbox]:checked').length
  if boxes < 2
    false
  else
    true

form.addEventListener 'submit', (e) ->
  messages = []
  FIORegEng = /[A-Za-z]+ [A-Za-z]+ [A-Za-z]+/
  FIORegRus = /[А-ЯЁа-яё]+ [А-ЯЁа-яё]+ [А-ЯЁа-яё]+/
  if FIO.value == '' or FIO.value == null
    FIO.focus()
    messages.push 'Поле ФИО не заполнено'
  else if FIORegEng.test(FIO.value) == false and FIORegRus.test(FIO.value) == false
    FIO.focus()
    messages.push 'Поле ФИО заполнено не верно'
  if question1.value == '' or question1.value == null
    question1.focus()
    messages.push 'Ответ на 1 вопрос не заполнен'
  if is_checked() == false
    messages.push 'В 3 вопросе надо выбрать не менее 2 вариантов ответа'
  if messages.length > 0
    e.preventDefault()
    errorElement.innerText = messages.join(', ')
  return