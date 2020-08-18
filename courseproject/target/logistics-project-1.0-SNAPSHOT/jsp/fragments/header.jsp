<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>
</head>
<body>
<header>
    <div class="top">
        <img src="${pageContext.request.contextPath}/img/ic_account_link.png" class="account-picture"/>

        <c:if test="${empty sessionScope.user}">
            <div class="account-model text-top" id="personal-account"><fmt:message key="label.personal.account"
                                                                                   bundle="${rb}"/></div>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
        <a href="${pageContext.request.contextPath}/controller?command=logout"><div class="account-model text-top">
                <fmt:message key="label.exit"  bundle="${rb}"/></div></a>

        </c:if>
        <div class="authentication_modal" id="authentication_modal">
            <form action="${pageContext.request.contextPath}/controller" method="POST" name="form"
                  onsubmit="return validationSingUp();">
                <input type="hidden" name="command" value="login">
                <div class="line">
                    <div class="name"><fmt:message key="label.login"
                                                   bundle="${rb}"/></div>
                    <input class="input" type="text" name="login">
                </div>
                <div class="line">
                    <div class="name"><fmt:message key="label.password" bundle="${rb}"/></div>
                    <input class="input" type="password" name="password">
                </div>

                <div class="submit left">
                    <button class="submit_btn" type="submit" style="margin-bottom: 1px"><fmt:message key="button.submit" bundle="${rb}"/></button>
                </div>
            </form>
            ${errorAuthorisation}
        </div>
    </div>
</header>

<div class="menu">

    <c:if test="${sessionScope.role == 'admin'}">
        <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/admin/adminProfile.jsp"><fmt:message
                key="page.profile" bundle="${rb}"/></a></span>
        <span><a href="${pageContext.request.contextPath}/controller?command=show_workers"><fmt:message
                key="page.workers" bundle="${rb}"/></a></span>
        <span>
            <a href="${pageContext.request.contextPath}/controller?command=show_customers">
                <fmt:message key="page.customers" bundle="${rb}"/>
            </a>
        </span>
        <span><a href="${pageContext.request.contextPath}/controller?command=show_orders"><fmt:message
                key="page.orders" bundle="${rb}"/></a></span>
    </c:if>

    <c:if test="${sessionScope.role == 'customer'}">
        <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/customer/customerProfile.jsp"><fmt:message
                key="page.profile" bundle="${rb}"/></a></span>
        <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/customer/purchaseMenu.jsp"><fmt:message
                key="page.purches" bundle="${rb}"/></a></span>
        <span>
            <a href="${pageContext.request.contextPath}/controller?command=show_history">
                <fmt:message key="page.history" bundle="${rb}"/>
            </a>
        </span>
    </c:if>

    <c:if test="${sessionScope.role == 'worker'}">
        <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/worker/workerProfile.jsp"><fmt:message
                key="page.profile" bundle="${rb}"/></a></span>
        <span><a href="${pageContext.request.contextPath}/controller?command=show_items_to_warehouse&category=water"><fmt:message
                key="page.addToWarehouse" bundle="${rb}"/></a></span>
        <span>
            <a href="${pageContext.request.contextPath}/controller?command=show_processed_orders">
                <fmt:message key="page.AdoptedOrder" bundle="${rb}"/>
            </a>
        </span>
    </c:if>



<!--Создать ссылки!!!! -->
    <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/common/main.jsp"><fmt:message key="page.main"
                                                                                                                           bundle="${rb}"/></a></span>
    <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/common/main.jsp"><fmt:message key="page.services"
                                                                                                                           bundle="${rb}"/></a></span>
    <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/common/main.jsp"><fmt:message key="page.contacts"
                                                                                                                           bundle="${rb}"/></a></span>

    <span><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/common/main.jsp"><fmt:message key="page.about.company"
                                                                                                                           bundle="${rb}"/></a></span>

</div>
</body>
</html>
