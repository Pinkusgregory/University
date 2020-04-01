d0 = new Date(1910, 0o0, 0o1)
d1 = new Date
dS = d1
year = undefined
month = undefined
text = undefined
calendar = undefined

updateDate = ->
  `var i`
  dS.setFullYear year.value
  dS.setMonth month.value - 1
  text.value = dS.getDate() + ' ' + dS.getMonth() + 1 + ' ' + dS.getFullYear()
  days = []
  calendar.innerHTML = '<tr><th>Пн</th><th>Вт</th><th>Ср</th><th>Чт</th><th>Пт</th><th>Сб</th><th>Вс</th></tr>'
  firstDay = new Date(dS.getFullYear(), dS.getMonth(), 1).getDay()
  i = 1
  while i <= daysInMonth(dS.getFullYear(), dS.getMonth() + 1)
    days.push i
    i++
  if firstDay == 0
    firstDay = 7
  row = 1
  isNullDays = true
  while days.length > 0
    calendar.innerHTML += '<tr id="row' + row + '"></tr>'
    i = 0
    while i < 7
      if i == firstDay - 1
        isNullDays = false
      if !isNullDays
        if days.length == 0
          document.getElementById('row' + row).innerHTML += '<td></td>'
        else
          if days[0] == dS.getDate()
            document.getElementById('row' + row).innerHTML += '<td class="day selected" id="day' + days[0] + '" onclick="selectDate(this)"><a>' + days[0] + '</a></td>'
          else
            document.getElementById('row' + row).innerHTML += '<td class="day" id="day' + days[0] + '" onclick="selectDate(this)"><a>' + days[0] + '</a></td>'
          days.splice 0, 1
      else
        document.getElementById('row' + row).innerHTML += '<td></td>'
      i++
    row++
  t = setTimeout((->
    updateDate()
    return
  ), 500)
  return

daysInMonth = (year, month) ->
  new Date(year, month, 0).getDate()

selectDate = (element) ->
  dS.setDate element.children[0].innerHTML
  updateDate()
  return

window.onload = ->
  `var i`
  year = document.getElementById('calendar-year')
  month = document.getElementById('calendar-month')
  calendar = document.getElementById('calendar-table')
  text = document.getElementById('calendar-text')
  i = d1.getFullYear()
  while i >= d0.getFullYear()
    year.innerHTML += '<option value ="' + i + '" >' + i + '</option>'
    i--
  i = 1
  while i <= 12
    month.innerHTML += '<option value ="' + i + '" >' + i + '</option>'
    i++
  month.value = d1.getMonth() + 1
  year.value = d1.getFullYear()
  updateDate()
  return