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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
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

        System.out.println("Restaurante id: " + id);

        Restaurante restaurante = restauranteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado!"));

        itemCardapio.setRestaurante(restaurante);
        itemCardapio.setIdRestaurante(id);

        System.out.println(itemCardapio.getIdRestaurante());
        
        
        itemCardapioRepository.save(itemCardapio);
        return("redirect:/cardapio/"+id);
    }

    @Transactional
    @GetMapping("/excluir-item/{id}")
        public String removeritem(@PathVariable("id") int id, HttpServletRequest request) {
            ItemCardapio itemCardapio = itemCardapioRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("O id do item é inválido:" + id));

            
            itemCardapioRepository.delete(itemCardapio);
    
            return "redirect:/index";
        }

    @GetMapping("/editar-item/{id}/{idRestaurante}")
    public String formAlterarCardapio(@PathVariable("id") int id, 
        @PathVariable("idRestaurante") int idRestaurante, Model model){
        ItemCardapio itemCardapio = itemCardapioRepository.findById(id) .orElseThrow(() -> 
            new IllegalArgumentException("Id de cardápio inválido" + id));
        
        Restaurante restaurante = restauranteRepository.findById(idRestaurante) .orElseThrow(() -> 
        new IllegalArgumentException("Id de restaurante inválido" + id));

        model.addAttribute("itemCardapio", itemCardapio);
        model.addAttribute("restaurante", restaurante);
        return "atualizar-cardapio";
    }

    @PostMapping("/atualizar-item/{id}/{itemId}")
    public String atualizarCardapio(@PathVariable("id") int id, @PathVariable("itemId") int itemId,
        @Valid ItemCardapio itemCardapio,  BindingResult result, Model model){
            if(result.hasErrors()){
                return "index";
            }

            itemCardapioRepository.updateItemCardapio(itemId, itemCardapio.getNome(),        
                itemCardapio.getDescricao(), itemCardapio.getPreco());
            return ("redirect:/cardapio/"+id);
    }


}
