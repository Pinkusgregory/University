var modal = $("#myModal");
var btn = $("#myBtn");
var span = $(".close-modal");
btn.click(function() {
  modal.css("display", "block");
});

span.click(function() {
  modal.css("display", "none");
});

$("window").click(function(event) {
  if (event.target == modal) {
    modal.css("display", "none");
  }
});