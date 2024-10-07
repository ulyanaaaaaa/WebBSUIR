<%@ page import="java.util.List" %>
<%@ page import="entities.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: vadio
  Date: 04.10.2023
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        TABLE {
            width: 800px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Название</th>
        <th>Тип</th>
        <th>Количество</th>
        <th>Цена</th>
    </tr>

        <c:forEach var="product" items="${productList}">
            <tr>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.type}" /></td>
                <td><c:out value="${product.count}" /></td>
                <td><c:out value="${product.price}" /></td>
            </tr>

        </c:forEach>
    <tr>
        <td>&nbsp</td>
        <td>&nbsp</td>

        <td><c:out value="${Product.totalCount(productList)}" /></td>
        <td><c:out value="${Product.totalPrice(productList)}" /></td>
    </tr>
    <%--
 <%
    List<Product> productList = (List<Product>) request.getAttribute("productList");

    if (productList != null && !productList.isEmpty()) {

        for (Product p: productList) {
            out.println("<tr>");
            out.println( "<td>" +p.getName() +"</td>" + "<td>" +p.getType()+"</td>" + "<td>" +p.getCount() +"</td>"+"<td>" +p.getPrice()+"</td>");
            out.println("</tr>");
        }
        out.println("<tr>");
        out.println("<td> &nbsp;</td>");
        out.println("<td> &nbsp;</td>");
        out.println("<td>" +Product.totalCount(productList) +"</td>");
        out.println("<td>"+ Product.totalPrice(productList)+"</td>");
        out.println("</tr>");
    } else out.println("<p>No product</p>");

%>
--%>
</table>
</body>
</html>
