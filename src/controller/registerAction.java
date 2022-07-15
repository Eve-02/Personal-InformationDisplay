package controller;

import dao.registerDao;
import domain.account;
import utils.MyException;

import static utils.ExceptionDealUtils.*;

public class registerAction {

    registerDao r = new registerDao();

    // 增加账户
    public int addAccount(String email,String password) throws MyException {
        check_email(email);
        check_password(password);
        account a = new account(email,password);
        int add = r.add(a);
        return add;
    }

    // 修改密码
    public int changeAccount(int id,String password) throws MyException {
        check_password(password);
        return r.change(id,password);
    }

}
