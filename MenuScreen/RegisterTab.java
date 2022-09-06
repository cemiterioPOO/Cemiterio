package MenuScreen;

import MenuScreen.src.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegisterTab extends JPanel implements ActionListener {
    static int selectedPlan;
    static int tipoCadastro;

    RegisterTab() {
        setLayout(new GridLayout(4, 1));
        JPanel commomRegisterPanel = new JPanel();
        commomRegisterPanel.setLayout(new GridLayout(6, 2));
        JComboBox<String> registerComboBox = new JComboBox<>(new String[] { "Defunto", "Familiar", "Funcionário" });
        JTextField nomeText = new JTextField();
        JTextField sobrenomeText = new JTextField();
        JTextField cpfText = new JTextField();
        JTextField dataNascText = new JTextField();
        JComboBox<String> generoComboBox = new JComboBox<>(new String[] {"H", "M"});
        JTextField estadoCivilText = new JTextField();
        commomRegisterPanel.add(new JLabel("Nome"));
        commomRegisterPanel.add(nomeText);
        commomRegisterPanel.add(new JLabel("Sobrenome"));
        commomRegisterPanel.add(sobrenomeText);
        commomRegisterPanel.add(new JLabel("CPF"));
        commomRegisterPanel.add(cpfText);
        commomRegisterPanel.add(new JLabel("Data de Nascimento"));
        commomRegisterPanel.add(dataNascText);
        commomRegisterPanel.add(new JLabel("Gênero"));
        commomRegisterPanel.add(generoComboBox);
        commomRegisterPanel.add(new JLabel("Estado Civil"));
        commomRegisterPanel.add(estadoCivilText);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        JPanel specificRegistrationPanel = new JPanel();
        specificRegistrationPanel.setLayout(new CardLayout());

        JPanel defuntoRegisterPanel = new JPanel();
        JTextField religiaoText2 = new JTextField();
        defuntoRegisterPanel.setLayout(new GridLayout(5, 2));
        defuntoRegisterPanel.add(new JLabel("Plano"));
        JPanel groupPlansButtonsPanel = new JPanel();
        ButtonGroup bGroupPlansButtonsPanel = new ButtonGroup();
        JRadioButton planOneRadioButton = new JRadioButton("Standard");
        JRadioButton planTwoRadioButton = new JRadioButton("Premium");
        bGroupPlansButtonsPanel.add(planOneRadioButton);
        bGroupPlansButtonsPanel.add(planTwoRadioButton);
        groupPlansButtonsPanel.add(planOneRadioButton);
        groupPlansButtonsPanel.add(planTwoRadioButton);
        planOneRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedPlan = 1;
            }
        });
        planTwoRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedPlan = 2;
            }
        });
        defuntoRegisterPanel.add(groupPlansButtonsPanel);
        JTextField dataEnterroText = new JTextField();
        JTextField localizacaoText = new JTextField();
        defuntoRegisterPanel.add(new JLabel("Data do enterro"));
        defuntoRegisterPanel.add(dataEnterroText);
        defuntoRegisterPanel.add(new JLabel("Localização"));
        defuntoRegisterPanel.add(localizacaoText);
        defuntoRegisterPanel.add(new JLabel("Religião"));
        defuntoRegisterPanel.add(religiaoText2);
        specificRegistrationPanel.add(defuntoRegisterPanel);

        JPanel familiarRegisterPanel = new JPanel();
        familiarRegisterPanel.setLayout(new GridLayout(4, 2));
        JTextField enderecoText = new JTextField();
        JTextField telefoneText = new JTextField();
        JTextField religiaoText = new JTextField();
        familiarRegisterPanel.add(new JLabel("Endereço"));
        familiarRegisterPanel.add(enderecoText);
        familiarRegisterPanel.add(new JLabel("Telefone"));
        familiarRegisterPanel.add(telefoneText);
        familiarRegisterPanel.add(new JLabel("Religião"));
        familiarRegisterPanel.add(religiaoText);
        specificRegistrationPanel.add(familiarRegisterPanel);

        JPanel funcionarioRegisterPanel = new JPanel();
        funcionarioRegisterPanel.setLayout(new GridLayout(3, 2));
        JTextField funcaoText = new JTextField();
        JTextField bonificacaoText = new JTextField();
        funcionarioRegisterPanel.add(new JLabel("Função"));
        funcionarioRegisterPanel.add(funcaoText);
        defuntoRegisterPanel.add(new JPanel());
        funcionarioRegisterPanel.add(new JLabel("Bonificação"));
        funcionarioRegisterPanel.add(bonificacaoText);
        defuntoRegisterPanel.add(new JPanel());
        specificRegistrationPanel.add(funcionarioRegisterPanel);
        JButton submitButton = new JButton();
        submitButton.setText("Cadastrar");
        add(registerComboBox);
        add(commomRegisterPanel);
        add(specificRegistrationPanel);
        add(submitButton);
        registerComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (registerComboBox.getSelectedItem().toString()) {
                    case "Defunto":
                        specificRegistrationPanel.getComponent(0).setVisible(true);
                        specificRegistrationPanel.getComponent(1).setVisible(false);
                        specificRegistrationPanel.getComponent(2).setVisible(false);
                        break;
                    case "Familiar":
                        specificRegistrationPanel.getComponent(0).setVisible(false);
                        specificRegistrationPanel.getComponent(1).setVisible(true);
                        specificRegistrationPanel.getComponent(2).setVisible(false);
                        break;
                    case "Funcionário":
                        specificRegistrationPanel.getComponent(0).setVisible(false);
                        specificRegistrationPanel.getComponent(1).setVisible(false);
                        specificRegistrationPanel.getComponent(2).setVisible(true);
                        break;
                }
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcao = JOptionPane.showConfirmDialog(null, "Submeter cadastro?", "Cadastro", 0);
                if (opcao == 1) {
                    // Cancelou o cadastro, ou seja, não faz nada.
                } 
                else {
                    if (registerComboBox.getSelectedItem().toString() == "Defunto")
                        tipoCadastro = 0;
                    else if (registerComboBox.getSelectedItem().toString() == "Familiar")
                        tipoCadastro = 1;
                    else
                        tipoCadastro = 2;
                    if (nomeText.getText().isEmpty() || sobrenomeText.getText().isEmpty() || cpfText.getText().isEmpty() || dataNascText.getText().isEmpty() || estadoCivilText.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, complete todos os campos.", "Cadastro", 3);
                    } 
                    else {
                        if (registerComboBox.getSelectedItem().toString() == "Defunto") {
                            if (dataEnterroText.getText().isEmpty() || localizacaoText.getText().isEmpty())
                                JOptionPane.showMessageDialog(null, "Por favor, complete todos os campos.", "Cadastro", 3);
                            else {
                                try {
                                    Falecido temp = new Falecido(nomeText.getText(), sobrenomeText.getText(), cpfText.getText(), formatter.parse(dataEnterroText.getText()), generoComboBox.getSelectedItem().toString().charAt(0), estadoCivilText.getText(), "", "", 0, 0, "", selectedPlan, formatter.parse(dataEnterroText.getText()), "", religiaoText2.getText());
                                    if (selectedPlan == 0) {
                                        temp.setJazigo(new Jazigo("Temporário", localizacaoText.getText()));
                                    }
                                    else {
                                        temp.setJazigo(new Jazigo("Permanente", localizacaoText.getText()));
                                    }
                                    DefuntosTable.getInstance(new ArrayList<Falecido>()).addFalecido(temp);
                                }
                                catch (Exception ex){
                                    System.out.println(ex.toString());
                                }
                            }
                            
                        }
                        else if (registerComboBox.getSelectedItem().toString() == "Familiar") {
                            if (enderecoText.getText().isEmpty() || telefoneText.getText().isEmpty() || religiaoText.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Por favor, complete todos os campos.", "Cadastro", 3);
                            }
                            else {
                                try {
                                    FamiliaresTable.getInstance(new ArrayList<Familiar>()).addFamiliar(new Familiar(nomeText.getText(), sobrenomeText.getText(), cpfText.getText(), formatter.parse(dataNascText.getText()), generoComboBox.getSelectedItem().toString().charAt(0), estadoCivilText.getText(), "", "", 0, 0, "", telefoneText.getText(), "", religiaoText.getText()));
                                }
                                catch (Exception ex){}
                            }

                        }
                        else {
                            if (funcaoText.getText().isEmpty() || bonificacaoText.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Por favor, complete todos os campos.", "Cadastro", 3);
                            }
                            else { 
                                try {
                                    FuncionariosTable.getInstance(new ArrayList<Funcionario>()).addFuncionario(new Funcionario(nomeText.getText(), sobrenomeText.getText(), cpfText.getText(), formatter.parse(dataNascText.getText()), generoComboBox.getSelectedItem().toString().charAt(0), estadoCivilText.getText(), "", "", 0, 0, "", funcaoText.getText(), Double.parseDouble(bonificacaoText.getText())));
                                }
                                catch (Exception ex){}
                            }
                        }

                        JOptionPane.showMessageDialog(null, "Cadastro submetido com sucesso.", "Cadastro", 1);
                        Component[] commomComponents = commomRegisterPanel.getComponents(); // Limpa todos os campos
                        Component[] specificComponents;
                        for (int i = 0; i < commomComponents.length; i++)
                            if (commomComponents[i].getClass() == JTextField.class) {
                                ((JTextField) commomComponents[i]).setText("");
                            }
                        specificComponents = ((JPanel) specificRegistrationPanel.getComponent(tipoCadastro)).getComponents();
                        for (int i = 0; i < specificComponents.length; i++)
                            if (specificComponents[i].getClass() == JTextField.class)
                                ((JTextField) specificComponents[i]).setText("");
                    }
                }
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
