<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setBundle basename="locale" var="rb"/>

<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8"/>
    <title><fmt:message key="page.orders" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>

</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="personal-data-model">

            <c:choose>
                <c:when test="${not empty orderList}">
                    <c:forEach var="item" items="${orderList}">
                        <c:if test="${item.processing == 'posted'}">
                        <div>
                            <form action="${pageContext.request.contextPath}/controller" method="GET" name="form" on/>
                                <input type="hidden" name="command" value="check_order">
                                <input type="hidden" name="idCheckedOrder" value="${item.idOrder}"/>
                                <p style="margin: 10px;" class="links">Заказ №7036${item.idOrder} (${item.cost} руб, <span class="convertDate">${item.deliveryDate}</span>)</p>
                                <div class="update-body" >
                                    <p>
                                        <span>Дата заказа:  </span><span class="convertDate">${item.orderDate}</span>
                                    </p>
                                    <p>
                                        <span>Общая сумма:  </span><span>${item.cost}</span>
                                    </p>
                                    <p>
                                        <span>Заказчик:  </span>
                                        <c:choose>
                                            <c:when test="${not empty item.getCustomer().name}">
                                                <span>${item.getCustomer().name}</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span>${item.getCustomer().representative}</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </p>
                                    <p>
                                        <span>Единиц товаров: </span> <span>${fn:length(item.getOrderProducts())} шт</span>
                                    </p>
                                    <br>
                                    <button type="submit">Проверить</button>
                                    <c:if test="${idCheckedOrder == item.idOrder}">
                                        <c:if test="${not empty unCheckedOrder}">
                                            <span id="checked-label" style="color: red; font-weight: bold; font-size: 16px; margin-left: 10px">${unCheckedOrder}</span>
                                        </c:if>
                                        <c:if test="${not empty checkedOrder}">
                                            <span id="checked-label" style="color: green; font-weight: bold; font-size: 16px; margin-left: 10px">${checkedOrder}</span>
                                        </c:if>
                                    </c:if>
                                </div>
                            </form>
                        </div>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p class="null-list">${emptyData}</p>
                </c:otherwise>
            </c:choose>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>
</body>
</html>
