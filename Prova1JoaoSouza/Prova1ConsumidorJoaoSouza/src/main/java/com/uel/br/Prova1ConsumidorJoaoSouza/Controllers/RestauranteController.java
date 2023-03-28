package com.uel.br.Prova1ConsumidorJoaoSouza.Controllers;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapioRepository;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.Restaurante;
import com.uel.br.Prova1ConsumidorJoaoSouza.Controllers.RestauranteController;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.RestauranteRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

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
