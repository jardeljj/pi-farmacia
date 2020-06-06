/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CarrinhoCompra;
import Model.ProdutoCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fcane
 */
public class PedidoDAO {
    
    public static boolean salvar(CarrinhoCompra c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            int id = 0;
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO pedido (cliente, total, inclusao) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setInt(1, 1);
            instrucaoSQL.setDouble(2, c.getTotal());
            instrucaoSQL.setDate(3, new java.sql.Date(c.getDataCriacao().getTime()));

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Falha ao obter o ID do pedido.");
                }
                salvarItensPedido(id, c);
            } else {
                retorno = false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        return retorno;
    }

    private static void salvarItensPedido(int id, CarrinhoCompra c) {
        for (ProdutoCarrinho p : c.getProdutos()) {
            salvarItem(id, p);
        }
    }

    private static boolean salvarItem(int id, ProdutoCarrinho p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO pedido_item (id_venda, id_produto, preco, quantidade, total) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setInt(1, id);
            instrucaoSQL.setInt(2, p.getId());
            instrucaoSQL.setDouble(3, p.getPreco());
            instrucaoSQL.setInt(4, p.getQuantidade());
            instrucaoSQL.setDouble(5, p.getTotal());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        return retorno;
    }
}
