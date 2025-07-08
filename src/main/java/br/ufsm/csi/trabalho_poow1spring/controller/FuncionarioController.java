package br.ufsm.csi.trabalho_poow1spring.controller;

import br.ufsm.csi.trabalho_poow1spring.model.Funcionario;
import br.ufsm.csi.trabalho_poow1spring.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @GetMapping
    public String listaFuncionarios(Model model) {
        model.addAttribute("funcionarios", new FuncionarioService().listar());
        if (!model.containsAttribute("funcionario")) {
            model.addAttribute("funcionario", new Funcionario());
        }

        return "pages/funcionarios";
    }

    @PostMapping
    public String salvarFuncionario(Funcionario funcionario, RedirectAttributes redirectAttributes) {
        String retorno;
        if (funcionario.getId() != null && funcionario.getId() > 0) {
            retorno = new FuncionarioService().alterar(funcionario);
        } else {
            retorno = new FuncionarioService().inserir(funcionario);
        }

        redirectAttributes.addFlashAttribute("msg", retorno);

        return "redirect:/funcionario";
    }

    @GetMapping("/editar/{funcionarioId}")
    public String editar(@PathVariable Integer funcionarioId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("funcionario", new FuncionarioService().buscar(funcionarioId));

        return "redirect:/funcionario";
    }

    @GetMapping("/excluir/{funcionarioId}")
    public String excluir(@PathVariable int funcionarioId, RedirectAttributes redirectAttributes) {
        String retorno = new FuncionarioService().excluir(funcionarioId);
        redirectAttributes.addFlashAttribute("msg", retorno);

        return "redirect:/funcionario";
    }
}
