<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8"/>
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
        <p>РЕДАКТИРОВАНИЕ ЗАКАЗЧИКА</p>
        <form name="form"  method="get" action="${pageContext.request.contextPath}/controller">
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.customer.name" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="customer_name" value='${customer.name}'/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.representative" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name= "representative" value="${customer.representative}" required/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.email" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="email" required value="${customer.email}" pattern="(\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6})"/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.address" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="region" required value="${customer.regionCustomer}"/></div>

            </div>
            <div class="flow-row-left"><p><fmt:message key="label.status" bundle="${rb}"/></p></div>
            <div class="flow-row-right">
            <c:if test="${customer.getUser().status =='active'}">
                <select name="status" required size="1" style="margin-top: 5px;">
                    <option selected value="active">Работает</option>
                    <option  value="reserved">Резерв</option>
                </select>
            </c:if>
            <c:if test="${customer.getUser().status =='reserved'}">
                <select name="status" required size="1" style="margin-top: 5px;">
                    <option value="active">Работает</option>
                    <option selected  value="reserved">Резерв</option>
                </select>
            </c:if></div>
            <input type="hidden" name="command" value="edit_customer"/>
            <input type="hidden" name="idcustomer" value="${customer.idCustomer}"/>
            <c:set var="user_customer" value="${customer.getUser()}" scope="session"/>
            </br>
            <button type="submit"><fmt:message key="button.save" bundle="${rb}"/></button>
        </form>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>