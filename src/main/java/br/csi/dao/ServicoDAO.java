package br.csi.dao;

import br.csi.model.Cliente;
import br.csi.model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO {

    public String inserir(Servico servico) {

        try{
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO servico (descricao, valor) VALUES (?,?)");

            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getValor());

            stmt.execute();

        }catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao inserir servico");
        }

        return "Servico inserido com sucesso";
    }

    public String alterar(Servico servico) {

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("UPDATE servico SET descricao = ?, valor = ? WHERE id = ?");
            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getValor());
            stmt.setInt(3, servico.getId());
            stmt.execute();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao alterar servico");
        }

        return "Servico alterado com sucesso";
    }

    public Boolean excluir(int id) {
        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM servico WHERE id = ?");

            stmt.setInt(1, id);

            stmt.execute();

            if (stmt.getUpdateCount() <= 0) {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao excluir servico");
        }

        return true;
    }

    public ArrayList<Servico> listar() {
        ArrayList<Servico> servicos = new ArrayList<>();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM servico ORDER BY id");

            stmt.execute();

            while (stmt.getResultSet().next()) {
                Servico servico = new Servico();
                servico.setId(stmt.getResultSet().getInt("id"));
                servico.setDescricao(stmt.getResultSet().getString("descricao"));
                servico.setValor(stmt.getResultSet().getDouble("valor"));

                servicos.add(servico);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao listar servicos");
        }

        return servicos;
    }

    public Servico buscar(int id) {
        Servico servico = new Servico();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM servico WHERE id = ?");

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                servico.setId(rs.getInt("id"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setValor(rs.getDouble("valor"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao buscar servico");
        }

        return servico;
    }

}
