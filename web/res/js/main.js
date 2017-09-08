/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showAlert() {
    alert('hello');
}

function getData() {
    var url = "result.htm?member=jimmy";
    $.get(url, function (data, status) {
        if (status === "success") {
            alert(data.toString().trim());
        }
    });
}