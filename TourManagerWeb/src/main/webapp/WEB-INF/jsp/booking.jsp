<%-- 
    Document   : booking
    Created on : Aug 30, 2022, 2:38:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>
<h1 class="text-center text-danger">Đăt tour </h1>

<c:url value="/booking/${tourid}" var="action" />
<form:form method="post" action="${action}" modelAttribute="booking" enctype="form-data">
    <div class="form-group" style="padding: 10px">
        <label for="numberofadult">So luong ve nguoi lon</label>
        <form:input type="number" id="numberofadult" path="numberofadult" cssClass="form-control"/>
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="numberofchild">So luong ve tre em</label>
        <form:input type="number" id="numberofchild" path="numberofchild" cssClass="form-control"/>
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="time">Ngày dat hang</label>
        <form:input type="date" id="bookingdate" path="bookingdate" cssClass="form-control" />
    </div>
    <div class="form-group" style="padding: 10px">
        <a class="alert-danger">TotalPrice: ${totalprice[6]} </a>
        
    </div>
    <div class="form-group">
        <input type="submit" value="Dat tour" class="btn btn-danger"/>
    </div>
</form:form>