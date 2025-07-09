package br.ufsm.csi.trabalho_poow1spring.service;


import br.ufsm.csi.trabalho_poow1spring.model.Funcionario;

public class LoginService {

    public Funcionario autenticar(String email, String senha) {

        Funcionario funcionario = new FuncionarioService().buscar(email);

        if(funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario;
        } else {
            return null;
        }

    }

}