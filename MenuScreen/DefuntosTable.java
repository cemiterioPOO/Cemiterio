package MenuScreen;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import MenuScreen.src.*;

class DefuntosTable extends AbstractTableModel {
    private static volatile DefuntosTable dtm;
    private ArrayList<Falecido> defuntos;

    private DefuntosTable(ArrayList<Falecido> defuntos) {
        this.defuntos = defuntos;
    }

    public static DefuntosTable getInstance(ArrayList<MenuScreen.src.Falecido> arrayList) {
        DefuntosTable instance = dtm;
        if (instance == null) {
            synchronized (DefuntosTable.class) {
                instance = dtm;
                if (instance == null) {
                    dtm = instance = new DefuntosTable(arrayList);
                }
            }
        }
        return instance;
    }

    @Override
    public String getColumnName(int column) {
        return getDefuntosColumns()[column];
    }

    @Override
    public int getRowCount() {
        return this.defuntos.size();
    }

    @Override
    public int getColumnCount() {
        return getDefuntosColumns().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return defuntos.get(rowIndex).getId();
            case 1:
                return defuntos.get(rowIndex).getJazigo(); 
            case 2:
                return defuntos.get(rowIndex).getCpf();
            case 3:
                return (Object) ((String) defuntos.get(rowIndex).getNome()).concat(" ").concat((String)defuntos.get(rowIndex).getSobrenome());
            case 4:
                return defuntos.get(rowIndex).getGenero();
            case 5:
                return defuntos.get(rowIndex).getEstadoCivil();
            case 6:
                return defuntos.get(rowIndex).getDataNasc();
            case 7:
                return defuntos.get(rowIndex).getPlano();
            case 8:
                return defuntos.get(rowIndex).getReligiao();
            case 9:
                return defuntos.get(rowIndex).getDataEnterro();
            default:
                break;
        }
        return null;

    }

    public void addFalecido(Falecido defunto) {
        this.defuntos.add(defunto);
        this.fireTableDataChanged();
    }


    public ArrayList<Falecido> getFalecidosList() {
        return this.defuntos;
    }

    public String[] getDefuntosColumns() {
        String[] defuntosTableColumns = { "ID", "Localização", "CPF", "Nome", "Gênero", "Estado civil",
                "Data de Nascimento", "Plano", "Religião", "Data do Enterro" };
        return defuntosTableColumns;
    }

}