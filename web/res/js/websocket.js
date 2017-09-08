/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global url */

var wsocket;

//連線
function connect() {
    //建立連線
    wsocket = new WebSocket(url + "/WebSocket");
    wsocket.onmessage = onMessage;
}

//接收訊息
function onMessage(evt) {
    var system_msg = evt.data;
    var json_data = JSON.parse(system_msg);
    var function_s = json_data.function;
    if (function_s === 'update') {
        data_json = json_data;
        update_data();
    }
}

//傳送訊息
function doSend(message) {
    //document.getElementById('text').value = "";
    wsocket.send(message);
}

window.addEventListener("load", connect, false);


