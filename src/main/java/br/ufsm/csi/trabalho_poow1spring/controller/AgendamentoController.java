package br.ufsm.csi.trabalho_poow1spring.controller;

import br.ufsm.csi.trabalho_poow1spring.model.Agendamento;
import br.ufsm.csi.trabalho_poow1spring.model.Cliente;
import br.ufsm.csi.trabalho_poow1spring.model.Funcionario;
import br.ufsm.csi.trabalho_poow1spring.model.Servico;
import br.ufsm.csi.trabalho_poow1spring.service.AgendamentoService;
import br.ufsm.csi.trabalho_poow1spring.service.ClienteService;
import br.ufsm.csi.trabalho_poow1spring.service.FuncionarioService;
import br.ufsm.csi.trabalho_poow1spring.service.ServicoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService = new AgendamentoService();
    private final ClienteService clienteService = new ClienteService();
    private final FuncionarioService funcionarioService = new FuncionarioService();
    private final ServicoService servicoService = new ServicoService();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @GetMapping
    public String listar(@RequestParam(name = "status", required = false) String status, Model model) {
        if (status != null && !status.isEmpty()) {
            model.addAttribute("agendamentos", agendamentoService.listarPorStatus(status));
        } else {
            model.addAttribute("agendamentos", agendamentoService.listar());
        }
        return "pages/agendamentos-listar";
    }

    @GetMapping("/inserir")
    public String inserir(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("funcionarios", funcionarioService.listar());
        model.addAttribute("servicos", servicoService.listar());
        return "pages/agendamento-form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        model.addAttribute("agendamento", agendamentoService.buscar(id));
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("funcionarios", funcionarioService.listar());
        model.addAttribute("servicos", servicoService.listar());
        return "pages/agendamento-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Agendamento agendamento) {

        if (agendamento.getId() == null || agendamento.getId() == 0) {
            agendamento.setStatus("Agendado");
        }

        if (agendamento.getId() != null && agendamento.getId() > 0) {

            agendamento.setCliente(clienteService.buscar(agendamento.getCliente().getId()));
            agendamento.setFuncionario(funcionarioService.buscar(agendamento.getFuncionario().getId()));
            agendamento.setServico(servicoService.buscar(agendamento.getServico().getId()));

            agendamentoService.alterar(agendamento);
        } else {
            agendamentoService.inserir(agendamento);
        }

        return "redirect:/agendamento";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        agendamentoService.excluir(id);
        return "redirect:/agendamento";
    }

    @GetMapping("/finalizar/{id}")
    public String finalizar(@PathVariable("id") int id) {
        Agendamento agendamento = agendamentoService.buscar(id);
        if (agendamento != null && "Agendado".equalsIgnoreCase(agendamento.getStatus())) {
            agendamento.setStatus("Finalizado");
            agendamentoService.alterar(agendamento);
        }
        return "redirect:/agendamento";
    }


}
