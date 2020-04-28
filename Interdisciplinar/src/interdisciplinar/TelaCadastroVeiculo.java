/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interdisciplinar;

import comum.Banco;
import comum.Util;
import comum.ValidacaoDeFormularios;
import entidades.Estado;
import entidades.Modelos;
import entidades.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Lizandra
 */
public class TelaCadastroVeiculo extends javax.swing.JFrame {

    private ArrayList<Modelos> _modelos = null;
    private ArrayList<Estado> _estados = null;
    private Banco _banco = null;

    /**
     * Creates new form TelaCadastroVeiculo
     */
    public TelaCadastroVeiculo() {
        initComponents();

        // Centraliza o formulario no meio da tela
        this.setLocationRelativeTo(null);
        // Não permite que o usuario altere o tamanho do formulario
        this.setResizable(false);

        _banco = new Banco();

        preencherComboBoxEstados();
        preencherComboBoxMarcaModelo();
    }

    private void preencherComboBoxEstados() {

        cbEstado.removeAllItems();
        cbEstado.addItem("SELECIONE");
        this._estados = _banco.listarEstados();

        // {UF} / {Nome}        
        for (Estado item : _estados) {
            String texto = String.format("%s / %s", item.getUf(), item.getNome());
            cbEstado.addItem(texto);
        }

    }

    private void preencherComboBoxMarcaModelo() {

        cbMarcaModelo.removeAllItems();
        cbMarcaModelo.addItem("SELECIONE");
        this._modelos = _banco.listarMarcasModelos();

        //{Marca} / {Modelo}        
        for (Modelos item : _modelos) {
            String texto = String.format("%s / %s", item.getMarca(), item.getModelo());
            cbMarcaModelo.addItem(texto);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        cbMarcaModelo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de veiculos");
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        jLabel1.setText("Placa");

        jLabel2.setText("Preço");

        jLabel3.setText("Ano");

        cbMarcaModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Marcar / Modelo");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtPlaca)
                    .addComponent(txtAno, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(txtPreco)
                    .addComponent(cbMarcaModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMarcaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (!formularioValido()) {
            return;
        }

        int idModelo = extrairIdDoModelo();
        int idEstado = extrairIdDoEstado();
        int ano = Integer.parseInt(txtAno.getText());
        float preco = Float.parseFloat(txtPreco.getText());

        
        Veiculo veiculo = new Veiculo(
                txtPlaca.getText(),                
                ano,
                idModelo,
                preco,
                idEstado);

        boolean inseriu = _banco.novoVeiculo(veiculo);
        if (inseriu)
            Util.mensagemDeAlerta("Veiculo inserido com sucesso", this);
        else
            Util.mensagemDeAlerta("Ocorreu um erro ao tentar inserir um novo veiculo no banco de dados", this);
        
        
        this.dispose();
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private boolean formularioValido() {

        if (!ValidacaoDeFormularios.campoTextoEstaValido("Placa", txtPlaca, this)) {
            return false;
        }

        if (!ValidacaoDeFormularios.campoComboBoxEstaValido("Marca", cbMarcaModelo, this)) {
            return false;
        }

        if (!ValidacaoDeFormularios.campoTextoEstaValido("Ano", txtAno, this)) {
            return false;
        }

        if (!ValidacaoDeFormularios.campoTextoEstaValido("Preço", txtPreco, this)) {
            return false;
        }

        if (!ValidacaoDeFormularios.campoComboBoxEstaValido("Estado", cbEstado, this)) {
            return false;
        }

        return true;

    }

    private int extrairIdDoModelo() {

        // formato: {Marca} / {Modelo}
        String valor = cbMarcaModelo.getSelectedItem().toString();
        String marca = valor.split("/")[0].trim();
        String modelo = valor.split("/")[1].trim();
        for (Modelos item : _modelos) {            
            if (item.getMarca().equals(marca) && item.getModelo().equals(modelo))
                return item.getId();
        }

        return 0;
    }
    
     private int extrairIdDoEstado() {

        // formato: {UF} / {Nome}        
        String valor = cbEstado.getSelectedItem().toString();
        String uf = valor.split("/")[0].trim();        
        for (Estado item : _estados) {            
            if (item.getUf().equals(uf))
                return item.getId();
        }

        return 0;
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbMarcaModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
