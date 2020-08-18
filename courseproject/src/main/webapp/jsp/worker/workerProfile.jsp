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
    <div class="personal-data-model" var="worker" items="${sessionScope.worker}">
        <table style="border-style: hidden;">
            <tr>
                <td style="border-style: hidden;">
                    <img src="${pageContext.request.contextPath}/img/avatar.jpg" alt="Аватар" style="width: 240px">
                </td>
                <td>
                        <table>
                            <caption><fmt:message key="label.account" bundle="${rb}"/></caption>
                            <tr style="height: 30px;">
                                <th width="30%"><fmt:message key="label.surname" bundle="${rb}"/></th>
                                <th width="300px">${worker.surname}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.name" bundle="${rb}"/></th>
                                <th>${worker.name}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.seniority" bundle="${rb}"/></th>
                                <th>${worker.seniority}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.phone" bundle="${rb}"/></th>
                                <th>${worker.phone}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.address" bundle="${rb}"/></th>
                                <th>${worker.regionWorker}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.login" bundle="${rb}"/></th>
                                <th>${worker.getUser().login}</th>
                            </tr>
                            <tr>
                                <th colspan="2">
                                    ${errorEditWorker}
                                </th>
                            </tr>
                            <tr style="font-style: italic; height: 50px">
                                <th colspan="2">
                                <a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/worker/editProfile.jsp"><fmt:message key="label.editAccountInfo" bundle="${rb}"/></a>
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
