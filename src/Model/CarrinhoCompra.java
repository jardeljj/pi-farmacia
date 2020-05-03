package Model;


import Model.Produto;
import java.util.ArrayList;
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
public class CarrinhoCompra {
    
    public Date dataCriacao;
    public ArrayList<Produto> produtos;
    
    public CarrinhoCompra() {
        this.produtos = new ArrayList<>();
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void adicinarProduto(Produto produto) {
        if (produto != null) {
            this.produtos.add(produto);
        }
    }
    
}
