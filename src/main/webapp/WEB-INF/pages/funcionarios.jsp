<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Funcionarios</title>
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
                    <a class="nav-link" href="servico">Servicos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="funcionario" aria-current="page">Funcionarios</a>
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

<h1 class="text-center">Cadastro de funcionarios</h1>
<div class="d-flex justify-content-lg-center">
    <form action="funcionario" method="post" class="w-50">

        <c:choose>
            <c:when test="${funcionario.id != null}">
                <h2>Editar Funcionario</h2>
                <input type="hidden" name="idfuncionario" value="${funcionario.id}">
            </c:when>
            <c:otherwise>
                <h2>Adicionar Funcionario</h2>
                <input type="hidden" name="idfuncionario" value="0">
            </c:otherwise>
        </c:choose>

        <div class="mb-1">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="Nome" placeholder="Nome" name="nome" required
                   value="${funcionario.nome}">
        </div>
        <div class="mb-1">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="Email" placeholder="Email" name="email" required
                   value="${funcionario.email}">
        </div>
        <div class="mb-1">
            <label for="Senha" class="form-label">Senha:</label>
            <input type="password" class="form-control" id="Senha" placeholder="Senha" name="senha" required
                   value="${funcionario.senha}">
        </div>

        <c:choose>
            <c:when test="${funcionario.id != null}">
                <input type="submit" value="Alterar" name="gravar" class="btn btn-primary">
            </c:when>
            <c:otherwise>
                <input type="submit" value="Cadastrar" name="gravar" class="btn btn-primary">
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
    <h1 class="text-center">Lista de Funcionarios</h1>
</div>

<div class="d-flex justify-content-lg-center">
    <table class="table table-bordered w-50">
        <th>Nome</th>
        <th>Email</th>
        <th>Ações</th>
        <c:forEach var="funcionario" items="${funcionarios}">
            <tr>
                <td>${funcionario.nome}</td>
                <td>${funcionario.email}</td>
                <td>
                    <a href="funcionario?opcao=editar&&info=${funcionario.id}" class="btn btn-warning btn-sm me-2">Editar</a>
                    <a href="funcionario?opcao=excluir&&info=${funcionario.id}"
                       class="btn btn-danger btn-sm">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
