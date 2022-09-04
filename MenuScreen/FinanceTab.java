package MenuScreen;

import java.awt.*;
import javax.swing.*;

import MenuScreen.src.Funcionario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FinanceTab extends JPanel implements ActionListener {

    FinanceTab() {
        setLayout(new GridLayout(4, 1));
        JPanel financesPanel = new JPanel();
        JLabel salariosLabel = new JLabel("Salários: ");
        double salarios = 0;
        for (int i = 0; i < FuncionariosTable.getInstance(new ArrayList<Funcionario>()).getFuncionariosList().size(); i++) 
            salarios+=FuncionariosTable.getInstance(new ArrayList<Funcionario>()).getFuncionariosList().get(i).getRemuneracao();
        JLabel valSalLabel = new JLabel(String.valueOf(salarios));
        financesPanel.add(salariosLabel);
        financesPanel.add(valSalLabel);
        add(financesPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
