modal = $('#myModal')
btn = $('#myBtn')
span = $('.close-modal')
btn.click ->
  modal.css 'display', 'block'
  return
span.click ->
  modal.css 'display', 'none'
  return
$('window').click (event) ->
  if event.target == modal
    modal.css 'display', 'none'
  return