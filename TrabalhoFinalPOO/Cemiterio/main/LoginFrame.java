


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.plaf.DimensionUIResource;

public class LoginFrame extends JFrame implements ActionListener {
    static public boolean pressed = false;
    static public boolean validPress = false;

    LoginFrame() {
        DimensionUIResource windowSize = new DimensionUIResource(450, 500);
        setLayout(null);
        setTitle("Login");
        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton();
        JLabel wrongPasswordLabel = new JLabel("Login ou Senha incorretos");
        JLabel loginLabel = new JLabel("Login:");
        JLabel passLabel = new JLabel("Senha:");
        loginButton.setText("Entrar");
        loginField.setSize(200, 20);
        passwordField.setSize(200, 20);
        passwordField.setLocation(145, 200);
        loginField.setLocation(145, 150);
        passLabel.setSize(40, 40);
        loginLabel.setSize(40, 40);
        passLabel.setLocation(90, 189);
        loginLabel.setLocation(91, 139);
        loginButton.setSize(120, 30);
        loginButton.setLocation(155, 270);
        wrongPasswordLabel.setSize(150, 150);
        wrongPasswordLabel.setLocation(155, 310);
        add(loginLabel);
        add(loginField);
        add(passLabel);
        add(passwordField);
        add(loginButton);
        add(wrongPasswordLabel);
        wrongPasswordLabel.setVisible(false);
        loginField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pressed = true;
                if (validPress) {
                    validPress = false;
                    wrongPasswordLabel.setVisible(false);
                }
            }
        });

        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pressed = true;
                if (validPress) {
                    validPress = false;
                    wrongPasswordLabel.setVisible(false);
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordAuthentication(loginField.getText().toString(), String.valueOf(passwordField.getPassword()))) {
                    dispose();
                    new MenuFrame();
                } else if (pressed)
                    wrongPasswordLabel.setVisible(true);
                validPress = true;
            }
        });;
        setPreferredSize(windowSize);
        setMinimumSize(windowSize);
        setMaximumSize(windowSize);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }

    private boolean passwordAuthentication(String login, String password) {
        if (login.equals("user") && password.equals("user123"))
            return true;
        else
            return false;
    }

}
