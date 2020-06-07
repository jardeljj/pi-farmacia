/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fcane
 */
public class ProdutoDAO {

    public static boolean excluir(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE id = ?");
            instrucaoSQL.setInt(1, p.getId());
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

    public static boolean salvar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, unidade, preco, validade, categoria, estoque) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getUnidade());
            instrucaoSQL.setDouble(3, p.getPreco());
            instrucaoSQL.setDate(4, new java.sql.Date(p.getValidade().getTime()));
            instrucaoSQL.setInt(5, p.getCategoria());
            instrucaoSQL.setInt(6, p.getEstoque());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID do produto.");
                }
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

    public static boolean atualizar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome = ?, unidade = ?, preco = ?, validade = ?, categoria = ?, estoque = ? WHERE id = ?");
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getUnidade());
            instrucaoSQL.setDouble(3, p.getPreco());
            instrucaoSQL.setDate(4, new java.sql.Date(p.getValidade().getTime()));
            instrucaoSQL.setInt(5, p.getCategoria());
            instrucaoSQL.setInt(6, p.getEstoque());
            instrucaoSQL.setInt(7, p.getId());
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
    
    public static Produto retornarId(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Produto produto = new Produto();

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT pro.*, cat.nome nome_categoria FROM produto pro left join categoria cat on pro.categoria = cat.id WHERE pro.id = ?");
            instrucaoSQL.setInt(1, id);
            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setValidade(rs.getDate("validade"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setNomeCategoria(rs.getString("nome_categoria"));
                break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            produto = null;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }

        return produto;
    }

    public static ArrayList<Produto> consultarProdutos(String nome) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean filtroNome = nome != null && !nome.isEmpty();

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            String query = "SELECT pro.*, cat.nome nome_categoria FROM produto pro left join categoria cat on pro.categoria = cat.id WHERE 1 = 1";

            if (filtroNome) {
                query += " AND pro.nome like ?";
            }

            instrucaoSQL = conexao.prepareStatement(query);
            if (filtroNome) {
                instrucaoSQL.setString(1, nome + "%");
            }

            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setUnidade(rs.getString("unidade"));
                p.setPreco(rs.getDouble("preco"));
                p.setValidade(rs.getDate("validade"));
                p.setCategoria(rs.getInt("categoria"));
                p.setEstoque(rs.getInt("estoque"));
                p.setNomeCategoria(rs.getString("nome_categoria"));

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
