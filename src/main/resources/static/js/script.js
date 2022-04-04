var buttonContainer = document.getElementById("infoMenu");
var buttons = buttonContainer.getElementsByClassName("menuButton");

for (var i = 0; i < buttons.length; i++)
{
    buttons[i].addEventListener("click", function()
    {
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
        if (width > 992) {
            hr.style.marginLeft = "34%";
        } else {
            hr.style.marginLeft = "50%";
        }
    } else {
        divInventory.style.display = "block";
        if (width > 992) {
            hr.style.marginLeft = "34%";
        } else {
            hr.style.marginLeft = "50%";
        }
    }

    var divGenerate = document.getElementById("generate");

    if (divGenerate.style.display === "block") {
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
    footer.style.marginTop = "350px";

    if (divGenerate.style.display === "none") {
        divGenerate.style.display = "block";
        if (width > 992) {
            hr.style.marginLeft = "47rem";
        } else {
            hr.style.marginLeft = "35rem";
        }
    } else {
        divGenerate.style.display = "block";
        if (width > 992) {
            hr.style.marginLeft = "47rem";
        } else {
            hr.style.marginLeft = "35rem";
        }
    }

    var divInventory = document.getElementById("inventory");

    if (divInventory.style.display === "block") {
        divInventory.style.display = "none";
    } else {
        divInventory.style.display = "none";
    }
}