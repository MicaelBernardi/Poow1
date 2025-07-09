<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Servicos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

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
                <li class="nav-item"><a class="nav-link" href="inicio">Página Inicial</a></li>
                <li class="nav-item"><a class="nav-link" href="cliente">Clientes</a></li>
                <li class="nav-item"><a class="nav-link active" href="servico" aria-current="page">Servicos</a></li>
                <li class="nav-item"><a class="nav-link" href="funcionario">Funcionarios</a></li>
                <li class="nav-item"><a class="nav-link" href="agendamento">Agendamentos</a></li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
                <li class="nav-item"><a class="nav-link" href="logout">Sair</a></li>
            </ul>
        </div>
    </div>
</nav>

<h1 class="text-center">Cadastro de servicos</h1>

<div class="d-flex justify-content-lg-center">
    <form:form action="servico" method="post" modelAttribute="servico" class="w-50">
        <h2>${servico.id != null && servico.id > 0 ? 'Editar Servico' : 'Adicionar Servico'}</h2>
        <form:hidden path="id"/>

        <div class="mb-1">
            <form:label path="descricao" class="form-label">Descricao:</form:label>
            <form:input path="descricao" class="form-control" placeholder="Descricao" required="true"/>
        </div>

        <div class="mb-1">
            <form:label path="valor" class="form-label">Valor:</form:label>
            <form:input path="valor" class="form-control" placeholder="Valor" required="true" type="number" step="0.01"/>
        </div>

        <input type="submit" value="${servico.id != null && servico.id > 0 ? 'Alterar' : 'Cadastrar'}" class="btn btn-primary mt-3"/>
    </form:form>
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
                    <a href="servico/editar/${servico.id}" class="btn btn-warning btn-sm me-2">Editar</a>
                    <a href="servico/excluir/${servico.id}" class="btn btn-danger btn-sm">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<c:if test="${not empty msg}">
    <div class="toast-container position-fixed bottom-0 end-0 p-3" style="z-index: 9999">
        <div id="toastMsg" class="toast align-items-center bg-warning text-white border-2" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body text-dark">
                        ${msg}
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
    </div>
</c:if>


</body>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const toastEl = document.getElementById("toastMsg");

        if (toastEl) {
            const toast = new bootstrap.Toast(toastEl, {
                delay: 5000 // <-- tempo de exibição (em ms)
            });

            toast.show(); // <-- aqui o Bootstrap adiciona `show` dinamicamente
        }
    });
</script>
</html>
