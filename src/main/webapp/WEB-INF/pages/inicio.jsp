<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Página Inicial</title>
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
                    <a class="nav-link active" aria-current="page" href="#">Página Inicial</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cliente">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="servico">Serviços</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="funcionario">Funcionários</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="agendamento">Agendamentos</a>
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

<div class="container mt-5">
    <h1 class="text-center mb-4">Agendamento de Revisões para Clientes</h1>
    <p class="text-center mb-5">Utilize os atalhos abaixo para acessar os cadastros:</p>
    <div class="row">
        <div class="col-md-4">
            <div class="card text-center mb-4">
                <div class="card-body bg-body-tertiary">
                    <h5 class="card-title">Cadastro de Clientes</h5>
                    <p class="card-text">Adicione novos clientes ao sistema.</p>
                    <a href="cliente" class="btn btn-primary">Acessar</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center mb-4">
                <div class="card-body bg-body-tertiary">
                    <h5 class="card-title">Cadastro de Serviços</h5>
                    <p class="card-text">Gerencie os serviços oferecidos.</p>
                    <a href="servico" class="btn btn-success">Acessar</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center mb-4">
                <div class="card-body bg-body-tertiary">
                    <h5 class="card-title">Cadastro de Funcionários</h5>
                    <p class="card-text">Inclua novos funcionários no sistema.</p>
                    <a href="funcionario" class="btn btn-warning">Acessar</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>