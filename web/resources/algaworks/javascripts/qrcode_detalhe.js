var qrcode = new QRCode(document.getElementById("qrcode"), {
    width: 100,
    height: 100
});

function makeCode() {
    var elText = window.location.href;
    qrcode.makeCode(elText);
    
}
makeCode();




