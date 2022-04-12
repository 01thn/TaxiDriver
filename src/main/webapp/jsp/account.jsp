<%@ page import="java.util.List" %>
<%@ page import="com.thn.driver.model.Order" %>
<%@ page import="com.thn.driver.service.OrderService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Driver's account</title>
</head>
<body>
<c:if test="${not empty message}">
    ${message}
</c:if>
<button onClick="window.location.reload();">Refresh Page</button>
<table border="1">
    <%
        List<Order> orders = OrderService.getOrders();
        for (Order order : orders) {
            out.print(
                    "<tr>"
                            + "<td>" + order.getPlaceFrom() + "</td>"
                            + "<td>" + order.getPlaceTo() + "</td>"
                            + "<td>" + order.getClientName() + "</td>"
                            + "<td><form method=\"post\" action=\"get-order\">\n" +
                            "        <input type=\"hidden\" name=\"id\" value="+order.getId()+">\n" +
                            "        <input type=\"submit\" value=\"Get order\"/>\n" +
                            "    </form></td>"
                            + "</tr>"
            );
        }
    %>
</table>

</body>
</html>
