<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista de Agendamentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          crossorigin="anonymous"/>
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
                <li class="nav-item"><a class="nav-link" href="servico">Servicos</a></li>
                <li class="nav-item"><a class="nav-link" href="funcionario">Funcionarios</a></li>
                <li class="nav-item"><a class="nav-link active" href="agendamento" aria-current="page">Agendamentos</a></li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
                <li class="nav-item"><a class="nav-link" href="logout">Sair</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">

    <h1 class="text-center mb-4">Lista de Agendamentos</h1>

    <div class="text-center mb-3">
        <a href="agendamento/inserir" class="btn btn-success">Novo Agendamento</a>

        <div class="container mt-4 mb-3 w-50">
            <form action="${pageContext.request.contextPath}/agendamento" method="get" class="d-flex gap-2">
                <select name="status" class="form-select">
                    <option value="">-- Todos --</option>
                    <option value="Agendado" ${param.status == 'Agendado' ? 'selected' : ''}>Agendado</option>
                    <option value="Finalizado" ${param.status == 'Finalizado' ? 'selected' : ''}>Finalizado</option>
                </select>
                <button type="submit" class="btn btn-primary">Filtrar</button>
            </form>
        </div>

    </div>

    <div class="table-responsive">
        <table class="table table-bordered table-striped w-100 mx-auto text-nowrap">
            <thead class="table-light">
            <tr>
                <th>Data</th>
                <th>Cliente</th>
                <th>Funcionário</th>
                <th>Serviço</th>
                <th>Status</th>
                <th style="width: 150px;" class="text-center">Opções</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="agendamento" items="${agendamentos}">
                <tr>
                    <td><c:out value="${agendamento.data}"/></td>
                    <td><c:out value="${agendamento.cliente.nome}"/></td>
                    <td><c:out value="${agendamento.funcionario.nome}"/></td>
                    <td><c:out value="${agendamento.servico.descricao}"/></td>
                    <td><c:out value="${agendamento.status}"/></td>
                    <td>
                        <a href="/agendamento/editar/${agendamento.id}" class="btn btn-warning btn-sm me-2">Editar</a>
                        <a href="/agendamento/excluir/${agendamento.id}" class="btn btn-danger btn-sm me-2">Excluir</a>
                        <c:if test="${agendamento.status == 'Agendado'}">
                            <a href="/agendamento/finalizar/${agendamento.id}"
                               class="btn btn-success btn-sm"
                               onclick="return confirm('Tem certeza que deseja finalizar este agendamento?');">
                                Finalizar
                            </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
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
