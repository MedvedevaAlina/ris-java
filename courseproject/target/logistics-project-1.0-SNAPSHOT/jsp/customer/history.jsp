<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8"/>
    <title><fmt:message key="page.history" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="wrapper">
        <article>
            <div class="container">
                <div style="margin-left: 10%; text-align: left; margin-bottom: 15px;">
                    <form action="${pageContext.request.contextPath}/controller" method="GET"
                          name="form">
                        <span>Статус   </span>
                        <select name="status">
                            <option selected disabled>Выберите статус</option>
                            <option value="processed">Обрабатывается</option>
                            <option value="rejected">Отклонен</option>
                            <option value="adopted">Реализован</option>
                        </select> <span> C   </span><input type="date" name="search-order-from"/><span>  по  </span><input type="date" name="search-order-since"/>
                        <input type="hidden" name="command" value="search_order"/>
                        <button type="submit">Показать</button>
                        <p>${errorSearch}</p>
                    </form>
                </div>


                <table class="table-order">
                    <thead>
                    <tr>
                        <th>Дата заказа</th>
                        <th>Сумма</th>
                        <th>Статус</th>
                        <th></th>
                    </tr>
                    </thead>
                    <c:choose>
                        <c:when test="${not empty orders}">
                            <tbody>
                            <c:forEach var="item" items="${orders}">
                                <tr>
                                    <td class="convertDate-td">${item.orderDate}</td>
                                    <td>${item.cost}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${item.processing == 'rejected'}">
                                                Отклонен
                                            </c:when>
                                            <c:when test="${item.processing == 'adopted'}">
                                                Реализован
                                            </c:when>
                                            <c:otherwise>
                                                Обрабатывается
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <button class="popup-open">Список покупок</button>
                                        <div class="popup-fade">
                                            <div class="popup">
                                                <a class="popup-close" href="#">Закрыть</a>
                                                <p>Список покупок</p>
                                                    <table style="background-color: white;">
                                                        <tr style="background-color: #b5b5b9">
                                                            <td>Наименование</td>
                                                            <td>Количество</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Вода "БонАква"  1л негазированная</td>
                                                            <td>10<span> шт.</span></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Вода "БонАква" малина 1л газированная</td>
                                                            <td>7<span> шт.</span></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Напиток "Швепс" 1л газированный</td>
                                                            <td>20<span> шт.</span></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Напиток "Фанта" апельсин 2л газированный</td>
                                                            <td>5<span> шт.</span></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Морс "Добрый" ягодный 1л негазированный</td>
                                                            <td>15<span> шт.</span></td>
                                                        </tr>
                                                    </table>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </c:when>
                        <c:otherwise>
                            <p class="null-list">${emptyData}</p>
                        </c:otherwise>
                    </c:choose>
                </table>
            </div>
        </article>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>
