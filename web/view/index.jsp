<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.08.2021
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
    <title>Main</title>
</head>
<body class="main">

<div class="hat" style="background-image:url(../content/hat-pic.jpg)">

    <div class="t">XM
        <div class="littleT">ilieux.by
        </div>
    </div>
    <div class="topButtonsDiv">
        <form method="post" action="/view/controller?command=do"><button class="topButtons" name="regButton">Регистрация</button> </form>
        <form method="post" action="/view/controller?command=do"><button class="topButtons" name="entButton">Вход</button></form>
    </div>
</div>
<div class="contentFirstLine">
    <div class="square">1</div>
    <div class="square">2</div>
    <div class="square">3</div>
    <div class="square">4</div>
    <div class="square">5</div>
    <div class="square">6</div>

</div>
</body>
</html>
