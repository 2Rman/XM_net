
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
    <link rel="stylesheet" href="../css/userpage.css" type="text/css"/>
    <link rel="stylesheet" href="../css/userData.css" type="text/css"/>
    <title>Main</title>
</head>
<header class="main">

    <div class="hat" style="background-image:url(../content/hat-pic.jpg)">

        <div class="t">XM
            <div class="littleT">ilieux.by
            </div>
        </div>
        <div class="topButtonsDiv">
            <form method="post" action="/view/registration.jsp">
                <button class="topButtons" name="regButton">Регистрация</button>
            </form>
            <form method="post" action="/view/controller">
                <button class="topButtons" name="command" value="logout">Выход</button>
            </form>
        </div>
    </div>
</header>
<body class="main">
<div class="userField">
    <div class="welcomeText">
        Добро пожаловать в личный кабинет, <c: ${sessionScope.name}>!
    </div class="userFrame">
        <div class="textSimpleUser">
            
                <div>
                    <p>Имя:</p><div class="textField" name="name" ${name}></div>
                </div>
                <div>
                    <p>Фамилия</p><div class="textField" name="surname" ${sessionScope.surname}></div>
                </div>
                <div>
                    <p>Контактный телефон</p><div class="textField" name="phone" ${sessionScope.phone}></div>
                </div>
                <div>
                    <p>Город</p><div class="textField" name="city" ${sessionScope.city}></div>
                </div>
                <div>
                    <p>Email</p><div class="textField" name="email" ${sessionScope.email}></div> 
                </div>
            
            <p class="userButton">
                <button type="submit" class="submitButton" name="command" value="update">Редактировать данные</button>
            </p>
        </div>
</body>
</html>
