package com.utils.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterJFrame extends JFrame implements MouseListener {
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField rePassword = new JTextField();

    JButton submit = new JButton();
    JButton reset = new JButton();

    public RegisterJFrame() {
        initFrame();
        initView();
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == submit) {
            submit.setIcon(new ImageIcon("image/register/注册按下.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("image/register/重置按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == submit) {
            submit.setIcon(new ImageIcon("image/register/注册按钮.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("image/register/重置按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("image/register/注册用户名.png"));
        usernameText.setBounds(85, 135, 80, 20);

        username.setBounds(195, 134, 200, 30);

        JLabel passwordText = new JLabel(new ImageIcon("image/register/注册密码.png"));
        passwordText.setBounds(97, 193, 70, 20);

        password.setBounds(195, 195, 200, 30);

        JLabel rePasswordText = new JLabel(new ImageIcon("image/register/再次输入密码.png"));
        rePasswordText.setBounds(64, 255, 95, 20);

        rePassword.setBounds(195, 255, 200, 30);

        submit.setIcon(new ImageIcon("image/register/注册按钮.png"));
        submit.setBounds(123, 310, 128, 47);
        submit.setBorderPainted(false);
        submit.setContentAreaFilled(false);
        submit.addMouseListener(this);

        reset.setIcon(new ImageIcon("image/register/重置按钮.png"));
        reset.setBounds(256, 310, 128, 47);
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.addMouseListener(this);

        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        background.setBounds(0, 0, 470, 390);

        this.getContentPane().add(usernameText);
        this.getContentPane().add(passwordText);
        this.getContentPane().add(rePasswordText);
        this.getContentPane().add(username);
        this.getContentPane().add(password);
        this.getContentPane().add(rePassword);
        this.getContentPane().add(submit);
        this.getContentPane().add(reset);
        this.getContentPane().add(background);
    }

    private void initFrame() {
        setSize(488, 430);
        setTitle("Sliding Puzzle V1.0Register");
        setLayout(null);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }

    JDialog jDialog = new JDialog();

    public void showDialog(String content) {
        if (!jDialog.isVisible()) {
            jDialog.getContentPane().removeAll();
            JLabel jLabel = new JLabel(content);
            jLabel.setBounds(0, 0, 200, 150);
            jDialog.add(jLabel);
            jDialog.setSize(200, 150);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
    }
}
