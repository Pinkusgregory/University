var localCont;
var cookieCont;

function resetLocalStorage(){
    localStorage.clear();
    localStorage.setItem("Интересы","0");
    localStorage.setItem("Учеба","0");
    localStorage.setItem("Контакт","0");
    localStorage.setItem("Фотоальбом","0");
    localStorage.setItem("Тест","0");
    localStorage.setItem("История","0");
}

window.onload = function saveLocalHistory(){
    localStorage.setItem(window.document.title,(parseInt(localStorage.getItem(window.document.title))+1).toString());
    return
}

function getLocalHistory(){
    localCont = document.getElementById("history-local");

    for(var i=0; i<6; i++){
        switch (i) {
            case 0:
                localCont.innerHTML += "<tr><td>Интересы</td><td>"+localStorage.getItem("Интересы")+"</td></tr>";
                break;
            case 1:
                localCont.innerHTML += "<tr><td>Учеба</td><td>"+localStorage.getItem("Учеба")+"</td></tr>";
                break;
            case 2:
                localCont.innerHTML += "<tr><td>Контакт</td><td>"+localStorage.getItem("Контакт")+"</td></tr>";
                break;
            case 3:
                localCont.innerHTML += "<tr><td>Фотоальбом</td><td>"+localStorage.getItem("Фотоальбом")+"</td></tr>";
                break;
            case 4:
                localCont.innerHTML += "<tr><td>Тест</td><td>"+localStorage.getItem("Тест")+"</td></tr>";
                break;
            case 5:
                localCont.innerHTML += "<tr><td>История</td><td>"+localStorage.getItem("История")+"</td></tr>";
                break;
        }
    }
}

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function setCookie(cname, cvalue, exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays*24*60*60*1000));
  var expires = "expires="+ d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function resetCookies(){ 
    if(getCookie("interes.html")=="") setCookie("interests.html",0,30)
    if(getCookie("studies.html")=="") setCookie("study.html",0,30)
    if(getCookie("contact.html")=="") setCookie("contact.html",0,30)
    if(getCookie("photos.html")=="") setCookie("photo.html",0,30)
    if(getCookie("test.html")=="") setCookie("test.html",0,30)
    if(getCookie("history.html")=="") setCookie("history.html",0,30)
    return
}

function saveCookieHistory(){
    console.log("hi")
    setCookie(window.location.pathname.split("/").pop(),(parseInt(getCookie(window.location.pathname.split("/").pop()))+1).toString());
    return
}

function getCookieHistory(){
    cookieCont = document.getElementById("history-cookie");

    for(var i=0; i<6; i++){
        switch (i) {
            case 0:
                cookieCont.innerHTML += "<tr><td>Интересы</td><td>"+getCookie("interests.html")+"</td></tr>";
                break;
            case 1:
                cookieCont.innerHTML += "<tr><td>Учеба</td><td>"+getCookie("study.html")+"</td></tr>";
                break;
            case 2:
                cookieCont.innerHTML += "<tr><td>Контакт</td><td>"+getCookie("contact.html")+"</td></tr>";
                break;
            case 3:
                cookieCont.innerHTML += "<tr><td>Фотоальбом</td><td>"+getCookie("photo.html")+"</td></tr>";
                break;
            case 4:
                cookieCont.innerHTML += "<tr><td>Тест</td><td>"+getCookie("test.html")+"</td></tr>";
                break;
            case 5:
                cookieCont.innerHTML += "<tr><td>История</td><td>"+getCookie("history.html")+"</td></tr>";
                break;
        }
    }
}

getLocalHistory();
getCookieHistory();
saveCookieHistory();