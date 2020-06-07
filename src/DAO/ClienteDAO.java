package DAO;


/*

@autor Bruno Martins de Almeida
Classe para persistencia com Banco de Dados

*/


import Model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ClienteDAO {
    
    public static boolean salvar(Cliente clienteDados) throws SQLException{
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement insertSQL = null;
        
        try{
            
            conexao = GerenciadorConexao.abrirConexao();
            insertSQL = conexao.prepareStatement(" INSERT INTO Cliente(cpf,nome,endereco,numero,bairro,cidade,idade,"
                                                          + "telefone,sexo,email,estadoCivil)" 
                                                          +  " VALUES (?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                  
            insertSQL.setString(1, clienteDados.getCpf());
            insertSQL.setString(2, clienteDados.getNome());
            insertSQL.setString(3, clienteDados.getEndereco());
            insertSQL.setString(4, clienteDados.getNumero());
            insertSQL.setString(5, clienteDados.getBairro());
            insertSQL.setString(6, clienteDados.getCidade());
            insertSQL.setDate(7, (Date) clienteDados.getIdade());
            insertSQL.setString(8, clienteDados.getTelefone());
            insertSQL.setString(9, clienteDados.getSexo());
            insertSQL.setString(10, clienteDados.getEmail());
            insertSQL.setString(11, clienteDados.getEstadoCivil());
                int linhasAfetadas = insertSQL.executeUpdate();
          
          if(linhasAfetadas>0)
            {
              retorno = true;

               ResultSet generatedKeys = insertSQL.getGeneratedKeys(); //Recupero o ID do cliente
                    if (generatedKeys.next()) {
                        clienteDados.setId(generatedKeys.getInt(1));
                    } 
                    else {
                        
                      throw new SQLException("Falha ao obter o ID do cliente.");
                      
                    }    
            } 
          else {
              
              retorno = false;
              
          }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            
            try {
                if(insertSQL!=null)
                    
                    insertSQL.close();
                
                      GerenciadorConexao.fecharConexao(conexao,insertSQL);
          
                
               } catch (SQLException ex) {
                
             }
        }
     
        return retorno;         
   }
    
    
    public static ArrayList<Cliente> consultarCliente(String cpf) {
        
        ResultSet resultadoConsulta = null;
        
        Connection conexao = null;
        PreparedStatement consultaSQL = null;
        
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            consultaSQL = conexao.prepareStatement(" SELECT * FROM Cliente WHERE cpf LIKE ?;");
            
            consultaSQL.setString(1, cpf + "%");
            
            resultadoConsulta = consultaSQL.executeQuery();
                
             
            while(resultadoConsulta.next())
                    {
                        Cliente cliente = new Cliente();
                        cliente.setId(resultadoConsulta.getInt("id"));
                        cliente.setCpf(resultadoConsulta.getString("cpf"));
                        cliente.setNome(resultadoConsulta.getString("nome"));
                        cliente.setEndereco(resultadoConsulta.getString("endereco"));
                        cliente.setNumero(resultadoConsulta.getString("numero"));
                        cliente.setBairro(resultadoConsulta.getString("bairro"));
                        cliente.setCidade(resultadoConsulta.getString("cidade"));
                        cliente.setIdade(resultadoConsulta.getDate("idade"));
                        cliente.setTelefone(resultadoConsulta.getString("telefone"));
                        cliente.setSexo(resultadoConsulta.getString("sexo"));
                        cliente.setEmail(resultadoConsulta.getString("email"));
                        cliente.setEstadoCivil(resultadoConsulta.getString("estadoCivil"));
                        listaClientes.add(cliente);
                        
                    } 
        }catch(SQLException ex) {
                System.out.println(ex.getMessage());
                listaClientes = null;
                
               } finally{
                            
                              try {
                            
                if(resultadoConsulta!= null)
                    resultadoConsulta.close();
        
                if(consultaSQL!=null)
                    consultaSQL.close();
                
                GerenciadorConexao.fecharConexao(conexao,consultaSQL);
            } catch (SQLException ex) {
             
            }                            
        }
        return listaClientes;
    }
   
    public static boolean atualizar(Cliente clienteDados){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement updateSQL = null;
        
        try{
            
            conexao = GerenciadorConexao.abrirConexao();
            updateSQL = conexao.prepareStatement("UPDATE Cliente SET cpf = ?, nome = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?,"
                                                                 + " idade = ?, telefone = ?, sexo = ?, email = ?, estadoCivil = ?"
                                                                 + " WHERE id = ? ");
            
            updateSQL.setString(1, clienteDados.getCpf());
            updateSQL.setString(2, clienteDados.getNome());
            updateSQL.setString(3, clienteDados.getEndereco());
            updateSQL.setString(4, clienteDados.getNumero());
            updateSQL.setString(5, clienteDados.getBairro());
            updateSQL.setString(6, clienteDados.getCidade());
            updateSQL.setDate(7, (Date) clienteDados.getIdade());
            updateSQL.setString(8, clienteDados.getTelefone());
            updateSQL.setString(9, clienteDados.getSexo());
            updateSQL.setString(10, clienteDados.getEmail());
            updateSQL.setString(11, clienteDados.getEstadoCivil());
            updateSQL.setInt(12, clienteDados.getId());
            
                                                                    
            int linhasAfetadas = updateSQL.executeUpdate();
            
              if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        }finally{
    
            try {
                if(updateSQL!=null)
                    updateSQL.close();
                
                GerenciadorConexao.fecharConexao(conexao,updateSQL);
                
              } catch (SQLException ex) {
             }
        }
        return retorno;
    }
    
    public static boolean excluir(int idCliente){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement deleteSQL = null;
        
        try{
            conexao = GerenciadorConexao.abrirConexao();
            deleteSQL =  conexao.prepareStatement(" DELETE FROM Cliente WHERE id = ?");
            
            deleteSQL.setInt(1, idCliente);
            
            int linhasAfetadas = deleteSQL.executeUpdate();
            
             if(linhasAfetadas>0)
            {
                retorno = true;
            }
            else{
                retorno = false;
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
    
            try {
                if(deleteSQL!=null)
                    deleteSQL.close();
                
                GerenciadorConexao.fecharConexao(conexao,deleteSQL);
                
              } catch (SQLException ex) {
             }
        }
       return retorno; 
    }
    
}
