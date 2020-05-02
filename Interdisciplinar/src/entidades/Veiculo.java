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
public class Veiculo {
    
    private int _id;
    private String _placa;    
    private int _ano;        
    private float _preco;    
    
    private int _idEstado;
    private Estado _estado;
    
    private int _idModelo;

    
    private Modelo _modelo;
    
    private int _idLoja;
    private Loja _loja;

    
    // Gerado para construir uma nova instancia de veiculo a partir do banco de dados.
    // Somente o banco de dados que vai utilizar esse construtor
    public Veiculo(
            int id, String placa, int ano, float preco, 
            Estado estado, 
            Modelo modelo,
            Loja loja) {
        this._id = id;
        this._placa = placa;
        this._ano = ano;        
        this._preco = preco;        
        this._estado = estado;
        this._idEstado = estado.getId();
        this._modelo = modelo;        
        this._idModelo = modelo.getId();
        this._loja = loja;
        this._idLoja = loja.getId();
        
    }

    // Esse construtor deve ser usando para criar um novo veiculo
    public Veiculo(String placa, int ano, float preco, int idModelo, int idEstado, int idLoja) {
        this._placa = placa;
        this._ano = ano;        
        this._preco = preco;
        this._idModelo = idModelo;
        this._idEstado = idEstado;
        this._idLoja = idLoja;
        
    }
    
    
  

    

    public int getId() {
        return _id;
    }

    public String getPlaca() {
        return _placa;
    }

    public int getAno() {
        return _ano;
    }

    public String getModelo() {
        return _modelo.getModelo();
    }
    
    public String getMarca() {
        return _modelo.getMarca();
    }

    public float getPreco() {
        return _preco;
    }

    public String getEstado() {
        return _estado.getNome();
    }
    
    public String getUF() {
        return _estado.getUf();
    }   
    
    public String getLoja() {
        return _loja.getNome();
    }
    
    public int getIdLoja(){
        return _idLoja;
    }
    
    
    // Setter para atualização
    // o campo Id é imutavel, não pode ser atualizado
    
    
    public void setPlaca(String _placa) {
        this._placa = _placa;
    }

    public int getIdModelo() {
        return _idModelo;
    }

    public int getIdEstado() {
        return _idEstado;
    }

    public void setAno(int _ano) {
        this._ano = _ano;
    }   

    public void setPreco(float _preco) {
        this._preco = _preco;
    }    
    
    public void setIdEstado(int _idEstado) {
        this._idEstado = _idEstado;
    }

    public void setIdModelo(int _idModelo) {
        this._idModelo = _idModelo;
    }

    public void setIdLoja(int _idLoja) {
        this._idLoja = _idLoja;
    }

    
   
    
    
    
}

