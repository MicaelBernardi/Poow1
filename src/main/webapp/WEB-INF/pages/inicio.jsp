<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Concessionária - Painel de Agendamentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>

        .card-body {
            min-height: 180px;
        }

        .card i {
            font-size: 2rem;
            margin-bottom: 10px;
            color: #0d6efd;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-secondary sticky-top fs-5">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="inicio">
            <i class="bi bi-gear-fill me-2"></i>Concessionária
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link active" href="inicio">Página Inicial</a></li>
                <li class="nav-item"><a class="nav-link" href="cliente">Clientes</a></li>
                <li class="nav-item"><a class="nav-link" href="servico">Serviços</a></li>
                <li class="nav-item"><a class="nav-link" href="funcionario">Funcionários</a></li>
                <li class="nav-item"><a class="nav-link" href="agendamento">Agendamentos</a></li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
                <li class="nav-item"><a class="nav-link text-danger" href="logout"><i class="bi bi-box-arrow-right"></i> Sair</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <h1 class="text-center mb-4">Painel de Agendamentos de Revisões</h1>
    <p class="text-center mb-5 text-muted">Acesse as opções abaixo para gerenciar cadastros e agendamentos de revisões dos veículos dos clientes.</p>

    <div class="row text-center">
        <div class="col-md-4">
            <div class="card mb-4">
                <div class="card-body bg-body-tertiary">
                    <i class="bi bi-person-plus-fill"></i>
                    <h5 class="card-title">Cadastro de Clientes</h5>
                    <p class="card-text">Adicione e gerencie os dados dos clientes da concessionária.</p>
                    <a href="cliente" class="btn btn-primary">Acessar</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <div class="card-body bg-body-tertiary">
                    <i class="bi bi-tools"></i>
                    <h5 class="card-title">Serviços Oferecidos</h5>
                    <p class="card-text">Configure os tipos de revisões e manutenções disponíveis.</p>
                    <a href="servico" class="btn btn-success">Acessar</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4">
                <div class="card-body bg-body-tertiary">
                    <i class="bi bi-people-fill"></i>
                    <h5 class="card-title">Cadastro de Funcionários</h5>
                    <p class="card-text">Inclua e edite atendentes responsáveis pelos agendamentos.</p>
                    <a href="funcionario" class="btn btn-warning">Acessar</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="card text-center mb-5">
                <div class="card-body bg-body-tertiary">
                    <i class="bi bi-calendar-check-fill"></i>
                    <h5 class="card-title">Lista de Agendamentos</h5>
                    <p class="card-text">Consulte e crie novos agendamentos de revisões.</p>
                    <a href="agendamento" class="btn btn-info text-white">Acessar</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
