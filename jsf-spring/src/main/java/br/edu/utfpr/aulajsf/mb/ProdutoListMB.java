package br.edu.utfpr.aulajsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import br.edu.utfpr.aulajsf.model.Produto;
import br.edu.utfpr.aulajsf.repository.ProdutoRepository;
import lombok.Getter;
import lombok.Setter;

@Controller("produtoListMB")
@RequestScope
@Getter
@Setter
public class ProdutoListMB implements Serializable {

	private static final long serialVersionUID = 2950222347783415712L;
	
	private List<Produto> produtos;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void init(){
		setProdutos(produtoRepository.findAll());
	}

}
