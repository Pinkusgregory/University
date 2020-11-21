function checkTime(i) {
  if (i < 10) {
    i = "0" + i;
  }
  return i;
}

$(function startTime() {
  var today = new Date();
  var h = today.getHours();
  var m = today.getMinutes();
  var s = today.getSeconds();
  var today = new Date();
  var dd = String(today.getDate()).padStart(2, '0');
  var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
  var yyyy = today.getFullYear();
  // add a zero in front of numbers<10
  m = checkTime(m);
  s = checkTime(s);
  $('#time').html(h + ":" + m + ":" + s);
  $('#date').html(dd + "." + mm + "." + yyyy);
  t = setTimeout(function() {
    startTime()
  }, 500);
});