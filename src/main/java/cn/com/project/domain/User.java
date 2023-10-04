package cn.com.project.domain;

// 用户
public class User {
    //主键id
    private Integer id;

    //姓名
    private String account;

    //密码
    private String password;

    //年龄
    private String age;

    //角色
    private String role;

    //地址
    private String address;

    //联系电话
    private String tel;

    //类型
    private String chexing;

    //科室
    private String jsnumber;

    //身份证号码
    private String idk;

    //状态
    private String state;

    //照片
    private byte[] photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getChexing() {
        return chexing;
    }

    public void setChexing(String chexing) {
        this.chexing = chexing == null ? null : chexing.trim();
    }

    public String getJsnumber() {
        return jsnumber;
    }

    public void setJsnumber(String jsnumber) {
        this.jsnumber = jsnumber == null ? null : jsnumber.trim();
    }

    public String getIdk() {
        return idk;
    }

    public void setIdk(String idk) {
        this.idk = idk == null ? null : idk.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

}