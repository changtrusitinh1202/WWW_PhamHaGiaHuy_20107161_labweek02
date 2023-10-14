<%@ page import="repositories.EmployeeRespository" %>
<%@ page import="models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/09/2023
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
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

    .dangNhap{
        text-align: center;
    }
</style>
<body>

<div class="menu">
    <h2>Website bán giày chất lượng cao Gia Huy</h2>
        <ul>
            <li><a href="">Home</a></li>
            <li><a href="">Cart</a></li>
            <li><a href="">Order</a></li>
            <li><a href="">Log In</a></li>
        </ul>
</div>
<div class="dangNhap">
    <h1 class="center">Đăng nhập</h1>
    <form method="post" action="Controll"  class="register-form">
        <label>Tên đăng nhập</label>
        <input type="text" name="username"> <br>
        <label style="margin-right: 35px;">Mật khẩu</label>
        <input type="password" name="phone"> <br>
        <button type="submit" style="margin-top: 20px; margin-left: 30px;">Đăng nhập</button>

</div>
</body>
<script src="">
    const username = document.getElementsByName("username")[0].value;
    const password = document.getElementsByName("password")[0].value;
    localStorage.setItem("username", username);
    localStorage.setItem("password",password);
    window.location.href = "result.jsp";
</script>
</html>
