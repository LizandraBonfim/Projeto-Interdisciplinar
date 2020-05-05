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
    
    public static boolean campoTextoEstaValido(String nomeCampo, javax.swing.JTextField txtField, int qtdMinimaCaracteres, javax.swing.JFrame frame) {

        String conteudo = txtField.getText();
        return textoEstaValido(nomeCampo, conteudo, qtdMinimaCaracteres, frame);

    }    
    
    public static boolean campoFloatEstaValido(String nomeCampo, float valorMinimo, float valorMaximo, float valorDefault, javax.swing.JTextField txtField, javax.swing.JFrame frame){
        
        String texto = String.format("Valor do campo %s está inválido, digite um valor entre %s a %s", nomeCampo, valorMinimo, valorMaximo);
        String campo = txtField.getText();        
        
        if (Util.tryParseFloat(campo, -1) == -1){
            Util.mensagemDeAlerta(texto, frame);
            txtField.setText(Float.toString(valorDefault));
            return false;
        }
        
        
        float valor = Util.tryParseFloat(campo, 0);
        if (valor < valorMinimo || valor > valorMaximo){            
            Util.mensagemDeAlerta(texto, frame);
            return false;
        }
        
        
        
        return true;        
    }
    
    public static boolean campoIntEstaValido(String nomeCampo, int valorMinimo, int valorMaximo, javax.swing.JTextField txtField, javax.swing.JFrame frame) {
        
        String texto = String.format("Valor do campo %s está inválido, digite um valor entre %s a %s", nomeCampo, valorMinimo, valorMaximo);
        
        String campo = txtField.getText();
        if (Util.tryParseInt(campo, -1) == -1){            
            Util.mensagemDeAlerta(texto, frame);
            return false;
        }
        
        int valor = Util.tryParseInt(campo, 0);
        if (valor < valorMinimo || valor > valorMaximo){            
            Util.mensagemDeAlerta(texto, frame);
            return false;
        }
        
        return true;        

    }    
    
    
    public static boolean campoComboBoxEstaValido(String nomeCampo, javax.swing.JComboBox<String> jComboBox, javax.swing.JFrame frame){
        
        String conteudo = jComboBox.getSelectedItem().toString();
        if ("SELECIONE".equals(conteudo)){
            Util.mensagemDeAlerta(String.format("Campo %s inválido, selecione um item", nomeCampo), frame);
            return false;
        }
        return textoEstaValido(nomeCampo, conteudo, 0, frame);
        
    }
    
    private static boolean textoEstaValido(String nomeCampo, String conteudoCampo, int qtdMinimaCaracteres, javax.swing.JFrame frame){
        
        if ("".equals(conteudoCampo)) { 
            
            String texto = String.format("O campo %s é obrigatório", nomeCampo);
            JOptionPane.showMessageDialog(frame, texto, "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        if (conteudoCampo.length() < qtdMinimaCaracteres){           
            
            String texto = String.format("O campo %s deve ter no minimo %s caracteres", nomeCampo, qtdMinimaCaracteres);
            JOptionPane.showMessageDialog(frame, texto, "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
            
        }
        
        return true;
        
    }
    
}
