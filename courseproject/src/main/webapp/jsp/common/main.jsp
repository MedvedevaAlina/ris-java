<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html"  charset="UTF-8"/>
    <title><fmt:message key="page.main" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/index.js"></script>
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<img src="${pageContext.request.contextPath}/img/backgrnd1.jpg" style="position: absolute; height: 484px; width: 100%; left: 0px; top: 120px;">
<div class="advertisement">
    <p>Наша логистика</p>
    <span>Надежная опора вашего бизнеса</span>
</div>
<img src="${pageContext.request.contextPath}/img/service.jpg" style="position: absolute; width: 100%; left: 0px; top: 604px;">
<img src="${pageContext.request.contextPath}/img/b.jpg" style="
    position: absolute;
    left: 0px;
    top: 1157px;
    width:100%;
">
<div style="position: absolute; left: 15%; top: 1200px;">
    <img src="${pageContext.request.contextPath}/img/company.png" width="1100px" ></div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>
</body>
</html>
