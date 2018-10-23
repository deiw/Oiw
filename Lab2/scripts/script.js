function addParagraph() {
    var paragraph = document.createElement("p");
    var node = document.createTextNode("This is new paragraph");

    paragraph.appendChild(node);

    var element = document.getElementById("content");
    var child = document.getElementById("description");
    paragraph.style.color = 'red';
    element.insertBefore(paragraph, child);
}

var button = document.querySelector("button");

button.onclick = function () {
    addParagraph();
}
