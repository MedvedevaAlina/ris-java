<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8"/>
    <title><fmt:message key="page.workers" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>

</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>

<div class="center">
    <div class="personal-data-model">
        <p><fmt:message key="label.workers" bundle="${rb}"/></p>

        <form class="searchWorker" action="${pageContext.request.contextPath}/controller" method="GET"
              name="form">
            <input maxlength="25" size="80" name= "searchSurname" placeholder="Поиск"
                   required style="font-size: 16px;"/>

            <input type="hidden" name="command" value="search_worker"/>
            <button type="submit"><fmt:message key="button.search" bundle="${rb}"/></button>
            <p>${errorSearch}</p>
        </form>

        <br/>
        <table class="data-for-admin-table">
            <thead style="background-color: #867f7f">
            <tr>
                <td><fmt:message key="label.surname" bundle="${rb}"/></td>
                <td><fmt:message key="label.name" bundle="${rb}"/></td>
                <td><fmt:message key="label.seniority" bundle="${rb}"/></td>
                <td><fmt:message key="label.phone" bundle="${rb}"/></td>
                <td><fmt:message key="label.address" bundle="${rb}"/></td>
                <td align="center"><fmt:message key="label.status" bundle="${rb}"/>
                </td>
                <td align="center"><fmt:message key="label.update" bundle="${rb}"/></td>
                <td align="center"><fmt:message key="label.fire" bundle="${rb}"/></td>
            </tr>
            </thead>
            <c:choose>
                <c:when test="${not empty workers}">
                    <tbody>
                    <c:forEach var="worker" items="${workers}">
                        <c:if test="${worker.getUser().status != 'blocked'}">
                            <tr>
                                <td>${worker.surname}</td>
                                <td>${worker.name}</td>
                                <td>${worker.seniority}</td>
                                <td>${worker.phone}</td>
                                <td>${worker.regionWorker}</td>
                                <td>${worker.getUser().status}</td>
                                <td align="center"><a href="${pageContext.request.contextPath}/controller?command=find_worker&id=${worker.idWorker}">
                                    <img src="${pageContext.request.contextPath}/img/edit.png" width="25px"></a></td>
                                <td  id="remove-td" align="center"><a href="${pageContext.request.contextPath}/controller?command=delete_user&id=${worker.getUser().idUser}&page=/jsp/admin/workers.jsp">
                                    <img src="${pageContext.request.contextPath}/img/delet.png" width="20px">
                                </a></td>
                            </tr>
                        </c:if>
                        </tbody>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p class="null-list">${emptyData}</p>
                </c:otherwise>
            </c:choose>
        </table>
        <img src="${pageContext.request.contextPath}/img/add.png" alt="Добавить" width="15px"/>
        <span style="font-style: italic; color: #4B2121"><a href="${pageContext.request.contextPath}/controller?command=load_page&page=/jsp/admin/addWorker.jsp">
            <fmt:message key="button.addNew" bundle="${rb}"/></a></span>
        ${resultChangeWorkers}
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>
</body>
</html>
