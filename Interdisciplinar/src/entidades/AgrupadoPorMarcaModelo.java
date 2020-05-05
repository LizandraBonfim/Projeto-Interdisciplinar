/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lizandra
 */
public class AgrupadoPorMarcaModelo {    
    
    private Modelo _modelo;
    private int _qtd;

    public AgrupadoPorMarcaModelo(Modelo _modelo, int _qtd) {
        this._modelo = _modelo;
        this._qtd = _qtd;
    }

    public int getQtd() {
        return _qtd;
    }
    
    public String getMarca(){
        return _modelo.getMarca();
    }
    
    public String getModelo(){
        return _modelo.getModelo();
    }
    
    
    
}
