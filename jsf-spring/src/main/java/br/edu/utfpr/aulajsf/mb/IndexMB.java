package br.edu.utfpr.aulajsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import br.edu.utfpr.aulajsf.model.Pessoa;

@Controller("indexMB")
@RequestScope
public class IndexMB implements Serializable {

	private static final long serialVersionUID = 2950222347783415712L;
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	@PostConstruct
	public void init(){
		setPessoas(new ArrayList<>());
		getPessoas().add(new Pessoa("André","123"));
		getPessoas().add(new Pessoa("João","456"));
		pessoa = new Pessoa();
	}
	
	public void botaoOK(){
		this.getPessoa().setNome(getPessoa().getNome().toUpperCase()+" Botão OK");
	}
	
	public void adicionarNome(){
		getPessoas().add(this.getPessoa());
		pessoa = new Pessoa();
	}
	
	public void editar(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public String tipoProduto(){
		return "tipoProduto.jsf";
	}
	
	public void remover(Pessoa pessoa){
		this.pessoas.remove(pessoa);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
