/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author fcane
 */
public class GerenciadorConexao {
    public static Connection abrirConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/pifarmacia?useTimezone=true&serverTimezone=UTC&useSSL=false";
            conexao = DriverManager.getConnection(URL, "root", "");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return conexao;    
    }
    
    public static void fecharConexao(Connection conexao, PreparedStatement instrucaoSQL) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(instrucaoSQL!=null)
                instrucaoSQL.close();
            conexao.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
