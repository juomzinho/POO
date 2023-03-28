package com.uel.br.Prova1ConsumidorJoaoSouza.Controllers;

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
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.Pedido;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.Restaurante;
import com.uel.br.Prova1ConsumidorJoaoSouza.Models.RestauranteRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PedidoController {
    
    private static final String SESSION_PEDIDOS ="sessionPedidos";

    @Autowired
    ItemCardapioRepository itemCardapioRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping("/pedir/{id}")
    public String realizarPedido(@PathVariable("id") int id, HttpServletRequest request){
        ItemCardapio itemCardapio = itemCardapioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O id do item não foi encontrado: " + id));

        Restaurante restaurante = restauranteRepository.findById(itemCardapio.getIdRestaurante())
            .orElseThrow(() -> new IllegalArgumentException("O id do restaurante não foi encontrado: " + id));


        List<Pedido> pedidos = (List<Pedido>)request.getSession().getAttribute(SESSION_PEDIDOS);

        Pedido pedido = new Pedido(id, itemCardapio.getNome(), restaurante.getNome(), 1, itemCardapio.getPreco());

        if (CollectionUtils.isEmpty(pedidos)) {
            pedidos = new ArrayList<>();
            pedidos.add(pedido);
        }else{
            for(Pedido extractedPedido: pedidos){
                if(extractedPedido.getId() == pedido.getId()){
                    extractedPedido.setQuantidade(extractedPedido.getQuantidade() + 1);
                    request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);

                    return "redirect:/pedidos";
                }
            }
            pedidos.add(pedido);
        }



        request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);


        return "redirect:/pedidos";
    }

    @GetMapping("/aumentar/{id}")
    public String aumentar(@PathVariable("id") int id, HttpServletRequest request){
        List<Pedido> pedidos = (List<Pedido>)request.getSession().getAttribute(SESSION_PEDIDOS);

        for(Pedido extractedPedido: pedidos){
                if(extractedPedido.getId() == id){
                    extractedPedido.setQuantidade(extractedPedido.getQuantidade() + 1);
                    request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);

                    return "redirect:/pedidos";
                }
        }

        return "redirect:/pedidos";
    }

    @GetMapping("/diminuir/{id}")
    public String diminuir(@PathVariable("id") int id, HttpServletRequest request){
        List<Pedido> pedidos = (List<Pedido>)request.getSession().getAttribute(SESSION_PEDIDOS);

        for(Pedido extractedPedido: pedidos){
                if(extractedPedido.getId() == id){
                    if(extractedPedido.getQuantidade() == 1){
                        pedidos.remove(extractedPedido);
                        request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);

                        return "redirect:/pedidos";
                    }
                    extractedPedido.setQuantidade(extractedPedido.getQuantidade() - 1);
                    request.getSession().setAttribute(SESSION_PEDIDOS, pedidos);

                    return "redirect:/pedidos";
                }
        }

        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos")
    public String exibirPedidos(Model model, HttpServletRequest request){
        List<Pedido> pedidos = (List<Pedido>) request.getSession().getAttribute(SESSION_PEDIDOS);
        List<Pedido> newPedidos = new ArrayList<>();
        double precoTotal = 0;

        if(!CollectionUtils.isEmpty(pedidos)){
            for(Pedido pedido: pedidos){
                System.out.println(pedido.getNome() + " " + itemCardapioRepository.existsById(pedido.getId()));
                if(!itemCardapioRepository.existsById(pedido.getId())){
                    // pedidos.remove(pedido);
                }else{
                    pedido.setNome(itemCardapioRepository.nomeById(pedido.getId()));
                    pedido.setPreco(itemCardapioRepository.precoById(pedido.getId()));
                    precoTotal = precoTotal + (pedido.getPreco() * pedido.getQuantidade());
                    newPedidos.add(pedido);
                }
            }
        };
        
        request.getSession().setAttribute(SESSION_PEDIDOS, newPedidos);
        model.addAttribute("precoTotal", precoTotal);
        model.addAttribute("sessionPedidos", !CollectionUtils.isEmpty(newPedidos) ? newPedidos : new ArrayList<>());

        return "pedidos";
    }


}
