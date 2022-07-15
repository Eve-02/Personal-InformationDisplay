package domain;

public class userInfo {

    private int id;
    private String name;
    private int age;
    private Sex sex;
    private int height;
    private Degree degree;
    private String graduateSchool;
    private String address;
    private String phone;
    private String email;
    private String skill;

    public userInfo(){

    }

    /* 姓名 年龄 性别 身高 地址 技能 电话 邮件 学历 毕业院校 */
    public userInfo(int id,String name, int age, int height, String graduateSchool, String address, String phone, String email, String skill,Sex sex, Degree degree) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.degree = degree;
        this.graduateSchool = graduateSchool;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String[] getInfo(){
        String[] strings = new String[10];
        /* 姓名 年龄 (性别) 身高 地址 技能 电话 邮件 (学历) 毕业院校 */
        strings[0] = name;
        strings[1] = age + "";
        strings[2] = height + "";
        strings[3] = address;
        strings[4] = skill;
        strings[5] = phone;
        strings[6] = email;
        strings[7] = graduateSchool;
        strings[8] = sex.toString();
        strings[9] = degree.toString();
        return strings;
    }
}
