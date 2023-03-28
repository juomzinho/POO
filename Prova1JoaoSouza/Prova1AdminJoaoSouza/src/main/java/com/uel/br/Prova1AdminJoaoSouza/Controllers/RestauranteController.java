package com.uel.br.Prova1AdminJoaoSouza.Controllers;

import com.uel.br.Prova1AdminJoaoSouza.Models.ItemCardapioRepository;
import com.uel.br.Prova1AdminJoaoSouza.Models.Restaurante;
import com.uel.br.Prova1AdminJoaoSouza.Controllers.RestauranteController;
import com.uel.br.Prova1AdminJoaoSouza.Models.RestauranteRepository;

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

    @GetMapping("/novo-restaurante")
    public String formNovoRestaurante(Restaurante restaurante){
        return "novo-restaurante";
    }


    @PostMapping("/adicionar-restaurante")
    public String adicionarRestaurante(@Valid Restaurante restaurante, BindingResult result){
        if(result.hasErrors()){
            return "/novo-restaurante";
        } 
        
        restauranteRepository.save(restaurante);
        return("redirect:/index");
    }

    @GetMapping("/editar/{id}")
    public String formAlterarRestaurante(@PathVariable("id") int id, Model model){
        Restaurante restaurante = restauranteRepository.findById(id) .orElseThrow(() -> 
            new IllegalArgumentException("Id de restaurante inválido" + id));

        model.addAttribute("restaurante", restaurante);
        return "atualizar-restaurante";
    }
    

    @PostMapping("/atualizar/{id}")
    public String atualizarRestaurante(@PathVariable("id") int id, @Valid Restaurante restaurante,
        BindingResult result, Model model){
            if(result.hasErrors()){
                restaurante.setId(id);
                return "atualizar-restaurante";
            }

            restauranteRepository.save(restaurante);
            return "redirect:/index";
    }


        @Transactional
        @GetMapping("/excluir/{id}")
        public String removerRestaurante(@PathVariable("id") int id, HttpServletRequest request) {
            restauranteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("O id do restaurante é inválido:" + id));


            restauranteRepository.deleteById(id);
    
            return "redirect:/index";
        }
    
}
