    <%-- 
    Document   : tourdetail
    Created on : Aug 25, 2022, 11:57:10 AM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>

<h1 class="text-center text-info" style="padding: 15px"> Chi tiết tour du lịch </h1>

<div class="row">
    <div class="col-md-6">
        <c:choose>
            <c:when test="${tour.image!=null && tour.image.startsWith('http')==true}">
                <img class="card-img-top flexAll " class="img-fluid" src="${tour.image}" alt="Card image">
            </c:when>
            <c:when test="${tour.image==null || tour.image.startsWith('http')==false}">
                <img class="card-img-top flexAll " class="img-fluid" src="../../resources/img/phocohoian.jpg" alt="Card image">
            </c:when>
        </c:choose>
    </div>

    <div class="col-md-6">
        <h1 class="text-center text-danger">${tour.tourname}</h1>
        <h5 style="padding: 5px">Giá cho người lớn - <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${tour.priceforadult}" /> VNÐ</h5>
        <h5 style="padding: 5px">Giá cho trẻ em - <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${tour.priceforchild}" /> VNÐ</h5>
        <h5 style="padding: 5px">Ngày đi - ${tour.time}</h5>
        <h5 style="padding: 5px">Mô tả - ${tour.description}</h5>
        <div style="padding: 15px">
            <a href="<c:url value="/booking/${tour.tourid}"></c:url>" class="btn btn-primary ">Dat tour ngay</a>
        </div>
    </div>
</div>
<br></br>
<form>
    <div class="form-group" style="padding: 10px">
        <textarea class="form-control"  id="commentId" placeholder="Nhap danh gia"  ></textarea>
        <br>
        <input type="button"
               onclick="addComment(${tour.tourid})"
               value="Gui binh luan" class="btn btn-danger"/>
    </div> 
</form>
<div id="commentArea">
    <c:forEach items="${tour.ratesList}" var="rate">
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