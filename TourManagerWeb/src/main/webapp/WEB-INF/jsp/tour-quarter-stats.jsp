<%-- 
    Document   : tour-quarter-stats
    Created on : Sep 3, 2022, 11:34:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../tablig.jsp" %>
<h1 class="text-center text-info">THONG KE BAO CAO</h1>


<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Ten san pham</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${tourQuarterStats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>
                        <fmt:formatNumber type="number" value="${c[2]}" maxFractionDigits="3" /> VND
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <c:url value="/admin/tour-quarter-stats" var="action" />
        <form action="${action}">
            <div class="mb-3 mt-3">
                <select class="form-control" name="quarter">
                    <c:forEach begin="1" end="4" var="i">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
             
              <input type="number" class="form-control" placeholder="Nhap nam" name="year">
            </div>
            <button type="submit" class="btn btn-primary">Loc du lieu</button>
        </form>
        <canvas id="myTourQuarterChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
    window.onload = function () {
        let data2 = [];
        let labels2 = [];

    <c:forEach items="${tourQuarterStats}" var="c">
        data2.push(${c[2]});
        labels2.push('$${c[1]}');
    </c:forEach>
 
        tourQuarterChart(labels2, data2);
    }
</script>