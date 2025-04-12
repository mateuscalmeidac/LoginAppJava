package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginApp {
    // Simulação de banco de dados com usuários e senhas
    private static HashMap<String, String> usersDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Adicionando usuários ao banco de dados simulado
        usersDatabase.put("admin", "12345");
        usersDatabase.put("user", "senha");

        // Criando a interface gráfica (frontend)
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Label de usuário
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Campo de texto para o usuário
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Label de senha
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // Campo de senha
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 100, 25);
        panel.add(loginButton);

        // Mensagem de status
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(10, 110, 300, 25);
        panel.add(statusLabel);

        // Ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());

                // Validação de credenciais (backend)
                if (usersDatabase.containsKey(user) && usersDatabase.get(user).equals(password)) {
                    statusLabel.setText("Login bem-sucedido!");
                } else {
                    statusLabel.setText("Usuário ou senha inválidos.");
                }
            }
        });
    }
}