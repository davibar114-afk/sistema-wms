package com.davifeldmann.sistemawms.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    // ==========================
    // CRIAR PRODUTO
    // ==========================
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    // ==========================
    // LISTAR PRODUTOS
    // ==========================
    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    // ==========================
    // BUSCAR PRODUTO POR ID
    // ==========================
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    // ==========================
    // ATUALIZAR PRODUTO
    // ==========================
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    // ==========================
    // ENTRADA DE ESTOQUE
    // ==========================
    @PostMapping("/entrada")
    public Produto entrada(@RequestParam String sku, @RequestParam Integer quantidade) {
        return produtoService.entradaEstoque(sku, quantidade);
    }

    // ==========================
    // SAÍDA DE ESTOQUE
    // ==========================
    @PostMapping("/saida")
    public Produto saida(@RequestParam String sku, @RequestParam Integer quantidade) {
        return produtoService.saidaEstoque(sku, quantidade);
    }

    // ==========================
    // ESTOQUE BAIXO
    // ==========================
    @GetMapping("/estoque-baixo")
    public List<Produto> estoqueBaixo() {
        return produtoService.listarEstoqueBaixo();
    }

    // ==========================
    // DESATIVAR PRODUTO
    // ==========================
    @DeleteMapping("/{id}")
    public void desativar(@PathVariable Long id) {
        produtoService.desativarProduto(id);
    }
}