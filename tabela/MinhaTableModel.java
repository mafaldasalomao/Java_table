package tabela;

import javax.swing.table.AbstractTableModel;

public class MinhaTableModel extends AbstractTableModel {

    private String[] tituloColunas;
    private Object[][] data;
    private int linhas, colunas;


    public MinhaTableModel(String[] tituloColunas, int numLinhas, int numColunas) {
        this.tituloColunas = tituloColunas;
        this.data = new Object[numLinhas][numColunas];
        linhas = numLinhas;
        colunas = numColunas;
    }

    public String getColumnName(int col) {
        return tituloColunas[col];
    }
    @Override
    public int getColumnCount() {
        return colunas;
    }
    @Override
    public int getRowCount() {
        return linhas;
    }
    @Override
    public Object getValueAt(int linha, int coluna) {
        return data[linha][coluna];
    }
    public void setValueAt(Object valor, int linha, int coluna) {
        data[linha][coluna] = valor.toString();
        fireTableCellUpdated(linha, coluna);
    }
}