package com.uel.br.Prova1ConsumidorJoaoSouza.Controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapio;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapioRepository;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.Restaurante;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.RestauranteRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
public class ItemCardapioController implements Serializable {

    private static final String SESSION_PEDIDOS ="sessionPedidos";

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
    
    @Transactional
    public void deletarTodosItens(int idRestaurante) {
        itemCardapioRepository.deleteByRestauranteId(idRestaurante);
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

    @GetMapping("/excluir-item/{id}")
        public String removeritem(@PathVariable("id") int id, HttpServletRequest request) {
            ItemCardapio itemCardapio = itemCardapioRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("O id do item é inválido:" + id));

            
            restauranteRepository.deleteById(itemCardapio.getIdRestaurante());
    
            return "redirect:/index";
    }

    @GetMapping("/pedir/{id}")
    public String realizarPedido(@PathVariable("id") int id, HttpServletRequest request){
        ItemCardapio itemCardapio = itemCardapioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do pedido não foi encontrado: " + id));


        List<ItemCardapio> pedidos = (List<ItemCardapio>) request.getSession().getAttribute(SESSION_PEDIDOS);


        if (CollectionUtils.isEmpty(pedidos)) {
            pedidos = new ArrayList<>();
        }


        pedidos.add(itemCardapio);
        request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);


        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos")
        public String exibirPedidos(Model model, HttpServletRequest request){
        List<ItemCardapio> pedidos = (List<ItemCardapio>) request.getSession().getAttribute(SESSION_PEDIDOS);
        model.addAttribute("sessionPedidos", !CollectionUtils.isEmpty(pedidos) ? pedidos : new ArrayList<>());


        return "pedidos";
    }


}
