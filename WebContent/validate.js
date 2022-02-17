function validate() {
    let name = document.getElementById("nameId").value;
    let percentage = document.getElementById("percentId").value;
    let username = document.getElementById("usernameId").value;
    let password = document.getElementById("passwordId").value;

    if (isBlank(name)) {
        document.getElementById("nameMsg").innerHTML = "Enter name";
        document.getElementById("nameMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(percentage)) {
        document.getElementById("percentMsg").innerHTML = "Enter percentage";
        document.getElementById("percentMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(usernname)) {
        document.getElementById("usernameMsg").innerHTML = "Enter username";
        document.getElementById("usernameMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(password)) {
        document.getElementById("passwordMsg").innerHTML = "Enter password";
        document.getElementById("passwordMsg").style.color = "red";
        return false;
    }
 
    return true;
}
function isBlank(val) {
    return (val.trim() == "") ? true : false;
}