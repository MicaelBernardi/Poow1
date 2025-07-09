package br.ufsm.csi.trabalho_poow1spring.controller;

import br.ufsm.csi.trabalho_poow1spring.model.Funcionario;
import br.ufsm.csi.trabalho_poow1spring.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(HttpSession session, Model model, String email, String senha) {
        Funcionario funcionario = new LoginService().autenticar(email, senha);

        if(funcionario != null) {
            // Se a autenticação for bem-sucedida, armazena o usuário na sessão
            session.setAttribute("funcionarioLogado", funcionario);
            return "redirect:/inicio"; // Redireciona para o dashboard
        } else {
            // Se a autenticação falhar, retorna à página de login com uma mensagem de erro
            model.addAttribute("msg", "Login ou senha incorreto!");
            return "index"; // Retorna à página de login
        }
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "pages/inicio";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalida a sessão para fazer logout
        session.invalidate();
        return "redirect:/"; // Redireciona para a página de login
    }

}

