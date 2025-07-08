package br.ufsm.csi.trabalho_poow1spring.service;


import br.ufsm.csi.trabalho_poow1spring.model.Funcionario;

public class LoginService {

    public boolean autenticar(String email, String senha) {

        FuncionarioService funcionarioService = new FuncionarioService();
        Funcionario funcionario = funcionarioService.buscar(email);

        return senha.equals(funcionario.getSenha());
    }

}