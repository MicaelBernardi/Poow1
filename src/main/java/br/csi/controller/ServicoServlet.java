package br.csi.controller;

import br.csi.model.Servico;
import br.csi.service.ServicoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("servico")
public class ServicoServlet extends HttpServlet {

    private static ServicoService service = new ServicoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("idservico"));
        String descricao = req.getParameter("descricao");
        String valor = req.getParameter("valor");

        Servico servico = new Servico();
        servico.setDescricao(descricao);
        servico.setValor(Double.parseDouble(valor));

        String retorno;
        if (id > 0) {
            servico.setId(id);
            retorno = new ServicoService().alterar(servico);
        } else {
            retorno = new ServicoService().inserir(servico);
        }

        req.setAttribute("retorno", retorno);
        req.setAttribute("servicos", new ServicoService().listar());

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/servicos.jsp");

        rd.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String opcao = req.getParameter("opcao");
        String info = req.getParameter("info");

        if (opcao != null) {
            switch (opcao) {
                case "editar":
                    Servico servico = service.buscar(Integer.parseInt(info));
                    req.setAttribute("servico", servico);
                    break;

                case "excluir":
                    String valor = service.excluir(Integer.parseInt(info));
                    req.setAttribute("msg", valor);
                    break;
            }
        }

        ArrayList<Servico> servicos = new ServicoService().listar();
        req.setAttribute("servicos", servicos);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/servicos.jsp");
        rd.forward(req, resp);
    }

}
