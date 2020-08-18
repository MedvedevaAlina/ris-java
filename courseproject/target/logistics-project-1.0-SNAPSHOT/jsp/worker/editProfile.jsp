<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8"/>
    <title><fmt:message key="page.profile" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="personal-data-model">
        <p>Редактировать профиль</p>
        <form name="form"  method="get" action="${pageContext.request.contextPath}/controller">
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.surname" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="surname" value="${worker.surname}" pattern="^[A-ZА-Я][a-zа-я]+$" required/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.name" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name= "name" value="${worker.name}" pattern="^[A-ZА-Я][a-zа-я]+$" required/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.seniority" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="seniority" value="${worker.seniority}" type="number" step="any" disabled/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.phone" bundle="${rb}"/></p></div><div class="flow-row-right"><input name="phone" required value="${worker.phone}" pattern="^(\(?\d{2}\)?[\- ]?)?[\d\-]{7,9}$"/></div>

            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.address" bundle="${rb}"/></p></div><div class="flow-row-right"><input name="region" required value="${worker.regionWorker}"/></div>

            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.login" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="login" required value="${worker.getUser().login}"/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.password" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input disabled type="password" value="${worker.getUser().password}"/></div>
                <input name="lastPassword"  type ="hidden" value="${worker.getUser().password}"/>
            </div>

            <div>
                <div class="flow-row-left"><p><fmt:message key="label.Newpassword" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="newPassword" type="password"/></div>
            </div>
            <div>
                <div class="flow-row-left"><p><fmt:message key="label.confirmpassword" bundle="${rb}"/></p></div>
                <div class="flow-row-right"><input name="repeatNewPassword" type="password"/></div>
            </div>
            <input type="hidden" name="command" value="edit_profile_worker"/>
            <input type="hidden" name="idworker" value="${worker.idWorker}"/>
            <c:set var="user_worker" value="${worker.getUser()}" scope="session"/>
            </br>
            <button type="submit"><fmt:message key="button.save" bundle="${rb}"/></button>
        </form>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>