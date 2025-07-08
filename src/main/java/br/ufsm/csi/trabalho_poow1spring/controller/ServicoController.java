package br.ufsm.csi.trabalho_poow1spring.controller;

import br.ufsm.csi.trabalho_poow1spring.model.Servico;
import br.ufsm.csi.trabalho_poow1spring.service.ServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/servico")
public class ServicoController {

    @GetMapping
    public String listaServicos(Model model) {
        model.addAttribute("servicos", new ServicoService().listar());
        if (!model.containsAttribute("servico")) {
            model.addAttribute("servico", new Servico());
        }
        return "pages/servicos";
    }

    @PostMapping
    public String salvarServico(Servico servico, RedirectAttributes redirectAttributes) {
        String retorno;

        if (servico.getId() != null && servico.getId() > 0) {
            retorno = new ServicoService().alterar(servico);
        } else {
            retorno = new ServicoService().inserir(servico);
        }

        redirectAttributes.addFlashAttribute("msg", retorno);

        return "redirect:/servico";
    }

    @GetMapping("/excluir/{servicoId}")
    public String excluir(@PathVariable int servicoId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", new ServicoService().excluir(servicoId));

        return "redirect:/servico";
    }

    @GetMapping("/editar/{servicoId}")
    public String editar(@PathVariable Integer servicoId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("servico", new ServicoService().buscar(servicoId));

        return "redirect:/servico";
    }

}
