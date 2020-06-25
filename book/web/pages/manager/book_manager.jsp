<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%--    静态包含--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 删除提示
            $("a.deleteClass").click(function () {
                return confirm("确定删除" + $(this).parent().parent().find("td:first").text() + "？");
            });
        })
    </script>
    <style>
        #page_nav{
            height: 40px;
            width: 100%;
            position: absolute;
            bottom: 40px;
        }
        #main{
            position: relative;
        }
    </style>
</head>

<body>

<%@include file="/pages/common/manager_menu.jsp" %>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>
    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo>1}">
            <a href="manager/bookServlet?action=page&pageNo=1">首页</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">
                    ${requestScope.page.pageNo-1}</a>
        </c:if>



        【${requestScope.page.pageNo}】



        <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">
                    ${requestScope.page.pageNo+1}</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>
        共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn"
                                                                                         id="pn_input"/>页
        <input id="searchPageBtn" type="button" value="确定">
        <script type="text/javascript">
            $(function () {
                $("#searchPageBtn").click(function () {
                    let pageNo = $("#pn_input").val();
                    // 判断页码越界
                    if (pageNo>=1&&pageNo<=${requestScope.page.pageTotal}){
                        location.href="${pageScope.basePath}manager/bookServlet?action=page&pageNo="+pageNo;
                    }else {
                        alert("越界！");
                    }

                })
            })
        </script>
    </div>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>