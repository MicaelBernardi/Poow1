package br.csi.dao;

import br.csi.model.Agendamento;
import br.csi.model.Cliente;
import br.csi.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendamentoDAO {

    public String inserir(Agendamento agendamento) {

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO agendamento (data, status, funcionarioid, clienteid) VALUES (?, ?, ?, ?)");

            stmt.setString(1, String.valueOf(agendamento.getData()));
            stmt.setString(2, agendamento.getStatus());
            stmt.setInt(3, agendamento.getFuncionario().getId());
            stmt.setInt(4, agendamento.getCliente().getId());

            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao inserir agendamento");
        }

        return "Agendamento inserido com sucesso";
    }

    public String alterar(Agendamento agendamento) {
        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("UPDATE cliente SET data = ?, status = ?, funcionarioid = ?, clienteid = ? WHERE id = ?");

            stmt.setString(1, String.valueOf(agendamento.getData()));
            stmt.setString(2, agendamento.getStatus());
            stmt.setInt(3, agendamento.getFuncionario().getId());
            stmt.setInt(4, agendamento.getCliente().getId());
            stmt.setInt(5, agendamento.getId());

            stmt.execute();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao alterar agendamento");
        }

        return "Agendamento alterado com sucesso";
    }

    public Boolean excluir(int id) {
        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM agendamento WHERE id = ?");

            stmt.setInt(1, id);

            stmt.execute();

            if (stmt.getUpdateCount() <= 0) {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao excluir agendamento");
        }

        return true;
    }

    public ArrayList<Agendamento> listar() {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM agendamento");

            ResultSet rs = stmt.executeQuery();

            while (stmt.getResultSet().next()){
                Agendamento agendamento = new Agendamento();
                agendamento.setData(stmt.getResultSet().getDate("data"));
                agendamento.setStatus(stmt.getResultSet().getString("status"));

                Cliente cliente = new Cliente();



                Funcionario funcionario = new Funcionario();

                agendamentos.add(agendamento);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao listar agendamentos");
        }

        return agendamentos;
    }

}
