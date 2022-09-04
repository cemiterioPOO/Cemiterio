package MenuScreen;

import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.DimensionUIResource;


public class MenuFrame extends JFrame {

		MenuFrame () {
			setLayout(new BorderLayout());
			setTitle("Cemitério Sarça Ardente");
			JPanel flipTabsPanel = new JPanel();
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setMinimumSize(new DimensionUIResource(620, 440));
			add(new LeftPanel(), BorderLayout.WEST); // Painel Esquerdo
			setJMenuBar(new MenuBar()); // Menu Bar
			flipTabsPanel.setLayout(new CardLayout());
			flipTabsPanel.add(new SearchTab(), "searchTab"); // Aba Pesquisa
			flipTabsPanel.add(new RegisterTab(), "registerTab"); // Aba Cadastro
			flipTabsPanel.add(new FinanceTab(), "financeTab"); // Aba Finanças
			add(flipTabsPanel, BorderLayout.CENTER); // Abas
			pack();
			setLocationRelativeTo(null); 
			setVisible(true);
		}

		public static void main (String[] args) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e) {}
			new LoginFrame();
		}

}
