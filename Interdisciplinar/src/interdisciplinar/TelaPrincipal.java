/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interdisciplinar;


import Tabelas.VeiculoJTable;
import comum.Banco;
import comum.UsuarioLogado;
import comum.Util;
import entidades.Veiculo;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Lizandra
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private Banco _db;
    private VeiculoJTable _veiculoJTable;
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();              
        
        this.setExtendedState(this.MAXIMIZED_BOTH);         
        lblSaudacao.setText("Bem Vindo(a): " + UsuarioLogado.nome);
        
        _db = new Banco();
        _veiculoJTable = new VeiculoJTable(_db);       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        lblSaudacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDinamica = new javax.swing.JTable();
        btnListarVeiculos = new javax.swing.JButton();
        btnQtdPorMarcaEModelo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMaiorMenorPorAno = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuModelo = new javax.swing.JMenuItem();
        menuEstado = new javax.swing.JMenuItem();
        menuLoja = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuConsultaVeiculo = new javax.swing.JMenuItem();
        menuModelos = new javax.swing.JMenuItem();
        menuEstados = new javax.swing.JMenuItem();
        menuLojas = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        menuProjeto = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblSaudacao.setText("Bem Vindo");

        tbDinamica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDinamica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDinamicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDinamica);

        btnListarVeiculos.setText("Listar");
        btnListarVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarVeiculosActionPerformed(evt);
            }
        });

        btnQtdPorMarcaEModelo.setText("Qtd por marca e modelo");
        btnQtdPorMarcaEModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQtdPorMarcaEModeloActionPerformed(evt);
            }
        });

        jLabel1.setText("Listagem de veículos:");

        btnMaiorMenorPorAno.setText("Maior / Menor por ano");
        btnMaiorMenorPorAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaiorMenorPorAnoActionPerformed(evt);
            }
        });

        jMenu2.setText("Cadastro");

        jMenuItem1.setText("Veiculos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        menuModelo.setText("Modelo");
        menuModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModeloActionPerformed(evt);
            }
        });
        jMenu2.add(menuModelo);

        menuEstado.setText("Estados");
        menuEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstadoActionPerformed(evt);
            }
        });
        jMenu2.add(menuEstado);

        menuLoja.setText("Loja");
        menuLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLojaActionPerformed(evt);
            }
        });
        jMenu2.add(menuLoja);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Consulta");

        menuConsultaVeiculo.setText("Veiculos");
        menuConsultaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultaVeiculoActionPerformed(evt);
            }
        });
        jMenu3.add(menuConsultaVeiculo);

        menuModelos.setText("Modelos");
        menuModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModelosActionPerformed(evt);
            }
        });
        jMenu3.add(menuModelos);

        menuEstados.setText("Estados");
        menuEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstadosActionPerformed(evt);
            }
        });
        jMenu3.add(menuEstados);

        menuLojas.setText("Lojas");
        menuLojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLojasActionPerformed(evt);
            }
        });
        jMenu3.add(menuLojas);

        jMenuBar1.add(jMenu3);

        menuSobre.setText("Sobre");

        menuProjeto.setText("Projeto");
        menuProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProjetoActionPerformed(evt);
            }
        });
        menuSobre.add(menuProjeto);

        jMenuBar1.add(menuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSaudacao)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListarVeiculos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQtdPorMarcaEModelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMaiorMenorPorAno)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaudacao)
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarVeiculos)
                    .addComponent(btnQtdPorMarcaEModelo)
                    .addComponent(btnMaiorMenorPorAno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TelaCadastroVeiculo telaVeiculos = new TelaCadastroVeiculo();
        telaVeiculos.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModeloActionPerformed
        // TODO add your handling code here:
        TelaCadastroModelos modelo = new TelaCadastroModelos();
        modelo.show();
    }//GEN-LAST:event_menuModeloActionPerformed

    private void menuEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstadoActionPerformed
        // TODO add your handling code here:
        TelaCadastroEstado estado = new TelaCadastroEstado();
        estado.show();
    }//GEN-LAST:event_menuEstadoActionPerformed

    private void btnListarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarVeiculosActionPerformed
        // TODO add your handling code here:
        
        _veiculoJTable.montarVeiculos(tbDinamica);        
    }//GEN-LAST:event_btnListarVeiculosActionPerformed

    private void menuLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLojaActionPerformed
        // TODO add your handling code here:
        
        new TelaCadastroLoja().show();
        
    }//GEN-LAST:event_menuLojaActionPerformed

    private void tbDinamicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDinamicaMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_tbDinamicaMouseClicked

    private void btnQtdPorMarcaEModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQtdPorMarcaEModeloActionPerformed
        // TODO add your handling code here:
        
        _veiculoJTable.montarQtdVeiculosPorEModelo(tbDinamica);        
        
    }//GEN-LAST:event_btnQtdPorMarcaEModeloActionPerformed

    private void btnMaiorMenorPorAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaiorMenorPorAnoActionPerformed
        // TODO add your handling code here:
        _veiculoJTable.montarMairoMenorPrecoPorAno(tbDinamica);        
    }//GEN-LAST:event_btnMaiorMenorPorAnoActionPerformed

    private void menuConsultaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultaVeiculoActionPerformed
        // TODO add your handling code here:
        new TelaConsultaVeiculo().show();
        
    }//GEN-LAST:event_menuConsultaVeiculoActionPerformed

    private void menuModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModelosActionPerformed
        // TODO add your handling code here:
        new TelaConsultaModelos().show();
    }//GEN-LAST:event_menuModelosActionPerformed

    private void menuEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstadosActionPerformed
        // TODO add your handling code here:
        new TelaConsultaEstado().show();
        
        
    }//GEN-LAST:event_menuEstadosActionPerformed

    private void menuLojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLojasActionPerformed
        // TODO add your handling code here:
        new TelaConsultaLoja().show();
    }//GEN-LAST:event_menuLojasActionPerformed

    private void menuProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProjetoActionPerformed
        // TODO add your handling code here:
        
        new TelaSobreProjeto().show();
        
    }//GEN-LAST:event_menuProjetoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarVeiculos;
    private javax.swing.JButton btnMaiorMenorPorAno;
    private javax.swing.JButton btnQtdPorMarcaEModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaudacao;
    private javax.swing.JMenuItem menuConsultaVeiculo;
    private javax.swing.JMenuItem menuEstado;
    private javax.swing.JMenuItem menuEstados;
    private javax.swing.JMenuItem menuLoja;
    private javax.swing.JMenuItem menuLojas;
    private javax.swing.JMenuItem menuModelo;
    private javax.swing.JMenuItem menuModelos;
    private javax.swing.JMenuItem menuProjeto;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JTable tbDinamica;
    // End of variables declaration//GEN-END:variables
}
