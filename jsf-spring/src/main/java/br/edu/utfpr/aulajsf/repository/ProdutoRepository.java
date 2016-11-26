package br.edu.utfpr.aulajsf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.aulajsf.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
