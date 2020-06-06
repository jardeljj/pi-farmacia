package Model;


import Model.ProdutoCarrinho;
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
    
    int id;
    Date dataCriacao;
    ArrayList<ProdutoCarrinho> produtos;
    Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setProdutos(ArrayList<ProdutoCarrinho> produtos) {
        this.produtos = produtos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public CarrinhoCompra() {
        this.produtos = new ArrayList<>();
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ProdutoCarrinho> getProdutos() {
        return produtos;
    }
    
    public void removerProduto(ProdutoCarrinho produto) {
        ArrayList<ProdutoCarrinho> novoProduto = new ArrayList<>();
        
        for (ProdutoCarrinho c : produtos) {
            if (c.getId() != produto.getId()) {
                novoProduto.add(c);
            }
        }
        
        produtos = novoProduto;
    }

    public void adicinarProduto(ProdutoCarrinho produto) {
        if (this.produtos == null)
            this.produtos = new  ArrayList<>();

        if (produto != null) {
            ProdutoCarrinho jaIncluido = null;
            for (ProdutoCarrinho c : produtos) {
                if (c.getId() == produto.getId())
                    jaIncluido = c;
            }
            if (jaIncluido != null) {
                jaIncluido.setQuantidade(jaIncluido.getQuantidade() + produto.getQuantidade());
                jaIncluido.setTotal(jaIncluido.getTotal()+ produto.getTotal());
            } else {
                this.produtos.add(produto);
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (ProdutoCarrinho c : produtos) {
            total += c.getTotal();
        }
        return total;
    }
    
}
