<%-- 
    Document   : tours
    Created on : Aug 14, 2022, 4:21:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>
<h1 class="text-center text-danger">Quản lý tour </h1>

<c:url value="/admin/tours" var="action"/>
<form:form method="post" action="${action}" modelAttribute="tour" enctype="multipart/form-data">
    <div class="form-group" style="padding: 10px">
        <label for="tourname">Tên tour</label>
        <form:input type="text" id="tourname" path="tourname" cssClass="form-control" />
        <form:errors path="tourname" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="priceforadult">Giá người lớn</label>
        <form:input type="text" id="priceforadult" path="priceforadult" cssClass="form-control" />
        <form:errors path="priceforadult" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="priceforchild">Giá trẻ em</label>
        <form:input type="text" id="priceforchild" path="priceforchild" cssClass="form-control" />
        <form:errors path="priceforchild" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="time">Ngày di</label>
        <form:input type="date" id="time" path="time" cssClass="form-control" />
        <form:errors path="time" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="time">Số lượng vé tối đa</label>
        <form:input type="text" id="" path="maxquantity" cssClass="form-control" />
        <form:errors path="maxquantity" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="time">Mô tả</label>
        <form:input type="text" id="" path="description" cssClass="form-control" />
        <form:errors path="description" cssClass="alert alert-danger" element="div" />
    </div>
    <div class="form-floating" style="padding: 10px">
        <form:select path="tourtypes" class="form-select" id="tourtypes" name="types">
            <c:forEach items="${tourtypes}" var="t">
                <option value="${t.typeid}">${t.typename}</option>
            </c:forEach>
        </form:select>
        <label for="tourtype">Loai tour</label>
    </div>
    
    <div class="form-group" style="padding: 10px">
        <label for="file">Ảnh tour</label>
        <form:input type="file" id="file" path="file" cssClass="form-control" />
    </div>
    <p></p>
    <div class="form-group">
        <input type="submit" value="Them tour" class="btn btn-danger"/>
    </div>


</form:form>


<div>
    <table class="table">
        <tr>
            <th>Image</th>
            <th>TourName</th>
            <th>PriceForAdult</th>
            <th>PriceForChild</th>
            <th></th>
        </tr>
        <c:forEach items="${price}" var="p">
            <tr>
                <td><div class="col-md-2"><img class="card-img-top img-fluid " src="${p[0]}" class="rounded" alt="image"/></div></td>
                <td>${p[1]}</td>
                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p[2]}" /></td>
                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p[3]}" /></td>
                <td><a href="<c:url value="/admin/tours/delete/${p[4]}"></c:url>" class="btn btn-info ">Xóa</a></td>
                <td><a href="<c:url value="/admin/tours/update/${p[4]}"></c:url>" class="btn btn-info ">Câp nhat</a></td>
            </tr>
        </c:forEach>
    </table>
</div>