package com.uel.br.Prova1AdminJoaoSouza.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uel.br.Prova1AdminJoaoSouza.Models.ItemCardapio;
import com.uel.br.Prova1AdminJoaoSouza.Models.ItemCardapioRepository;

import jakarta.validation.Valid;

@Controller
public class ItemCardapioController {

    @Autowired
    ItemCardapioRepository itemCardapioRepository;

    @GetMapping("/cardapio/{id}")
    public String listarCardapio(@PathVariable("id") int id,Model model){
        model.addAttribute("itens", itemCardapioRepository.findByIdRestaurante(id));
        model.addAttribute("restauranteId", id);
        return "cardapio";
    }
    

    @GetMapping("/novo-item/{id}")
    public String formNovoItem(@PathVariable("id") String id,ItemCardapio itemCardapio){
        System.out.println(id);
        return "novo-item";
    }


    @PostMapping("/adicionar-item")
    public String adicionarItem(@Valid ItemCardapio itemCardapio, BindingResult result){
        if(result.hasErrors()){
            return "/novo-item";
        } 
        
        itemCardapioRepository.save(itemCardapio);
        return("redirect:/cardapio");
    }
}
