<%-- 
    Document   : register
    Created on : Aug 23, 2022, 2:51:39 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>

<c:if   test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:url value="/register" var="action"/>       
<form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
    <h3 class="text-center text-info">Register</h3>
    <div class="form-group" style="padding: 10px">
        <label for="firstname" class="text-info">First name:</label><br>
        <form:input type="text" id="firstname" path="firstname" class="form-control"/>
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="lastname" class="text-info">Last name:</label><br>
        <form:input type="text" id="lastname" path="lastname" class="form-control"/>
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="username" class="text-info">Username:</label><br>
        <form:input type="text" id="username" path="username" class="form-control"/>
    </div>   
    <div class="form-group" style="padding: 10px">
        <label for="password" class="text-info">Password:</label><br>
        <form:input type="password" id="password" path="password" class="form-control"/>
    </div>
    <div class="form-group" style="padding: 10px">
        <label for="firstname" class="text-info">Confirm password:</label><br>
        <form:input type="password" id="confirmPassword" path="confirmPassword" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="file">Avartar</label>
        <form:input type="file" id="file" path="avatarFile" cssClass="form-control" />
    </div>
    <div class="form-group" style="padding: 10px">
        <input type="submit" value="Dang ki" class="btn btn-info"/>
    </div>
</form:form>
