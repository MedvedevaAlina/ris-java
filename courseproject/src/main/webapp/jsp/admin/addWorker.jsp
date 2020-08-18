<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8"/>
    <title><fmt:message key="page.workers" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>

</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="personal-data-model">
        <p>ДОБАВЛЕНИЕ РАБОТНИКА</p>
        <form name="form"  method="get" action="${pageContext.request.contextPath}/controller">
                <div>
                    <div class="flow-row-left"><p><fmt:message key="label.surname" bundle="${rb}"/></p></div>
                    <div class="flow-row-right"><input name="surname" placeholder="Фамилия" required/></div>
                </div>
                <div>
                    <div class="flow-row-left"><p><fmt:message key="label.name" bundle="${rb}"/></p></div>
                    <div class="flow-row-right"><input name= "name" placeholder="Имя" required/></div>
                </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.seniority" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="seniority" placeholder="Стаж" type="number" step="any" required/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.phone" bundle="${rb}"/></p></div><div class="flow-row-right"><input name="phone" required placeholder="(__)-___-__-__" pattern="^(\(?\d{2}\)?[\- ]?)?[\d\-]{7,9}$"/></div>

            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.address" bundle="${rb}"/></p></div><div class="flow-row-right"><input name="region" required placeholder="Адрес"/></div>

            </div>
            <button type="submit"><fmt:message key="button.save" bundle="${rb}"/></button>
            <input type="hidden" name="command" value="add_worker"/>
        </form>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>
</body>
</html>
