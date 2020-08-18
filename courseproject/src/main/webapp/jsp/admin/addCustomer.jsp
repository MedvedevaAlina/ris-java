<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8"/>
    <title><fmt:message key="page.customers" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>

</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="personal-data-model">
        <p>ДОБАВЛЕНИЕ ЗАКАЗЧИКА</p>
        <form name="form"  method="get" action="${pageContext.request.contextPath}/controller">
                <div>
                    <div class="flow-row-left"><p><fmt:message key="label.customer.name" bundle="${rb}"/></p></div>
                    <div class="flow-row-right"><input name="customer_name" placeholder="Название"/></div>
                </div>
                <div>
                    <div class="flow-row-left"><p><fmt:message key="label.representative" bundle="${rb}"/></p></div>
                    <div class="flow-row-right"><input name= "representative" placeholder="ФИО представителя" required/></div>
                </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.email" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="email" placeholder="Почта" type="email" required/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.address" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="region" required placeholder="Адрес"/></div>

            </div>
            <button type="submit"><fmt:message key="button.save" bundle="${rb}"/></button>
            <input type="hidden" name="command" value="add_customer"/>
        </form>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>
</body>
</html>
