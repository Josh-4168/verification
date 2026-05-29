function submitPhone(){ 
    let country = document.getElementById("countryCode").value; 
    let phone = document.getElementById("phone").value;
    let fullPhone = country + phone; 
    if(phone === ""){
        document.getElementById("message") .innerHTML = "Phone number required";
        return; } 
    fetch("submitPhone",{ method:"POST", headers:{
            "Content-Type": "application/x-www-form-urlencoded" },
        body:"phone=" + encodeURIComponent(fullPhone) })
            .then(response => response.text())
            .then(data => { if(data === "SUCCESS"){
                    window.location.href = "verify.jsp";
        }else{ document.getElementById("message") .innerHTML = "Failed to submit"; } }); 
} 
function verifyCode(){ 
    let code = document.getElementById("code").value;
    fetch("verifyCode",{ method:"POST",
        headers:{ "Content-Type": "application/x-www-form-urlencoded" }, 
        body:"code=" + encodeURIComponent(code) })
            .then(response => response.text()) 
            .then(data => { 
                if(data === "VERIFIED"){
                    document.getElementById("verifyMessage") .style.color = "#00ff99";
            document.getElementById("verifyMessage") .innerHTML = "Verification successful"; 
        }else{ document.getElementById("verifyMessage") .innerHTML = "Invalid code"; } }); 
}
function generateCode(){ 
    let phone = document.getElementById("adminPhone").value; 
    let code = document.getElementById("adminCode").value; 
    fetch("generateCode",{ method:"POST", 
        headers:{ "Content-Type": "application/x-www-form-urlencoded" },
        body: "phone=" + encodeURIComponent(phone) + "&code=" + encodeURIComponent(code) }) 
            .then(response => response.text())
            .then(data => { document.getElementById("adminMessage") .innerHTML = data; }); } 
function toggleTheme(){
    document.body.classList.toggle("light-mode"); } 
let countdown = 60; setInterval(() => { 
    let element = document.getElementById("countdown"); 
    if(element && countdown > 0){ 
        countdown--;
        element.innerHTML = countdown; } },1000);


