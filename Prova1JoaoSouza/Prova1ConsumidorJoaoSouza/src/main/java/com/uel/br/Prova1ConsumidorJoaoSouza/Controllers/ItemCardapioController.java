package com.uel.br.Prova1ConsumidorJoaoSouza.Controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapio;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.ItemCardapioRepository;

import com.uel.br.Prova1ConsumidorJoaoSouza.Models.Restaurante;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.RestauranteRepository;

import jakarta.servlet.http.HttpServletRequest;
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
    

    @GetMapping("/pedir/{id}")
    public String realizarPedido(@PathVariable("id") int id, HttpServletRequest request){
        ItemCardapio itemCardapio = itemCardapioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do pedido não foi encontrado: " + id));


        List<ItemCardapio> pedidos = (List<ItemCardapio>)request.getSession().getAttribute(SESSION_PEDIDOS);


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
