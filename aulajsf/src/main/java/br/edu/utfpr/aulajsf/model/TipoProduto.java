package br.edu.utfpr.aulajsf.model;

import java.time.LocalDate;

public class TipoProduto {

	private String nome;
	private Double valorMinimo;
	private LocalDate dataVencimento;
	
	public TipoProduto(){
		
	}
	
	public TipoProduto(String nome, Double valorMinimo) {
		super();
		this.nome = nome;
		this.valorMinimo = valorMinimo;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
