package com.minascafe.api.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos
@Table(name = "cad_cafe_maquina")
public class Cafe_Maquina implements Serializable{

	private static final long serialVersionUID = 57352917407981597L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)//Auto incremento = Configurando o provedor de persistência q implementa a JPA seja o responsável junto com o MySQL de controlar os valores gerados para o identificar único
    private int lote;
    
    private String produtor;
    private String status;
    private Date data;
    private int sacas;
    private double quilos;
    private int barracao;
    private String subproduto;
    private int numero_nota;
    private String classificacao;
    private int catacao;
    private int peneira;
    private String lancado;
    private String referencia;
    private String observacoes;
	
    public int getLote() {
		return lote;
	}
	public void setLote(int lote) {
		this.lote = lote;
	}
	public String getProdutor() {
		return produtor;
	}
	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getSacas() {
		return sacas;
	}
	public void setSacas(int sacas) {
		this.sacas = sacas;
	}
	public double getQuilos() {
		return quilos;
	}
	public void setQuilos(double d) {
		this.quilos = d;
	}
	public int getBarracao() {
		return barracao;
	}
	public void setBarracao(int barracao) {
		this.barracao = barracao;
	}
	public String getSubproduto() {
		return subproduto;
	}
	public void setSubproduto(String subproduto) {
		this.subproduto = subproduto;
	}
	public int getNumero_nota() {
		return numero_nota;
	}
	public void setNumero_nota(int numero_nota) {
		this.numero_nota = numero_nota;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public int getCatacao() {
		return catacao;
	}
	public void setCatacao(int catacao) {
		this.catacao = catacao;
	}
	public int getPeneira() {
		return peneira;
	}
	public void setPeneira(int peneira) {
		this.peneira = peneira;
	}
	public String getLancado() {
		return lancado;
	}
	public void setLancado(String lancado) {
		this.lancado = lancado;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	@PreUpdate //executa o método anotado antes da entidade ser atualizada
	public void preUpdate() {
		data = new Date();
	}
	@PrePersist //executa o método anotado antes da entidade ser persistida
	public void prePersist() {
		final Date atual = new Date();
		data = atual;
	}
	
	@Override
	public String toString() { //retorna uma representação string de um objeto
		return "cafe_maquina [lote=" + lote + ", produtor=" + produtor + ", status=" + status + ", data=" + data
				+ ", sacas=" + sacas + ", quilos=" + quilos + ", barracao=" + barracao + ", subproduto=" + subproduto
				+ ", numero_nota=" + numero_nota + ", classificacao=" + classificacao + ", catacao=" + catacao
				+ ", peneira=" + peneira + ", lancado=" + lancado + ", referencia=" + referencia + ", observacoes="
				+ observacoes + "]";
	}
    
}