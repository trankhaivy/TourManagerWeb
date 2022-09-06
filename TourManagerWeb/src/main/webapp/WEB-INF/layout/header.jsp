<%-- 
    Document   : header
    Created on : Jul 24, 2022, 1:10:04 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<c:if test="${currentUser!=null}">
    ${currenUser.firstname}
</c:if>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a href="" class="navbar-brand">
            <h5 class="m-0 text-success"><span class="text-white">Tour nhà l</span>àm</h5>
        </a>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto" style="font-size: 10px">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
                </li>

                <c:forEach items="${tourtypes}" var="c">
                    <c:url value="/" var="cUrl">
                        <c:param name="typeid" value="${c.typeid}" />
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cUrl}">${c.typename}</a>
                    </li>
                </c:forEach>

                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/register"/>">Đăng kí</a>
                </li>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item active">
                        <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                    </li>
                </c:if>

                <c:if test="${pageContext.request.userPrincipal.name!=null}">
                    <li class="nav-item">
                        <a class="nav-link text-success" href="<c:url value="/login"/>">
                            <c:if test="${currentUser.avatar!=null}">
                                <img src="${currentUser.avatar}" class="rounded-circle" style="width: 30px"/>${pageContext.request.userPrincipal.name}
                            </c:if>
                            <c:if test="${currentUser.avatar==null}">
                                <i class="fa fa-user" aria-hidden="true">${pageContext.request.userPrincipal.name}</i>
                            </c:if>
                        </a>
                    </li>
                </c:if>
                <li class="nav-item active">
                    <a class="nav-link text-success" href="<c:url value="/logout"/>">Đăng xuất</a>
                </li>
                <c:if test="${currentUser.role=='admin'}">
                    <li class="nav-item active">
                        <a class="nav-link text-success" href="<c:url value="/admin/tours"/>">Quản lí tour</a>
                    </li>
                </c:if>
                <c:if test="${currentUser.role=='admin'}">
                    <li class="nav-item active">
                        <a class="nav-link text-success" href="<c:url value="/admin/news"/>">Quản lý tin tức</a>
                    </li>
                </c:if>
                <li class="nav-item active">
                    <a class="nav-link " href="<c:url value="/news"/>">Tin tức</a>
                </li>
                <c:if test="${currentUser!=null&&currentUser.role!='admin'}">
                    <li class="nav-item text-success">
                        <a href="<c:url value="/bookingdetail"/>" class="fas fa-cart-plus">
                            Thông tin đơn hàng
                        </a>
                    </li>
                </c:if>
                <c:if test="${currentUser.role=='admin'}">
                    <li class="nav-item active">
                        <a class="nav-link text-success" href="<c:url value="/admin/tour-stats"/>">Quản lý doanh thu</a>
                    </li>
                </c:if>
            </ul>
        </div>     
    </div>
</nav>
<div class="navbar-toggler">
    <form action="${action}" class="d-flex">
        <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tour...">
        <button type="submit" class="btn btn-success" type="button">Tìm</button>
    </form>
</div>


