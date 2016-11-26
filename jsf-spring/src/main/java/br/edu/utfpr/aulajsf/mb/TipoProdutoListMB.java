package br.edu.utfpr.aulajsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import br.edu.utfpr.aulajsf.model.TipoProduto;
import br.edu.utfpr.aulajsf.repository.TipoProdutoRepository;

@Controller("tipoProdutoListMB")
@RequestScope
public class TipoProdutoListMB implements Serializable {

	private static final long serialVersionUID = 2950222347783415712L;
	
	private List<TipoProduto> tiposProdutos;
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@PostConstruct
	public void init(){
		setTiposProdutos(tipoProdutoRepository.findAll());
	}

	public List<TipoProduto> getTiposProdutos() {
		return tiposProdutos;
	}

	public void setTiposProdutos(List<TipoProduto> tiposProdutos) {
		this.tiposProdutos = tiposProdutos;
	}
	
}
