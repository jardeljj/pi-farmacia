/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Common.DataHelper;
import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import Model.Categoria;
import Model.Produto;
import Validation.campoNumero;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class ProdutoForm extends javax.swing.JInternalFrame {
    
    public String modoTela = "Criação";
    Produto objProduto;
    ArrayList<Categoria> categorias;

    public ProdutoForm() {
        initComponents();
        CarregarCategorias();
        
        this.objProduto = new Produto();
        txtPreco.setDocument(new campoNumero());
        txtQtnestoque.setDocument(new campoNumero());
    }

    public ProdutoForm(Produto objProduto) {
        initComponents();
        CarregarCategorias();
        
        txtPreco.setDocument(new campoNumero());
        txtQtnestoque.setDocument(new campoNumero());
        
        this.objProduto = objProduto;
        
        this.txtNomeProduto.setText(objProduto.getNome());
        this.txtUnidade.setText(objProduto.getUnidade());
        this.txtPreco.setText(Double.toString(objProduto.getPreco()));
        this.txtValidade.setText(DataHelper.dateToTexto(objProduto.getValidade()));
        this.jCategorias.setSelectedItem(objProduto.getNomeCategoria());
        this.txtQtnestoque.setText(Integer.toString(objProduto.getEstoque()));
    }
    
    public void CarregarCategorias() {
        categorias = CategoriaDAO.consultarCategoria("");
        if (categorias != null && categorias.size() > 0) {
            for (Categoria c : categorias) {
                this.jCategorias.addItem(c.getNome());
            }
        }
    }

    /**
     * Creates new form produtoPrototipo
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnCancelar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        panelProduto = new javax.swing.JPanel();
        txtNomeProduto = new javax.swing.JTextField();
        lblUnidade = new javax.swing.JLabel();
        lblValidade = new javax.swing.JLabel();
        lblNomeProduto = new javax.swing.JLabel();
        txtUnidade = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtValidade = new javax.swing.JFormattedTextField();
        txtPreco = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtQtnestoque = new javax.swing.JTextField();
        jCategorias = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        panelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Produto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        txtNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdutoActionPerformed(evt);
            }
        });

        lblUnidade.setText("Unidade");

        lblValidade.setText("Validade");

        lblNomeProduto.setText("Nome ");

        txtUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadeActionPerformed(evt);
            }
        });

        lblCategoria.setText("Categoria");

        lblPreco.setText("Preço  ");

        try {
            txtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        jLabel1.setText("Qnt.Estoque");

        javax.swing.GroupLayout panelProdutoLayout = new javax.swing.GroupLayout(panelProduto);
        panelProduto.setLayout(panelProdutoLayout);
        panelProdutoLayout.setHorizontalGroup(
            panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProdutoLayout.createSequentialGroup()
                        .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdutoLayout.createSequentialGroup()
                                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblUnidade)
                                    .addComponent(txtUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(lblValidade)
                                    .addComponent(txtValidade))
                                .addGap(36, 36, 36)
                                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPreco)
                                    .addGroup(panelProdutoLayout.createSequentialGroup()
                                        .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPreco)
                                            .addComponent(lblCategoria))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(panelProdutoLayout.createSequentialGroup()
                        .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtQtnestoque, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelProdutoLayout.setVerticalGroup(
            panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnidade)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValidade)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(txtQtnestoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(panelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoActionPerformed

    private void txtUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadeActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        objProduto.setNome(txtNomeProduto.getText());
        objProduto.setUnidade(txtUnidade.getText());
        objProduto.setPreco(Double.parseDouble(txtPreco.getText()));
        objProduto.setValidade(DataHelper.textoToDate(txtValidade.getText()));
        objProduto.setEstoque(Integer.parseInt(txtQtnestoque.getText()));
        
        String categoria = jCategorias.getSelectedItem().toString();
        if (categorias != null && categorias.size() > 0 && !categoria.equals("")) {
            for (Categoria c : categorias) {
                if (c.getNome().equals(categoria)) {
                    objProduto.setCategoria(c.getId());
                    break;
                }
            }
        }

        if (txtNomeProduto.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(null, " O campo Nome é obrigatório, por favor preencha-o! ", " AVISO ", JOptionPane.WARNING_MESSAGE);

        } else if (txtUnidade.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(null, " O campo Unidade é obrigatório, por favor preencha-o! ", " AVISO ", JOptionPane.WARNING_MESSAGE);

        } else if (txtPreco.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(null, " O campo Preço é obrigatório, por favor preencha-o! ", " AVISO ", JOptionPane.WARNING_MESSAGE);

        } else if (txtValidade.getText().equals("  /  /    ")) {

            JOptionPane.showMessageDialog(null, " O campo Validade é obrigatório, por favor preencha-o! ", " AVISO ", JOptionPane.WARNING_MESSAGE);

        }else if (txtQtnestoque.getText().equals("")) {

            JOptionPane.showMessageDialog(null, " O campo estoque é obrigatório, por favor preencha-o! ", " AVISO ", JOptionPane.WARNING_MESSAGE);
        } else{
            try {
                if (this.objProduto.getId() > 0) {
                    ProdutoDAO.atualizar(objProduto);
                } else {
                    ProdutoDAO.salvar(objProduto);
                }

                JOptionPane.showMessageDialog(this, "Adicinado com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Falha ao gravar no banco de dados\n" + e.getMessage(),
                        "Aviso de Falha", JOptionPane.ERROR_MESSAGE);
            }
            txtNomeProduto.setText("");
            txtUnidade.setText("");
            txtPreco.setText("");
            txtValidade.setText("");
            //txtCategoria.setText("");
            txtQtnestoque.setText("");
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblUnidade;
    private javax.swing.JLabel lblValidade;
    private javax.swing.JPanel panelProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JTextField txtQtnestoque;
    private javax.swing.JTextField txtUnidade;
    private javax.swing.JFormattedTextField txtValidade;
    // End of variables declaration//GEN-END:variables

}
