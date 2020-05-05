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
public class MaiorMenorPrecoPorAno {
    
    private int _ano;
    private float _menorPreco;
    private float _maiorPreco;
    private String _marca;
    private String _modelo;

    public int getAno() {
        return _ano;
    }

    public float getMenorPreco() {
        return _menorPreco;
    }

    public float getMaiorPreco() {
        return _maiorPreco;
    }

    public String getMarca() {
        return _marca;
    }

    public String getModelo() {
        return _modelo;
    }

    public MaiorMenorPrecoPorAno(int ano, float menorPreco, float maiorPreco, String marca, String modelo) {
        this._ano = ano;
        this._menorPreco = menorPreco;
        this._maiorPreco = maiorPreco;
        this._marca = marca;
        this._modelo = modelo;
    }
    
    
    
}
