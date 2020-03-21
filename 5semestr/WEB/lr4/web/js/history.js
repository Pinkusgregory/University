var localCont;
var sessionCont;

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

function getSessionHistory(){
    sessionCont = document.getElementById("history-cookies");

    for(var i=0; i<6; i++){
        switch (i) {
            case 0:
                sessionCont.innerHTML += "<tr><td>Интересы</td><td>"+sessionStorage.getItem("Интересы")+"</td></tr>";
                break;
            case 1:
                sessionCont.innerHTML += "<tr><td>Учеба</td><td>"+sessionStorage.getItem("Учеба")+"</td></tr>";
                break;
            case 2:
                sessionCont.innerHTML += "<tr><td>Контакт</td><td>"+sessionStorage.getItem("Контакт")+"</td></tr>";
                break;
            case 3:
                sessionCont.innerHTML += "<tr><td>Фотоальбом</td><td>"+sessionStorage.getItem("Фотоальбом")+"</td></tr>";
                break;
            case 4:
                sessionCont.innerHTML += "<tr><td>Тест</td><td>"+sessionStorage.getItem("Тест")+"</td></tr>";
                break;
            case 5:
                sessionCont.innerHTML += "<tr><td>История</td><td>"+sessionStorage.getItem("История")+"</td></tr>";
                break;
        }
    }
}

getLocalHistory();
getSessionHistory();