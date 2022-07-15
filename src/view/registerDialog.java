package view;

import controller.registerAction;
import controller.userInfoAction;
import utils.MyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class registerDialog extends JDialog {

    private JTextField emailTfd;
    private JPasswordField passwordTfd;

    public registerDialog(){
        init();
        this.setTitle("登录");
        setBounds(200, 200, 800, 542);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        Container container = getContentPane();
        container.setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(252,56,332,405);
        panel.setBackground(new Color(255, 255, 255, 255));

        JLabel email=new JLabel("邮箱:");
        JLabel password=new JLabel("密码:");
        emailTfd=new JTextField();
        passwordTfd=new JPasswordField();
        JLabel text=new JLabel("免费注册");
        JCheckBox jCheckBox=new JCheckBox("同意注册协议和隐私条款");
        JButton jButton=new JButton("注册");

        jButton.setBounds(130,270,120,40);
        jButton.setFont(new Font("宋体",Font.PLAIN,25));
        jButton.setBackground(new Color(0x169BD5));
        jButton.setForeground(Color.white);
        jButton.setFocusPainted(false);
        panel.add(jButton);

        email.setBounds(37,101,63,22);
        email.setFont(new Font("楷体",Font.PLAIN,25));
        panel.add(email);
        emailTfd.setBounds(110,95,170,35);
        panel.add(emailTfd);

        password.setBounds(37,170,63,22);
        password.setFont(new Font("楷体",Font.PLAIN,25));
        panel.add(password);
        passwordTfd.setBounds(110,164,170,35);
        panel.add(passwordTfd);

        text.setBounds(135,30,150,30);
        text.setFont(new Font("宋体",Font.BOLD,25));
        panel.add(text);

        jCheckBox.setBounds(37,220,200,17);
        jCheckBox.setForeground(Color.BLUE);
        jCheckBox.setFont(new Font("宋体",Font.PLAIN,14));
        jCheckBox.setBackground(new Color(255,255,255,255));
        jCheckBox.setFocusPainted(false);
        panel.add(jCheckBox);
        container.add(panel);

        panel.setLayout(null);
        ImageIcon imageIcon=new ImageIcon("images/u0.png");
        JLabel label_bg=new JLabel();
        label_bg.setIcon(imageIcon);
        label_bg.setBounds(0,0,800,542);
        getLayeredPane().add(label_bg,new Integer(Integer.MIN_VALUE));
        container.add(label_bg);

        // 注册事件
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBox.isSelected()){
                    if(emailTfd.getText().equals("")||new String(passwordTfd.getPassword()).equals("")){
                        JOptionPane.showMessageDialog( null, "账号和密码不能为空!");
                    }else{
                        registerAction r = new registerAction();
                        try {
                            int i = r.addAccount(emailTfd.getText(), new String(passwordTfd.getPassword()));
                            if(i>0){
                                JOptionPane.showMessageDialog( null, "注册成功!");
                                new userInfoAction().addInfo(emailTfd.getText());
                                setVisible(false);
                            }else{
                                JOptionPane.showMessageDialog( null, "注册失败!");
                            }
                        } catch (MyException ex) {
                            JOptionPane.showMessageDialog( null, ex.toString());
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog( null, "请勾选同意注册协议和隐私条款!");
                }
            }
        });


    }
}

