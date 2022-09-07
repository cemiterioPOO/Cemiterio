

import java.io.*;
import java.util.ArrayList;

public class ReadWrite {
    private static volatile ReadWrite rw;
    public DefuntosTable defuntosAbsTable;
    public FamiliaresTable familiaresAbsTable;
    public FuncionariosTable funcionariosAbsTable;
    private FileInputStream fis;
    private FileOutputStream fos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private ReadWrite(String path) throws Exception {
        this.fis = new FileInputStream(new File(path));
    }

    public static ReadWrite getInstance(String path) throws Exception {
        ReadWrite instance = rw;
        if (instance == null) {
            synchronized (ReadWrite.class) {
                if (instance == null) {
                    rw = instance = new ReadWrite(path);
                }
            }
        }
        return instance;
    }

    public void readStatic() throws Exception {
        this.ois = new ObjectInputStream(this.fis);
        ArrayList<Object> objectsData = (ArrayList<Object>) ois.readObject();
        ArrayList<Falecido> falecidosList = new ArrayList<>();
        ArrayList<Familiar> familiaresList = new ArrayList<>();
        ArrayList<Funcionario> funcionariosList = new ArrayList<>();
        for (int i = 0; i < objectsData.size(); i++) {
            if (objectsData.get(i) instanceof Falecido)
                falecidosList.add(((Falecido) objectsData.get(i)));
            else if (objectsData.get(i) instanceof Familiar)
                familiaresList.add(((Familiar) objectsData.get(i)));
            else if (objectsData.get(i) instanceof Funcionario)
                funcionariosList.add(((Funcionario) objectsData.get(i)));
        }
        this.defuntosAbsTable = DefuntosTable.getInstance(falecidosList);
        this.familiaresAbsTable = FamiliaresTable.getInstance(familiaresList);
        this.funcionariosAbsTable = FuncionariosTable.getInstance(funcionariosList);
    }

    public void writeStatic() throws Exception{
        fos = new FileOutputStream(MenuFrame.class.getResource("data.ser").getPath());
        oos = new ObjectOutputStream(fos);
        ArrayList<Object> temp = new ArrayList<>();
        temp.addAll(DefuntosTable.getInstance(new ArrayList<Falecido>()).getFalecidosList());
        temp.addAll(FuncionariosTable.getInstance(new ArrayList<Funcionario>()).getFuncionariosList());
        temp.addAll(FamiliaresTable.getInstance(new ArrayList<Familiar>()).getFamiliaresList());
        oos.writeObject(temp);
        oos.close();
        fos.close();
    }
}
