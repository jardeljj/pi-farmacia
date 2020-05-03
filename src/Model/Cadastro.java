/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PC-adim
 */
public class Cadastro {
    
    private int Cpf;
    private String Usuario;
    private String Senha;
    private String ConfirmarSenha;

    /**
     * @return the Cpf
     */
    public int getCpf() {
        return Cpf;
    }

    /**
     * @param Cpf the Cpf to set
     */
    public void setCpf(int Cpf) {
        this.Cpf = Cpf;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param Senha the Senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    /**
     * @return the ConfirmarSenha
     */
    public String getConfirmarSenha() {
        return ConfirmarSenha;
    }

    /**
     * @param ConfirmarSenha the ConfirmarSenha to set
     */
    public void setConfirmarSenha(String ConfirmarSenha) {
        this.ConfirmarSenha = ConfirmarSenha;
    }

   
    
}
