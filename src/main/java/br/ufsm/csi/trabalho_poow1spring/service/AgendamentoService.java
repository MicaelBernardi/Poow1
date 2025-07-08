package br.ufsm.csi.trabalho_poow1spring.service;


import br.ufsm.csi.trabalho_poow1spring.dao.AgendamentoDAO;
import br.ufsm.csi.trabalho_poow1spring.model.Agendamento;

import java.util.ArrayList;

public class AgendamentoService {
    private static AgendamentoDAO dao = new AgendamentoDAO();

    public String inserir(Agendamento agendamento) {
        return dao.inserir(agendamento);
    }

    public String alterar(Agendamento agendamento) {
        return dao.alterar(agendamento);
    }

    public String excluir(int id) {
        if (dao.excluir(id)) {
            return "Sucesso ao excluir agendamento";
        } else {
            return "Erro ao excluir agendamento";
        }
    }

    public ArrayList<Agendamento> listar() {
        return dao.listar();
    }

    public Agendamento buscar(int id) {
        return dao.buscar(id);
    }

    public ArrayList<Agendamento> listarPorStatus(String status) {
        return dao.listarPorStatus(status);
    }
}
