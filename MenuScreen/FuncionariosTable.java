package MenuScreen;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import MenuScreen.src.*;

class FuncionariosTable extends AbstractTableModel {
    private static volatile FuncionariosTable funtm;
    private ArrayList<Funcionario> funcionarios;

    private FuncionariosTable(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public static FuncionariosTable getInstance (ArrayList<Funcionario> funcionarios) {
        FuncionariosTable instance = funtm;
        if (instance == null) {
            synchronized (FuncionariosTable.class) {
                instance = funtm;
                if (instance == null) {
                    funtm = instance = new FuncionariosTable(funcionarios);
                }
            }
        }
        return instance;
    }

    @Override
    public String getColumnName(int column) {
        return getFuncionariosColumns()[column];
    }

    @Override
    public int getRowCount() {
        return this.funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return getFuncionariosColumns().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return funcionarios.get(rowIndex).getCpf();
            case 1:
            return (Object) ((String) funcionarios.get(rowIndex).getNome()).concat(" ").concat((String) funcionarios.get(rowIndex).getSobrenome());
            case 2:
            return funcionarios.get(rowIndex).getFuncao();
            case 3:
                return funcionarios.get(rowIndex).getRemuneracao();
            case 4:
                return funcionarios.get(rowIndex).getGenero();
            case 5:
                return funcionarios.get(rowIndex).getEstadoCivil();
            case 6:
                return funcionarios.get(rowIndex).getDataNasc();
            default:
                break;
        }
        return null;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        this.fireTableDataChanged();
    }

    public ArrayList<Funcionario> getFuncionariosList() {
        return this.funcionarios;
    }

    public String[] getFuncionariosColumns() {
        String[] funcionariosTableColumns = { "CPF", "Nome", "Função", "Remuneração", "Gênero", "Estado Civil",
                "Data de Nascimento"};
        return funcionariosTableColumns;
    }
}