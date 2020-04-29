$(document).ready(function () {
    var slideIndex;
    $(".close").click(function () {
        $("#myModal").css("display", "none");
    });
    $(".hover-shadow").click(function () {
        $("#myModal").css("display", "block");
        var str = $(this).attr("src");
        var matches = str.match(/(\d+)/);
        var n = matches[0];
        slideIndex = n;
        showSlides(n);
    });
    $(".prev").click(function () {
        slideIndex -= 1;
        showSlides(slideIndex);
    });

    $(".next").click(function () {
        slideIndex = parseInt(slideIndex) + 1;
        showSlides(slideIndex);
    });
    
    function showSlides(n){
        console.log(slideIndex);
        var i;
        var slides = $(".mySlides");
        if (n > slides.length) {slideIndex = 1}
        if (n < 1) {slideIndex = slides.length}
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }

        slides[slideIndex-1].style.display = "block";
    }

});
