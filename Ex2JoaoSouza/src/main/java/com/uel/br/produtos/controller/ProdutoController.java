package com.uel.br.produtos.controller;

import com.uel.br.produtos.model.Produto;
import com.uel.br.produtos.model.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@Controller
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value={"/index", "/"})
    public String exibir(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "index";
    }

    @GetMapping("/novo-produto")
    public String novoProduto(Produto produto){
        return "adicionar-produto";
    }

    @PostMapping("/adicionar-produto")
    public String adicionarProduto(@Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "adicionar-produto";
        }

        produtoRepository.save(produto);
        return "redirect:/index";
    }

    @GetMapping("/editar/{id}")
    public String dadosProduto(@PathVariable("id") int id, Model model) {
        Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("O id do contato é inválido:" + id));


        model.addAttribute("produto", produto);
        return "alterar-produto";
    }

    @PostMapping("/alterar/{id}")
    public String alterarProduto(@PathVariable("id") int id,
        @Valid Produto produto, BindingResult result, Model model) {
        System.out.println("VEIo");
        if (result.hasErrors()) {
            produto.setId(id);
            System.out.println("Deu ruim");
            return "alterar-produto";
        }

        produtoRepository.save(produto);
        return "redirect:/index";
    }

    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") int id, Model model){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("" +
                        "Id inválido"));

        produtoRepository.delete(produto);

        model.addAttribute("produtos", produtoRepository.findAll());
        return "redirect:/index";
    }



}
