package br.edu.utfpr.aulajsf.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import br.edu.utfpr.aulajsf.model.TipoProduto;
import br.edu.utfpr.aulajsf.repository.TipoProdutoRepository;

@Controller("tipoProdutoFormMB")
@RequestScope
public class TipoProdutoFormMB implements Serializable {

	private static final long serialVersionUID = 2950222347783415712L;
	
	private TipoProduto tipoProduto;
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@PostConstruct
	public void init(){
		tipoProduto = new TipoProduto();
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			tipoProdutoRepository.save(tipoProduto);
			tipoProduto = new TipoProduto();
			context.addMessage(null, new FacesMessage
									(FacesMessage.SEVERITY_INFO, 
										"Salvo com sucesso", 
										"Tipo de produto salvo com sucesso"
									)
								);
		}catch (ConstraintViolationException e) {
			e.getConstraintViolations().forEach(erro->{
				 FacesMessage message = new FacesMessage(
						 	FacesMessage.SEVERITY_ERROR, 
							erro.getMessage(), 
							"");
				context.addMessage(erro.getPropertyPath().toString(),
							message);	
				
			});
			return "";
		}
		return "tipoProdutoList";
	}
	
	public String editar(TipoProduto tipoProduto){
		this.tipoProduto = tipoProdutoRepository.findOne(tipoProduto.getCodigo());
		return "tipoProdutoForm";
	}
	
	public String remover(){
		tipoProdutoRepository.delete(tipoProduto);
		return "tipoProdutoList";
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
}
