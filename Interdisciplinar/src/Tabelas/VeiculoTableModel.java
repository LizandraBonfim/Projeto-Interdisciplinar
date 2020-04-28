/*
package Tabelas;

import entidades.Veiculo;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

*/


/**
 *
 * @author Lizandra
 */

/*
public class VeiculoTableModel extends AbstractTableModel {

    private List<Veiculo> _veiculos;
    private String[] colunas = new String[]{
        "Id", "Placa", "Ano", "Modelo", "Preco", "Estado"
    };

    
    public VeiculoTableModel(List<Veiculo> veiculos) {
        this._veiculos = veiculos;
    }

    public VeiculoTableModel() {
        this._veiculos = new ArrayList<Veiculo>();
    }

    public int getRowCount() {
        return _veiculos.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void setValueAt(Veiculo aValue, int rowIndex) {
        Veiculo veiculo = _veiculos.get(rowIndex);

        veiculo.set(aValue.getLogin());
        veiculo.setNome(aValue.getNome());
        veiculo.setSenha(aValue.getSenha());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usuario usuario = _veiculos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                usuario.setLogin(aValue.toString());
            case 1:
                usuario.setNome(aValue.toString());
            case 2:
                usuario.setSenha(aValue.toString());

            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuarioSelecionado = _veiculos.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                valueObject = usuarioSelecionado.getLogin();
                break;
            case 1:
                valueObject = usuarioSelecionado.getNome();
                break;
            case 2:
                valueObject = usuarioSelecionado.getSenha();
                break;
            default:
                System.err.println("Índice inválido para propriedade do bean Usuario.class");
        }

        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Usuario getUsuario(int indiceLinha) {
        return _veiculos.get(indiceLinha);
    }

    public void addUsuario(Usuario u) {
        _veiculos.add(u);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeUsuario(int indiceLinha) {
        _veiculos.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeUsuarios(List<Usuario> novosUsuarios) {

        int tamanhoAntigo = getRowCount();
        _veiculos.addAll(novosUsuarios);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        _veiculos.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return _veiculos.isEmpty();
    }

}
*/