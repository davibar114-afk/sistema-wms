package com.davifeldmann.sistemawms.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Verificar se SKU já existe
    boolean existsBySku(String sku);

    // Buscar produto por SKU
    Optional<Produto> findBySku(String sku);

    // Estoque baixo (custom query)
    @Query("""
        SELECT p FROM Produto p
        WHERE p.quantidadeAtual <= p.quantidadeMinima
""")
    List<Produto> findProdutosComEstoqueBaixo();
}