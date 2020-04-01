resetLocalStorage = ->
  localStorage.clear()
  localStorage.setItem 'Интересы', '0'
  localStorage.setItem 'Учеба', '0'
  localStorage.setItem 'Контакт', '0'
  localStorage.setItem 'Фотоальбом', '0'
  localStorage.setItem 'Тест', '0'
  localStorage.setItem 'История', '0'
  return

resetSessionStorage = ->
  sessionStorage.clear()
  sessionStorage.setItem 'Интересы', '0'
  sessionStorage.setItem 'Учеба', '0'
  sessionStorage.setItem 'Контакт', '0'
  sessionStorage.setItem 'Фотоальбом', '0'
  sessionStorage.setItem 'Тест', '0'
  sessionStorage.setItem 'История', '0'
  return

$ ->
  if isNaN(localStorage.getItem(window.document.title)) or localStorage.getItem(window.document.title) == null
    resetLocalStorage()
  if isNaN(sessionStorage.getItem(window.document.title)) or sessionStorage.getItem(window.document.title) == null
    resetSessionStorage()
  localStorage.setItem window.document.title, (parseInt(localStorage.getItem(window.document.title)) + 1).toString()
  sessionStorage.setItem window.document.title, (parseInt(sessionStorage.getItem(window.document.title)) + 1).toString()
  return