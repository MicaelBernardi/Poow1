<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><c:choose>
        <c:when test="${agendamento.id != null}">Editar Agendamento</c:when>
        <c:otherwise>Novo Agendamento</c:otherwise>
    </c:choose></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2-bootstrap-5-theme@1.3.0/dist/select2-bootstrap-5-theme.min.css" />

</head>
<body>

<div class="container mt-4">
    <h2 class="text-center">
        <c:choose>
            <c:when test="${agendamento.id != null}">Editar Agendamento</c:when>
            <c:otherwise>Novo Agendamento</c:otherwise>
        </c:choose>
    </h2>

    <form:form method="post" action="/agendamento/salvar" modelAttribute="agendamento" class="w-50 mx-auto mt-4">

        <form:hidden path="id"/>

        <div class="mb-3">
            <form:label path="cliente.id" class="form-label">Cliente:</form:label>
            <form:select path="cliente.id" cssClass="form-select select2" required="true">
                <form:option value="" label="-- Selecione --"/>
                <form:options items="${clientes}" itemValue="id" itemLabel="nome"/>
            </form:select>
        </div>

        <div class="mb-3">
            <form:label path="funcionario.id" class="form-label">Funcionário:</form:label>
            <form:select path="funcionario.id" cssClass="form-select select2" required="true">
                <form:option value="" label="-- Selecione --"/>
                <form:options items="${funcionarios}" itemValue="id" itemLabel="nome"/>
            </form:select>
        </div>

        <div class="mb-3">
            <form:label path="servico.id" class="form-label">Serviço:</form:label>
            <form:select path="servico.id" cssClass="form-select select2" required="true">
                <form:option value="" label="-- Selecione --"/>
                <form:options items="${servicos}" itemValue="id" itemLabel="descricao"/>
            </form:select>
        </div>

        <div class="mb-3">
            <form:label path="data" class="form-label">Data:</form:label>
            <form:input path="data" type="date" cssClass="form-control" required="true"/>
        </div>

        <c:if test="${agendamento.id != null}">
            <form:hidden path="status"/>
        </c:if>


        <div class="text-center">
            <button type="submit" class="btn btn-primary">
                <c:choose>
                    <c:when test="${agendamento.id != null}">Alterar</c:when>
                    <c:otherwise>Cadastrar</c:otherwise>
                </c:choose>
            </button>
            <a class="btn btn-secondary" href="/agendamento">Voltar</a>
        </div>

    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

</body>

<script>
    $(document).ready(function() {
        $('.select2').select2({
            placeholder: "-- Selecione --",
            theme: 'bootstrap-5'
        });
    });
</script>

</html>
