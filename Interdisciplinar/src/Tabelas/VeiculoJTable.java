/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import comum.Banco;
import entidades.AgrupadoPorMarcaModelo;
import entidades.MaiorMenorPrecoPorAno;
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

    public void montarVeiculos(JTable tabela) {
        ArrayList<Veiculo> veiculos = _db.listarVeiculos();
        montarVeiculos(tabela, veiculos);
    }
    
    public void montarVeiculos(JTable tabela, ArrayList<Veiculo> veiculos) {

        String[] colunas = {"Id", "Placa", "Marca", "Modelo", "Ano",
            "Preco", "Estado", "UF", "Loja"};
        
        Object[][] data = montarDados(veiculos);

        DefaultTableModel model = new DefaultTableModel(data, colunas);
        tabela.setModel(model);

        TableColumnModel modeloColuna = tabela.getColumnModel();
        modeloColuna.getColumn(0).setPreferredWidth(3);
        modeloColuna.getColumn(1).setPreferredWidth(2);
        modeloColuna.getColumn(4).setPreferredWidth(2);
        modeloColuna.getColumn(7).setPreferredWidth(2);

    }    
    
     private Object[][] montarDados(ArrayList<Veiculo> veiculos) {

        
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

    public void montarQtdVeiculosPorEModelo(JTable tabela) {

        String[] colunas = {"Marca", "Modelo", "Quantidade"};

        ArrayList<AgrupadoPorMarcaModelo> veiculos
                = _db.listarVeiculosAgrupadoPorMarcaModelo();

        Object[][] data = new Object[veiculos.size()][3];

        for (int indiceLinha = 0; indiceLinha < veiculos.size(); indiceLinha++) {

            AgrupadoPorMarcaModelo veiculo = veiculos.get(indiceLinha);

            data[indiceLinha][0] = veiculo.getMarca();
            data[indiceLinha][1] = veiculo.getModelo();
            data[indiceLinha][2] = veiculo.getQtd();

        }

        DefaultTableModel model = new DefaultTableModel(data, colunas);
        tabela.setModel(model);
    }

    public void montarMairoMenorPrecoPorAno(JTable tabela) {

        String[] colunas = {"Ano", "Maior Preço", "Menor Preço", "Marca", "Modelo"};

        ArrayList<MaiorMenorPrecoPorAno> veiculos
                = _db.listarMaiorMenorPrecoPorAno();

        Object[][] data = new Object[veiculos.size()][5];

        for (int indiceLinha = 0; indiceLinha < veiculos.size(); indiceLinha++) {

            MaiorMenorPrecoPorAno veiculo = veiculos.get(indiceLinha);

            data[indiceLinha][0] = veiculo.getAno();
            data[indiceLinha][1] = veiculo.getMaiorPreco();
            data[indiceLinha][2] = veiculo.getMenorPreco();
            data[indiceLinha][3] = veiculo.getMarca();
            data[indiceLinha][4] = veiculo.getModelo();
        }

        DefaultTableModel model = new DefaultTableModel(data, colunas);
        tabela.setModel(model);
    }

}
