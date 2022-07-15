package utils;

import javax.swing.*;

public class ExceptionDealUtils {

    // 检验电子邮箱
    public static void check_email(String email) throws MyException {
        String regex = "^[A-Za-z\\d]+@[A-Za-z\\d]+\\.com$";
        if(!email.matches(regex)){
            throw new MyException("请输入正确的邮箱格式!");
        }
    }

    // 检验密码
    public static void check_password(String psd) throws MyException {
        if(psd.length()<6){
            throw new MyException("密码长度不能小于6位!");
        }else if(psd.length()>16){
            throw new MyException("密码长度不能大于16位!");
        }
    }

    // 信息合理性判断
    public static void check_Info(JTextField[] textFields) throws MyException {
        /* 0姓名 1年龄 2身高 3地址 4技能 5电话 6邮件 7毕业院校 8性别 9学历 */

        if(textFields[0].getText().length()>5){
            throw new MyException("姓名长度不能超出5位!");
        }

        try {
            Integer.parseInt(textFields[1].getText());
        } catch (NumberFormatException e) {
            throw new MyException("年龄请输入数字!");
        }

        try {
            Integer.parseInt(textFields[2].getText());
        } catch (NumberFormatException e) {
            throw new MyException("身高请输入数字!");
        }

        if(textFields[3].getText().length()>40){
            throw new MyException("地址长度不能超过40位!");
        }

        if(textFields[4].getText().length()>32){
            throw new MyException("技能描述超过32位!");
        }

        if(!textFields[5].equals("")){
            if(textFields[5].getText().length()>12||!textFields[5].getText().matches("\\d{11}")){
                throw new MyException("请输入正确的手机号码格式!");
            }
        }

        if(!textFields[6].equals("")){
            if(textFields[6].getText().length()>32||!textFields[6].getText().matches("^[A-Za-z\\d]+@[A-Za-z\\d]+\\.com$")){
                throw new MyException("请输入正确的邮箱格式!");
            }
        }

        if(textFields[7].getText().length()>20){
            throw new MyException("毕业院校长度超出20位!");
        }

    }
}
