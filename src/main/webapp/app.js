console.log("APP JS LOADED");
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
let resendCountdown = 180;
let resendInterval;
let canResend = false;

function startCountdown() {
console.log("TIMER STARTED");
    // ALWAYS clear first (important fix)
    clearInterval(resendInterval);

    resendCountdown = 180;
    canResend = false;

    let resendText = document.getElementById("resendText");
    let countdownEl = document.getElementById("countdown");

    if(resendText){
        resendText.style.color = "gray";
        resendText.style.cursor = "not-allowed";
        resendText.innerText = "Resend code";
    }

    if(countdownEl){
    countdownEl.innerText = "03:00";
}

    resendInterval = setInterval(() => {

      resendCountdown--;

let minutes = Math.floor(resendCountdown / 60);
let seconds = resendCountdown % 60;

// add leading zeros (important)
if (minutes < 10) minutes = "0" + minutes;
if (seconds < 10) seconds = "0" + seconds;

if (countdownEl) {
    countdownEl.innerText = minutes + ":" + seconds;
}

        if(resendCountdown <= 0){
            clearInterval(resendInterval);
            canResend = true;

            if(resendText){
                resendText.innerText = "Resend code ";
                resendText.style.color = "blue";
                resendText.style.cursor = "pointer";
            }
        }

    }, 1000);
}
function resendCode() {
    if(!canResend) return;

    // optional backend call here
    // fetch("resendCode", { method: "POST" });

    startCountdown();
}
document.addEventListener("DOMContentLoaded", function () {
    console.log("TIMER STARTED");
    startCountdown();
});


