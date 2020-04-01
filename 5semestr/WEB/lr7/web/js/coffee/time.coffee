checkTime = (i) ->
  if i < 10
    i = '0' + i
  i

$ ->
  `var today`
  today = new Date
  h = today.getHours()
  m = today.getMinutes()
  s = today.getSeconds()
  today = new Date
  dd = String(today.getDate()).padStart(2, '0')
  mm = String(today.getMonth() + 1).padStart(2, '0')
  #January is 0!
  yyyy = today.getFullYear()
  # add a zero in front of numbers<10
  m = checkTime(m)
  s = checkTime(s)
  $('#time').html h + ':' + m + ':' + s
  $('#date').html dd + '.' + mm + '.' + yyyy
  t = setTimeout((->
    startTime()
    return
  ), 500)
  return