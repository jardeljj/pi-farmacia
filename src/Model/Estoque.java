package Model;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fcane
 */
public class Estoque {
    public int idProduto;
    public long qtdEstoque;
    public Date dataAtualizacao;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public long getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(long qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
}
