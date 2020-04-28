/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;


import entidades.Estado;
import entidades.Modelos;
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

    public ArrayList<Modelos> listarMarcasModelos() {
        ArrayList<Modelos> modelos = new ArrayList<Modelos>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(Querys.ListarMarcas());

            while (resultado.next()) {

                int id = resultado.getInt("id");

                String marca = resultado.getString("marca");
                String modelo = resultado.getString("modelo");
                modelos.add(new Modelos(id, marca, modelo));

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

}
