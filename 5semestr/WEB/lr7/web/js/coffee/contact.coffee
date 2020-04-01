FIO = document.getElementById('fullname')
email = document.getElementById('email')
phone = document.getElementById('phone')
form = document.getElementById('form')
errorElementFIO = document.getElementById('errorFIO')
errorElementEmail = document.getElementById('errorEmail')
errorElementPhone = document.getElementById('errorPhone')
errorElementText = document.getElementById('errorText')
textArea = document.getElementById('message')

is_checked = ->
  choice1_checked = document.getElementById('Choice1').checked
  choice2_checked = document.getElementById('Choice2').checked
  choice1_checked or choice2_checked

FIO.addEventListener 'blur', (e) ->
  messages = []
  FIORegEng = /[A-Za-z]+ [A-Za-z]+ [A-Za-z]+/
  FIORegRus = /[А-ЯЁа-яё]+ [А-ЯЁа-яё]+ [А-ЯЁа-яё]+/
  if FIO.value == '' or FIO.value == null
    FIO.focus()
    messages.push 'Поле ФИО не заполнено'
  else if FIORegEng.test(FIO.value) == false and FIORegRus.test(FIO.value) == false
    FIO.focus()
    messages.push 'Поле ФИО заполнено не верно'
  if messages.length > 0
    e.preventDefault()
    errorElementFIO.innerText = messages.join(', ')
  if messages.length == 0
    errorElementFIO.innerText = ''
  return
email.addEventListener 'blur', (e) ->
  messages = []
  if email.value == '' or email.value == null
    email.focus()
    messages.push 'Поле Емаил не заполнено'
  if messages.length > 0
    e.preventDefault()
    errorElementEmail.innerText = messages.join(', ')
  if messages.length == 0
    errorElementEmail.innerText = ''
  return
phone.addEventListener 'blur', (e) ->
  messages = []
  phoneReg = /^[+][7|3]\d{8,10}$/g
  if phone.value == '' or phone.value == null
    phone.focus()
    messages.push 'Поле телефон не заполнено'
  else if phoneReg.test(phone.value) == false
    phone.focus()
    messages.push 'Поле телефон заполнено не верно'
  if messages.length > 0
    e.preventDefault()
    errorElementPhone.innerText = messages.join(', ')
  if messages.length == 0
    errorElementPhone.innerText = ''
  return
textArea.addEventListener 'blur', (e) ->
  messages = []
  if textArea.value == '' or textArea.value == null
    textArea.focus()
    messages.push 'Поле текста не заполнено'
  if messages.length > 0
    e.preventDefault()
    errorElementText.innerText = messages.join(', ')
  if messages.length == 0
    errorElementText.innerText = ''
  return
form.addEventListener 'submit', (e) ->
  messages = []
  if is_checked() == false
    messages.push 'Пол не выбран'
  if messages.length > 0
    e.preventDefault()
    errorElement.innerText = messages.join(', ')
  return