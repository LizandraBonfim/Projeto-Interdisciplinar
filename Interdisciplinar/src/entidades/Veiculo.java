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
    private int _idModelo;
    private String _modelo;
    private float _preco;
    private int _idEstado;
    private String _estado;

    
    // Gerado para construir uma nova instancia de veiculo a partir do banco de dados.
    // Somente o banco de dados que vai utilizar esse construtor
    public Veiculo(int _id, String _placa, int _ano, int _idModelo, String _modelo, float _preco, int _idEstado, String _estado) {
        this._id = _id;
        this._placa = _placa;
        this._ano = _ano;
        this._idModelo = _idModelo;
        this._modelo = _modelo;
        this._preco = _preco;
        this._idEstado = _idEstado;
        this._estado = _estado;
    }

    // Esse construtor deve ser usando para criar um novo veiculo
    public Veiculo(String _placa, int _ano, int _idModelo, float _preco, int _idEstado) {
        this._placa = _placa;
        this._ano = _ano;
        this._idModelo = _idModelo;
        this._preco = _preco;
        this._idEstado = _idEstado;
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
        return _modelo;
    }

    public float getPreco() {
        return _preco;
    }

    public String getEstado() {
        return _estado;
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

    public void setModelo(String _modelo) {
        this._modelo = _modelo;
    }

    public void setPreco(float _preco) {
        this._preco = _preco;
    }

    public void setEstado(String _estado) {
        this._estado = _estado;
    }

    
    //Usado para atualizar posteriormente no banco de dados    
    public void AtualizarEstado(int idEstado){
        this._idEstado = idEstado;        
    }    
    
    //Usado para atualizar posteriormente no banco de dados
    public void AtualizarModelo(int idModelo){
        this._idModelo = idModelo;        
    }    
    
}
