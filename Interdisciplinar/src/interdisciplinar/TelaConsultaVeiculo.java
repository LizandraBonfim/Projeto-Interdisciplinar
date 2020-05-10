/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interdisciplinar;

import Tabelas.VeiculoJTable;
import comum.Banco;
import comum.Util;
import comum.ValidacaoDeFormularios;
import entidades.Modelo;
import entidades.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Lizandra
 */
public class TelaConsultaVeiculo extends javax.swing.JFrame {

    private Banco _banco;
    private ArrayList<Modelo> _modelos;
    private VeiculoJTable _veiculoJTable;
    private ArrayList<Veiculo> _veiculos;
    private int _linhaSelecionada;

    /**
     * Creates new form TelaConsultaVeiculo
     */
    public TelaConsultaVeiculo() {
        initComponents();

        // Centraliza o formulario no meio da tela
        this.setLocationRelativeTo(null);
        // Não permite que o usuario altere o tamanho do formulario
        this.setResizable(false);

        _banco = new Banco();
        _veiculoJTable = new VeiculoJTable(_banco);

        preencherComboBoxMarcaModelo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbMarcaModelo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecoDe = new javax.swing.JTextField();
        txtPrecoAte = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de veiculos");
        setResizable(false);

        tbConsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbConsulta);

        jLabel1.setText("Filtros:");

        jLabel2.setText("Placa:");

        jLabel3.setText("Marca / Modelo:");

        cbMarcaModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Preço de:");

        jLabel5.setText("Preço ate:");

        txtPrecoDe.setText("0");

        txtPrecoAte.setText("900000");

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMarcaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecoDe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtPrecoAte, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMarcaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:

        filtrar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    
    private void filtrar() {
        
        if (!formularioValido()) {
            return;
        }
        
        int idModelo = extrairIdDoModelo();
        float precoInicial = Float.parseFloat(txtPrecoDe.getText());
        float precoFinal = Float.parseFloat(txtPrecoAte.getText());

        _veiculos = _banco.listarVeiculos(txtPlaca.getText(), idModelo, precoInicial , precoFinal);
        _veiculoJTable.montarVeiculos(tbConsulta, _veiculos);
    }
    
    private boolean selecionouUmaLinha() {
        
        int linhaSelecionada = tbConsulta.getSelectedRow();
        
        if ( linhaSelecionada == -1 || _veiculos == null || _veiculos.size() == 0 )
            return false;
        
        return true;
    }
    
    private int obterIdSelecionado(){
        
        int linhaSelecionada = tbConsulta.getSelectedRow();        
        System.out.println("linha seleiconada: " + linhaSelecionada );
        Object valor = tbConsulta.getModel().getValueAt(linhaSelecionada, 0);
        int id = (int)valor;
        return id;
        
    }
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (!selecionouUmaLinha())
            return;            
            
        int id = obterIdSelecionado();
        new TelaCadastroVeiculo(id).show();
        filtrar();
                
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
        if (!selecionouUmaLinha())
            return;
        
        int id = obterIdSelecionado();
        boolean querExcluir = Util.mensagemDeConfirmacao("Deseja realmente excluir esse registro ?", this);
        if (querExcluir)
            excluirVeiculo(id);
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    
    private void excluirVeiculo(int idVeiculo){
        
        boolean excluiu = _banco.excluirVeiculo(idVeiculo);
        if (excluiu){
            Util.mensagemDeAlerta("Veiculo excluido com sucesso", this);
            filtrar();
            return;            
        }
        
        
        Util.mensagemDeAlerta("Ocorreu um erro ao tentar excluir o veiculo", this);
        
    }
    
    private boolean formularioValido() {       
        
        if (!ValidacaoDeFormularios.campoFloatEstaValido("preco", 0, 999000, 0, txtPrecoDe, this)){
            return false;
        }
        if (!ValidacaoDeFormularios.campoFloatEstaValido("preco", 0, 999000, 900000f, txtPrecoAte, this)){
            return false;
        }

        return true;

    }

    private void preencherComboBoxMarcaModelo() {

        cbMarcaModelo.removeAllItems();
        cbMarcaModelo.addItem("SELECIONE");
        _modelos = new Banco().listarMarcasModelos();

        //{Marca} / {Modelo}        
        for (Modelo item : _modelos) {
            String texto = String.format("%s / %s", item.getMarca(), item.getModelo());
            cbMarcaModelo.addItem(texto);
        }

    }

    private int extrairIdDoModelo() {

        // formato: {Marca} / {Modelo}
        String valor = cbMarcaModelo.getSelectedItem().toString();
        if ("SELECIONE".equals(valor))
            return 0;
        
        String marca = valor.split("/")[0].trim();
        String modelo = valor.split("/")[1].trim();
        for (Modelo item : _modelos) {
            if (item.getMarca().equals(marca) && item.getModelo().equals(modelo)) {
                return item.getId();
            }
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
            java.util.logging.Logger.getLogger(TelaConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cbMarcaModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbConsulta;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPrecoAte;
    private javax.swing.JTextField txtPrecoDe;
    // End of variables declaration//GEN-END:variables
}
