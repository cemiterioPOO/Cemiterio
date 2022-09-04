package MenuScreen;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import MenuScreen.src.*;

class FamiliaresTable extends AbstractTableModel {
    private static volatile FamiliaresTable famtm;
    private ArrayList<Familiar> familiares;

    private FamiliaresTable(ArrayList<Familiar> familiares) {
        this.familiares = familiares;
    }
    
    public static FamiliaresTable getInstance(ArrayList<Familiar> familiares) {
        FamiliaresTable instance = famtm;
        if (instance == null) {
            synchronized (FamiliaresTable.class) {
                instance = famtm;
                if (instance == null) {
                    famtm = instance = new FamiliaresTable(familiares);
                }
            }
        }
        return instance;
    }

    @Override
    public String getColumnName(int column) {
        return getFamiliaresColumns()[column];
    }

    @Override
    public int getRowCount() {
        return  this.familiares.size();
    }

    @Override
    public int getColumnCount() {
        return getFamiliaresColumns().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return familiares.get(rowIndex).getCpf();
            case 1:
                return (Object) ((String) familiares.get(rowIndex).getNome()).concat(" ").concat((String)familiares.get(rowIndex).getSobrenome());
            case 2:
                return familiares.get(rowIndex).getGenero();
            case 3:
                return familiares.get(rowIndex).getReligiao();
            case 4:
                return familiares.get(rowIndex).getEstadoCivil();
            case 5:
                return familiares.get(rowIndex).getTelefone();
            case 6:
                return familiares.get(rowIndex).getDataNasc();
            default:
                break;
        }
        return null;
    }

    public void addFamiliar (Familiar familiar) {
        this.familiares.add(familiar);
        this.fireTableDataChanged();
    }

    public ArrayList<Familiar> getFamiliaresList () {
        return this.familiares;
    }

    public String[] getFamiliaresColumns() {
        String[] familiaresTableColumns = {"CPF", "Nome", "Gênero", "Religião", "Estado civil",
                "Telefone", "Data de Nascimento"};
        return familiaresTableColumns;
    }
}