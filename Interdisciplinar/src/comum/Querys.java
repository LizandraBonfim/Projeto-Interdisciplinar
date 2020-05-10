/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;

import entidades.Estado;
import entidades.Loja;
import entidades.Modelo;
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

    public static String NovaLoja(String nome) {
        return String.format("INSERT INTO Loja (nome) VALUES ( '%s' ) ", nome);
    }

    public static String ListarLojas() {
        return "SELECT id, nome FROM Loja";
    }

    public static String AtualizarLojas(String nome, int id) {
        return String.format(" UPDATE Loja SET nome = '%s' WHERE id = %s ", nome, id);
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

    public static String listarEstados() {

        return "SELECT id, nome, uf FROM Estado ORDER BY UF ";

    }

    public static String novoVeiculo(Veiculo veiculo) {
        return String.format(
                "INSERT INTO Veiculo ( placa, idMarcaModelo, ano, preco, idEstado, idLoja ) "
                + " VALUES ( '%s', %s, %s, %s, %s, %s )",
                veiculo.getPlaca(),
                veiculo.getIdModelo(),
                veiculo.getAno(),
                veiculo.getPreco(),
                veiculo.getIdEstado(),
                veiculo.getIdLoja()
        );
    }

    public static String listarVeiculos() {

        return "SELECT "
                + "	   v.id as id, "
                + " v.placa as placa, "
                + " v.idMarcaModelo AS idMarca, "
                + " m.marca as marca, "
                + " m.modelo as modelo, "
                + " v.ano as ano, "
                + " v.preco as preco, "
                + " v.idEstado as idEstado, "
                + " e.nome as nome, "
                + " e.uf as uf, "
                + " l.id as idLoja, "
                + " l.nome as loja "
                + "	  FROM Veiculo AS v "
                + "INNER JOIN MarcasModelos AS m ON m.id = v.idMarcaModelo "
                + "INNER JOIN Estado AS e ON e.id = v.idEstado "
                + "INNER JOIN Loja AS l ON l.id = v.idLoja ";

    }

    public static String buscarVeiculoPorId(int id) {

        String query = String.format(listarVeiculos() + " WHERE v.id = %s ", id);
        return query;

    }

    public static String atualizarVeiculo(Veiculo veiculo) {

        return String.format(
                "UPDATE Veiculo \n"
                + "SET Placa = '%s', \n"
                + "       idMarcaModelo = %s, \n"
                + "       ano           = %s, \n"
                + "       preco         = %s, \n"
                + "       idEstado      = %s, \n"
                + "       idLoja        = %s \n"
                + "  WHERE id            = %s ",
                veiculo.getPlaca(),
                veiculo.getIdModelo(),
                veiculo.getAno(),
                veiculo.getPreco(),
                veiculo.getIdEstado(),
                veiculo.getIdLoja(),
                veiculo.getId());

    }
    
    public static String listarVeiculosAgrupadoPorMarcaModelo(){
        return 
                "SELECT v.idMarcaModelo AS idModelo \n" +
"		   ,count(v.idMarcaModelo) as Qtd\n" +
"		   ,m.marca as Marca\n" +
"		   ,m.modelo as Modelo\n" +
"	  FROM Veiculo AS v \n" +
"        INNER JOIN MarcasModelos AS m ON m.id = v.idMarcaModelo \n" +
"  GROUP BY v.idMarcaModelo ";
    }
    
    
    public static String listarMaiorMenorPrecoPorAno(){
        return "SELECT 	  v.ano AS Ano\n" +
"			, max(preco) AS MaiorPreco\n" +
"			, min(preco) AS MenorPreco\n" +
"			, m.marca AS Marca\n" +
"			, m.modelo AS Modelo\n" +
"		  FROM Veiculo AS v\n" +
"	    INNER JOIN MarcasModelos AS m ON m.id = v.idMarcaModelo \n" +
"	  GROUP by v.ano ";
    }
    
    
    public static String filtroVeiculos(String placa, int idMarcaModelo, float precoInicial, float precoFinal){
        
        String queryBase =
                "SELECT     v.id as id, \n" +
                            " v.placa as placa, \n" +
                            " v.idMarcaModelo AS idMarca, \n" +
                            " m.marca as marca, \n" +
                            " m.modelo as modelo, \n" +
                            " v.ano as ano, \n" +
                            " v.preco as preco, \n" +
                            " v.idEstado as idEstado, \n" +
                            " e.nome as nome, \n" +
                            " e.uf as uf, \n" +
                            " l.id as idLoja, \n" +
                            " l.nome as loja \n" +
"        	  FROM Veiculo AS v \n" +
"           INNER JOIN MarcasModelos AS m ON m.id = v.idMarcaModelo \n" +
"           INNER JOIN Estado AS e ON e.id = v.idEstado \n" +
"           INNER JOIN Loja AS l ON l.id = v.idLoja \n";
        
        String query = queryBase + " WHERE placa like '%" + placa + "%' ";
        if (idMarcaModelo > 0){
            query += " AND idMarcaModelo = " + idMarcaModelo;
        }
        
        if (precoFinal == 0 ){
            precoFinal = 999000;
        }        

        query += String.format(" AND preco BETWEEN %s and %s ", precoInicial, precoFinal);

        return query;
    }
    
    public static String excluirVeiculo(int id){
        return String.format("DELETE FROM Veiculo WHERE id = %s ", id);
    }
    
    public static String excluirMarcaModelo(int id){
        return String.format("DELETE FROM MarcasModelos WHERE id = %s ", id);
    }
    
    public static String buscarModeloPorId(int id){
        return String.format("SELECT * FROM MarcasModelos WHERE id = %s ", id);
    }
    
    
    public static String atualizarModelo(Modelo modelo){
        return String.format("UPDATE MarcasModelos "
                + "SET "
                + "marca = '%s', "
                + "modelo = '%s' WHERE id = %s", 
                modelo.getMarca(), 
                modelo.getModelo(), 
                modelo.getId()
        );
    }
    
    
    public static String atualizarEstado(Estado estado){
        return String.format("UPDATE Estado "
                + "SET "
                + "nome = '%s', "
                + "uf = '%s' "
                + "WHERE id = %s ", 
                estado.getNome(),
                estado.getUf(),
                estado.getId()
                );
                
    }
    
    public static String buscarEstadoPorId(int id){
        return String.format("SELECT * FROM Estado WHERE id = %s ", id);
    }
    
    public static String excluiEstado(int id){
        return String.format("DELETE FROM Estado WHERE id = %s", id);
    }
    
    
    public static String buscarLojaPorId(int id){
        return String.format("SELECT * FROM Loja WHERE id = %s", id);
    }
    
    public static String excluirLoja(int id){
        return String.format("DELETE FROM Loja WHERE id = %s", id);
    }
    
    public static String AtualizarLojas(Loja loja){
        return String.format("UPDATE Loja "
                + "SET "
                + "nome = '%s' "
                + "WHERE id = %s", 
                loja.getNome(),
                loja.getId()
        );
    }

}
