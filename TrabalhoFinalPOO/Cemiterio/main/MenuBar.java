


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBar extends JMenuBar implements ActionListener {

    public MenuBar() {
        JMenu file = new JMenu();
        file.setText("File");

        JMenuItem save = new JMenuItem();
        save.setText("Save");
        save.setActionCommand("saveOpt");
        save.addActionListener(this);
        file.add(save);
        this.add(file);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JMenuItem) e.getSource()).getActionCommand();
        switch (command) {
            case "saveOpt":
                int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja salvar as modificações?", "Arquivo", 0);
                if (confirm == 0) {
                    try {
                        ReadWrite.getInstance("").writeStatic();
                    } catch (Exception ex) {
                    }
                }
                else {}
                break;
            default:
                break;
        }
    }
}
