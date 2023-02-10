package com.minascafe.api.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos 
@Table(name = "cad_cafe_baixado")
public class Cafe_Baixado implements Serializable{

	private static final long serialVersionUID = 2069695207928350720L;

	@Id //Chave primária = Spring criará e gerenciará os identificadores únicos da tabela "cad_cafe_coco"
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
    private String observacoes;
    private String referencia;
	
    public Cafe_Baixado() {    	
    }
    
    public int getLote() {
		return lote;
	}
    
	public void setLote(int lote) {
		this.lote = lote;
	}
	
	@Column (name = "produtor", nullable = false) //*nullable* indica que o elemento anotado pode estar 'nulo' em algum momento
	public String getProdutor() {
		return produtor;
	}
	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	
	@Column (name = "status", nullable = true)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column (name = "data", nullable = false)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Column (name = "sacas", nullable = false)
	public int getSacas() {
		return sacas;
	}
	public void setSacas(int sacas) {
		this.sacas = sacas;
	}
	
	@Column (name = "quilos", nullable = false)
	public double getQuilos() {
		return quilos;
	}
	public void setQuilos(double quilos) {
		this.quilos = quilos;
	}
	
	@Column (name = "barracao", nullable = true)
	public int getBarracao() {
		return barracao;
	}
	public void setBarracao(int barracao) {
		this.barracao = barracao;
	}
	
	@Column (name = "subproduto", nullable = true)
	public String getSubproduto() {
		return subproduto;
	}
	public void setSubproduto(String subproduto) {
		this.subproduto = subproduto;
	}
	
	@Column (name = "numero_nota", nullable = true)
	public int getNumero_nota() {
		return numero_nota;
	}
	public void setNumero_nota(int numero_nota) {
		this.numero_nota = numero_nota;
	}
	
	@Column (name = "classificacao", nullable = true)
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	@Column (name = "catacao", nullable = true)
	public int getCatacao() {
		return catacao;
	}
	public void setCatacao(int catacao) {
		this.catacao = catacao;
	}
	
	@Column (name = "peneira", nullable = true)
	public int getPeneira() {
		return peneira;
	}
	public void setPeneira(int peneira) {
		this.peneira = peneira;
	}
	
	@Column (name = "lancado", nullable = true)
	public String getLancado() {
		return lancado;
	}
	public void setLancado(String lancado) {
		this.lancado = lancado;
	}
	
	@Column (name = "observacoes", nullable = true)
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	@Column (name = "referencia", nullable = true)
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override
	public String toString() { //retorna uma representação string de um objeto
		return "Cafe_Baixado [lote=" + lote + ", produtor=" + produtor + ", status=" + status + ", data=" + data
				+ ", sacas=" + sacas + ", quilos=" + quilos + ", barracao=" + barracao + ", subproduto=" + subproduto
				+ ", numero_nota=" + numero_nota + ", classificacao=" + classificacao + ", catacao=" + catacao
				+ ", peneira=" + peneira + ", lancado=" + lancado + ", observacoes=" + observacoes + ", referencia="
				+ referencia + "]";
	}    
	
}