package br.edu.utfpr.aulajsf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.aulajsf.model.TipoProduto;

public interface TipoProdutoRepository 
		extends JpaRepository<TipoProduto, Long>{

}
