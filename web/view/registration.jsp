<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
    <link rel="stylesheet" href="../css/registration.css" type="text/css"/>
    <title>Registration</title>
</head>
<header class="main">
    <header></header>

    <div class="hat" style="background-image:url(../content/hat-pic.jpg)">

        <div class="t">XM
            <div class="littleT">ilieux.by
            </div>
        </div>
        <div class="topButtonsDiv">
            <form method="post" action="/view/registration.jsp">
                <button class="topButtons" name="regButton">Регистрация</button>
            </form>
            <form method="post" action="/view/authorization.jsp">
                <button class="topButtons" name="entButton">Вход</button>
            </form>
        </div>
    </div>
</header>
<body class="main">
<form action="/view/controller">
    <div class="registerForm">
        <p class="headTextReg">Регистрация нового пользователя</p>
        <p class="textReg">Введите логин</p>
        <input class="textField" type="text" name="login" placeholder="Username" required></textarea>
        <p class="textReg">Введите пароль</p>
        <input class="textField" type="password" name="pass" placeholder="Password" required>
        <p class="textReg">Повторите пароль</p>
        <input class="textField" type="password" name="passR" placeholder="Password" required>
        <p>
            <button type="submit" class="submitButton" name="command" value="register">Зарегистрироваться</button>
        </p>
    </div>
</form>
</body>
</html>