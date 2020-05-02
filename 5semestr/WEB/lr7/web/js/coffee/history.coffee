pages = ['Интересы', 'Учеба', 'Контакт', 'Фотоальбом', 'Тест', 'История']

$ ->
  $('#history-local').html () ->
    str = ''
    for page in pages
      str += '<tr><td>' + page + '</td><td>' + localStorage.getItem(page) + '</td></tr>'
    str
  return
$ ->
  $('#history-cookies').html () ->
    str = ''
    for page in pages
      str += '<tr><td>' + page + '</td><td>' + sessionStorage.getItem(page) + '</td></tr>'
    str
  return