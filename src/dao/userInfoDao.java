package dao;

import domain.userInfo;

public class userInfoDao extends BasicDao<userInfo>{

    // 更新信息
    public int update(userInfo u){
        String sql = "update userInfo set name=?,age=?,sex=?,height=?,degree=?,graduateSchool=?,address=?,phone=?,email=?,skill=? WHERE id=?";
        return super.update(sql,u.getName(),u.getAge(),u.getSex().toString(),u.getHeight(),u.getDegree().toString(),u.getGraduateSchool(),u.getAddress(),u.getPhone(),u.getEmail(),u.getSkill(),u.getId());
    }

    // 查询信息
    public userInfo query(int id){
        String sql = "select * from userInfo where id=?";
        return super.querySingle(sql,userInfo.class,id);
    }

    // 增加用户
    public int add(String email){
        String sql = "insert into userInfo(email) values (?)";
        return super.update(sql,email);
    }

}
