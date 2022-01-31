function toggleInventory() {
    var divInventory = document.getElementById("inventory");
    var hr = document.getElementById ("hrInfo")
    var width = window.innerWidth;
    var footer = document.getElementById("foot");
    footer.style.paddingTop = "200px";

    if (divInventory.style.display === "none") {
        divInventory.style.display = "block";
        if (width > 992) {
            hr.style.marginLeft = "32%";
        } else {
            hr.style.marginLeft = "22%";
        }
    } else {
        divInventory.style.display = "block";
        if (width > 992) {
            hr.style.marginLeft = "32%";
        } else {
            hr.style.marginLeft = "22%";
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
    var hr = document.getElementById ("hrInfo")
    var width = window.innerWidth;
    var footer = document.getElementById("foot");
    footer.style.paddingTop = "500px";

    if (divGenerate.style.display === "none") {
        divGenerate.style.display = "block";
        if (width > 992) {
            hr.style.marginLeft = "51.5%";
        } else {
            hr.style.marginLeft = "47%";
        }
    } else {
        divGenerate.style.display = "block";
        if (width > 992) {
            hr.style.marginLeft = "51.5%";
        } else {
            hr.style.marginLeft = "47%";
        }
    }

    var divInventory = document.getElementById("inventory");

    if (divInventory.style.display === "block") {
        divInventory.style.display = "none";
    } else {
        divInventory.style.display = "none";
    }
}