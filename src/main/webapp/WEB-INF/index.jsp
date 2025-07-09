<%@page contentType="text/html; ISO-8859-1" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>


<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>

<div class="d-flex justify-content-lg-center">
    <form class="form-signin mt-5 w-25" action="login" method="post">
        <h1 class="h3 mb-3 font-weight-normal text-center">Entrar no Sistema</h1>
        <label for="inputEmail" class="sr-only">Email:</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email" name="email" required autofocus="">
        <label for="inputPassword" class="sr-only">Senha:</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="senha" required>

        <button class="btn btn-lg btn-primary btn-block mt-3" type="submit" value="LOGAR" name="login">Entrar</button>

    </form>
</div>

<div class="d-flex justify-content-lg-center mb-2">
    <c:if test="${not empty msg}">
        <h3 class="text-center"><u>${msg}</u></h3>
    </c:if>

</div>

</body>
</html>
