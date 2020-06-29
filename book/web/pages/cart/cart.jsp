<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--    静态包含--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $(".deleteItem").click(function () {
                return confirm("确定删除" + $(this).parent().parent().find("td:first").text() + "吗？");
            });
            $(".clearItem").click(function () {
                return confirm("确定清空购物车吗？");
            });
            // 失去焦点
			$(".updateCount").change(function () {
				//获取商品名称
				var name = $(this).parent().parent().find("td:first").text();
				//获取自定义的bookId属性的值。
				var bookId= $(this).attr("bookId");
				//获取商品数量
				var count = this.value;
				if(confirm("你确定要将【" + name + "】商品修改数量为："+count+"吗？")) {
					//发起请求，给服务器保存修改
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&id="+bookId;
				}else{
					//defaultValue属性是表单项dom对象的属性，它表示默认的value属性值
					this.value = this.defaultValue;
				}
			});
        })
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="">
    <span class="wel_word">购物车</span>
    <%--    静态包含--%>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="items">
            <tr>
                <td>${items.value.name}</td>
                <td>
                    <input class="updateCount" style="width: 80px;" type="text" bookId="${items.value.id}" value="${items.value.count}">
                </td>
                <td>${items.value.price}</td>
                <td>${items.value.totalPrice}</td>
                <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${items.value.id}">删除</a></td>
            </tr>
        </c:forEach>


    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clearItem" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
        </div>
    </c:if>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>