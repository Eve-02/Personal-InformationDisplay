package controller;

import dao.userInfoDao;
import domain.Degree;
import domain.Sex;
import domain.userInfo;
import utils.MyException;

import javax.swing.*;

import static utils.ExceptionDealUtils.check_Info;

public class userInfoAction {

    userInfoDao userInfoDao = new userInfoDao();

    // 编辑信息
    public int updateInfo(int id,JTextField[] textFields,JComboBox[] comboBoxes) throws MyException {

        /* 0姓名 1年龄 2身高 3地址 4技能 5电话 6邮件 7毕业院校 8性别 9学历 */
        String[] strings = new String[10];
        for(int i=0;i<8;i++){
            strings[i] = textFields[i].getText();
        }
        for(int i=8;i<10;i++){
            strings[i] = comboBoxes[i-8].getSelectedItem().toString();
        }
        check_Info(textFields);
        int age = Integer.parseInt(strings[1]);
        int height = Integer.parseInt(strings[2]);
        Sex sex = Sex.valueOf(strings[8]);
        Degree degree = Degree.valueOf(strings[9]);

        // 创建用户
        /* 0姓名 1年龄 2身高 3地址 4技能 5电话 6邮件 7毕业院校 8性别 9学历 */
        userInfo u = new userInfo(id,strings[0],age,height,strings[7],strings[3],strings[5],strings[6],strings[4],sex,degree);
        // 调用dao方法
        int update = userInfoDao.update(u);
        return update;
    }

    // 增加用户信息
    public int addInfo(String email){
        return userInfoDao.add(email);
    }

    // 查询信息
    public userInfo queryInfo(int id){
        return userInfoDao.query(id);
    }


}
