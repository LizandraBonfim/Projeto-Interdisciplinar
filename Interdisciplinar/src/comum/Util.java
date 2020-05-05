/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;

import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Lizandra
 */
public class Util {
    
    public static String buscarFullPathSqlite(){
        
        Path path = Paths.get(
                System.getProperty("user.dir"), 
                "src", 
                "bancoDeDados", 
                "data",
                "banco.sqlite");
        
        
        System.out.println("caminho do banco de dados:");
        System.out.println(path.toString());
        
        return path.toString();
        
    }
    
    
    public static void mensagemDeAlerta(String texto, javax.swing.JFrame frame){
        JOptionPane.showMessageDialog(frame, texto, "Alerta", JOptionPane.NO_OPTION);
    }
    
    public static boolean eUmNumero(String valor){
        int resultado = tryParseInt(valor, -1);
        if (resultado == -1)
            return false;
       
        return true;
    }
    
    public static int tryParseInt(String valor, int valorDefault){
        try {
            
            return Integer.parseInt(valor);
            
        } catch (Exception e) {
            return valorDefault;
        }
    }
    
    
    public static float tryParseFloat(String valor, float valorDefault){
        try {
            
            return Float.parseFloat(valor);
            
        } catch (Exception e) {
            return valorDefault;
        }
    }
    
}
