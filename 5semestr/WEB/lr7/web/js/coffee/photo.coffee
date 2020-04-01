gallery_elements = []
i = 1
while i <= 9
  gallery_elements.push 'images/' + i + '.jpg'
  i++
$ ->
  `var i`
  container = document.getElementById('gallery')
  i = 1
  gallery_elements.forEach photo, ->
    a = document.createElement('a')
    a.setAttribute 'href', photo
    a.setAttribute 'data-lightbox', 'myphotos'
    a.innerHTML = ' <img src=" ' + photo + ' "> '
    container.appendChild a
    return
  return