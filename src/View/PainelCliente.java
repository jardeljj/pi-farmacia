
package View;

import DAO.ClienteDAO;
import Model.Cliente;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PainelCliente extends javax.swing.JInternalFrame {
     
    public String modoTela = "Criação";
    
    Cliente clienteDados;
    
    DefaultTableModel t = new DefaultTableModel();
    
  public PainelCliente() {
      
        initComponents();
        
        clienteDados = new Cliente();
        
       jBSalvar.setEnabled(true);
       jTextNome.setEnabled(true);
       jBExcluir1.setEnabled(true);
       jBAlterar.setEnabled(true);
       txtCPFCliente.setEnabled(true);
       txtCPF.setEnabled(true);
       jFormattedTextIdade.setEnabled(true);
       jTextEndereco.setEnabled(true);
       jTextBairro.setEnabled(true);
       jTextCidade.setEnabled(true);
       jTextNumero.setEnabled(true);
       jComboBoxSexo.setEnabled(true);
       jComboBoxEstadoCivil.setEnabled(true);
       jTextTelefone.setEnabled(true);
       jTextEmail.setEnabled(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jTextEndereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextNumero = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter(" ######## ");

            jTextNumero = new javax.swing.JFormattedTextField(telefone);
        }catch(Exception e){
        }
        jTextBairro = new javax.swing.JTextField();
        jTextCidade = new javax.swing.JTextField();
        jComboBoxSexo = new javax.swing.JComboBox();
        jBAlterar = new javax.swing.JButton();
        jBConsultar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jBExcluir1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtCPFCliente = new javax.swing.JFormattedTextField();
        jFormattedTextIdade = new javax.swing.JFormattedTextField();
        jTextTelefone = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        lblEstadoCivil = new javax.swing.JLabel();
        jComboBoxEstadoCivil = new javax.swing.JComboBox<>();
        txtCPF = new javax.swing.JFormattedTextField();
        adicionarNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome Completo:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("CPF:");

        jLabel5.setText("Bairro:");

        jLabel6.setText("Idade:");

        jLabel7.setText("Sexo:");

        jLabel8.setText("Cidade:");

        jTextNome.setEnabled(false);
        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });

        jTextEndereco.setEnabled(false);

        jLabel9.setText("Número(CEP):");

        jTextNumero.setEnabled(false);

        jTextBairro.setEnabled(false);

        jTextCidade.setEnabled(false);

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Masculino", "Feminino", "Não quero informar" }));
        jComboBoxSexo.setEnabled(false);
        jComboBoxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSexoActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar");
        jBAlterar.setEnabled(false);
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBConsultar.setText("Consultar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.setEnabled(false);
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cpf", "Nome", "Endereco", "Numero", "Bairro", "Cidade", "Idade", "Telefone", "Sexo", "E-mail", "Estado Civil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        jLabel12.setText("Telefone:");

        jBExcluir1.setText("Excluir");
        jBExcluir1.setEnabled(false);
        jBExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluir1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Consulte seu cadastro atráves do Cpf");

        try {
            txtCPFCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFCliente.setEnabled(false);
        txtCPFCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFClienteActionPerformed(evt);
            }
        });

        try {
            jFormattedTextIdade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextIdade.setEnabled(false);
        jFormattedTextIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextIdadeActionPerformed(evt);
            }
        });

        try {
            jTextTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblEmail.setText("Email:");

        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        lblEstadoCivil.setText("Estado Civil:");

        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Solteiro(a)", "Viuvo(a)", "Casado(a)", "Divorciado(a)" }));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        adicionarNovo.setText("Limpar Campos");
        adicionarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jTextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jFormattedTextIdade)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblEstadoCivil)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(adicionarNovo)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextTelefone))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jBConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(368, 368, 368))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jBExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCivil)
                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAlterar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBExcluir1)
                        .addComponent(jBCancelar)
                        .addComponent(jBSalvar)
                        .addComponent(adicionarNovo)))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBConsultar)
                    .addComponent(jLabel13)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Cadastro Cliente");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCPFClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFClienteActionPerformed
       
    }//GEN-LAST:event_txtCPFClienteActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
       
    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
       
         if(modoTela == "Criação"){
             
             
             
             if (!jTextNome.getText().trim().equals("") 
            & !jTextEndereco.getText().trim().equals("")
            & !jTextNumero.getText().trim().equals("")
            & !jTextBairro.getText().trim().equals("")
            & !jTextCidade.getText().trim().equals("")
            & !txtCPFCliente.getText().equals("   .   .   -  ")
            & !jFormattedTextIdade.getText().equals("  /  /    ") 
            & !jComboBoxSexo.getSelectedItem().equals("Nenhum")
            & !jComboBoxEstadoCivil.getSelectedItem().equals("Nenhum")   
            & !jTextTelefone.getText().equals("")
            & !jTextEmail.getText().trim().equals("")  ){ 

               
            
        
             String nome = jTextNome.getText();
             String email = jTextEmail.getText();
             String estadoCivil = (String) jComboBoxEstadoCivil.getSelectedItem();
             String endereco = jTextEndereco.getText();
             String numero = jTextNumero.getText();
             String bairro = jTextBairro.getText();
             String cidade = jTextCidade.getText();
             String sexo = (String) jComboBoxSexo.getSelectedItem();
            
             
             /* 
             @autor Bruno Martins
             Na aplicacão o campo CPF, vem formatado com " - " e " . " 
             Uso o replace para limpar estes caracteres e passar somente os números ao campo 
             
             */
             String cpfFormatado = txtCPFCliente.getText();
             String cpfLiso = cpfFormatado.replace(".","");
             cpfLiso = cpfLiso.replaceAll("-","");
             String cpf = cpfLiso;
             
                        
               /* 
             
             @autor Bruno Martins
             Na aplicacão o campo Telefone, vem formatado com " - "
             Uso o replace para limpar este caractere e passar somente os números ao campo 
             
             */
             String tel = jTextTelefone.getText();
             tel = tel.replaceAll("-","");
             String telefone = tel;
             
             
             
             // Formatar a data e convertendo a data para o sql
             SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
             String dataIdade = jFormattedTextIdade.getText();
             
             // @throws 
             try {
                 
                 clienteDados.setIdade(new java.sql.Date(formated.parse(dataIdade).getTime()));
                 
             } catch (ParseException ex) {
                 Logger.getLogger(PainelCliente.class.getName()).log(Level.SEVERE, null, ex);
                 
                 System.out.println(ex);
             }
             
             
             
             clienteDados.setNome(nome);
             clienteDados.setEmail(email);
             clienteDados.setEstadoCivil(estadoCivil);
             clienteDados.setEndereco(endereco);
             clienteDados.setNumero(numero);
             clienteDados.setBairro(bairro);
             clienteDados.setCidade(cidade);
             clienteDados.setCpf(cpf);
             clienteDados.setSexo(sexo);
             clienteDados.setTelefone(telefone);
           
            
             
             try {
                ClienteDAO.salvar(clienteDados);
                JOptionPane.showMessageDialog(this,"Cliente cadastrado com sucesso!","Inserido com sucesso!",JOptionPane.INFORMATION_MESSAGE);
                
            
        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Falha ao gravar, contate o administrador" + e.getMessage(), 
                                                "ERRO!", JOptionPane.ERROR_MESSAGE);
                 System.out.println(e.getMessage());
            }
             
           } else {
                 
                 JOptionPane.showMessageDialog(rootPane, "Para que o cadastro seja concluido, é obrigatório preenchimento de todos os campos!");    
                 
             }
          
        } else if(modoTela == "Alteração") {
             
                if (!jTextNome.getText().trim().equals("") 
            & !jTextEndereco.getText().trim().equals("")
            & !jTextNumero.getText().trim().equals("")
            & !jTextBairro.getText().trim().equals("")
            & !jTextCidade.getText().trim().equals("")
            & !txtCPFCliente.getText().equals("   .   .   -  ")
            & !jFormattedTextIdade.getText().equals("  /  /    ") 
            & !jComboBoxSexo.getSelectedItem().equals("Nenhum")
            & !jComboBoxEstadoCivil.getSelectedItem().equals("Nenhum")   
            & !jTextTelefone.getText().equals("")
            & !jTextEmail.getText().trim().equals("")  ){ 
           
                    
              
               
             
             String nome = jTextNome.getText();
             String email = jTextEmail.getText();
             String estadoCivil = (String) jComboBoxEstadoCivil.getSelectedItem();
             String endereco = jTextEndereco.getText();
             String numero = jTextNumero.getText();
             String bairro = jTextBairro.getText();
             String cidade = jTextCidade.getText();
             String sexo = (String) jComboBoxSexo.getSelectedItem();
             
             
             /* 
             @autor Bruno Martins
             Na aplicacão o campo CPF, vem formatado com " - " e " . " 
             Uso o replace para limpar estes caracteres e passar somente os números ao campo 
             
             */
             String cpfFormatado = txtCPFCliente.getText();
             String cpfLiso = cpfFormatado.replace(".","");
             cpfLiso = cpfLiso.replaceAll("-","");
             String cpf = cpfLiso;
             
                        
               /* 
             
             @autor Bruno Martins
             Na aplicacão o campo Telefone, vem formatado com " - "
             Uso o replace para limpar este caractere e passar somente os números ao campo 
             
             */
             String tel = jTextTelefone.getText();
             tel = tel.replaceAll("-","");
             String telefone = tel;
             
             
             
             // Formatar a data e convertendo a data para o sql
             SimpleDateFormat formated = new SimpleDateFormat("dd/MM/yyyy");
             String dataIdade = jFormattedTextIdade.getText();
             
             // @throws 
             try {
                 
                 clienteDados.setIdade(new java.sql.Date(formated.parse(dataIdade).getTime()));
                 
             } catch (ParseException ex) {
                 Logger.getLogger(PainelCliente.class.getName()).log(Level.SEVERE, null, ex);
                 
                 System.out.println(ex);
             }
             
             
             
             clienteDados.setNome(nome);
             clienteDados.setEmail(email);
             clienteDados.setEstadoCivil(estadoCivil);
             clienteDados.setEndereco(endereco);
             clienteDados.setNumero(numero);
             clienteDados.setBairro(bairro);
             clienteDados.setCidade(cidade);
             clienteDados.setCpf(cpf);
             clienteDados.setSexo(sexo);
             clienteDados.setTelefone(telefone);
            
             
                 try {
                 ClienteDAO.atualizar(clienteDados);
                JOptionPane.showMessageDialog(this,"Cliente alterado com sucesso!","Tudo Certo!",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Falha ao gravar, contate o administrador"+ e.getMessage(), 
                                                "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
                }  
           
         }
             
             
        if (jTextNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, " O campo Nome é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        } 
        
        if (jTextEndereco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, " O campo Endereço é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);        
        } 
        
        if (jTextNumero.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, " O campo Número é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);    
        } 
        
        if (jTextBairro.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, " O campo Bairro é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        } 
        
        if (jTextCidade.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, " O campo Cidade é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        }
       
        if (txtCPFCliente.getText().equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(null, " O campo CPF é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        }
        
        if (jFormattedTextIdade.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, " O campo Idade é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        }
        
        if (jComboBoxSexo.getSelectedItem().equals("Nenhum")){
            JOptionPane.showMessageDialog(null, " O campo Sexo é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        }
        
        if (jTextTelefone.getText().equals("     -    ")){
            JOptionPane.showMessageDialog(null, " O campo Telefone é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        }
        
        if (jTextEmail.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, " O campo Email é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        } 
        
         if (jComboBoxEstadoCivil.getSelectedItem().equals("Nenhum")){
            JOptionPane.showMessageDialog(null, " O campo Estado Civil é obrigatório, por favor preencha-o! ", " AVISO ",JOptionPane.WARNING_MESSAGE);
        }  
       
         
      
        
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluir1ActionPerformed
      
              if(tbCliente.getRowCount() > 0){
             
            
                     int linha = tbCliente.getSelectedRow();
            
            
             int idCli = Integer.parseInt(tbCliente.getModel().getValueAt(linha, 0).toString());
             String cpf = tbCliente.getModel().getValueAt(linha, 1).toString(); 
             String nome = tbCliente.getModel().getValueAt(linha, 2).toString(); 
             String endereco = tbCliente.getModel().getValueAt(linha, 3).toString(); 
             String numero = tbCliente.getModel().getValueAt(linha, 4).toString();
             String bairro = tbCliente.getModel().getValueAt(linha, 5).toString(); 
             String cidade = tbCliente.getModel().getValueAt(linha, 6).toString(); 
             String idade = tbCliente.getModel().getValueAt(linha, 7).toString(); 
             String telefone = tbCliente.getModel().getValueAt(linha, 8).toString(); 
             String sexo = tbCliente.getModel().getValueAt(linha, 9).toString(); 
             String email = tbCliente.getModel().getValueAt(linha, 10).toString(); 
             String estadoCivil = tbCliente.getModel().getValueAt(linha, 11).toString(); 
            
             clienteDados.setId(idCli);
             clienteDados.setNome(nome);
             clienteDados.setEmail(email);
             clienteDados.setEstadoCivil(estadoCivil);
             clienteDados.setEndereco(endereco);
             clienteDados.setNumero(numero);
             clienteDados.setBairro(bairro);
             clienteDados.setCidade(cidade);
             clienteDados.setCpf(cpf);
             clienteDados.setSexo(sexo);
             clienteDados.setTelefone(telefone);
           
 
             // Formatar a data e convertendo a data para o sql
             SimpleDateFormat formated = new SimpleDateFormat("yyyy-MM-dd");
             String dataIdade = idade;
             
             // @throws 
             try {
                 
                 clienteDados.setIdade(new java.sql.Date(formated.parse(dataIdade).getTime()));
                 
             } catch (ParseException ex) {
                 Logger.getLogger(PainelCliente.class.getName()).log(Level.SEVERE, null, ex);
                 
                 System.out.println(ex);
             }
            
             
             if(ClienteDAO.excluir(clienteDados.getId())){
                 
                  JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
             } else {
                 JOptionPane.showMessageDialog(this, "Falha o excluir!");
             }
             
            }else{
            JOptionPane.showMessageDialog(this, "Selecione um cliente da tabela!");
        }
        
    }//GEN-LAST:event_jBExcluir1ActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        
        modoTela = "Alteração";
        
        if(tbCliente.getRowCount() > 0){
            
            int linha = tbCliente.getSelectedRow();
            
            
             int idCli = Integer.parseInt(tbCliente.getModel().getValueAt(linha, 0).toString());
             String cpf = tbCliente.getModel().getValueAt(linha, 1).toString(); 
             String nome = tbCliente.getModel().getValueAt(linha, 2).toString(); 
             String endereco = tbCliente.getModel().getValueAt(linha, 3).toString(); 
             String numero = tbCliente.getModel().getValueAt(linha, 4).toString();
             String bairro = tbCliente.getModel().getValueAt(linha, 5).toString(); 
             String cidade = tbCliente.getModel().getValueAt(linha, 6).toString(); 
             String idade = tbCliente.getModel().getValueAt(linha, 7).toString(); 
             String telefone = tbCliente.getModel().getValueAt(linha, 8).toString(); 
             String sexo = tbCliente.getModel().getValueAt(linha, 9).toString(); 
             String email = tbCliente.getModel().getValueAt(linha, 10).toString(); 
             String estadoCivil = tbCliente.getModel().getValueAt(linha, 11).toString(); 
            
             clienteDados.setId(idCli);
             clienteDados.setNome(nome);
             clienteDados.setEmail(email);
             clienteDados.setEstadoCivil(estadoCivil);
             clienteDados.setEndereco(endereco);
             clienteDados.setNumero(numero);
             clienteDados.setBairro(bairro);
             clienteDados.setCidade(cidade);
             clienteDados.setCpf(cpf);
             clienteDados.setSexo(sexo);
             clienteDados.setTelefone(telefone);
           
 
             // Formatar a data e convertendo a data para o sql
             SimpleDateFormat formated = new SimpleDateFormat("yyyy-MM-dd");
             String dataIdade = idade;
             
             // @throws 
             try {
                 
                 clienteDados.setIdade(new java.sql.Date(formated.parse(dataIdade).getTime()));
                 
             } catch (ParseException ex) {
                 Logger.getLogger(PainelCliente.class.getName()).log(Level.SEVERE, null, ex);
                 
                 System.out.println(ex);
             }
            
             
  
        this.jTextNome.setText(clienteDados.getNome());
        this.jTextEmail.setText(clienteDados.getEmail());
        this.jComboBoxEstadoCivil.setSelectedItem(clienteDados.getEstadoCivil());
        this.jTextEndereco.setText(clienteDados.getEndereco());
        this.jTextNumero.setText(clienteDados.getNumero());
        this.jTextBairro.setText(clienteDados.getBairro());
        this.jTextCidade.setText(clienteDados.getCidade());
        this.txtCPFCliente.setText(clienteDados.getCpf());  
        
        this.jComboBoxSexo.setSelectedItem(clienteDados.getSexo());
        this.jTextTelefone.setText(clienteDados.getTelefone());
       
        
        // convertendo a data para texto, para ser setado no campo
        Date dataAtual = clienteDados.getIdade();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataAtual);
        this.jFormattedTextIdade.setText(dataFormatada);
        
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um cliente da tabela!");
        }

    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jFormattedTextIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextIdadeActionPerformed
        
    }//GEN-LAST:event_jFormattedTextIdadeActionPerformed

    private void jComboBoxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSexoActionPerformed
       
    }//GEN-LAST:event_jComboBoxSexoActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        
    }//GEN-LAST:event_jTextEmailActionPerformed

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
            
              
            ArrayList<Cliente> listaClientes = ClienteDAO.consultarCliente(txtCPF.getText());
            
           
            DefaultTableModel dadosCliente = new DefaultTableModel();
            
            dadosCliente.addColumn("id");
            dadosCliente.addColumn("Cpf");
            dadosCliente.addColumn("Nome");
            dadosCliente.addColumn("Endereco");
            dadosCliente.addColumn("Número");
            dadosCliente.addColumn("Bairro");
            dadosCliente.addColumn("Cidade");
            dadosCliente.addColumn("Idade");
            dadosCliente.addColumn("Telefone");
            dadosCliente.addColumn("Sexo");
            dadosCliente.addColumn("Email");
            dadosCliente.addColumn("Estado Civil");
            tbCliente.setModel(dadosCliente);
           
            tbCliente.removeColumn(tbCliente.getColumnModel().getColumn(0));
            
            
            
            dadosCliente.setRowCount(0);
            
            for( Cliente cli : listaClientes){
                
                dadosCliente.addRow(
                        new Object[]{
                            cli.getId(),
                            cli.getCpf(),
                            cli.getNome(),
                            cli.getEndereco(),
                            cli.getNumero(),
                            cli.getBairro(),
                            cli.getCidade(),
                            cli.getIdade(),
                            cli.getTelefone(),
                            cli.getSexo(),
                            cli.getEmail(),
                            cli.getEstadoCivil()
                            });
            } 
    }//GEN-LAST:event_jBConsultarActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed

    }//GEN-LAST:event_txtCPFActionPerformed

    private void adicionarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarNovoActionPerformed
       
        modoTela = "Criação";
        
        
        this.jTextNome.setText("");
        this.jTextEmail.setText("");
        this.jComboBoxEstadoCivil.setSelectedIndex(0);
        this.jTextEndereco.setText("");
        this.jTextNumero.setText("");
        this.jTextBairro.setText("");
        this.jTextCidade.setText("");
        this.txtCPFCliente.setText("");  
        
        this.jComboBoxSexo.setSelectedIndex(0);
        this.jTextTelefone.setText("");
       
        
        // convertendo a data para texto, para ser setado no campo
        Date dataAtual = clienteDados.getIdade();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataAtual);
        this.jFormattedTextIdade.setText("");
        this.txtCPF.setText("");
    }//GEN-LAST:event_adicionarNovoActionPerformed

       public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PainelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelCliente().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarNovo;
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBExcluir1;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jComboBoxEstadoCivil;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JFormattedTextField jFormattedTextIdade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBairro;
    private javax.swing.JTextField jTextCidade;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextEndereco;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextNumero;
    private javax.swing.JFormattedTextField jTextTelefone;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JTable tbCliente;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPFCliente;
    // End of variables declaration//GEN-END:variables

   
}
