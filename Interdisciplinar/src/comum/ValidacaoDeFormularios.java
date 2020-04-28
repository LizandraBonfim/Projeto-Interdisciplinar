/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;

import javax.swing.JOptionPane;

/**
 *
 * @author Lizandra
 */
public class ValidacaoDeFormularios {
    
    public static boolean campoTextoEstaValido(String nomeCampo, javax.swing.JTextField txtField, javax.swing.JFrame frame) {

        String conteudo = txtField.getText();
        return textoEstaValido(nomeCampo, conteudo, frame);

    }    
    
    
    public static boolean campoComboBoxEstaValido(String nomeCampo, javax.swing.JComboBox<String> jComboBox, javax.swing.JFrame frame){
        
        String conteudo = jComboBox.getSelectedItem().toString();
        if ("SELECIONE".equals(conteudo)){
            Util.mensagemDeAlerta(String.format("Campo %s inválido, selecione um item", nomeCampo), frame);
            return false;
        }
        return textoEstaValido(nomeCampo, conteudo, frame);
        
    }
    
    private static boolean textoEstaValido(String nomeCampo, String conteudoCampo, javax.swing.JFrame frame){
        
        if ("".equals(conteudoCampo)) { 
            
            String texto = String.format("O campo %s é obrigatório", nomeCampo);
            JOptionPane.showMessageDialog(frame, texto, "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        if (conteudoCampo.length() < 2){           
            
            String texto = String.format("O campo %s deve ter no minimo 3 caracteres", nomeCampo);
            JOptionPane.showMessageDialog(frame, texto, "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
            
        }
        
        return true;
        
    }
    
}
