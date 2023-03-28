package com.uel.br.Prova1ConsumidorJoaoSouza.Controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapio;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapioRepository;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.Restaurante;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.RestauranteRepository;
;
@Controller
public class ItemCardapioController implements Serializable {

    @Autowired
    ItemCardapioRepository itemCardapioRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping("/cardapio/{id}")
    public String listarCardapio(@PathVariable("id") int id,Model model){
        List<ItemCardapio> itemCardapio = itemCardapioRepository.findByRestauranteId(id);

        Restaurante restaurante = restauranteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado!"));

        model.addAttribute("itens", itemCardapio);
        model.addAttribute("restaurante", restaurante);

        return "cardapio";
    }
}
