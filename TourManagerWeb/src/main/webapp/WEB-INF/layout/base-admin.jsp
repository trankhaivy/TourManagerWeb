<%-- 
    Document   : baseadmin
    Created on : Sep 2, 2022, 11:29:39 AM
    Author     : Admin
--%>

<%@include file="../tablig.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.2.0/css/all.css">
        <link rel="stylesheet" href="<c:url value="/resources/css/flexType.css" />"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <tiles:insertAttribute name="left" />
                </div>
                <div class="col-md-8 col-xs-12">
                    <tiles:insertAttribute name="content" />
                </div>
            </div>
                <tiles:insertAttribute name="footer" />
        </div>      
        
        <script src="../../resources/js/stats.js" type="text/javascript"></script>
    </body>
</html>