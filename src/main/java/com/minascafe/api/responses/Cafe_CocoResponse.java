package com.minascafe.api.responses;

import java.util.ArrayList;
import java.util.List;

public class Cafe_CocoResponse <T>{ //'T'- Na instanciação da Classe, permite que você passe qualquer classe para ela  
	
	private T data; //data (dados) do tipo 'T'. Será sempre o retorno do tipo de response que eu estou trabalhando.--Será usado para casos de sucesso
	private List<String> errors; //Será usado para salvar os erros que possam vir a ocorrer. 

	public Cafe_CocoResponse() {		
	}
	
	public T getData() { //Acessores getters e setters
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<String> getErrors(){
		if(this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}
}
