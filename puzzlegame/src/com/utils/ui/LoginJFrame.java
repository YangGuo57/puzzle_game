package com.utils.ui;

import com.utils.domain.User;
import com.utils.util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    static ArrayList<User> allUsers = new ArrayList<>();

    static {
        allUsers.add(new User("zhangsan", "123"));
        allUsers.add(new User("lisi", "1234"));
    }

    JButton login = new JButton();
    JButton register = new JButton();

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();
    JLabel rightCode = new JLabel();

    public LoginJFrame() {
        initJFrame();
        initView();
        this.setVisible(true);
    }

    public void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("image/login/用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        JLabel passwordText = new JLabel(new ImageIcon("image/login/密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        JLabel codeText = new JLabel(new ImageIcon("image/login/验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        code.setBounds(195, 256, 100, 30);
        code.addMouseListener(this);
        this.getContentPane().add(code);

        String codeStr = CodeUtil.getCode();
        rightCode.setText(codeStr);
        rightCode.addMouseListener(this);
        rightCode.setBounds(300, 256, 50, 30);
        this.getContentPane().add(rightCode);

        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);

        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("image/login/注册按钮.png"));
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);
        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    public void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("Sliding Puzzle V1.0Login");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login) {
            System.out.println("click login");
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String codeInput = code.getText();

            User userInfo = new User(usernameInput, passwordInput);
            System.out.println("Username:" + usernameInput);
            System.out.println("Pwd:" + passwordInput);

            if (codeInput.isEmpty()) {
                showJDialog("Code cannt be empty");
            } else if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
                System.out.println("Username or Pwd is empty");
                showJDialog("Username or Pwd is empty");


            } else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
                showJDialog("Code is wrong");
            } else if (contains(userInfo)) {
                System.out.println("Start game!");
                this.setVisible(false);
                new GameJFrame();
            } else {
                System.out.println("Username or Pwd is wrong");
                showJDialog("Username or Pwd is wrong");
            }
        } else if (e.getSource() == register) {
            System.out.println("click register");
        } else if (e.getSource() == rightCode) {
            System.out.println("change code");
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }

    public void showJDialog(String content) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);

        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        jDialog.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("image/login/注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("image/login/登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("image/login/注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean contains(User userInput) {
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if (userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
