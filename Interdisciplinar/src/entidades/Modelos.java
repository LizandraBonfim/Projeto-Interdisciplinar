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
public class Modelos {
    
    private int _id;
    private String _marca;
    private String _modelo;

    public Modelos(int id, String _marca, String _modelo) {
        this._id = id;
        this._marca = _marca;
        this._modelo = _modelo;
    }
    
    public Modelos(){
        
    }
    
    public int getId(){
        return _id;
    }
    
    public String getMarca() {
        return _marca;
    }
    
    public String getModelo() {
        return _modelo;
    }
    
    public void setMarca(String marca){
        this._marca = marca;        
    }
    
    public void setModelo(String modelo){
        this._modelo = modelo;
    }
    
    
}


