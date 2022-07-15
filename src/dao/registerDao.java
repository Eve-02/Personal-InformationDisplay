package dao;

import domain.account;

public class registerDao extends BasicDao<account> {

    // 增加账户
    public int add(account a){
        String sql = "insert into account(email,password) values (?,?)";
        return super.update(sql,a.getEmail(),a.getPassword());
    }

    // 修改密码
    public int change(int id,String password){
        String sql = "update account set password=? where id=?";
        return super.update(sql,password,id);
    }
}
