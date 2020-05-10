/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import comum.Banco;
import entidades.Estado;
import entidades.Loja;
import entidades.Modelo;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Lizandra
 */
public class TabelaJTable {
    
    
    private Banco _db;

    public TabelaJTable(Banco banco) {
        _db = banco;
    }
    
    
    public void montarEstados(JTable tabela) {
        ArrayList<Estado> estados = _db.listarEstados();
        montarEstados(tabela, estados);
    }
    
    public void montarEstados(JTable tabela, ArrayList<Estado> estados) {

        String[] colunas = {"Id", "UF", "Estado"};
        
        Object[][] data = new Object[estados.size()][4];
        for (int indiceLinha = 0; indiceLinha < estados.size(); indiceLinha++) {

            Estado veiculo = estados.get(indiceLinha);

            data[indiceLinha][0] = veiculo.getId();
            data[indiceLinha][1] = veiculo.getUf();
            data[indiceLinha][2] = veiculo.getNome();
            
            
        }

        DefaultTableModel model = new DefaultTableModel(data, colunas);
        tabela.setModel(model);

        TableColumnModel modeloColuna = tabela.getColumnModel();
        modeloColuna.getColumn(0).setPreferredWidth(3);
        

    }    
    
    
    
    
    public void montarModelos(JTable tabela){
        ArrayList<Modelo> modelos = _db.listarMarcasModelos();
        montarModelos(tabela, modelos);
        
    }
    
    
    public void montarModelos(JTable tabela, ArrayList<Modelo> modelos) {

        String[] colunas = {"Id", "Marca", "Modelo"};
        
        Object[][] data = new Object[modelos.size()][4];
        for (int indiceLinha = 0; indiceLinha < modelos.size(); indiceLinha++) {

            Modelo veiculo = modelos.get(indiceLinha);

            data[indiceLinha][0] = veiculo.getId();            
            data[indiceLinha][1] = veiculo.getMarca();
            data[indiceLinha][2] = veiculo.getModelo();
            
        }

        DefaultTableModel model = new DefaultTableModel(data, colunas);
        tabela.setModel(model);

        TableColumnModel modeloColuna = tabela.getColumnModel();
        modeloColuna.getColumn(0).setPreferredWidth(3);        

    }    
    
    
    public void montarLojas(JTable tabela) {
        ArrayList<Loja> lojas = _db.listarLoja();
        montarLojas(tabela, lojas);
    }
    
    public void montarLojas(JTable tabela, ArrayList<Loja> lojas) {

        String[] colunas = {"Id", "Nome"};
        
        Object[][] data = new Object[lojas.size()][3];
        for (int indiceLinha = 0; indiceLinha < lojas.size(); indiceLinha++) {

            Loja veiculo = lojas.get(indiceLinha);

            data[indiceLinha][0] = veiculo.getId();            
            data[indiceLinha][1] = veiculo.getNome();
            
            
        }

        DefaultTableModel model = new DefaultTableModel(data, colunas);
        tabela.setModel(model);

        TableColumnModel modeloColuna = tabela.getColumnModel();
        modeloColuna.getColumn(0).setPreferredWidth(3);
        

    }    

    
    
    
}
