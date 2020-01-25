var gallery_elements = [];
for(var i=1;i<=9;i++) {
    gallery_elements.push('images/' + i + '.jpg');
}
  
window.onload = function() { 
    var container = document.getElementById("gallery");
    var i = 1;
    gallery_elements.forEach(photo => {
        var a = document.createElement('a');
        a.setAttribute('href', photo);
        a.setAttribute('data-lightbox', 'myphotos');
        a.innerHTML = ' <img src=" '+ photo + ' "> ';
        container.appendChild(a);
    });
}
 