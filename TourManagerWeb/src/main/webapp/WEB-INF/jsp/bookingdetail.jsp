<%-- 
    Document   : bookingdetail
    Created on : Aug 31, 2022, 2:02:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>

<div>
    <table class="table">
        <tr>
            <th>Hình ảnh</th>
            <th>Tên tour</th>
            <th>Giá vé người lớn</th>
            <th>Số lượng người lớn</th>
            <th>Giá vé trẻ em</th>       
            <th>Số lượng trẻ em</th>
            <th>Tổng giá</th>
            <th></th>
        </tr>
        <c:forEach items="${totalprice}" var="t">
            <tr>
                <td><div class="col-md-2"><img class="card-img-top img-fluid " src="${t[0]}" class="rounded" alt="image"/></div></td>
                <td>${t[1]}</td>
                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${t[2]}" /></td>
                <td>${t[4]}</td>
                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${t[3]}" /></td>
                <td>${t[5]}</td>
                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${t[6]+t[7]}" /></td>
                <td><a href="<c:url value="/bookingdetail/delete/${t[8]}"></c:url>" class="btn btn-info ">Hủy tour</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
