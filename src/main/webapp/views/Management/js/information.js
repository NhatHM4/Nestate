var buttons = document.getElementsByClassName('tablinks');

var contents = document.getElementsByClassName('tabcontent1');
console.log("list content:", contents)

// set Tabs display  = none or Grid
function showContent(id) {
    for (var i = 0; i < contents.length; i++) {
        contents[i].style.display = 'none';
    }
    var content = document.getElementById(id);
    // console.log("content:", content);
    content.style.display = 'grid';
}


// handle event click tab 
for (var i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener("click", function () {
        var id = this.textContent;
        for (var i = 0; i < buttons.length; i++) {
            buttons[i].classList.remove("active");
        }
        this.className += " active";
        showContent(id);
    });
}
showContent("Key-info");