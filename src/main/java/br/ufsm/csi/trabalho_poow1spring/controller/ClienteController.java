package br.ufsm.csi.trabalho_poow1spring.controller;

import br.ufsm.csi.trabalho_poow1spring.model.Cliente;
import br.ufsm.csi.trabalho_poow1spring.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping
    public String listaClientes(Model model) {
        model.addAttribute("clientes", new ClienteService().listar());
        if (!model.containsAttribute("cliente")) {
            model.addAttribute("cliente", new Cliente());
        }
        return "pages/clientes";
    }

    @PostMapping
    public String salvarCliente(Cliente cliente, RedirectAttributes redirectAttributes) {
        String retorno;

        if (cliente.getId() != null && cliente.getId() > 0) {
            retorno = new ClienteService().alterar(cliente);
        } else {
            retorno = new ClienteService().inserir(cliente);
        }

        redirectAttributes.addFlashAttribute("msg", retorno);

        return "redirect:/cliente";
    }

    @GetMapping("/excluir/{clienteId}")
    public String excluir(@PathVariable int clienteId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", new ClienteService().excluir(clienteId));

        return "redirect:/cliente";
    }

    @GetMapping("/editar/{clienteId}")
    public String editar(@PathVariable Integer clienteId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("cliente", new ClienteService().buscar(clienteId));

        return "redirect:/cliente";
    }

}
