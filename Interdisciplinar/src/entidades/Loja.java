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
public class Loja {
    
    private int _id;
    private String _nome;

    public int getId() {
        return _id;
    }

    public String getNome() {
        return _nome;
    }

    public Loja(int _id, String _nome) {
        this._id = _id;
        this._nome = _nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }
    
    
    
}
