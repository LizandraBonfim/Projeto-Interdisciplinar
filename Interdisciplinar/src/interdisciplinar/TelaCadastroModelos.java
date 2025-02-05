/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interdisciplinar;

import comum.Banco;
import comum.Util;
import comum.ValidacaoDeFormularios;
import entidades.Modelo;

/**
 *
 * @author Lizandra
 */
public class TelaCadastroModelos extends javax.swing.JFrame {

    private Modelo _modelo;
    private Banco _banco;

    /**
     * Creates new form TelaCadastroModelos
     */
    public TelaCadastroModelos() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        _banco = new Banco();

    }

    public TelaCadastroModelos(int idMarcaModelo) {
        this();        
        carregarModelo(idMarcaModelo);
    }

    private void carregarModelo(int idMarcaModelo) {

        _modelo = _banco.buscarModeloPorId(idMarcaModelo);

        txtMarca.setText(_modelo.getMarca());
        txtModelo.setText(_modelo.getModelo());

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
        txtMarca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de modelos");
        setResizable(false);

        jLabel1.setText("Marca");

        jLabel2.setText("Modelo");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtMarca)
                    .addComponent(txtModelo))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(jButton2))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (!formularioValido()) {
            return;
        }
        
        // Se o modelo estiver null significa que o usuario
        // esta criando um novo modelo
        if (_modelo == null){
            salvaNovoModelo();
            return;
        }
        
        // com a varival local _modelo tem conteudo, significa que o
        // usuario quer alterar um modelo selecionado.
        atualizarModelo();

       
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    private void atualizarModelo() {
        
        _modelo.setMarca(txtMarca.getText());
        _modelo.setModelo(txtModelo.getText());
        
        boolean atualizou = new Banco().atualizarModelo(_modelo);
        
        if (atualizou) {
            Util.mensagemDeAlerta("Modelo atualizado com sucesso", this);
        } else {
            Util.mensagemDeAlerta("Ocorreu um erro ao tentar atualizar um novo veiculo no banco de dados", this);
        }
        
        this.dispose();
        
    }
    
    private void salvaNovoModelo(){
         
        boolean salvou = new Banco().novoModelo(txtMarca.getText(), txtModelo.getText());
        if (salvou) {
            Util.mensagemDeAlerta("Modelo cadastrado com sucesso", this);
        } else {
            Util.mensagemDeAlerta("Ocorre um erro ao tentar salvar o modelo", this);
        }

        txtModelo.setText("");
    }
    
    private boolean formularioValido() {
        if (!ValidacaoDeFormularios.campoTextoEstaValido("Marca", txtMarca, 2, this)) {
            return false;
        }

        if (!ValidacaoDeFormularios.campoTextoEstaValido("Modelo", txtModelo, 2, this)) {
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
            java.util.logging.Logger.getLogger(TelaCadastroModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroModelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
