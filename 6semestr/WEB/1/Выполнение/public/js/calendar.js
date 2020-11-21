var d0 = new Date(1910, 00, 01);
var d1 = new Date();

var dS = d1;

var year;
var month;

var text;
var calendar;

window.onload = function setDefault(){
    year = document.getElementById("calendar-year");
    month = document.getElementById("calendar-month");
    calendar = document.getElementById("calendar-table");
    text = document.getElementById("calendar-text");

    for(var i = d1.getFullYear(); i>=d0.getFullYear(); i--){
        year.innerHTML += "<option value =\""+i+"\" >"+i+"</option>";
    }

    for(var i = 1; i<=12; i++){
        month.innerHTML += "<option value =\""+i+"\" >"+i+"</option>";
    }

    month.value = d1.getMonth()+1
    year.value = d1.getFullYear()

    updateDate()
}

function updateDate(){
    dS.setFullYear(year.value);
    dS.setMonth(month.value-1);
    text.value = dS.getDate()+" "+(dS.getMonth()+1)+" "+dS.getFullYear();
    
    var days = [];
    calendar.innerHTML = "<tr><th>Пн</th><th>Вт</th><th>Ср</th><th>Чт</th><th>Пт</th><th>Сб</th><th>Вс</th></tr>"

    var firstDay = new Date(dS.getFullYear(),dS.getMonth(),1).getDay()

    for(var i=1; i<=daysInMonth(dS.getFullYear(), dS.getMonth()+1); i++) days.push(i);
    
    if(firstDay==0) firstDay = 7;
    
    var row = 1;
    var isNullDays = true;

    while(days.length>0){
        calendar.innerHTML += "<tr id=\"row"+row+"\"></tr>";
        for(var i=0; i<7; i++){
            if(i==firstDay-1) isNullDays = false;
            if(!isNullDays){
                if(days.length==0){
                    document.getElementById("row"+row).innerHTML += "<td></td>";
                } else{
                    if(days[0]==dS.getDate()) document.getElementById("row"+row).innerHTML += "<td class=\"day selected\" id=\"day"+days[0]+"\" onclick=\"selectDate(this)\"><a>"+days[0]+"</a></td>";
                    else document.getElementById("row"+row).innerHTML += "<td class=\"day\" id=\"day"+days[0]+"\" onclick=\"selectDate(this)\"><a>"+days[0]+"</a></td>";
                    days.splice(0,1);
                }
                
            } else document.getElementById("row"+row).innerHTML += "<td></td>";
        }
        row++;
    }
    t = setTimeout(function() {
    updateDate()
  }, 500);
}

function daysInMonth(year, month) {
    return new Date(year, month, 0).getDate();
}

function selectDate(element){
    dS.setDate(element.children[0].innerHTML)
    updateDate()
}