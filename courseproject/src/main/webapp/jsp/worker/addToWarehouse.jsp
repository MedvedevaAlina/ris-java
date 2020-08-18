
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8"/>
    <title><fmt:message key="page.addToWarehouse" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <script>
        $( document ).ready(function(){
            $( "button.to-warehouse" ).on("click",function () {
                $(".success").css("display","block");
            })

        })
        // }
        // $(function() {
        //     $('.to-warehouse').click(function( e ) {
        //
        //         // или так
        //         $("#success").css("display","block");
        //         // или так
        //         $("#success").show();
        //     });
        // });
    </script>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="wrapper">
        <article>
            <div class="container" style="display: flex; justify-content: center; align-content: center">
                <div>
                    <table style="background-color: white; overflow: scroll; height: 400px;">
                        <tr style="background-color: #b5b5b9">
                            <td>Наименование</td>
                            <td>Количество</td>
                        </tr>
                    <c:forEach var="item" items="${products}">
                        <c:if test="${item.category eq category}">
                            <tr>
                                <td>${item.name} ${item.description}</td>
                                <td> <input type="number" value="1" size="70" max="100" min="1"/>
                                    <span>шт.</span></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </table>
                    <br/>
                </div>

                <div style="margin-left: 10%">
                    <button class="to-warehouse">Отправить на склад</button>
                    <p class="success" style="display: none;
    font-family: Roboto;
    font-size: 15px;
    font-weight: bold;
    color: green;">Товар успешно отправлен на базу!</p>
                </div>
            </div>
        </article>

        <nav style="justify-content: center">
            <ul>
                <li><a href="${pageContext.request.contextPath}/controller?command=show_items_to_warehouse&category=water">Вода</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=show_items_to_warehouse&category=drink">Напитки</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=show_items_to_warehouse&category=juice">Соки</a></li>
            </ul>
        </nav>

    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>
