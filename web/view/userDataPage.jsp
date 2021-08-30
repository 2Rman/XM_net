
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
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
            <form method="post" action="/view/error_404.jsp">
                <button class="topButtons" name="entButton">Вход</button>
            </form>
        </div>
    </div>
</header>
<body class="main">
    <div class="frame">
        
        <from method="POST" action="/veiw/controller">
            <p class="textMain">Пожалуйста, заполните Ваши данные</p>
        <div class="textSimple table">
            <div class="row">
                <div class="cell">
            <p>Ваше имя</p>
            <input class="textField" type="text" name="name" placeholder="Name">
                </div>
                <div class="cell">
            <p>Контактный телефон</p>
            <input class="textField" type="text" name="phone" placeholder="Phone">
                </div>
            </div>
            <div class="row">
                <div class="cell">
            <p>Ваш фамилия</p>
            <input class="textField" type="text" name="surname" placeholder="Surname">
                </div>
                 <div class="cell">
            <p>Ваш город</p>
            <input class="textField" type="text" name="city" placeholder="City">
                </div>
            </div>
            <div class="row">
                <div class="cell">
            <p>Email</p>
            <input class="textField" type="text" name="email" placeholder="Email">
                </div>               
                
                </div>
            </div>
            <div class="cellButton">
            <p><button class="submitButton"type="button" name="command" value="userDataUpdate">Отправить</button></p>
        </div>
        </from>
    </div>

</body>
</html>
