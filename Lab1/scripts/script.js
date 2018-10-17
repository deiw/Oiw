var year = 2018;
var countDownDate = new Date("Dec 31, " + year + " 00:00:00").getTime();

var x = setInterval(function () {

    var now = new Date().getTime();

    var timeDifference = countDownDate - now;

    var days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
    var hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);

    document.getElementById("counter").innerHTML = days + "d " + hours + "h "
        + minutes + "m " + seconds + "s ";

    if (timeDifference < 0) {
        clearInterval(x);
        year = year + 1;
    }
}, 1000);

var buttonHeaderChanger = document.querySelector('button');
var header = document.querySelector('h1');

function changeHeader() {
    var customHeader = prompt('Enter your header');
    localStorage.setItem('header', customHeader);
    header.textContent = customHeader;
}

buttonHeaderChanger.onclick = function () {
    changeHeader();
}

if (!localStorage.getItem('header')) {
    changeHeader();
} else {
    header.textContent = localStorage.getItem('header');
}