/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fcane
 */
public class CategoriaDAO {

    public static boolean excluir(Categoria c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM categoria WHERE id = ?");
            instrucaoSQL.setInt(1, c.getId());
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

    public static Categoria retornarId(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Categoria categoria = new Categoria();

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM categoria WHERE id = ?");
            instrucaoSQL.setInt(1, id);
            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            categoria = null;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }

        return categoria;
    }

    public static ArrayList<Categoria> consultarCategoria(String nome) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean filtroNome = nome != null && !nome.isEmpty();

        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();

        try {
            conexao = GerenciadorConexao.abrirConexao();
            String query = "SELECT * FROM categoria WHERE 1 = 1";

            if (filtroNome) {
                query += " AND nome like ?";
            }

            instrucaoSQL = conexao.prepareStatement(query);
            if (filtroNome) {
                instrucaoSQL.setString(1, nome + "%");
            }

            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));

                listaCategorias.add(c);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaCategorias = null;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }

        return listaCategorias;
    }

    public static boolean atualizar(Categoria categoria) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE categoria SET nome = ? WHERE id = ?");
            instrucaoSQL.setString(1, categoria.getNome());
            instrucaoSQL.setInt(2, categoria.getId());
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

    public static boolean salvar(Categoria categoria) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO categoria (nome) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, categoria.getNome());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    categoria.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID da categoria.");
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
    
}
