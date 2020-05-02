/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import comum.Banco;
import entidades.Veiculo;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Lizandra
 */
public class VeiculoJTable {
    
    private Banco _db;
    

    public VeiculoJTable(Banco banco) {
        _db = banco;
    }    
    
    public void montarVeiculos(JTable tabela){
        
        String[] colunas = { "Id", "Placa", "Marca", "Modelo", "Ano", 
            "Preco", "Estado", "UF", "Loja", "Editar" };
        
        Object[][] data = montarDados();
        
        DefaultTableModel model = new DefaultTableModel(data, colunas);
        tabela.setModel(model);
        
        TableColumnModel modeloColuna = tabela.getColumnModel();
        modeloColuna.getColumn(0).setPreferredWidth(3);
        modeloColuna.getColumn(1).setPreferredWidth(2);
        modeloColuna.getColumn(4).setPreferredWidth(2);
        modeloColuna.getColumn(7).setPreferredWidth(2);
        
    }  

    private Object[][] montarDados() {
        
        ArrayList<Veiculo> veiculos = _db.listarVeiculos();
        Object[][] data = new Object[veiculos.size()][9];
        for (int indiceLinha = 0; indiceLinha < veiculos.size(); indiceLinha++) {
            
            Veiculo veiculo = veiculos.get(indiceLinha);
            
            data[indiceLinha][0] = veiculo.getId();
            data[indiceLinha][1] = veiculo.getPlaca();
            data[indiceLinha][2] = veiculo.getMarca();
            data[indiceLinha][3] = veiculo.getModelo();
            data[indiceLinha][4] = veiculo.getAno();
            data[indiceLinha][5] = veiculo.getPreco();
            data[indiceLinha][6] = veiculo.getEstado();
            data[indiceLinha][7] = veiculo.getUF();
            data[indiceLinha][8] = veiculo.getLoja();
        }
        return data;
    }
    
    
    
}
