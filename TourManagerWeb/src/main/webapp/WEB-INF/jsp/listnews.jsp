<%-- 
    Document   : listnews
    Created on : Sep 1, 2022, 4:29:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>
<h1 class="text-center text-danger">Trang tin tức</h1>

<div>
    <table class="table">
        <tr>
            <th>Hình</th>
            <th>Tiêu đề</th>
            <th></th>
        </tr>
        <c:forEach items="${listnews}" var="l">
            <tr>
                <td><div class="col-md-2"><img class="card-img-top img-fluid " src="${l.image}" class="rounded" alt="image"/></div></td>
                <td>${l.newsname}</td>
                <td><a href="<c:url value="/news/${l.newsid}"></c:url>" class="btn btn-info ">Xem</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
