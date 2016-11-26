package br.edu.utfpr.aulajsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.utfpr.aulajsf.model.TipoProduto;

@ManagedBean(name="tipoProdutoMB")
@ViewScoped
public class TipoProdutoMB implements Serializable {

	private static final long serialVersionUID = 2950222347783415712L;
	
	private TipoProduto tipoProduto;
	private List<TipoProduto> tiposProdutos;
	
	@PostConstruct
	public void init(){
		setTiposProdutos(new ArrayList<>());
		tipoProduto = new TipoProduto();
	}

	public void adicionar(){
		getTiposProdutos().add(this.getTipoProduto());
		tipoProduto = new TipoProduto();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage
								(FacesMessage.SEVERITY_INFO, 
									"Salvo com sucesso", 
									"Tipo de produto salvo com sucesso"
								)
							);
	}
	
	public void editar(TipoProduto tipoProduto){
		this.tipoProduto = tipoProduto;
	}
	
	public void remover(TipoProduto tipoProduto){
		this.tiposProdutos.remove(tipoProduto);
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<TipoProduto> getTiposProdutos() {
		return tiposProdutos;
	}

	public void setTiposProdutos(List<TipoProduto> tiposProdutos) {
		this.tiposProdutos = tiposProdutos;
	}
	
}
