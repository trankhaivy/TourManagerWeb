/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
function addComment(tourid) {
    fetch("/api/add-rate", {
        method: 'post',
        body: JSON.stringify({
            "comment": document.getElementById("commentId").value,
            "tourid": tourid
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)
        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("commentArea");

        area.innerHTML = `
        <div class="row" style="padding: 10px">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" src="${data.users.avatar}"/>
            </div>
            <div class="col-md-10 date">
                <p>${data.comment}</p>
                <i>${moment(data.ratingdate).fromNow()}</i>
            </div>
        </div>
    ` + area.innerHTML
    })
}

function addComment(newsid) {
    fetch("/api/add-ratenews", {
        method: 'post',
        body: JSON.stringify({
            "comment": document.getElementById("commentId").value,
            "newsid": newsid
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)
        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("commentArea");

        area.innerHTML = `
        <div class="row" style="padding: 10px">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" src="${data.users.avatar}"/>
            </div>
            <div class="col-md-10 date">
                <p>${data.comment}</p>
                <i>${moment(data.ratingdate).fromNow()}</i>
            </div>
        </div>
    ` + area.innerHTML
    })
}
