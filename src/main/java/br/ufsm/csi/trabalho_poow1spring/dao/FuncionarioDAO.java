package br.ufsm.csi.trabalho_poow1spring.dao;

import br.ufsm.csi.trabalho_poow1spring.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    public String inserir(Funcionario funcionario) {

        try {

            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO funcionario (nome, email, senha) VALUES (?,?,?)");

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getSenha());

            stmt.execute();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao inserir funcionario");
        }

        return "Funcionario inserido com sucesso";
    }

    public String alterar(Funcionario funcionario) {

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("UPDATE funcionario SET nome = ?, email = ?, senha = ? WHERE id = ?");

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getSenha());
            stmt.setInt(4, funcionario.getId());

            stmt.execute();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao alterar funcionario");
        }

        return "Funcionario alterado com sucesso";
    }

    public Boolean excluir(int id) {

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM funcionario WHERE id = ?");

            stmt.setInt(1, id);

            stmt.execute();

            if (stmt.getUpdateCount() <= 0) {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao excluir funcionario");
            return false;
        }

        return true;
    }

    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM funcionario ORDER BY id");

            stmt.execute();

            while (stmt.getResultSet().next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(stmt.getResultSet().getInt("id"));
                funcionario.setNome(stmt.getResultSet().getString("nome"));
                funcionario.setEmail(stmt.getResultSet().getString("email"));
                funcionario.setSenha(stmt.getResultSet().getString("senha"));

                funcionarios.add(funcionario);
            }

            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao listar funcionarios");
        }

        return funcionarios;
    }

    public Funcionario buscar(int id) {
        Funcionario funcionario = new Funcionario();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE id = ?");

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao buscar funcionario");
        }

        return funcionario;
    }

    public Funcionario buscar(String email) {
        Funcionario funcionario = new Funcionario();

        try {
            Connection conn = ConectarBanco.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE email = ?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao buscar funcionario");
        }

        return funcionario;
    }

}
