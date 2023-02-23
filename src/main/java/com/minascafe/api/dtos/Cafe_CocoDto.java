package com.minascafe.api.dtos;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotEmpty;

public class Cafe_CocoDto {
	
    private int lote;	
	private String produtor;
	private Date data;
	private int sacos;
	private double quilos;
	
	public Cafe_CocoDto() {		
	}
	
	public int getLote() {
		return lote;
	}
	public void setLote(int lote) {
		this.lote = lote;
	}
	
	@NotEmpty(message = "O nome não pode ser vazio.") // Regra de validação - O nome do produtor não pode ser vazio 
	@Length(min = 3, max = 40, message = "O nome do produtor deve conter entre 3 e 40 caracteres.")		
	public String getProdutor() {
		return produtor;
	}
	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	
	@NotEmpty(message = "A data não pode ser vazia.")
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getSacos() {
		return sacos;
	}
	public void setSacos(int sacos) {
		this.sacos = sacos;
	}
	public double getQuilos() {
		return quilos;
	}
	public void setQuilos(double quilos) {
		this.quilos = quilos;
	}	
	
	@Override
	public String toString() {
		return "Cafe_Coco [lote=" + lote + ", produtor=" + produtor + ", data=" + data
				+ ", sacos=" + sacos + ", quilos=" + quilos + ", subproduto=" + "]";
	}	
}