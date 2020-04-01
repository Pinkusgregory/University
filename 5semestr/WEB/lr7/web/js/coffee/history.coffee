$ ->
  $('#history-local').html (n) ->
    `var n`
    str = ''
    n = 0
    while n < 6
      switch n
        when 0
          str += '<tr><td>Интересы</td><td>' + localStorage.getItem('Интересы') + '</td></tr>'
        when 1
          str += '<tr><td>Учеба</td><td>' + localStorage.getItem('Учеба') + '</td></tr>'
        when 2
          str += '<tr><td>Контакт</td><td>' + localStorage.getItem('Контакт') + '</td></tr>'
        when 3
          str += '<tr><td>Фотоальбом</td><td>' + localStorage.getItem('Фотоальбом') + '</td></tr>'
        when 4
          str += '<tr><td>Тест</td><td>' + localStorage.getItem('Тест') + '</td></tr>'
        when 5
          str += '<tr><td>История</td><td>' + localStorage.getItem('История') + '</td></tr>'
      n++
    str
  return
$ ->
  $('#history-cookies').html (n) ->
    `var n`
    str = ''
    n = 0
    while n < 6
      switch n
        when 0
          str += '<tr><td>Интересы</td><td>' + sessionStorage.getItem('Интересы') + '</td></tr>'
        when 1
          str += '<tr><td>Учеба</td><td>' + sessionStorage.getItem('Учеба') + '</td></tr>'
        when 2
          str += '<tr><td>Контакт</td><td>' + sessionStorage.getItem('Контакт') + '</td></tr>'
        when 3
          str += '<tr><td>Фотоальбом</td><td>' + sessionStorage.getItem('Фотоальбом') + '</td></tr>'
        when 4
          str += '<tr><td>Тест</td><td>' + sessionStorage.getItem('Тест') + '</td></tr>'
        when 5
          str += '<tr><td>История</td><td>' + sessionStorage.getItem('История') + '</td></tr>'
      n++
    str
  return