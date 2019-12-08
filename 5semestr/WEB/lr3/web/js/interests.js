var hobbies_elements = ["Хобби 1", "Хобби 2", "Хобби 3", "Хобби 4", "Хобби 5"];
var books_elements = ["Книга 1", "Книга 2", "Книга 3", "Книга 4", "Книга 5"]; 

  
window.onload = function() { 
    var cont1 = document.getElementById("Hobbies"), 
        html1 = '';
    var cont2 = document.getElementById("Books"), 
        html2 = '';
    for(var i=0;i<hobbies_elements.length;i++) {
        html1 += '<li><p>'+hobbies_elements[i]+'</p></li>';
    }
    for(var i=0;i<books_elements.length;i++) {
        html2 += '<li><p>'+books_elements[i]+'</p></li>';
    } 
    cont1.innerHTML = html1; 
    cont2.innerHTML = html2; 
} 