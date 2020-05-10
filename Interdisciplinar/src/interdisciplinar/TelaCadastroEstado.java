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

/**
 *
 * @author Lizandra
 */
public class TelaCadastroEstado extends javax.swing.JFrame {

    private Estado _estado;
    private Banco _banco;

    public TelaCadastroEstado(int idEstado) {

        this();
        carregarEstadoId(idEstado);
    }

    /**
     * Creates new form TelaCadastroEstado
     */
    public TelaCadastroEstado() {
        
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        _banco = new Banco();
        
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
        txtUf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("UF");

        jLabel2.setText("Nome Do Estado");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(txtUf, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addComponent(txtEstado)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarEstadoId(int id) {

        _estado = _banco.buscarEstadoPorId(id);

        txtUf.setText(_estado.getUf());
        txtEstado.setText(_estado.getNome());

    }


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        if (!formularioValido()) {
            return;
        }

        // Se o estado estiver null significa que o usuario
        // esta criando um novo estado
        if (_estado == null) {
            salvarNovoEstado();
            return;
        }

        // com a varival local _estado tem conteudo, significa que o
        // usuario quer alterar um estado selecionado.
        atualizarEstado();


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void atualizarEstado() {

        _estado.setNome(txtEstado.getText());
        _estado.setUf(txtUf.getText());

        boolean atualizou = _banco.atualizarEstado(_estado);

        if (atualizou) {
            Util.mensagemDeAlerta("Estado atualizado com sucesso", this);
        } else {
            Util.mensagemDeAlerta("Ocorreu um erro ao tentar atualizar o estado no banco de dados", this);
        }

        this.dispose();

    }

    private void salvarNovoEstado() {

        String nome = txtEstado.getText();
        String uf = txtUf.getText();

        boolean salvou = _banco.novoEstado(nome, uf);
        if (salvou) {
            Util.mensagemDeAlerta("Estado gravado com sucesso", this);
        } else {
            Util.mensagemDeAlerta("Ocorreu um erro ao tentar salvar", this);
        }

        txtEstado.setText("");
        txtUf.setText("");

    }

    private boolean formularioValido() {

        if (!ValidacaoDeFormularios.campoTextoEstaValido("uf", txtUf, 2, this)) {
            return false;
        }

        if (!ValidacaoDeFormularios.campoTextoEstaValido("estado", txtEstado, 2, this)) {
            return false;
        }

        return true;
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
            java.util.logging.Logger.getLogger(TelaCadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
