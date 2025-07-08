package br.ufsm.csi.trabalho_poow1spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class InicioController {

    @GetMapping("/inicio")
    public String inicio() {
        return "pages/inicio";
    }

}
