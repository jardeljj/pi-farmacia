/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author fcane
 */
public class ProdutoCarrinho extends Produto {
    int quantidade;
    double total;
    
    public ProdutoCarrinho() {
    }

    public ProdutoCarrinho(Produto produtoSelecionado) {
        setId(produtoSelecionado.getId());
        setNome(produtoSelecionado.getNome());
        setPreco(produtoSelecionado.getPreco());
        setUnidade(produtoSelecionado.getUnidade());
        setValidade(produtoSelecionado.getValidade());
        setCategoria(produtoSelecionado.getCategoria());
        setEstoque(produtoSelecionado.getEstoque());
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
