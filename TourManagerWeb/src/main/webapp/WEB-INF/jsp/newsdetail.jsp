<%-- 
    Document   : newsdetail
    Created on : Sep 1, 2022, 5:40:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>

<h1 class="text-center text-info" style="padding: 15px"> Chi tiết tin tuc</h1>

<div class="row">

    <div class="col">

        <h1 class="text-center text-danger">${newsdetail.newsname}</h1>
        <div class="col">
            <c:choose>
                <c:when test="${newsdetail.image!=null && newsdetail.image.startsWith('http')==true}">
                    <img class="card-img-top flexAll " class="img-fluid" src="${newsdetail.image}" alt="Card image">
                </c:when>
                <c:when test="${newsdetail.image==null || newsdetail.image.startsWith('http')==false}">
                    <img class="card-img-top flexAll " class="img-fluid" src="../../resources/img/phocohoian.jpg" alt="Card image">
                </c:when>
            </c:choose>
        </div>
        <h5 style="padding: 5px">Nôi dung - ${newsdetail.content}</h5>
    </div>
</div>
<br></br>
<form>
    <div class="form-group" style="padding: 10px">
        <textarea class="form-control"  id="commentId" placeholder="Nhap danh gia"  ></textarea>
        <br>
        <input type="button"
               onclick="addComment(${newsdetail.newsid})"
               value="Gui binh luan" class="btn btn-danger"/>
    </div> 
</form>
<div id="commentArea">
    <c:forEach items="${news.ratesofnewsList}" var="rate">
        <div class="row" style="padding: 10px">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" src="${rate.users.avatar}"/>
            </div>
            <div class="col-md-10 date">
                <p>${rate.comment}</p>
                <i>${rate.ratingdate}</i>
            </div>
        </div>
    </c:forEach>    
</div>
<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>