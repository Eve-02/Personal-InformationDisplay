package view;

import controller.registerAction;
import utils.JDBCUtils;
import utils.MyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePasswordDialog extends JDialog {

    private int id;

    public ChangePasswordDialog(int id){
        this.id = id;
        init();
        this.setTitle("账户设置");
        setBounds(200,200,800,542);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    private void init() {
        Container container=getContentPane();
        this.setLayout(null);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(360,56,358,394);
        panel.setBackground(new Color(255,255,255,255));
        JLabel text=new JLabel("修改密码");
        JLabel oldpass=new JLabel("旧密码:");
        JPasswordField oldTfd=new JPasswordField();
        JLabel newpass= new JLabel("新密码:");
        JPasswordField newTfd=new JPasswordField();
        JLabel againpass=new JLabel("确认密码:");
        JPasswordField againTfd=new JPasswordField();
        JButton jButton=new JButton("确认修改");
        jButton.setBounds(126,300,140,40);
        jButton.setFont(new Font("宋体",Font.PLAIN,25));
        jButton.setBackground(new Color(0x169BD5));
        jButton.setForeground(Color.white);
        jButton.setFocusPainted(false);
        panel.add(jButton);

        oldpass.setBounds(37,101,120,24);
        oldpass.setFont(new Font("楷体",Font.PLAIN,25));
        panel.add(oldpass);
        oldTfd.setBounds(150,95,179,35);
        panel.add(oldTfd);

        newpass.setBounds(37,170,120,24);
        newpass.setFont(new Font("楷体",Font.PLAIN,25));
        panel.add(newpass);
        newTfd.setBounds(150,164,179,35);
        panel.add(newTfd);

        againpass.setBounds(37,239,120,25);
        againpass.setFont(new Font("楷体",Font.PLAIN,25));
        panel.add(againpass);
        againTfd.setBounds(150,233,179,31);
        panel.add(againTfd);
        text.setBounds(126,30,110,24);
        text.setFont(new Font("宋体",Font.BOLD,25));
        panel.add(text);

        container.add(panel);

        panel.setLayout(null);
        ImageIcon imageIcon=new ImageIcon("images/u54.jpg");
        JLabel label_bg=new JLabel();
        label_bg.setIcon(imageIcon);
        label_bg.setBounds(0,0,800,542);
        getLayeredPane().add(label_bg,new Integer(Integer.MIN_VALUE));
        container.add(label_bg);

        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPass = new String(oldTfd.getPassword());
                String newPass = new String(newTfd.getPassword());
                String againPass = new String(againTfd.getPassword());
                if(oldPass.equals("") || newPass.equals("") || againPass.equals("")){
                    JOptionPane.showMessageDialog( null, "旧密码、新密码、确认密码不能为空!");
                }else{
                    String sql = "select password from account where id=?";
                    Connection connection = JDBCUtils.getConnection();
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1,id);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            String old_P = resultSet.getString("password");
                            if(old_P.equals(oldPass)){
                                if(newPass.equals(againPass)){
                                    registerAction registerAction = new registerAction();
                                    int i = registerAction.changeAccount(id, newPass);
                                    if(i>0){
                                        JOptionPane.showMessageDialog( null, "修改成功!");
                                        dispose();
                                    }else{
                                        JOptionPane.showMessageDialog( null, "修改失败!");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog( null, "新密码与确认密码不匹配!");
                                }
                            }else{
                                JOptionPane.showMessageDialog( null, "旧密码不正确!");
                            }
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (MyException ex) {
                        JOptionPane.showMessageDialog( null, ex.toString());
                    }
                }
            }
        });

    }

}
