package br.ufsm.csi.trabalho_poow1spring.dao;

import br.ufsm.csi.trabalho_poow1spring.model.Agendamento;
import br.ufsm.csi.trabalho_poow1spring.model.Cliente;
import br.ufsm.csi.trabalho_poow1spring.model.Funcionario;
import br.ufsm.csi.trabalho_poow1spring.model.Servico;

import java.sql.*;
import java.util.ArrayList;

public class AgendamentoDAO {

    public String inserir(Agendamento agendamento) {

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO agendamento (data, status, idfuncionario, idcliente, idservico) VALUES (?, ?, ?, ?, ?)");

            stmt.setDate(1,new Date(agendamento.getData().getTime()));
            stmt.setString(2, agendamento.getStatus());
            stmt.setInt(3, agendamento.getFuncionario().getId());
            stmt.setInt(4, agendamento.getCliente().getId());
            stmt.setInt(5, agendamento.getServico().getId());

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
            PreparedStatement stmt = conn.prepareStatement("UPDATE agendamento SET data = ?, status = ?, idfuncionario = ?, idcliente = ?, idservico = ? WHERE id = ?");

            stmt.setDate(1, new Date(agendamento.getData().getTime()));
            stmt.setString(2, agendamento.getStatus());
            stmt.setInt(3, agendamento.getFuncionario().getId());
            stmt.setInt(4, agendamento.getCliente().getId());
            stmt.setInt(5, agendamento.getServico().getId());
            stmt.setInt(6, agendamento.getId());

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
            return false;
        }

        return true;
    }

    public ArrayList<Agendamento> listar() {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM agendamento_view order by idagendamento desc ");

            stmt.execute();

            while (stmt.getResultSet().next()){
                Agendamento agendamento = new Agendamento();
                agendamento.setId(stmt.getResultSet().getInt("idagendamento"));
                agendamento.setData(stmt.getResultSet().getDate("data"));
                agendamento.setStatus(stmt.getResultSet().getString("status"));

                Cliente cliente = new Cliente();
                cliente.setId(stmt.getResultSet().getInt("idcliente"));
                cliente.setNome(stmt.getResultSet().getString("nomecliente"));
                cliente.setCpf(stmt.getResultSet().getString("cpfcliente"));
                cliente.setTelefone(stmt.getResultSet().getString("telefonecliente"));
                agendamento.setCliente(cliente);

                Funcionario funcionario = new Funcionario();

                funcionario.setId(stmt.getResultSet().getInt("idfunc"));
                funcionario.setNome(stmt.getResultSet().getString("nomefunc"));
                funcionario.setEmail(stmt.getResultSet().getString("emailfunc"));
                agendamento.setFuncionario(funcionario);

                Servico servico = new Servico();
                servico.setId(stmt.getResultSet().getInt("idservico"));
                servico.setDescricao(stmt.getResultSet().getString("descricaoservico"));
                servico.setValor(stmt.getResultSet().getDouble("valorservico"));
                agendamento.setServico(servico);

                agendamentos.add(agendamento);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao listar agendamentos");
        }

        return agendamentos;
    }

    public Agendamento buscar(int id) {
        Agendamento agendamento = new Agendamento();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM agendamento_view WHERE idagendamento = ?");

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {

                agendamento.setId(stmt.getResultSet().getInt("idagendamento"));
                agendamento.setData(stmt.getResultSet().getDate("data"));
                agendamento.setStatus(stmt.getResultSet().getString("status"));

                Cliente cliente = new Cliente();
                cliente.setId(stmt.getResultSet().getInt("idcliente"));
                cliente.setNome(stmt.getResultSet().getString("nomecliente"));
                cliente.setCpf(stmt.getResultSet().getString("cpfcliente"));
                cliente.setTelefone(stmt.getResultSet().getString("telefonecliente"));
                agendamento.setCliente(cliente);

                Funcionario funcionario = new Funcionario();

                funcionario.setId(stmt.getResultSet().getInt("idfunc"));
                funcionario.setNome(stmt.getResultSet().getString("nomefunc"));
                funcionario.setEmail(stmt.getResultSet().getString("emailfunc"));
                agendamento.setFuncionario(funcionario);

                Servico servico = new Servico();
                servico.setId(stmt.getResultSet().getInt("idservico"));
                servico.setDescricao(stmt.getResultSet().getString("descricaoservico"));
                servico.setValor(stmt.getResultSet().getDouble("valorservico"));
                agendamento.setServico(servico);
            }
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao buscar agendamento");
        }

        return agendamento;
    }

    public ArrayList<Agendamento> listarPorStatus(String status) {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM agendamento_view where status = ? order by idagendamento desc ");
            stmt.setString(1, status);

            stmt.execute();

            while (stmt.getResultSet().next()){
                Agendamento agendamento = new Agendamento();
                agendamento.setId(stmt.getResultSet().getInt("idagendamento"));
                agendamento.setData(stmt.getResultSet().getDate("data"));
                agendamento.setStatus(stmt.getResultSet().getString("status"));

                Cliente cliente = new Cliente();
                cliente.setId(stmt.getResultSet().getInt("idcliente"));
                cliente.setNome(stmt.getResultSet().getString("nomecliente"));
                cliente.setCpf(stmt.getResultSet().getString("cpfcliente"));
                cliente.setTelefone(stmt.getResultSet().getString("telefonecliente"));
                agendamento.setCliente(cliente);

                Funcionario funcionario = new Funcionario();

                funcionario.setId(stmt.getResultSet().getInt("idfunc"));
                funcionario.setNome(stmt.getResultSet().getString("nomefunc"));
                funcionario.setEmail(stmt.getResultSet().getString("emailfunc"));
                agendamento.setFuncionario(funcionario);

                Servico servico = new Servico();
                servico.setId(stmt.getResultSet().getInt("idservico"));
                servico.setDescricao(stmt.getResultSet().getString("descricaoservico"));
                servico.setValor(stmt.getResultSet().getDouble("valorservico"));
                agendamento.setServico(servico);

                agendamentos.add(agendamento);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao listar agendamentos");
        }

        return agendamentos;
    }
}
