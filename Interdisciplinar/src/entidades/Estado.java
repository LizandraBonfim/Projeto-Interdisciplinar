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
public class Estado {
    
    private int _id;
    private String _nome;
    private String _uf;

    public Estado(int id, String nome, String uf) {
        this._id = id;
        this._nome = nome;
        this._uf = uf;
    }

    public int getId() {
        return _id;
    }

    public String getNome() {
        return _nome;
    }

    public String getUf() {
        return _uf;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    public void setUf(String uf) {
        this._uf = uf;
    }
    
    
    
    
}
