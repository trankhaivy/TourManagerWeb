<%-- 
    Document   : tour-stats
    Created on : Sep 2, 2022, 11:14:57 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>
<h1 class="text-center text-info">THONG KE BAO CAO</h1>

<form action="">
    <div class="form-group">
        <label>Tu khoa</label>
        <input type="text" name="kw" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Tu ngay</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Den ngay</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <input type="submit" value="Bao cao" class="btn btn-info"/>
</form>

<div class="row">
    <div class="col-md-9 col-xs-12">
        <table class="table">
            <tr>
                <th>Ma tour</th>
                <th>Ten tour</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${tourStats}" var="t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                    <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${t[2]}" /> VNÐ</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="col-md-6 col-xs-12">
    <canvas id="myTourChart"></canvas>
</div>

<script>
    let tourLabels = [], tourInfo = []
    <c:forEach items="${tourStats}" var="t">
    tourInfo.push(${t[2]});
    tourLabels.push('${t[1]}');
    </c:forEach>
    window.onload = function () {
        tourChart("myTourChart", tourLabels, tourInfo);
    }
</script>
