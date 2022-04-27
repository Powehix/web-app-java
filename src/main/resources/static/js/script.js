var link = document.getElementById("printLink");

/*if (window.location.pathname === "/qrGenerate") {
    link.style.display = "block";
}*/

function togglePrint() {
    /*if (window.matchMedia('(print)')) {
        link.style.display = "none";
    }*/
}

var buttonContainer = document.getElementById("infoMenu");
var buttons = buttonContainer.getElementsByClassName("menuButton");

for (var i = 0; i < buttons.length; i++)
{
    buttons[i].addEventListener("click", function() {
        var current = document.getElementsByClassName("active");
        current[0].className = current[0].className.replace(" active", "");
        this.className += " active";
    });
}

function toggleInventory() {
    var divInventory = document.getElementById("inventory");
    var hr = document.getElementById("hrInfo");
    var width = window.innerWidth;
    var footer = document.getElementById("foot");
    footer.style.marginTop = "150px";

    if (divInventory.style.display === "none") {
        divInventory.style.display = "block";
        if (width > 1200) {
            hr.style.marginLeft = "33rem";
        } else {
            hr.style.marginLeft = "17rem";
        }
    } else {
        divInventory.style.display = "block";
        if (width > 1200) {
            hr.style.marginLeft = "33rem";
        } else {
            hr.style.marginLeft = "17rem";
        }
    }

    var divGenerate = document.getElementById("generate");

    if (divGenerate.style.display === "flex") {
        divGenerate.style.display = "none";
    } else {
        divGenerate.style.display = "none";
    }
}

function toggleGenerate() {
    var divGenerate = document.getElementById("generate");
    var hr = document.getElementById ("hrInfo");
    var width = window.innerWidth;
    var footer = document.getElementById("foot");
    footer.style.marginTop = "130px";

    if (divGenerate.style.display === "none") {
        divGenerate.style.display = "flex";
        if (width > 1200) {
            hr.style.marginLeft = "47rem";
        } else {
            hr.style.marginLeft = "31rem";
        }
    } else {
        divGenerate.style.display = "flex";
        if (width > 1200) {
            hr.style.marginLeft = "47rem";
        } else {
            hr.style.marginLeft = "31rem";
        }
    }

    var divInventory = document.getElementById("inventory");

    if (divInventory.style.display === "block") {
        divInventory.style.display = "none";
    } else {
        divInventory.style.display = "none";
    }
}