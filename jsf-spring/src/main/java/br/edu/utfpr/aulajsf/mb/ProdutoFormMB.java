package br.edu.utfpr.aulajsf.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import br.edu.utfpr.aulajsf.model.Produto;
import br.edu.utfpr.aulajsf.repository.ProdutoRepository;
import lombok.Getter;
import lombok.Setter;

@Controller("produtoFormMB")
@RequestScope
@Getter
@Setter
public class ProdutoFormMB implements Serializable {

	private static final long serialVersionUID = 2950222347783415712L;
	
	private Produto produto;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void init(){
		produto = new Produto();
	}

	public String salvar(){
		produtoRepository.save(this.getProduto());
		produto = new Produto();
		return "produtoList";
	}
	
	public String editar(Produto produto){
		this.produto = produtoRepository.findOne(produto.getCodigo());
		return "produtoForm";
	}
	
	public String remover(){
		produtoRepository.delete(produto);
		return "produtoList";
	}
}
