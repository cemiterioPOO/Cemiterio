package MenuScreen;

import java.awt.*;
import javax.swing.*;

import MenuScreen.src.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FinanceTab extends JPanel implements ActionListener {

    FinanceTab() {
        setLayout(new GridLayout(8, 1));
        JPanel financesPanel = new JPanel();
        financesPanel.setLayout(new GridLayout(3, 2));
        JLabel salariosLabel = new JLabel("Salários: ");
        JLabel pagamentosLabel = new JLabel("Pagamentos: ");
        JLabel totaLabel = new JLabel("Total: ");
        double salarios = 0;
        double pagamentos = 0;
        for (int i = 0; i < FuncionariosTable.getInstance(new ArrayList<Funcionario>()).getFuncionariosList().size(); i++) 
            salarios+=FuncionariosTable.getInstance(new ArrayList<Funcionario>()).getFuncionariosList().get(i).getRemuneracao();
        for (int i = 0; i < DefuntosTable.getInstance(new ArrayList<Falecido>()).getFalecidosList().size(); i++) 
            pagamentos+=DefuntosTable.getInstance(new ArrayList<Falecido>()).getFalecidosList().get(i).getPagamento();
        double total = pagamentos - salarios;
        JLabel valSalLabel = new JLabel(String.valueOf(salarios));
        JLabel valPagLabel = new JLabel(String.valueOf(pagamentos));
        JLabel valTotalLabel = new JLabel(String.valueOf(total));
        valTotalLabel.setFont(new Font("Arial", Font.BOLD, 15));
        valPagLabel.setFont(new Font("Arial", Font.BOLD, 15));
        valSalLabel.setFont(new Font("Arial", Font.BOLD, 15));
        salariosLabel.setFont(new Font("Arial", Font.BOLD, 15));
        pagamentosLabel.setFont(new Font("Arial", Font.BOLD, 15));
        totaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        totaLabel.setForeground(Color.RED);
        valTotalLabel.setForeground(Color.RED);
        financesPanel.add(salariosLabel);
        financesPanel.add(valSalLabel);
        financesPanel.add(pagamentosLabel);
        financesPanel.add(valPagLabel);
        financesPanel.add(totaLabel);
        financesPanel.add(valTotalLabel);
        add(financesPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
