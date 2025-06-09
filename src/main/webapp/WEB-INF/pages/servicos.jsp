<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Servicos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-secondary sticky-top fs-5">
    <div class="container-fluid">
        <a class="navbar-brand fs-4 fw-medium" href="inicio">Agendamentos</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="inicio">Página Inicial</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cliente">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="servico" aria-current="page">Servicos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="funcionario">Funcionarios</a>
                </li>
            </ul>

            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
                <li class="nav-item">
                    <a class="nav-link" href="login">Sair</a>
                </li>
            </ul>

        </div>
    </div>
</nav>

<h1 class="text-center">Cadastro de servicos</h1>

<div class="d-flex justify-content-lg-center">
    <form action="servico" method="post" class="w-50">

        <c:choose>
            <c:when test="${servico.id != null}">
                <h2>Editar Servico</h2>
                <input type="hidden" name="idservico" value="${servico.id}">
            </c:when>
            <c:otherwise>
                <h2>Adicionar Servico</h2>
                <input type="hidden" name="idservico" value="0">
            </c:otherwise>
        </c:choose>

        <div class="mb-1">
            <label for="descricao" class="form-label">Descrição:</label>
            <input type="text" class="form-control" id="descricao" placeholder="Descrição" name="descricao" required
                   value="${servico.descricao}">
        </div>

        <div class="mb-1">
            <label for="valor" class="form-label">Valor:</label>
            <input type="number" class="form-control" id="valor" placeholder="Valor" name="valor" required
                   value="${servico.valor}">
        </div>

        <c:choose>
            <c:when test="${servico.id != null}">
                <button type="submit" value="Alterar" name="gravar" class="btn btn-primary">Alterar</button>
            </c:when>
            <c:otherwise>
                <button type="submit" value="Cadastrar" name="gravar" class="btn btn-primary">Cadastrar</button>
            </c:otherwise>
        </c:choose>
    </form>
</div>

<div class="d-flex justify-content-lg-center mb-2">
    <c:if test="${not empty msg}">
        <h3 class="text-center"><u>${msg}</u></h3>
    </c:if>

</div>
<div class="d-flex justify-content-lg-center">
    <h1 class="text-center">Lista de Servicos</h1>
</div>

<div class="d-flex justify-content-lg-center">
    <table class="table table-bordered w-50">
        <th>Descricao</th>
        <th>Valor</th>
        <th>Ações</th>
        <c:forEach var="servico" items="${servicos}">
            <tr>
                <td>${servico.descricao}</td>
                <td>${servico.valor}</td>
                <td>
                    <a href="servico?opcao=editar&&info=${servico.id}" class="btn btn-warning btn-sm me-2">Editar</a>
                    <a href="servico?opcao=excluir&&info=${servico.id}" class="btn btn-danger btn-sm">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
