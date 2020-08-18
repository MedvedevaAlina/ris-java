<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setBundle basename="locale" var="rb"/>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8"/>
    <title><fmt:message key="page.purches" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/script/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
    <script>
        $( document ).ready(function(){

            $( "button.add-item" ).on("click",function () {
                var el = $(this).parents('.basket-items').clone();
                $('.basket').append(el);

                var itemContainer = document.getElementsByClassName("basket")[0];
                var itemsInBasket = itemContainer.getElementsByClassName('basket-items');
                var totalP=0;
                var totalQ=0;
                console.log(itemsInBasket);
                console.log(totalP);
                console.log(totalQ);
                for(var i=0; i<itemsInBasket.length; i++){
                    var item = itemsInBasket[i];
                    var priceItem = item.getElementsByClassName('price-item')[0];
                    console.log(priceItem);
                    var quantityItem = item.getElementsByClassName('item-quantity')[0];
                    console.log(quantityItem);
                    var price = parseFloat(priceItem.innerText.replace(' р за 1 шт.',''));
                    console.log(price);
                    var quantity = parseInt(quantityItem.value);
                    console.log(quantity);
                    totalP = totalP + price*quantity;
                    totalQ = totalQ + quantity;
                }
                totalP = Math.round(totalP*100)/100;
                document.getElementsByClassName('info-order')[0].innerText = totalQ + ' товаров на сумму '+ totalP.valueOf()+" р";
            })
        });
    </script>
    <%--<script src="${pageContext.request.contextPath}/script/index.js"></script>--%>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/header.jsp"></jsp:include>
<div class="center">
    <div class="wrapper">
        <article>
            <div class="container">
            <table class="table-product">
                <c:forEach begin="0" end="${fn:length(products)}" step="4" varStatus="loop">
                    <c:if test="${products[loop.index].category eq category}">
                        <tr>
                            <td>
                                <img style="width: 150px;" src="${pageContext.request.contextPath}/img/customer/${products[loop.index].img}"/>
                                <div class="basket-items">
                                    <p>${products[loop.index].name} ${products[loop.index].description}</p>
                                    <input class="item-quantity" type="number" value="0" size="70" max="100" min="0"/>
                                    <span>шт.</span><button class="add-item">+</button>
                                    <div class="price-item">${products[loop.index].price} р за 1 шт.</div>
                                </div>
                            </td>
                            <td>
                                <img src="${pageContext.request.contextPath}/img/customer/${products[loop.index+1].img}"/>
                                <div class="basket-items">
                                    <p>${products[loop.index+1].name} ${products[loop.index+1].description}</p>
                                    <input class="item-quantity" type="number" value="0" size="70" max="100" min="0"/>
                                    <span>шт.</span> <button class="add-item">+</button>
                                    <div class="price-item">${products[loop.index+1].price} р за 1 шт.</div>
                                </div>
                            </td>
                            <td>
                                <img src="${pageContext.request.contextPath}/img/customer/${products[loop.index+2].img}"/>
                                <div class="basket-items">
                                    <p>${products[loop.index+2].name} ${products[loop.index+2].description}</p>
                                    <input class="item-quantity" type="number" value="0" size="70" max="100" min="0"/>
                                    <span>шт.</span> <button class="add-item">+</button>
                                    <div class="price-item">${products[loop.index+2].price} р за 1 шт.</div>
                                </div>
                            </td>
                            <td>
                                <img src="${pageContext.request.contextPath}/img/customer/${products[loop.index+3].img}"/>
                                <div class="basket-items">
                                    <p>${products[loop.index +3].name} ${products[loop.index +3].description}</p>
                                    <input class="item-quantity" type="number" value="0" size="70" max="100" min="0"/>
                                    <span>шт.</span> <button class="add-item">+</button>
                                    <div class="price-item">${products[loop.index+3].price} р за 1 шт.</div>
                                </div>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </table>
            </div>
        </article>
        <nav style="justify-content: center">
            <ul>
                <li><a href="${pageContext.request.contextPath}/controller?command=show_items&category=water">Вода</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=show_items&category=drink">Напитки</a></li>
                <li><a href="${pageContext.request.contextPath}/controller?command=show_items&category=juice">Соки</a></li>
            </ul>
        </nav>
        <aside>
            <h2>Ваша корзина</h2>
            <div class="basket">
                <div class="basket-caption">
                    <div class="info-order">42 товаров на сумму 71.88 р</div>
                </div>
                <div class="basket-items">
                    <p>Вода "БонАква"  1л негазированная</p>
                    <input class="item-quantity" type="number" value="10" size="70" max="100" min="0"/>
                    <span>шт.</span> <button class="add-item">+</button>
                    <div class="price-item">1.19 р за 1 шт.</div>
                </div>
                <div class="basket-items">
                    <p>Вода "БонАква" малина 1л газированная</p>
                    <input class="item-quantity" type="number" value="7" size="70" max="100" min="0"/>
                    <span>шт.</span> <button class="add-item">+</button>
                    <div class="price-item">1.29 р за 1 шт.</div>
                </div>


                <div class="basket-items">
                    <p>Напиток "Швепс" 1л газированный</p>
                    <input class="item-quantity" type="number" value="20" size="70" max="100" min="0"/>
                    <span>шт.</span> <button class="add-item">+</button>
                    <div class="price-item">1.85 р за 1 шт.</div>
                </div>
                <div class="basket-items">
                    <p>Напиток "Фанта" апельсин 2л газированный</p>
                    <input class="item-quantity" type="number" value="5" size="70" max="100" min="0"/>
                    <span>шт.</span> <button class="add-item">+</button>
                    <div class="price-item">2.79 р за 1 шт.</div>
                </div>
            </div>
            <br/>
            <a href="${pageContext.request.contextPath}/controller?command=submit_order"><button>Оплатить</button></a>
        </aside>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/jsp/fragments/footer.jsp"></jsp:include>

</body>
</html>
