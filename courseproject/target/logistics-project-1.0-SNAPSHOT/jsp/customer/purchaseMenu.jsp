<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html"  charset="UTF-8"/>
    <title><fmt:message key="page.purches" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div style="width: 70%; margin-left: 15%;margin-top: 15px;">
        <div class="flex-model">
            <a href="${pageContext.request.contextPath}/controller?command=show_items&category=water">
            <div><img src="${pageContext.request.contextPath}/img/customer/menu/water.jpg" width="320" height="450"><p>Вода</p></div>
            </a>
            <a href="${pageContext.request.contextPath}/controller?command=show_items&category=drink">
                <div><img src="${pageContext.request.contextPath}/img/customer/menu/drink.jpg" width="320" height="450"><p>Напитки</p></div>
            </a>
            <a href="${pageContext.request.contextPath}/controller?command=show_items&category=juice">
                <div><img src="${pageContext.request.contextPath}/img/customer/menu/juice.jpg" width="320" height="450"><p>Соки</p></div>
            </a>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>
