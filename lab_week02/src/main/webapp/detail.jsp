<%@ page import="repositories.EmployeeRespository" %>
<%@ page import="models.Employee" %>
<%@ page import="repositories.ProductRespository" %>
<%@ page import="models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="repositories.ProductPriceRespository" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/10/2023
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    EmployeeRespository employeeRespository = new EmployeeRespository();
    String email = request.getParameter("username");
    String password = request.getParameter("phone");
    Employee employee = employeeRespository.checkLogIn(email,password);
%>
<style>
    .menu{
    background-color: rgb(238, 237, 237);
    flex-direction: column;
    width: 100%;
    padding: 5px;
    }


    a{
    text-decoration: none;

    }

    ul{
    list-style: none;
    width: 300px;
    position: absolute;
    left: 65%;
    top: 20px
    }

    ul li{
    display: inline-block;
    font-size: 20px;
    margin-right: 10px;

    }

    a{
    color: black;
    }


</style>
<body>

<div class="menu">
    <h2>Website bán giày chất lượng cao Gia Huy</h2>
    <ul>
        <li><a href="">Home</a></li>
        <li><a href="">Cart</a></li>
        <li><a href="">Order</a></li>
        <%
            if(employee != null){
        %>
        <li><a href="login.jsp">Log Out</a></li>
        <%}else{
        %>
        <li><a href="">Log In</a></li>
       <%
        }
            %>
    </ul>
</div>
<table cellpadding="10" border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Full name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <%
        ProductRespository productRespository = new ProductRespository();
        ProductPriceRespository productPriceRespository = new ProductPriceRespository();
        List<Product> productList = productRespository.getProductList().get();
        for (Product product : productList){
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getUnit()%></td>
        <td><%=product.getManufacturer()%></td>
        <td><%=product.getStatus()%></td>
        <td><%=productPriceRespository.getPriceOfProduct(product.getId()).get()%></td>
    </tr>

    <%
        }
    %>

    </tbody>
</table>
<div>

</div>
</body>
</html>
