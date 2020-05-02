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

}
