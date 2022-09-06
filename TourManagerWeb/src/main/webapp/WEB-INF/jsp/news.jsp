<%-- 
    Document   : news
    Created on : Sep 1, 2022, 12:09:13 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>
<h1 class="text-center text-danger">Quản lý tin tức </h1>

<c:url value="/admin/news" var="action"/>
<form:form method="post" action="${action}" modelAttribute="news" enctype="multipart/form-data">
    <div class="form-group" style="padding: 10px">
        <label for="newsname">Tiêu đề</label>
        <form:input type="text" id="newsname" path="newsname" cssClass="form-control" />
        <form:errors path="newsname" cssClass="alert alert-danger" element="div" />
    </div>
    <label style="padding:10px" for="content">Nội dung</label>
    <textarea style="padding: 10px"
        <form:input type="text" id="content" path="content" cssClass="form-control" />
        <form:errors path="content" cssClass="alert alert-danger" element="div" />
    </textarea>

    <div class="form-group" style="padding: 10px">
        <label for="file">Ảnh news</label>
        <form:input type="file" id="newsImage" path="newsImage" cssClass="form-control" />
    </div>
    <p></p>
    <div class="form-group">
        <input type="submit" value="Them tin tuc" class="btn btn-danger"/>
    </div>
</form:form>
