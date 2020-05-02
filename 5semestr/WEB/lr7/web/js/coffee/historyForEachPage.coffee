pages = ['Интересы', 'Учеба', 'Контакт', 'Фотоальбом', 'Тест', 'История']

resetLocalStorage = ->
  localStorage.clear()
  for page in pages
    localStorage.setItem page, '0'
  return

resetSessionStorage = ->
  sessionStorage.clear()
  for page in pages
    sessionStorage.setItem page, '0'
  return

$ ->
  if isNaN(localStorage.getItem(window.document.title)) or localStorage.getItem(window.document.title) == null
    resetLocalStorage()
  if isNaN(sessionStorage.getItem(window.document.title)) or sessionStorage.getItem(window.document.title) == null
    resetSessionStorage()
  localStorage.setItem window.document.title, (parseInt(localStorage.getItem(window.document.title)) + 1).toString()
  sessionStorage.setItem window.document.title, (parseInt(sessionStorage.getItem(window.document.title)) + 1).toString()
  return