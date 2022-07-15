package view;

import controller.userInfoAction;
import domain.userInfo;
import utils.MyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@SuppressWarnings({"all"})
public class IndexFrame extends JDialog {

    private int id;
    private JButton[] buttons = new JButton[5];
    private JLabel[] labels = new JLabel[10];
    private JTextField[] textFields = new JTextField[8];
    private JComboBox[] comboBoxes = new JComboBox[2];

    public IndexFrame(int id){
        this.id = id;
        init();
        this.setTitle("登录");
        setBounds(500, 160, 1000, 800);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        Container container = getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        container.setLayout(null);

        // 实例化
        buttons[0] = new JButton("保存");
        buttons[1] = new JButton("个人信息");
        buttons[2] = new JButton("修改密码");
        buttons[3] = new JButton("编辑信息");
        buttons[4] = new JButton("刷新数据");

        labels[0] = new JLabel("姓名:"); // 0
        labels[1] = new JLabel("年龄:"); // 1
        labels[2] = new JLabel("性别:");
        labels[3] = new JLabel("身高:"); // 2
        labels[4] = new JLabel("地址:"); // 3
        labels[5] = new JLabel("技能:"); // 4
        labels[6] = new JLabel("电话:"); // 5
        labels[7] = new JLabel("邮件:"); // 6
        labels[8] = new JLabel("学历:");
        labels[9] = new JLabel("毕业院校:"); // 7
        for(int i=0;i<textFields.length;i++){
            textFields[i] = new JTextField();
        }
        /* 姓名 年龄 性别 身高 地址 技能 电话 邮件 学历 毕业院校 */

        // 设置样式
        for(int i=0;i<buttons.length;i++){
            buttons[i].setBackground(new Color(0xB284CB));
            buttons[i].setFocusPainted(false);
            buttons[i].setFont(new Font("楷体", Font.BOLD, 20));
        }
        buttons[0].setBackground(new Color(0x7D7F83));
        buttons[0].setForeground(new Color(0xFFFFFF));
        for(int i=0;i<labels.length;i++){
            labels[i].setFont(new Font("楷体", Font.BOLD, 20));
        }
        panel.setBounds(200,150,720,550);
        panel.setBackground(new Color(255,255,255));

        comboBoxes[0] = new JComboBox<String>();
        comboBoxes[0].addItem("男");
        comboBoxes[0].addItem("女");
        comboBoxes[0].addItem("未知");
        comboBoxes[1] = new JComboBox<String>();
        comboBoxes[1].addItem("大专");
        comboBoxes[1].addItem("本科");
        comboBoxes[1].addItem("研究生");
        comboBoxes[1].addItem("未知");
        comboBoxes[0].setFont(new Font("楷体", Font.BOLD, 20));
        comboBoxes[1].setFont(new Font("楷体", Font.BOLD, 20));

        // 设置标签位置和大小
        buttons[0].setBounds(500,75,120,40);
        buttons[1].setBounds(40,250,120,40);
        buttons[2].setBounds(40,350,120,40);
        buttons[3].setBounds(40,450,120,40);
        buttons[4].setBounds(40,550,120,40);

        labels[0].setBounds(60,30,100,30);
        labels[1].setBounds(60,110,100,30);
        labels[2].setBounds(60,190,100,30);
        labels[3].setBounds(60,270,100,30);
        labels[4].setBounds(60,360,100,30);
        labels[5].setBounds(60,455,100,30);
        labels[6].setBounds(380,30,100,30);
        labels[7].setBounds(380,110,100,30);
        labels[8].setBounds(380,190,100,30);
        labels[9].setBounds(380,270,120,30);

        textFields[0].setBounds(130,30,200,30);
        textFields[1].setBounds(130,110,200,30);
        textFields[2].setBounds(130,270,200,30);
        textFields[3].setBounds(130,360,500,30);
        textFields[4].setBounds(130,455,500,30);
        textFields[5].setBounds(450,30,200,30);
        textFields[6].setBounds(450,110,200,30);
        textFields[7].setBounds(510,270,200,30);

        comboBoxes[0].setBounds(130,190,100,30);
        comboBoxes[1].setBounds(450,190,100,30);

        /* 添加组件 */
        for(JButton button:buttons){
            add(button);
        }
        for(JLabel label:labels){
            panel.add(label);
        }
        for(JTextField textField:textFields){
            panel.add(textField);
        }
        for(JComboBox comboBox:comboBoxes){
            panel.add(comboBox);
        }

        container.add(panel);
        ImageIcon imageIcon=new ImageIcon("images/u3.jpg");
        JLabel label_bg=new JLabel();
        label_bg.setIcon(imageIcon);
        label_bg.setBounds(0,0,1000,800);
        getLayeredPane().add(label_bg,new Integer(Integer.MIN_VALUE));
        container.add(label_bg);

        ImageIcon imageIcon1=new ImageIcon("images/u34.png");
        JLabel label=new JLabel();
        label.setIcon(imageIcon1);
        label.setBounds(200,85,130,70);

        ImageIcon imageIcon3=new ImageIcon("images/u4.png");
        JLabel label2=new JLabel();
        label2.setIcon(imageIcon3);
        label2.setBounds(50,30,200,50);

        container.add(label2);
        getLayeredPane().add(label2,new Integer(1));
        container.add(label);
        getLayeredPane().add(label,new Integer(1));

        // 初始化信息
        Initialize();

        // 设置只读
        for(int i=0;i<textFields.length;i++){
            textFields[i].setEditable(false);
        }
        buttons[0].setVisible(false);

        // 隐藏
        buttons[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<textFields.length;i++){
                    textFields[i].setEditable(true);
                }
                buttons[0].setVisible(true);
            }
        });

        // 刷新事件
        buttons[4].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Initialize();
                JOptionPane.showMessageDialog( null,"刷新成功!");
            }
        });

        // 修改事件
        buttons[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<textFields.length;i++){
                    textFields[i].setEditable(false);
                }
                buttons[0].setVisible(false);
                int i = 0;
                try {
                    i = new userInfoAction().updateInfo(id, textFields, comboBoxes);
                    if(i>0){
                        JOptionPane.showMessageDialog( null, "修改成功!");
                    }else{
                        JOptionPane.showMessageDialog( null, "修改失败!");
                    }
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog( null, ex.toString());
                }
            }
        });

        // 修改密码
        buttons[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChangePasswordDialog(id);
            }
        });
    }

    // 初始化数据/刷新数据
    public void Initialize(){
        /* 姓名 年龄 性别 身高 地址 技能 电话 邮件 学历 毕业院校 */
        userInfo u = new userInfoAction().queryInfo(id);
        if(u != null){
            String[] strings = u.getInfo();
            for(int i=0;i<8;i++){
                textFields[i].setText(strings[i]);
            }
            for(int i=8;i<10;i++){
                comboBoxes[i-8].setSelectedItem(strings[i]);
            }
        }

    }

}
