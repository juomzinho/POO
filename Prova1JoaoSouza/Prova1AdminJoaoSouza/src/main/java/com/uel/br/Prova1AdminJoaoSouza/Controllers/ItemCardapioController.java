package com.uel.br.Prova1AdminJoaoSouza.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uel.br.Prova1AdminJoaoSouza.Models.ItemCardapio;
import com.uel.br.Prova1AdminJoaoSouza.Models.ItemCardapioRepository;

import com.uel.br.Prova1AdminJoaoSouza.Models.Restaurante;
import com.uel.br.Prova1AdminJoaoSouza.Models.RestauranteRepository;


import jakarta.validation.Valid;

@Controller
public class ItemCardapioController {

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
    

    @GetMapping("/novo-item/{id}")
    public String formNovoItem(@PathVariable("id") int id,ItemCardapio itemCardapio, Model model){
        Restaurante restaurante = restauranteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado!"));

        model.addAttribute("restaurante", restaurante);
        return "novo-item";
    }


    @PostMapping("/adicionar-item/{id}")
    public String adicionarItem(@PathVariable("id") int id, @Valid ItemCardapio itemCardapio, BindingResult result){
        
        if(result.hasErrors()){
            return "/novo-item";
        } 

        Restaurante restaurante = restauranteRepository.findById(19)
            .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado!"));

        itemCardapio.setRestaurante(restaurante);
        itemCardapio.setIdRestaurante(id);

        System.out.println(itemCardapio.getIdRestaurante());
        
        
        itemCardapioRepository.save(itemCardapio);
        return("redirect:/cardapio/"+id);
    }
}
