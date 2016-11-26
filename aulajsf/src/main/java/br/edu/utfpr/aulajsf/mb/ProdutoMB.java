package br.edu.utfpr.aulajsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.utfpr.aulajsf.model.Produto;

@ManagedBean(name="produtoMB")
@ViewScoped
public class ProdutoMB implements Serializable {

	private static final long serialVersionUID = 2950222347783415712L;
	
	private Produto produto;
	private List<Produto> produtos;
	
	@PostConstruct
	public void init(){
		setProdutos(new ArrayList<>());
		produto = new Produto();
	}

	public void adicionar(){
		getProdutos().add(this.getProduto());
		produto = new Produto();
	}
	
	public void editar(Produto Produto){
		this.produto = Produto;
	}
	
	public void remover(Produto Produto){
		this.produtos.remove(Produto);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto Produto) {
		this.produto = Produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
