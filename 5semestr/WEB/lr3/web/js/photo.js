var gallery_elements = [];
for(var i=1;i<=9;i++) {
    gallery_elements.push('images/' + i + '.jpg');
}
  
window.onload = function() { 
    var container = document.getElementById("gallery");
    var i = 1;
    gallery_elements.forEach(photo => {
        var img = document.createElement('img');
        img.setAttribute('src', photo);
        img.setAttribute('alt', 'Photo' + i++);
        container.appendChild(img);
    });
}
 