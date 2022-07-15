package view;

import utils.JDBCUtils;
import utils.MyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.ExceptionDealUtils.*;

@SuppressWarnings({"all"})
public class LoginFrame extends JFrame {

    public LoginFrame() {
        init();
        setTitle("登录");
        setVisible(true);
        setResizable(false);
        setBounds(560, 240, 800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel mail = new JLabel("邮箱:");
        JTextField mailTfd = new JTextField();
        mailTfd.setPreferredSize(new Dimension(300, 30));

        JLabel psdLable = new JLabel("密码:");
        JPasswordField psdTfd = new JPasswordField();
        psdTfd.setPreferredSize(new Dimension(300, 30));

        JButton Longin =new JButton("登录");
        JButton Register=new JButton("注册");

        psdLable.setFont(new Font("楷体", Font.BOLD, 30));
        mail.setFont(new Font("楷体", Font.BOLD, 30));
        mailTfd.setFont(new Font("宋体", Font.PLAIN, 15));
        psdTfd.setFont(new Font("宋体", Font.PLAIN, 15));
        Longin.setFont(new Font("宋体", Font.PLAIN, 20));
        Register.setFont(new Font("宋体", Font.PLAIN, 20));

        Longin.setFocusPainted(false);
        Register.setFocusPainted(false);

        Longin.setForeground(Color.white);
        Register.setForeground(Color.white);
        Longin.setBackground(new Color(50, 51, 142));
        Register.setBackground(new Color(50, 51, 142));
        mailTfd.setBackground(new Color(220, 248, 254));
        psdTfd.setBackground(new Color(220, 248, 254));

        mail.setBounds(53, 145, 100, 30);
        mailTfd.setBounds(134,145,140,30);
        psdLable.setBounds(53,188,100,30);
        psdTfd.setBounds(134,188,140,30);
        Longin.setBounds(100,258,80,40);
        Register.setBounds(200,258,80,40);
        panel.setBounds(360,40,334,412);

        panel.setBackground(new Color(255,255,255,50));

        panel.add(mail);
        panel.add(mailTfd);
        panel.add(psdLable);
        panel.add(psdTfd);
        panel.add(Longin);
        panel.add(Register);
        container.add(panel);

        ImageIcon imageIcon=new ImageIcon("images/u0.jpg");
        JLabel label_bg=new JLabel();
        label_bg.setIcon(imageIcon);
        label_bg.setBounds(0,0,800,600);
        getLayeredPane().add(label_bg,new Integer(Integer.MIN_VALUE));
        container.add(label_bg);

        ImageIcon imageIcon1=new ImageIcon("images/u11.png");
        JLabel label=new JLabel();
        label.setIcon(imageIcon1);
        label.setBounds(100,100,300,100);
        container.add(label);
        getLayeredPane().add(label,new Integer(1));

        Connection con = JDBCUtils.getConnection();

        // 登陆事件
        Longin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = mailTfd.getText();
                String password = new String(psdTfd.getPassword());
                String sql = "select * from account where email=? and password=?";
                if(email.equals("")||password.equals("")){
                    JOptionPane.showMessageDialog( null, "账号和密码不能为空!");
                }else{
                    try {
                        check_email(email);
                        check_password(password);
                        PreparedStatement preparedStatement = con.prepareStatement(sql);
                        preparedStatement.setString(1,email);
                        preparedStatement.setString(2,password);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            JOptionPane.showMessageDialog( null, "登陆成功!");
                            setVisible(false);
                            new IndexFrame(Integer.parseInt(resultSet.getString("id")));
                        }else{
                            JOptionPane.showMessageDialog( null, "登陆失败!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (MyException ex) {
                        JOptionPane.showMessageDialog( null, ex.toString());
                    }
                }
            }
        });

        // 注册事件
        Register.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new registerDialog();
            }
        });
    }

}
