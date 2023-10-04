package cn.com.project.domain;

// 测试记录
public class Bf {
    //主键id
    private Integer id;

    //用户id
    private Integer kid;

    //用户id
    private Integer aid;

    //测试日期
    private String bfrq;

    //分数
    private String fk;

    //测试人姓名
    private String account;

    //测试人姓名
    private String lname;

    //测试人姓名
    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getBfrq() {
        return bfrq;
    }

    public void setBfrq(String bfrq) {
        this.bfrq = bfrq == null ? null : bfrq.trim();
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk == null ? null : fk.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}