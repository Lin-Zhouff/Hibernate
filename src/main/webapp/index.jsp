<%--
  Created by IntelliJ IDEA.
  User: linfeng2
  Date: 2020/11/15
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping</title>
</head>
<body>
<h1>Adding products to the database</h1>
<c:url value="/product/register" var="registerUrl" />
<form action="${registerUrl}" method="post">
    <table>
        <c:if test="${'${'}product.id ne null}">
            <tr>
                <td>Product ID:</td>
                <td><input type="text" name="id" value="${'${'}product.id}" readonly="readonly"></td>
            </tr>
        </c:if>
        <tr>
            <td>Product Name:</td>
            <td><input type="text" name="name" value="${'${'}product.name}" required></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price" value="${'${'}product.price}" required></td>
        </tr>

        <c:if test="${'${'}product.id eq null}">
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </c:if>
    </table>
</form>
<br>
<h1>List of Products</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Add to cart</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${productsList}" >
        <tr>
            <td><c:out value="${product.id}" /></td>
            <td><c:out value="${product.name}" /></td>
            <td><c:out value="${product.price}" /></td>

            <td>
                <form action="/product/update" method="post">
                    <input type="hidden" name="custId" value="${product.id}">
                    <input type="submit" value="Add to Cart">
                </form>
            <td>
                <form action="/product/delete" method="post">
                    <input type="hidden" name="custId" value="${product.id}">
                    <input style="background: #ff0000;" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
