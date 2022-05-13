package com.generation.minhalojagames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.minhalojagames.model.ProdutoModel;

	@Repository
	public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

	/**
	 * Método Personalizado - Buscar todos os Produtos cujo o preço seja maior do
	 * que um valor digitado ordenado pelo preço em ordem crescente
	 * 
	 * MySQL: select * from tb_produtos where preco > preco order by preco;
	 */

	public List<ProdutoModel> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);

	/**
	 * Método Personalizado - Buscar todos os Produtos cujo o preço seja menor do
	 * que um valor digitado ordenado pelo preço em ordem decrescente
	 * 
	 * MySQL: select * from tb_produtos where preco < preco order by preco desc;
	 */

	public List<ProdutoModel> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);

}
