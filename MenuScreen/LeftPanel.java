package MenuScreen;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

public class LeftPanel extends JPanel implements ActionListener{
    LeftPanel() {
        this.setLayout(new GridLayout(3, 1));
			// BufferedImage imagem = new ImageIO.read(new File("Java\\MenuScreen\\icon.png"));
			// JLabel mypicJLabel = new JLabel(new ImageIcon(imagem));
			this.setPreferredSize(new DimensionUIResource(200, 200));
			this.setMaximumSize(new DimensionUIResource(230, 230));
			this.setMinimumSize(new DimensionUIResource(130, 130));
			JLabel titulo = new JLabel("   Sarça Ardente");
			titulo.setFont(new Font("Arial", Font.BOLD, 23));
			this.add(titulo);
			// this.add(mypicJLabel);
			JPanel boxBotoes = new JPanel();
			GridLayout boxBotoesLayout = new GridLayout(3,1);
			boxBotoesLayout.setVgap(30);
			boxBotoesLayout.preferredLayoutSize(this);
			boxBotoes.setLayout(boxBotoesLayout);
			JButton searchButton = new JButton();
			JButton registerButton = new JButton();
			JButton mangementButton = new JButton();
			mangementButton.setText("Finanças");
			searchButton.setText("Pesquisa");	
			registerButton.setText("Cadastro");
			searchButton.setFont(new FontUIResource("Arial", Font.BOLD, 20));
			mangementButton.setFont(new FontUIResource("Arial", Font.BOLD, 20));
			registerButton.setFont(new FontUIResource("Arial", Font.BOLD, 20));
			registerButton.setActionCommand("registerSect");
			registerButton.addActionListener(this);
			mangementButton.setActionCommand("mangementSect");
			mangementButton.addActionListener(this);
			searchButton.setActionCommand("searchSect");
			searchButton.addActionListener(this);
			boxBotoes.add(searchButton);
			boxBotoes.add(registerButton);
			boxBotoes.add(mangementButton);
			this.add(boxBotoes);
			// this.add(mypicJLabel);
			boxBotoes.setAlignmentX(CENTER_ALIGNMENT);
            JLabel usuarioInferiorLabel = new JLabel();
			usuarioInferiorLabel.setVerticalAlignment(3);
			usuarioInferiorLabel.setText("<HTML>&nbsp;Victor Limeira<BR>&nbsp;Gestor de Finanças<BR>&nbsp;014</HTML>");
			this.add(usuarioInferiorLabel);
    }

    @Override
		public void actionPerformed(ActionEvent e) {
			String command = ((JButton) e.getSource()).getActionCommand();
			JPanel abas = (JPanel)this.getParent().getComponent(1);
			switch(command) {
				case "searchSect":
					abas.getComponent(0).setVisible(true);
					abas.getComponent(1).setVisible(false);
					abas.getComponent(2).setVisible(false);
					break;
				case "registerSect":
					abas.getComponent(0).setVisible(false);
					abas.getComponent(1).setVisible(true);
					abas.getComponent(2).setVisible(false);
					break;
				case "mangementSect":
					abas.getComponent(0).setVisible(false);
					abas.getComponent(1).setVisible(false);
					abas.getComponent(2).setVisible(true);
					break;
				default:
					break;
			}
		}
}
