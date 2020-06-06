/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CarrinhoCompra;
import Model.Cliente;
import Model.Produto;
import Model.ProdutoCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
    
    public static ArrayList<CarrinhoCompra> consultarPedidos(Date dataInicio, Date dataFim, String cpf) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean filtroCPF = cpf != null && !cpf.isEmpty();

        ArrayList<CarrinhoCompra> listaPedidos = new ArrayList<>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            String query = "SELECT * FROM PEDIDO WHERE 1 = 1 AND inclusao BETWEEN ? AND ?" ;            
            if (filtroCPF) {
                query += " AND cli.cpf like ?";
            }
            
            query += " order by inclusao desc, id desc";

            instrucaoSQL = conexao.prepareStatement(query);
            
            instrucaoSQL.setDate(1, new java.sql.Date(dataInicio.getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(dataFim.getTime()));

            if (filtroCPF) {
                instrucaoSQL.setString(3, cpf + "%");
            }

            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                CarrinhoCompra p = new CarrinhoCompra();
                p.setId(rs.getInt("id"));
                p.setDataCriacao(rs.getDate("inclusao"));
                Cliente cliente = new Cliente();
                p.setCliente(cliente);
                listaPedidos.add(p);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaPedidos = null;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        
        listaPedidos = retornarColecaoProdutos(listaPedidos);

        return listaPedidos;
    }

    private static ArrayList<CarrinhoCompra> retornarColecaoProdutos(ArrayList<CarrinhoCompra> listaPedidos) {
        for (CarrinhoCompra c : listaPedidos) {
            c.setProdutos(retornarItens(c.getId()));
        }
        return listaPedidos;
    }

    private static ArrayList<ProdutoCarrinho> retornarItens(int idPedido) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<ProdutoCarrinho> listaProdutos = new ArrayList<ProdutoCarrinho>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT ite.*, pro.nome FROM pedido_item ite  inner join produto pro on ite.id_produto = pro.id WHERE ite.id_venda = ?");
            instrucaoSQL.setInt(1, idPedido);
            
            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                ProdutoCarrinho p = new ProdutoCarrinho();
                p.setId(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setTotal(rs.getDouble("total"));

                listaProdutos.add(p);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }

        return listaProdutos;
    }
}
