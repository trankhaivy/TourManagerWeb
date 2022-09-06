<%-- 
    Document   : updatetour
    Created on : Sep 3, 2022, 8:37:48 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>
<h1 class="text-center text-danger">Quản lý tour </h1>

<c:url value="/admin/tours/update/${tourid}" var="action"/>
<form:form method="post" action="${action}" modelAttribute="tour" enctype="multipart/form-data">
    <form:hidden path="tourid"/>
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
        <input type="submit" value="Sua tour" class="btn btn-danger"/>
    </div>
</form:form>

