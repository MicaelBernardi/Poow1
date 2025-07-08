package br.ufsm.csi.trabalho_poow1spring.service;

import br.ufsm.csi.trabalho_poow1spring.dao.ServicoDAO;
import br.ufsm.csi.trabalho_poow1spring.model.Servico;

import java.util.ArrayList;

public class ServicoService {
    private static ServicoDAO dao = new ServicoDAO();

    public String inserir(Servico servico) {
        return dao.inserir(servico);
    }

    public String alterar(Servico servico) {
        return dao.alterar(servico);
    }

    public String excluir(int id) {
        if (dao.excluir(id)) {
            return "Sucesso ao excluir servico";
        } else {
            return "Erro ao excluir servico";
        }
    }

    public ArrayList<Servico> listar() {
        return dao.listar();
    }

    public Servico buscar(int id) {
        return dao.buscar(id);
    }

}
