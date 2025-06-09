package br.csi.controller;

import br.csi.model.Funcionario;
import br.csi.service.FuncionarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("funcionario")
public class FuncionarioServlet extends HttpServlet {

    private static FuncionarioService service = new FuncionarioService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("idfuncionario"));
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setEmail(email);
        funcionario.setSenha(senha);

        String retorno;
        if (id > 0) {
            funcionario.setId(id);
            retorno = new FuncionarioService().alterar(funcionario);
        } else {
            retorno = new FuncionarioService().inserir(funcionario);
        }

        req.setAttribute("retorno", retorno);
        req.setAttribute("funcionarios", new FuncionarioService().listar());

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/funcionarios.jsp");

        rd.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String opcao = req.getParameter("opcao");
        String info = req.getParameter("info");

        if (opcao != null) {
            switch (opcao) {
                case "editar":
                    Funcionario funcionario = service.buscar(Integer.parseInt(info));
                    req.setAttribute("funcionario", funcionario);
                    break;

                case "excluir":
                    String valor = service.excluir(Integer.parseInt(info));
                    req.setAttribute("msg", valor);
                    break;
            }
        }

        ArrayList<Funcionario> funcionarios = new FuncionarioService().listar();
        req.setAttribute("funcionarios", funcionarios);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/funcionarios.jsp");
        rd.forward(req, resp);
    }
}
