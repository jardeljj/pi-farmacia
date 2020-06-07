/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CarrinhoCompra;
import Model.Produto;
import Model.ProdutoCarrinho;

/**
 *
 * @author fcane
 */
public class EstoqueDAO {

    public static boolean temEstoque(ProdutoCarrinho produto, CarrinhoCompra carrinho) {
        boolean estoque = false;
        int quantidade = produto.getQuantidade();
        for (ProdutoCarrinho p : carrinho.getProdutos()) {
            if (produto.getId() == p.getId()) {
                quantidade += p.getQuantidade();
                break;
            }
        }
        
        Produto produtoBanco = ProdutoDAO.retornarId(produto.getId());
        
        if (produtoBanco != null && produtoBanco.getEstoque() > quantidade) {
            estoque = true;
        }
        
        return estoque;
    }
    
    public static void removeQtdEstoque(CarrinhoCompra carrinho) {
        for (ProdutoCarrinho produto : carrinho.getProdutos()) {
            Produto produtoBanco = ProdutoDAO.retornarId(produto.getId());
            if (produtoBanco != null) {
                produtoBanco.setEstoque(produtoBanco.getEstoque() - produto.getQuantidade());
                ProdutoDAO.atualizar(produtoBanco);
            }
        }
    }
}
