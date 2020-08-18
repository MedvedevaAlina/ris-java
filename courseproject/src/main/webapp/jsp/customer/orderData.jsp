<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setBundle basename="locale" var="rb"/>

<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8"/>
    <title><fmt:message key="page.data" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="personal-data-model">
        <p>Добавление адреса доставки и реквизитов получателя</p>
        <form>
            <p><div class="flow-row-left"><span>Фамилия</span></div> <div class="flow-row-right"><input value="${surname}"/></div></p>
            <p><div class="flow-row-left"><span>Имя</span></div><div class="flow-row-right"> <input value="${name}" /></div></p>
            <p><div class="flow-row-left"><span>Отчество</span></div><div class="flow-row-right"> <input value="${last_name}" /></div></p>
            <p><div class="flow-row-left"><span>Почта</span></div><div class="flow-row-right"><input type="email" value="${email}"/></div></p>
            <p><div class="flow-row-left"><span>Город</span></div><div class="flow-row-right"><input value="Минск" /></div></p>
            <p><div class="flow-row-left"><span>Улица</span></div><div class="flow-row-right"><input value="Л. Беды" /></div></p>
            <p><div class="flow-row-left"><span>Дом</span></div><div class="flow-row-right"><input type="number" value="17" placeholder="17" /></div></p>
            <p><div class="flow-row-left"><span>Дата реализации</span></div><div class="flow-row-right"><input type="date" /></div></p>
            <p><div class="flow-row-left"><span>Склад</span></div>
            <div class="flow-row-right">
                <select>
                    <option selected disabled>Выберите склад</option>
                    <option value="Минск">г.Минск</option>
                    <option value="Гродно">г.Гродно</option>
                    <option value="Гомель">г.Новополоцк</option>
                </select>
            </div></p>
        </form>
        <button class="submit-order">Сохранить</button>
    </div>
</div>



<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>
