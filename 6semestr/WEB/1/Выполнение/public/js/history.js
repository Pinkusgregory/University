$(function(){
    $("#history-local").html(function(n){
        var str = "";
        for(var n=0; n<6; n++){
            switch (n) {
                case 0:
                    str += "<tr><td>Интересы</td><td>"+localStorage.getItem("Интересы")+"</td></tr>";
                    break;
                case 1:
                    str += "<tr><td>Учеба</td><td>"+localStorage.getItem("Учеба")+"</td></tr>";
                    break;
                case 2:
                    str += "<tr><td>Контакт</td><td>"+localStorage.getItem("Контакт")+"</td></tr>";
                    break;
                case 3:
                    str += "<tr><td>Фотоальбом</td><td>"+localStorage.getItem("Фотоальбом")+"</td></tr>";
                    break;
                case 4:
                    str += "<tr><td>Тест</td><td>"+localStorage.getItem("Тест")+"</td></tr>";
                    break;
                case 5:
                    str += "<tr><td>История</td><td>"+localStorage.getItem("История")+"</td></tr>";
                    break;
            }
        }
        return str;
    });
});

$(function(){
    $("#history-cookies").html(function(n){
        var str = "";
        for(var n=0; n<6; n++){
            switch (n) {
                case 0:
                    str += "<tr><td>Интересы</td><td>"+sessionStorage.getItem("Интересы")+"</td></tr>";
                    break;
                case 1:
                    str += "<tr><td>Учеба</td><td>"+sessionStorage.getItem("Учеба")+"</td></tr>";
                    break;
                case 2:
                    str += "<tr><td>Контакт</td><td>"+sessionStorage.getItem("Контакт")+"</td></tr>";
                    break;
                case 3:
                    str += "<tr><td>Фотоальбом</td><td>"+sessionStorage.getItem("Фотоальбом")+"</td></tr>";
                    break;
                case 4:
                    str += "<tr><td>Тест</td><td>"+sessionStorage.getItem("Тест")+"</td></tr>";
                    break;
                case 5:
                    str += "<tr><td>История</td><td>"+sessionStorage.getItem("История")+"</td></tr>";
                    break;
            }
        }
        return str;
    });
});