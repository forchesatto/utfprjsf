package br.edu.utfpr.aulajsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.utfpr.aulajsf.model.TipoProduto;

@FacesConverter(value="tipoProdutoConverter", forClass=TipoProduto.class)
public class TipoProdutoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()){
			return null;
		}
		TipoProduto tipoProduto = new TipoProduto();
		tipoProduto.setCodigo(Long.valueOf(value));
		return tipoProduto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return null; 
		}
		return ((TipoProduto)value).getCodigo().toString();
	}

}
