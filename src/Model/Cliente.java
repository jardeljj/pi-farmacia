/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author PC-adim
 */
public class Cliente {
    
    private int cpf;
    private String nome;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private Date idade;
    private int telefone;
    private String sexo;

    /**
     * @return the cpf
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * @param Cpf the cpf to set
     */
    public void setCpf(int Cpf) {
        this.cpf = Cpf;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.nome = Nome;
    }

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.endereco = Endereco;
    }

    /**
     * @return the Bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param Bairro the Bairro to set
     */
    public void setBairro(String Bairro) {
        this.bairro = Bairro;
    }

    /**
     * @return the Cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param Cidade the Cidade to set
     */
    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    /**
     * @return the Idade
     */
    public Date getIdade() {
        return idade;
    }

    /**
     * @param Idade the Idade to set
     */
    public void setIdade(Date Idade) {
        this.idade = Idade;
    }

    /**
     * @return the Telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(int Telefone) {
        this.telefone = Telefone;
    }

    /**
     * @return the Sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param Sexo the Sexo to set
     */
    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

   
}
