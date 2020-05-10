/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comum;

import entidades.AgrupadoPorMarcaModelo;
import entidades.Estado;
import entidades.Loja;
import entidades.MaiorMenorPrecoPorAno;
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

    public ArrayList<Estado> listarEstados() {

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
    
    public boolean excluirEstado(int idEstado){
        return ExecutarComando(Querys.excluiEstado(idEstado));
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

    public boolean novoVeiculo(Veiculo veiculo) {

        boolean salvou = ExecutarComando(Querys.novoVeiculo(veiculo));
        return salvou;

    }
    
    private ArrayList<Veiculo> listarVeiculos(String query){
        
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(query);

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
    
    public ArrayList<Veiculo> listarVeiculos(String placa, int idMarcaModelo, float precoInicial, float precoFinal) {
        
        return listarVeiculos(Querys.filtroVeiculos(placa, idMarcaModelo, precoInicial, precoFinal));
    
    }

    public ArrayList<Veiculo> listarVeiculos() {

        return listarVeiculos(Querys.listarVeiculos());

    }

    public Veiculo buscarVeiculoPorId(int idVeiculo) {

        Veiculo veiculo = null;

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            
            String query = Querys.buscarVeiculoPorId(idVeiculo);
            ResultSet resultado = statement.executeQuery(Querys.buscarVeiculoPorId(idVeiculo));

            if (resultado.next()) {

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

                veiculo = new Veiculo(id, placa, ano, preco,
                        new Estado(idEstado, estado, uf),
                        new Modelo(idMarca, marca, modelo),
                        new Loja(idLoja, loja));
            }

            statement.close();
            return veiculo;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return veiculo;

    }

    public boolean novaLoja(String nome) {

        boolean salvou = ExecutarComando(Querys.NovaLoja(nome));
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
    
    
    public boolean atualizarVeiculo(Veiculo veiculo){
        
        boolean salvou = ExecutarComando(Querys.atualizarVeiculo(veiculo));
        return salvou;

    }
    
    public ArrayList<AgrupadoPorMarcaModelo> listarVeiculosAgrupadoPorMarcaModelo() {
         
        ArrayList<AgrupadoPorMarcaModelo> veiculos = 
                 new ArrayList<AgrupadoPorMarcaModelo>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(Querys.listarVeiculosAgrupadoPorMarcaModelo());

            while (resultado.next()) {

                int qtd = resultado.getInt("Qtd");
                
                int idMarca = resultado.getInt("idModelo");
                String marca = resultado.getString("Marca");
                String modelo = resultado.getString("Modelo");                

                veiculos.add(
                        new AgrupadoPorMarcaModelo(
                                new Modelo(idMarca, marca, modelo),qtd));

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
    
    public ArrayList<MaiorMenorPrecoPorAno> listarMaiorMenorPrecoPorAno() {
        
        ArrayList<MaiorMenorPrecoPorAno> veiculos = 
                 new ArrayList<MaiorMenorPrecoPorAno>();

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(Querys.listarMaiorMenorPrecoPorAno());

            while (resultado.next()) {

                int ano = resultado.getInt("Ano");                
                float maiorPreco = resultado.getFloat("MaiorPreco");
                float menorPreco = resultado.getFloat("MenorPreco");
                String marca = resultado.getString("Marca");                
                String modelo = resultado.getString("Modelo");                

                veiculos.add(new MaiorMenorPrecoPorAno(ano, menorPreco, maiorPreco, marca, modelo));
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
    
    public boolean excluirVeiculo(int id){
        return ExecutarComando(Querys.excluirVeiculo(id));        
    }
    
    
    public boolean excluirMarcaModelo(int id){
        return ExecutarComando(Querys.excluirMarcaModelo(id));
    }
    
     public Modelo buscarModeloPorId(int idVeiculo) {

        Modelo modelo = null;

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            
            String query = Querys.buscarModeloPorId(idVeiculo);
            ResultSet resultado = statement.executeQuery(query);

            if (resultado.next()) {

                int id = resultado.getInt("id");                
                String marca = resultado.getString("marca");
                String nomeModelo = resultado.getString("modelo");
                

                modelo = new Modelo(id, marca, nomeModelo);
                        
            }

            statement.close();
            return modelo;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return modelo;

    }
     
     
     public boolean atualizarModelo(Modelo modelo){
         return ExecutarComando(Querys.atualizarModelo(modelo));
     }
     
     
     public boolean atualizarEstado(Estado estado){
         return ExecutarComando(Querys.atualizarEstado(estado));
     }
     
     
     public Estado buscarEstadoPorId(int estadoId) {

        Estado estado = null;

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            
            String query = Querys.buscarEstadoPorId(estadoId);
            ResultSet resultado = statement.executeQuery(query);

            if (resultado.next()) {

                int id = resultado.getInt("id");                
                String nome = resultado.getString("nome");
                String uf = resultado.getString("uf");
                

                estado = new Estado(id, nome, uf);
                        
            }

            statement.close();
            return estado;

        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao tentar executar um comando "
                    + "no banco de dados");

            System.out.println("Erro: " + e.getMessage());
        }

        return estado;

    }
     
     
     public Loja buscarLojaPorId(int lojaId) {

        Loja loja = null;

        try {

            montarConexao();
            Statement statement = conexao.createStatement();
            
            String query = Querys.buscarLojaPorId(lojaId);
            ResultSet resultado = statement.executeQuery(query);

            if (resultado.next()) {

                int id = resultado.getInt("id");                
                String nome = resultado.getString("nome");
                
                loja = new Loja(id, nome);
                        
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
     
     public boolean excluirLoja(int id){
         return ExecutarComando(Querys.excluirLoja(id));
     }
     
     public boolean atualizarLoja(Loja loja){
         return ExecutarComando(Querys.AtualizarLojas(loja));
     }
     
     
     
    
    
    
    
    
    
}
