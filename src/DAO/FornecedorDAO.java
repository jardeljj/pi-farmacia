/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Fornecedor;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kinha
 */
public class FornecedorDAO {
    
     public static boolean excluir(Fornecedor p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM fornecedor WHERE id = ?");
            instrucaoSQL.setInt(1, p.getId());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if (linhasAfetadas > 0)
                retorno = true;
            else
                retorno = false;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        return retorno;
    }
    
    public static boolean salvar(Fornecedor p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO fornecedor (nome, CPF, telefone, item, valorTotal, qtd, dataEntrega) VALUES (?, ?, ?, ?, ?, ?, ?)", 
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, p.getnome());
            instrucaoSQL.setString(2, p.getCPF());
            instrucaoSQL.setString(3, p.gettelefone());
            instrucaoSQL.setString(4, p.getitem());
            instrucaoSQL.setDouble(5, p.getvalorTotal());
            instrucaoSQL.setInt(6, p.getqtd());
            instrucaoSQL.setDate(7, new java.sql.Date(p.getdataEntrega().getTime()));
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if (linhasAfetadas > 0){                
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do fornecedor.");
                }
            } else retorno = false;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        return retorno;
    }
    
    public static boolean atualizar(Fornecedor p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE fornecedor SET nome = ?, CPF = ?, telefone = ?, item = ?, valorTotal = ?, qtd = ?, dataEntrega = ? WHERE id = ?");
            instrucaoSQL.setString(1, p.getnome());
            instrucaoSQL.setString(2, p.getCPF());
            instrucaoSQL.setString(3, p.gettelefone());
            instrucaoSQL.setString(4, p.getitem());
            instrucaoSQL.setDouble(5, p.getvalorTotal());
            instrucaoSQL.setInt(6, p.getqtd());
            instrucaoSQL.setDate(7, new java.sql.Date(p.getdataEntrega().getTime()));
            instrucaoSQL.setInt(8, p.getId());
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if (linhasAfetadas > 0)
                retorno = true;
            else
                retorno = false;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        return retorno;
    }
        public static Fornecedor retornarId(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Fornecedor produto = new Fornecedor();

        try {
            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Fornecedor WHERE id = ?");
            instrucaoSQL.setInt(1, id);
            rs = instrucaoSQL.executeQuery();

            //Percorrer o resultSet
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setnome(rs.getString("nome"));
                produto.setCPF(rs.getString("CPF"));
                produto.settelefone(rs.getString("Telefone"));
                produto.setitem(rs.getString("Item"));
                produto.setvalorTotal(rs.getDouble("valorTotal"));
                produto.setqtd(rs.getInt("qtd"));
                produto.setdataEntrega(rs.getDate("dataEntrega"));
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
        
    
    public static ArrayList<Fornecedor> consultarFornecedor(String nome) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null; 
        boolean filtroNome = nome != null && !nome.isEmpty();
        
        ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
        
        try {
            conexao = GerenciadorConexao.abrirConexao();
            String query = "SELECT * FROM fornecedor WHERE 1 = 1";
            
            if(filtroNome) query += " AND nome like ?";
            
            instrucaoSQL = conexao.prepareStatement(query);
            if(filtroNome) instrucaoSQL.setString(1, nome + "%");

            rs = instrucaoSQL.executeQuery();
            
            //Percorrer o resultSet
            while(rs.next())
            {
                Fornecedor p = new Fornecedor();
                p.setId(rs.getInt("id"));
                p.setnome(rs.getString("nome"));
                p.setCPF(rs.getString("CPF"));
                p.settelefone(rs.getString("telefone"));
                p.setitem(rs.getString("item"));
                p.setvalorTotal(rs.getDouble("valorTotal"));
                p.setqtd(rs.getInt("qtd"));
                p.setdataEntrega(rs.getDate("dataEntrega"));
                
                listaFornecedores.add(p);
            }
            
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            listaFornecedores = null;
        } finally{
            GerenciadorConexao.fecharConexao(conexao, instrucaoSQL);
        }
        
        return listaFornecedores;
    }


    
}
