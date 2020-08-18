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
    <div class="personal-data-model" var="user" items="${sessionScope.user}">
        <table style="border-style: hidden;">
            <tr>
                <td style="border-style: hidden;">
                    <img src="${pageContext.request.contextPath}/img/avatar.jpg" alt="Аватар" style="width: 240px">
                </td>
                <td>
                    <form class="changePasswordForm" action="${pageContext.request.contextPath}/controller" method="POST"
                          name="form"
                          onsubmit="return validationChangePass();">
                        <table>
                            <caption><fmt:message key="label.account" bundle="${rb}"/></caption>
                            <tr style="height: 30px;">
                                <th width="30%"><fmt:message key="label.FIO" bundle="${rb}"/></th>
                                <th width="300px">Медведева Алина Юрьевна</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.login" bundle="${rb}"/></th>
                                <th>${user.login}</th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.password" bundle="${rb}"/></th>
                                <th><input name="lastPassword" type="password" disabled value="${user.password}"/></th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.Newpassword" bundle="${rb}"/></th>
                                <th><input name="newPassword" type="password"/></th>
                            </tr>
                            <tr style="height: 30px;">
                                <th><fmt:message key="label.confirmpassword" bundle="${rb}"/></th>
                                <th><input name="repeatNewPassword" type="password"/></th>
                            </tr>
                            <tr>
                                <th colspan="2">
                                    ${errorChangePass}
                                </th>
                            </tr>
                            <tr style="font-style: italic; height: 50px">
                                <th>
                                <input type="hidden" name="command" value="change_password"/>
                                <button type="submit"><fmt:message key="button.edit" bundle="${rb}"/></button>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>
</body>
</html>
