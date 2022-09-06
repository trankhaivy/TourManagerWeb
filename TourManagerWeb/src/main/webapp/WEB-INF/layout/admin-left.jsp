<%-- 
    Document   : admin-left
    Created on : Sep 2, 2022, 11:24:04 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>

<nav class="navbar br-light">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/tour-stats"/>">Thong ke doanh thu san pham</a>
        </li>
    </ul>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/tour-month-stats"/>">Thong ke doanh thu san pham theo thang</a>
        </li>
    </ul>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/tour-quarter-stats"/>">Thong ke doanh thu san pham theo quy</a>
        </li>
    </ul>
</nav>