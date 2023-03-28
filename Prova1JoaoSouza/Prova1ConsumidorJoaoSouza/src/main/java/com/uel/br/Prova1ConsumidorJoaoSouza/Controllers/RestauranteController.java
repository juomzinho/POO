package com.uel.br.Prova1ConsumidorJoaoSouza.Controllers;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapioRepository;
import com.uel.br.Prova1ConsumidorJoaoSouza.Controllers.RestauranteController;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class RestauranteController {
    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    ItemCardapioRepository itemCardapioRepository;

    @GetMapping(value={"/index", "/"})
    public String exibir(Model model) {
        model.addAttribute("restaurantes", restauranteRepository.findAll());
        return "index";
    }
    
}
