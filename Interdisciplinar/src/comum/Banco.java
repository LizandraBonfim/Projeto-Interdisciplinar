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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lizandra
 */
public class Banco {

    private Connection conexao;
    private Statement statement;    

    private void montarConexao() {

        try {

            String stringDeConexao = "jdbc:sqlite:" + Util.buscarFullPathSqlite();
            conexao = DriverManager.getConnection(stringDeConexao);

        } catch (SQLException e) {

            System.out.println("Ocorreu um erro ao tentar abrir a conexao com "
                    + "o banco de dados");
            System.out.println("Erro: " + e.getMessage());

        }

    }

    private boolean ExecutarComando(String query) {

        try {

            montarConexao();
            statement = conexao.createStatement();
            statement.execute(query);
            statement.close();
            return true;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());

            return false;
        }

    }

    private ResultSet ExecutarComandoQuerys(String query) {

        try {

            montarConexao();
            statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(query);
            return resultado;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return null;

    }

    public boolean usuarioExiste(String login, String senha) {

        try {
            ResultSet result = ExecutarComandoQuerys(Querys.UsuarioExiste(login, senha));
            boolean existe = result.next();
            statement.close();
            return existe;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar verificar se o usuário existe");
            return false;
        }
    }

    public boolean criarNovoUsuario(String nome, String login, String senha) {

        boolean criou = ExecutarComando(Querys.QueryNovoUsuario(nome, login, senha));
        return criou;
    }

    public boolean novoModelo(String marca, String modelo) {

        boolean salvou = ExecutarComando(Querys.NovoModelo(marca, modelo));
        return salvou;

    }
    
    public ArrayList<Estado> listarEstados(){
        
        ArrayList<Estado> estados = new ArrayList<Estado>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(Querys.listarEstados());

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String uf = resultado.getString("uf");
                
                estados.add(new Estado(id, nome, uf));

            }

            statement.close();
            return estados;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return estados;
        
    }

    public ArrayList<Modelo> listarMarcasModelos() {
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(Querys.ListarMarcas());

            while (resultado.next()) {

                int id = resultado.getInt("id");                
                
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                modelos.add(new Modelo(id, marca, modelo));

            }

            statement.close();
            return modelos;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return modelos;

    }

    public boolean novoEstado(String nome, String uf) {

        boolean salvou = ExecutarComando(Querys.novoEstado(nome, uf));
        return salvou;

    }
    
    public boolean novoVeiculo(Veiculo veiculo){
        
        boolean salvou = ExecutarComando(Querys.novoVeiculo(veiculo));
        return salvou;
        
    }
    
    public ArrayList<Veiculo> listarVeiculos() {
        
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(Querys.listarVeiculos());

            while (resultado.next()) {

                int id = resultado.getInt("id");                
                String placa = resultado.getString("placa");
                int idMarca = resultado.getInt("idMarca");
                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                int ano = resultado.getInt("ano");
                float preco = resultado.getFloat("preco");
                int idEstado = resultado.getInt("idEstado");
                String estado = resultado.getString("nome");
                String uf = resultado.getString("uf");
                int idLoja = resultado.getInt("idLoja");
                String loja = resultado.getString("loja");
                
                veiculos.add(
                        new Veiculo(id, placa, ano, preco, 
                                new Estado(idEstado, estado, uf), 
                                new Modelo(idMarca, marca, modelo),
                                new Loja(idLoja, loja)));

            }

            statement.close();
            return veiculos;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return veiculos;
        
    }
    
    public boolean novaLoja(String nome) {

        boolean salvou = ExecutarComando(Querys.NovaLoja(nome) );
        return salvou;

    }
    
    public ArrayList<Loja> listarLoja() {
        
        ArrayList<Loja> loja = new ArrayList<Loja>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(Querys.ListarLojas());

            while (resultado.next()) {

                int id = resultado.getInt("id");                
                String nome = resultado.getString("nome");                
                
                loja.add(new Loja(id, nome));

            }

            statement.close();
            return loja;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return loja;
        
    }

}
