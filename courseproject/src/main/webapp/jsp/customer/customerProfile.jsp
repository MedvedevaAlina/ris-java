<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8"/>
    <title><fmt:message key="page.profile" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="personal-data-model" var="customer" items="${sessionScope.customer}">
        <table style="border-style: hidden;">
            <tr>
                <td style="border-style: hidden;">
                    <img src="${pageContext.request.contextPath}/img/avatar.jpg" alt="Аватар" style="width: 240px">
                </td>
                <td>
                        <table>
                            <caption><fmt:message key="label.account" bundle="${rb}"/></caption>
                            <tr style="height: 30px;">
                                <th width="30%"><fmt:message key="label.organization" bundle="${rb}"/></th>
                                <th width="300px">${customer.name}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.FIO" bundle="${rb}"/></th>
                                <th>${customer.representative}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.email" bundle="${rb}"/></th>
                                <th>${customer.email}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.address" bundle="${rb}"/></th>
                                <th>${customer.regionCustomer}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.login" bundle="${rb}"/></th>
                                <th>${customer.getUser().login}</th>
                            </tr>
                            <tr>
                                <th colspan="2">
                                    ${errorEditCustomer}
                                </th>
                            </tr>
                            <tr style="font-style: italic; height: 50px">
                                <th colspan="2">
                                <a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/customer/editProfile.jsp"><fmt:message key="label.editAccountInfo" bundle="${rb}"/></a>
                                </th>
                            </tr>
                        </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>
