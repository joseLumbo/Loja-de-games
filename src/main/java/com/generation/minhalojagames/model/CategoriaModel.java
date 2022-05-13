package com.generation.minhalojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity // Entidade da classe --> define a classe
	@Table(name = "tb_categoria")
	public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para comentar que ele será auto incremento, serve como PK
	private Long id;
	
	@NotBlank (message = "O atríbuto tipo é obrigatório!") // Não aceita espaço vazio
	@Size(min = 5, max = 100, message = "O atríbuto tipo deve conter o minímo 5 e no máximo 100 caracteres")
	private String tipo; 
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)  
    @JsonIgnoreProperties("categoria")
    private List<ProdutoModel> produtos;

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

	public Long getId() { //servem para ter retornos
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}