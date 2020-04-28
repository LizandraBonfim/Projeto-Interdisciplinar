/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;

import entidades.Veiculo;

/**
 *
 * @author Lizandra
 */
public class Querys {

    public static String QueryNovoUsuario(String nome, String login, String senha) {
        return String.format("INSERT INTO Usuario (nome, login, senha) VALUES ('%s', '%s', '%s') ", nome, login, senha);
    }

    public static String UsuarioExiste(String login, String senha) {
        return String.format("SELECT * from Usuario where login = '%s' and senha = '%s' limit 1", login, senha);
    }

    public static String NovoModelo(String marca, String modelo) {
        return String.format("INSERT INTO MarcasModelos (marca, modelo) VALUES ('%s', '%s') ", marca, modelo);
    }

    public static String ListarMarcas() {
        return "SELECT id, marca, modelo FROM MarcasModelos";
    }

    public static String NovoVeiculo(String placa, int idMarcaModelo, int ano, float preco, int idEstado) {
        return String.format("INSERT INTO Veiculo (placa, idMarcaModelo, ano, preco, idEstado) VALUES "
                + " (%s, %s, %s, %s, %s) ", placa, idMarcaModelo, ano, preco, idEstado);
    }

    public static String novoEstado(String nome, String uf) {
        return String.format("INSERT INTO Estado (nome,uf) "
                + "VALUES('%s','%s') ;", nome, uf);
                
    }
    
    public static String listarEstados(){
        
        return "SELECT id, nome, uf FROM Estado ORDER BY UF ";
        
    }
    
    public static String novoVeiculo(Veiculo veiculo) {
        return String.format(
                "INSERT INTO Veiculo ( placa, idMarcaModelo, ano, preco, idEstado ) "
                        + " VALUES ( '%s', %s, %s, %s, %s )", 
                veiculo.getPlaca(), 
                veiculo.getIdModelo(), 
                veiculo.getAno(), 
                veiculo.getPreco(), 
                veiculo.getIdEstado()
        );
    }
    
    public static String listarVeiculos(){
        
        return "SELECT \n" +
        "		v.id, v.placa, v.idMarcaModelo AS idMarca, m.marca, m.modelo, v.ano, v.preco, v.idEstado, e.nome, e.uf\n " +
        "	  FROM Veiculo AS v\n " +
        "INNER JOIN MarcasModelos AS m ON m.id = v.idMarcaModelo\n " +
        "INNER JOIN Estado AS e ON e.id = v.idEstado ";
        
    }

}
