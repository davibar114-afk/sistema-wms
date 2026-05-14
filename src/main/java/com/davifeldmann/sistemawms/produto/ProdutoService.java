package com.davifeldmann.sistemawms.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final
    ProdutoRepository produtoRepository;

    // ==========================
    // CRIAR PRODUTO
    // ==========================
    public Produto criarProduto(Produto produto) {

        // Regra: SKU não pode duplicar
        if (produtoRepository.existsBySku(produto.getSku())) {
            throw new RuntimeException("Já existe um produto com esse SKU");
        }

        return produtoRepository.save(produto);
    }

    // ==========================
    // BUSCAR POR ID
    // ==========================
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // ==========================
    // LISTAR TODOS
    // ==========================
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // ==========================
    // ATUALIZAR PRODUTO
    // ==========================
    public Produto atualizarProduto(Long id, Produto novoProduto) {
        Produto produto = buscarPorId(id);

        // Regra: não permitir trocar SKU por um já existente
        if (!produto.getSku().equals(novoProduto.getSku()) && produtoRepository.existsBySku(novoProduto.getSku())) {
            throw new RuntimeException("Já existe um produto com esse SKU");
        }

        produto.setSku(novoProduto.getSku());
        produto.setNome(novoProduto.getNome());
        produto.setDescricao(novoProduto.getDescricao());
        produto.setCategoria(novoProduto.getCategoria());
        produto.setUnidade(novoProduto.getUnidade());
        produto.setQuantidadeMinima(novoProduto.getQuantidadeMinima());
        produto.setPrecoCusto(novoProduto.getPrecoCusto());
        produto.setAtivo(novoProduto.getAtivo());

        return produtoRepository.save(produto);
    }

    // ==========================
    // ENTRADA DE ESTOQUE
    // ==========================
    public Produto entradaEstoque(String sku, Integer quantidade) {
        if (quantidade == null || quantidade <= 0) {
            throw new RuntimeException("Quantidade deve ser maior que zero");
        }

        Produto produto = produtoRepository.findBySku(sku)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setQuantidadeAtual(produto.getQuantidadeAtual() + quantidade);

        return produtoRepository.save(produto);
    }

    // ==========================
    // SAÍDA DE ESTOQUE
    // ==========================
    public Produto saidaEstoque(String sku, Integer quantidade) {
        if (quantidade == null || quantidade <= 0) {
            throw new RuntimeException("Quantidade deve ser maior que zero");
        }

        Produto produto = produtoRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getQuantidadeAtual() < quantidade) {
            throw new RuntimeException("Quantidade insuficiente em estoque");
        }

        produto.setQuantidadeAtual(produto.getQuantidadeAtual() - quantidade);

        return produtoRepository.save(produto);
    }

    // ==========================
    // ESTOQUE BAIXO
    // ==========================
    public List<Produto> listarEstoqueBaixo() {
        return produtoRepository.findProdutosComEstoqueBaixo();
    }

    // ==========================
    // DESATIVAR PRODUTO
    // ==========================
    public void desativarProduto(Long id) {
        Produto produto = buscarPorId(id);
        produto.setAtivo(false);
        produtoRepository.save(produto);    }
}