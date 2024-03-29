package com.minascafe.api.dtos;

import java.time.LocalDate;

public class CafeBaixadoDto {//Faz a conversão entre o que o usuário envia e a aplicação

    private int lote;
    private String produtor;
    private LocalDate data;
    private int sacas;
    private double quilos;
    private String subproduto;

    public CafeBaixadoDto() {
    }

    public int getLote()
    {
        return lote;
    }
    public void setLote(int lote)
    {
        this.lote = lote;
    }
    public String getProdutor()
    {
        return produtor;
    }
    public void setProdutor(String produtor)
    {
        this.produtor = produtor;
    }

    public LocalDate getData()
    {
        return data;
    }
    public void setData(LocalDate data)
    {
        this.data = data;
    }
    public int getSacas()
    {
        return sacas;
    }
    public void setSacas(int sacas)
    {
        this.sacas = sacas;
    }
    public double getQuilos()
    {
        return quilos;
    }
    public void setQuilos(double quilos)
    {
        this.quilos = quilos;
    }

    public String getSubproduto()
    {
        return subproduto;
    }
    public void setSubproduto(String subproduto)
    {
        this.subproduto = subproduto;
    }

    @Override //Garantindo que estou sobrescrevendo um método e não criando um novo
    public String toString() {
        return "CafeBaixado [lote=" + lote + ", produtor=" + produtor + ", data=" + data
                + ", sacas=" + sacas + ", quilos=" + quilos + ", subproduto=" + subproduto
                + "]";
    }
}